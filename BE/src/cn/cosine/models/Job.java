package cn.cosine.models;
public class Job {
  private String id;
  private String user_id;
  private String name;
  private String statu;
  private String date;
  private String job_detail;
  private String job_url;
	/**
	* Default empty Job constructor
	*/
	public Job() {
		super();
	}

	/**
	* Default Job constructor
	*/
	public Job(String id, String user_id, String name, String statu, String date, String job_url) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.statu = statu;
		this.date = date;
		this.job_url = job_url;
	}

	/**
	* Returns value of id
	* @return
	*/
	public String getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**
	* Returns value of user_id
	* @return
	*/
	public String getUser_id() {
		return user_id;
	}

	/**
	* Sets new value of user_id
	* @param
	*/
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	* Returns value of statu
	* @return
	*/
	public String getStatu() {
		return statu;
	}

	/**
	* Sets new value of statu
	* @param
	*/
	public void setStatu(String statu) {
		this.statu = statu;
	}

	/**
	* Returns value of date
	* @return
	*/
	public String getDate() {
		return date;
	}

	/**
	* Sets new value of date
	* @param
	*/
	public void setDate(String date) {
		this.date = date;
	}

	/**
	* Returns value of job_url
	* @return
	*/
	public String getJob_url() {
		return job_url;
	}

	/**
	* Sets new value of job_url
	* @param
	*/
	public void setJob_url(String job_url) {
		this.job_url = job_url;
	}
}
