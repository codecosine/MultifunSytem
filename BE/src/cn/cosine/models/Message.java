package cn.cosine.models;

public class Message {
	private Boolean success;
	private String message;
	private String content;
	public Message(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	public Message() {
		super();
	}
	public Message(Boolean success, String message, String content) {
		super();
		this.success = success;
		this.message = message;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
