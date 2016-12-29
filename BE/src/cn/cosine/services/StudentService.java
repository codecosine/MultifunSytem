package cn.cosine.services;

import java.sql.SQLException;
import java.util.List;

import cn.cosine.dao.JobDaoImpl;
import cn.cosine.models.Job;

public class StudentService {
	private JobDaoImpl jobdao = null;
	public StudentService() {
		jobdao = JobDaoImpl.getInstance();
	}
	public List<Job> getUserJobs(String userId) {
		try {
			return jobdao.findByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean submitJob(Job update){
		try {
			return jobdao.updateJob(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
