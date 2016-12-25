package cn.cosine.services;

import java.util.List;

import cn.cosine.dao.JobDaoImpl;
import cn.cosine.models.Job;

public class StudentService {
	private JobDaoImpl jobdao = null;
	public StudentService() {
		jobdao = JobDaoImpl.getInstance();
	}
	public List<Job> getUserJobs(String userId) {
		return jobdao.findById(userId);
	}
	public boolean submitJob(Job update){
		return jobdao.updateJob(update);
	}
}
