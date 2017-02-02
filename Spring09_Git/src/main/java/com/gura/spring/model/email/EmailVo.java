package com.gura.spring.model.email;

public class EmailVo {
    private String senderName;
    private String senderMail;
    private String email;
    private String subject;
    private String message;
    private String message2;
    
    public EmailVo(String message2){
    	setMessage2(message2);
    }
    public EmailVo(){}
	public String getSenderName() {
		return senderName;
	}
	public String getSenderMail() {
		return senderMail;
	}
	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	@Override
	public String toString() {
		return "EmailVo [senderName=" + senderName + ", senderMail=" + senderMail + ", email=" + email + ", subject="
				+ subject + ", message=" + message + ", message2=" + message2 + "]";
	}


    
}
