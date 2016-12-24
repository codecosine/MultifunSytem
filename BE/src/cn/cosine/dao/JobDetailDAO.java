package cn.cosine.dao;

import java.util.List;

import cn.cosine.models.JobDetail;

public interface JobDetailDAO {
    List<JobDetail> findAll();
    List<JobDetail> findById();
    List<JobDetail> findByName();
    boolean insertJobDetail(JobDetail jobdetail);
    boolean updateJobDetail(JobDetail jobdetail);
    boolean deleteJobDetail(JobDetail jobdetail);
}
