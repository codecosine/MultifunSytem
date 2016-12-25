package cn.cosine.dao;

import java.sql.SQLException;
import java.util.List;

import cn.cosine.models.Job;

public interface JobDAO {
    List<Job> findAll() throws SQLException;
    List<Job> findByUserId(String userId) throws SQLException;
    List<Job> findByCourseName(String courseName) throws SQLException;
    List<Job> findByCourseClass(String courseClass) throws SQLException;
    boolean insertJob(Job job) throws SQLException;
    boolean updateJob(Job job) throws SQLException;
    boolean deleteJob(Job job) throws SQLException;
}
