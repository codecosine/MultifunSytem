package cn.cosine.models;

public class JobDetail {
	private String id;
	private String jobname;
	private String courseName;
	private String courseClass;
	private String introdution;
	private String requirement;
	private String deadTime;
	public JobDetail() {
		
	}
	public JobDetail(String jobname, String courseName, String courseClass, String introdution, String requirement,
			String deadTime) {
		super();
		this.jobname = jobname;
		this.courseName = courseName;
		this.courseClass = courseClass;
		this.introdution = introdution;
		this.requirement = requirement;
		this.deadTime = deadTime;
	}
	public JobDetail(String id, String jobname, String courseName, String courseClass, String introdution,
			String requirement, String deadTime) {
		super();
		this.id = id;
		this.jobname = jobname;
		this.courseName = courseName;
		this.courseClass = courseClass;
		this.introdution = introdution;
		this.requirement = requirement;
		this.deadTime = deadTime;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
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
	@Override
	public String toString() {
		return "JobDetail [jobName=" + jobname + ", courseName=" + courseName + ", courseClass=" + courseClass
				+ ", introdution=" + introdution + ", requirement=" + requirement + ", deadTime=" + deadTime + "]";
	}

	
}
