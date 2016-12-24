package cn.cosine.models;
public class JobDetail{
  private String name;
  private String courseName;
  private String introdution;
  private String requirement;
  private String deadTime;


	/**
	* Default empty JobDetail constructor
	*/
	public JobDetail() {
		super();
	}

	/**
	* Default JobDetail constructor
	*/
	public JobDetail(String name, String courseName, String introdution, String requirement, String deadTime) {
		super();
		this.name = name;
		this.courseName = courseName;
		this.introdution = introdution;
		this.requirement = requirement;
		this.deadTime = deadTime;
	}

	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Returns value of courseName
	* @return
	*/
	public String getCourseName() {
		return courseName;
	}

	/**
	* Sets new value of courseName
	* @param
	*/
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	* Returns value of introdution
	* @return
	*/
	public String getIntrodution() {
		return introdution;
	}

	/**
	* Sets new value of introdution
	* @param
	*/
	public void setIntrodution(String introdution) {
		this.introdution = introdution;
	}

	/**
	* Returns value of requirement
	* @return
	*/
	public String getRequirement() {
		return requirement;
	}

	/**
	* Sets new value of requirement
	* @param
	*/
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	/**
	* Returns value of deadTime
	* @return
	*/
	public String getDeadTime() {
		return deadTime;
	}

	/**
	* Sets new value of deadTime
	* @param
	*/
	public void setDeadTime(String deadTime) {
		this.deadTime = deadTime;
	}
}
