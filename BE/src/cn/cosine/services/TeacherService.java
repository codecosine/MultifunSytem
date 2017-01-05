package cn.cosine.services;

import java.sql.SQLException;
import java.util.List;

import cn.cosine.dao.JobDaoImpl;
import cn.cosine.dao.JobDetailDaoImpl;
import cn.cosine.models.Job;
import cn.cosine.models.JobDetail;

public class TeacherService {
	private JobDetailDaoImpl jobdetaildao = null;
	// private JobDaoImpl jobdao = null;
	public TeacherService() {
		jobdetaildao = JobDetailDaoImpl.getInstance();
		// jobdao = JobDaoImpl.getInstance();
	}
	public boolean addJobDetail(JobDetail add) {
		try {
			return jobdetaildao.insertJobDetail(add);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleleJobDetail(JobDetail delete) {
		try {
			return jobdetaildao.deleteJobDetail(delete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateJobDetail(JobDetail update) {
		try {
			return jobdetaildao.updateJobDetail(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<Job> getJobsByClass(String courseClass) {
		
		return null;
	}
	// download function 

}
