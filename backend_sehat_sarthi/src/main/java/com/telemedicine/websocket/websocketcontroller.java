package com.telemedicine.websocket;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.telemedicine.allentity.ChatMessage;
import com.telemedicine.allentity.user;
import com.telemedicine.allrepository.chat_repo;
import com.telemedicine.allrepository.user_repo;

@Controller
public class websocketcontroller {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private user_repo userRepository;

    @Autowired
    private chat_repo chatMessageRepository;

    @MessageMapping("/chat.message")
    public void handleChatMessage(@Payload Map<String, Object> messageMap) {
        System.out.println("📨 Received chat message: " + messageMap);

        try {
            String fromUserId = (String) messageMap.get("fromUser");
            String targetUserId = (String) messageMap.get("targetUser");
            String content = (String) messageMap.get("data");

            if (fromUserId == null || targetUserId == null || content == null) {
                System.out.println("❌ Missing fields in message");
                return;
            }

            Long senderId = Long.parseLong(fromUserId);
            Long receiverId = Long.parseLong(targetUserId);

            user sender = userRepository.findById(senderId)
                    .orElseThrow(() -> new RuntimeException("Sender not found"));
            user receiver = userRepository.findById(receiverId)
                    .orElseThrow(() -> new RuntimeException("Receiver not found"));

            // Save chat message to DB
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setSender(sender);
            chatMessage.setReceiver(receiver);
            chatMessage.setContent(content);
            chatMessage.setSentAt(LocalDateTime.now());
            ChatMessage savedMessage = chatMessageRepository.save(chatMessage);

            Map<String, Object> msgResponse = new HashMap<>();
            msgResponse.put("type", "CHAT");
            msgResponse.put("fromUser", fromUserId);
            msgResponse.put("targetUser", targetUserId);
            msgResponse.put("data", content);
            msgResponse.put("timestamp", savedMessage.getSentAt().toString());
            msgResponse.put("senderName", sender.getName());
            msgResponse.put("receiverName", receiver.getName());
            msgResponse.put("messageId", savedMessage.getId());
            msgResponse.put("status", "DELIVERED");

            // Send to both users (using /topic/chat/{userId})
            messagingTemplate.convertAndSend("/topic/chat/" + targetUserId, msgResponse);
            messagingTemplate.convertAndSend("/topic/chat/" + fromUserId, msgResponse);

            System.out.println("✅ Message sent to /topic/chat/" + targetUserId + " and " + fromUserId);

        } catch (Exception e) {
            System.err.println("❌ Error processing message: " + e.getMessage());
        }
    }

    @MessageMapping("/chat.test")
    public void testConnection() {
        System.out.println("🔄 Test connection successful");
    }
}
