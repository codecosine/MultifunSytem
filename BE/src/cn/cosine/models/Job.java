package cn.cosine.models;

public class Job {
	private int id;
	private String username;
	private String jobname;
	private String statu;
	private String submitTime;
	private String fileid;
	public Job() {
		super();
	}
	public Job(int id) {
		super();
		this.id = id;
	}
	public Job(String username, String jobname, String statu, String submitTime, String fileid) {
		super();
		this.username = username;
		this.jobname = jobname;
		this.statu = statu;
		this.submitTime = submitTime;
		this.fileid = fileid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", username=" + username + ", jobname=" + jobname + ", statu=" + statu
				+ ", submitTime=" + submitTime + ", fileid=" + fileid + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Job(int id, String username, String jobname, String statu, String submitTime, String fileid) {
		super();
		this.id = id;
		this.username = username;
		this.jobname = jobname;
		this.statu = statu;
		this.submitTime = submitTime;
		this.fileid = fileid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
