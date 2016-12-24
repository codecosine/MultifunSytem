package cn.cosine.models;

public class Job {
	private String id;
	private String user_id;
	private String name;
	private String statu;
	private String date;
	private String job_detail;
	private String job_url;
	public Job() {
		super();
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getJob_detail() {
		return job_detail;
	}
	public void setJob_detail(String job_detail) {
		this.job_detail = job_detail;
	}
	public String getJob_url() {
		return job_url;
	}
	public void setJob_url(String job_url) {
		this.job_url = job_url;
	}

}
