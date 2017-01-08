package cn.cosine.models;

public class JobDetail {
	private int id;
	private String jobname;
	private String operator;
	private String coursename;
	private String courseclass;
	private String requirements;
	private String deadTime;
	public JobDetail() {

	}
	public JobDetail(int id, String jobname, String operator, String coursename, String courseclass,
			String requirements, String deadTime) {
		super();
		this.id = id;
		this.jobname = jobname;
		this.operator = operator;
		this.coursename = coursename;
		this.courseclass = courseclass;
		this.requirements = requirements;
		this.deadTime = deadTime;
	}
	public JobDetail(String jobname, String operator, String coursename, String courseclass, String requirements,
			String deadTime) {
		super();
		this.jobname = jobname;
		this.operator = operator;
		this.coursename = coursename;
		this.courseclass = courseclass;
		this.requirements = requirements;
		this.deadTime = deadTime;
	}
	public JobDetail(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseclass() {
		return courseclass;
	}
	public void setCourseclass(String courseclass) {
		this.courseclass = courseclass;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getDeadTime() {
		return deadTime;
	}
	public void setDeadTime(String deadTime) {
		this.deadTime = deadTime;
	}



}
