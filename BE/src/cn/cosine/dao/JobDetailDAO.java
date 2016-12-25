package cn.cosine.dao;

import java.sql.SQLException;
import java.util.List;

import cn.cosine.models.JobDetail;

public interface JobDetailDAO {
    List<JobDetail> findAll() throws SQLException;
    boolean insertJobDetail(JobDetail jobdetail) throws SQLException;
    boolean updateJobDetail(JobDetail jobdetail) throws SQLException;
    boolean deleteJobDetail(JobDetail jobdetail) throws SQLException;
}
