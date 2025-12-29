package com.telemedicine.allentity;

public class SignalMessage {
	
	  private String type; // OFFER, ANSWER, ICE_CANDIDATE, CHAT, CALL_START, CALL_END
	    private String fromUser;
	    private String targetUser;
	    private Object data;
	    private String sessionId;
		public SignalMessage(String type, String fromUser, String targetUser, Object data, String sessionId) {
			super();
			this.type = type;
			this.fromUser = fromUser;
			this.targetUser = targetUser;
			this.data = data;
			this.sessionId = sessionId;
		}
		public SignalMessage() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getFromUser() {
			return fromUser;
		}
		public void setFromUser(String fromUser) {
			this.fromUser = fromUser;
		}
		public String getTargetUser() {
			return targetUser;
		}
		public void setTargetUser(String targetUser) {
			this.targetUser = targetUser;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public String getSessionId() {
			return sessionId;
		}
		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}
		@Override
		public String toString() {
			return "SignalMessage [type=" + type + ", fromUser=" + fromUser + ", targetUser=" + targetUser + ", data="
					+ data + ", sessionId=" + sessionId + "]";
		}
	    
	    

}
