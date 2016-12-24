package cn.cosine.models;

public class JobDetail {
	private String name;
	private String courseName;
	private String introdution;
	private String requirement;
	private String deadTime;
	public JobDetail(String name, String courseName, String introdution, String requirement, String deadTime) {
		super();
		this.name = name;
		this.courseName = courseName;
		this.introdution = introdution;
		this.requirement = requirement;
		this.deadTime = deadTime;
	}
	public JobDetail() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getIntrodution() {
		return introdution;
	}
	public void setIntrodution(String introdution) {
		this.introdution = introdution;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getDeadTime() {
		return deadTime;
	}
	public void setDeadTime(String deadTime) {
		this.deadTime = deadTime;
	}	

}
