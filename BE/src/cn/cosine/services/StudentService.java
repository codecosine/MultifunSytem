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
	public List<Job> getUserJobs(String username) {
		try {
			return jobdao.findByUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean addJob(Job add) {
		try {
			return jobdao.insertJob(add);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateJob(Job update) {
		try {
			return jobdao.updateJob(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteJob(Job delete) {
		try {
			return jobdao.deleteJob(delete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
