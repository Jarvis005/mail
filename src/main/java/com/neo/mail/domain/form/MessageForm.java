package com.neo.mail.domain.form;

public class MessageForm {
	private String receiveUser;
	private String target;
	private String msgContent;
	
	public String getReceiveUser() {
		return receiveUser;
	}
	
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public String getMsgContent() {
		return msgContent;
	}
	
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
}
