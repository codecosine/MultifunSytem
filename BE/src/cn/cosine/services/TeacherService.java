package cn.cosine.services;

import java.util.List;

import cn.cosine.dao.JobDaoImpl;
import cn.cosine.dao.JobDetailDaoImpl;
import cn.cosine.models.Job;
import cn.cosine.models.JobDetail;

public class TeacherService {
	private JobDetailDaoImpl jobdetaildao = null;
	private JobDaoImpl jobdao = null;
	public TeacherService() {
		jobdetaildao = JobDetailDaoImpl.getInstance();
		jobdao = JobDaoImpl.getInstance();
	}
	public boolean addJobDetail(JobDetail add) {
		return jobdetaildao.insertJobDetail(add);
	}
	public boolean deleleJobDetail(JobDetail delete) {
		return jobdetaildao.deleteJobDetail(delete);
	}
	public boolean updateJobDetail(JobDetail update) {
		return jobdetaildao.updateJobDetail(update);
	}
	public List<Job> getJobsByClass(String courseClass) {
		return jobdao.findByCourseClass(courseClass);
	}
	// download function 

}
