package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.ChatMessage;
import com.telemedicine.allentity.user;

import java.util.List;
import java.time.LocalDateTime;



@Repository
public interface chat_repo  extends JpaRepository<ChatMessage, Long>{
	
    // ✅ FIXED: Capital 'B' in findBy
    @Query("SELECT cm FROM ChatMessage cm WHERE cm.sender.id = :senderId AND cm.receiver.id = :receiverId ORDER BY cm.sentAt")
    List<ChatMessage> findBySenderIdAndReceiverIdOrderBySentAt(
        @Param("senderId") Long senderId, 
        @Param("receiverId") Long receiverId
    );
    
    // ✅ FIXED: Capital 'B' in findBy
    @Query("SELECT cm FROM ChatMessage cm WHERE (cm.sender.id = :userId1 OR cm.receiver.id = :userId2) ORDER BY cm.sentAt")
    List<ChatMessage> findBySenderIdOrReceiverIdOrderBySentAt(
        @Param("userId1") Long userId1, 
        @Param("userId2") Long userId2
    );
    
    // Additional chat methods
    @Query("SELECT cm FROM ChatMessage cm WHERE cm.sender.id = :userId OR cm.receiver.id = :userId ORDER BY cm.sentAt DESC")
    List<ChatMessage> findUserMessages(@Param("userId") Long userId);
    
    @Query("SELECT cm FROM ChatMessage cm WHERE (cm.sender.id = :user1 AND cm.receiver.id = :user2) OR (cm.sender.id = :user2 AND cm.receiver.id = :user1) ORDER BY cm.sentAt")
    List<ChatMessage> findConversation(@Param("user1") Long user1, @Param("user2") Long user2);
	
	
	

}
