package cn.cosine.models;

public class JobDetail {
	private String jobName;
	private String courseName;
	private String courseClass;
	private String introdution;
	private String requirement;
	private String deadTime;
	public JobDetail() {
		
	}
	public JobDetail(String jobName, String courseName, String courseClass, String introdution, String requirement,
			String deadTime) {
		super();
		this.jobName = jobName;
		this.courseName = courseName;
		this.courseClass = courseClass;
		this.introdution = introdution;
		this.requirement = requirement;
		this.deadTime = deadTime;
	}
	public String getjobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseClass() {
		return courseClass;
	}
	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
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
