package cn.cosine.dao;

import java.util.List;

import cn.cosine.models.Job;

public interface JobDAO {
    List<Job> findAll();
    List<Job> findById();
    List<Job> findByName();
    boolean insertJob(Job job);
    boolean updateJob(Job job);
    boolean deleteJob(Job job);
}
