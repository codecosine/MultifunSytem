package cn.cosine.models;

public class Job {
	private String id;
	private String user_id;
	private String course_name;
	private String course_class;
	private String statu;
	private String date;
	private String url;
	public Job() {
		
	}
	public Job(String id, String user_id, String course_name, String course_class, String statu, String date,
			String url) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.course_name = course_name;
		this.course_class = course_class;
		this.statu = statu;
		this.date = date;
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_class() {
		return course_class;
	}
	public void setCourse_class(String course_class) {
		this.course_class = course_class;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


}
