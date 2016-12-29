package cn.cosine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.cosine.models.Job;

public class JobDaoImpl implements JobDAO {
	private static JobDaoImpl instance = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private JobDaoImpl() {
		
	}
	public static JobDaoImpl getInstance() {
		if (instance == null){
			instance = new JobDaoImpl();
		}
		return instance;
	}
	@Override
	public List<Job> findAll() throws SQLException {
		List<Job> result = new ArrayList<Job>();
		String sql = "SELECT id,user_id,course_name,course_class,statu,date,url FROM Job";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Job temp = null;
		while (rs.next()) {
			temp = new Job(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			result.add(temp);
		}
		return result;
	}
	@Override
	public List<Job> findByUserId(String userId) throws SQLException {
		List<Job> result = new ArrayList<Job>();
		String sql = "SELECT id,course_name,course_class,statu,date,url FROM Job WHERE user_id=?";
		this.pstmt.setString(1, userId);
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Job temp = null;
		while (rs.next()) {
			temp = new Job(userId,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			result.add(temp);
		}
		return result;
	}
	@Override
	public List<Job> findByCourseClass(String courseClass) throws SQLException {
		List<Job> result = new ArrayList<Job>();
		String sql = "SELECT id,user_id,course_name,statu,date,url FROM Job WHERE course_class=?";
		this.pstmt.setString(1, courseClass);
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Job temp = null;
		while (rs.next()) {
			temp = new Job(rs.getString(1),rs.getString(2),rs.getString(3),courseClass,rs.getString(4),rs.getString(5),rs.getString(6));
			result.add(temp);
		}
		return result;
	}

	@Override
	public List<Job> findByCourseName(String courseName) throws SQLException {
		List<Job> result = new ArrayList<Job>();
		String sql = "SELECT id,user_id,course_class,statu,date,url FROM Job WHERE course_name=?";
		this.pstmt.setString(1, courseName);
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Job temp = null;
		while (rs.next()) {
			temp = new Job(rs.getString(1),rs.getString(2),courseName,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			result.add(temp);
		}
		return result;
	}

	@Override
	public boolean insertJob(Job job) throws SQLException {
		String sql = "INSERT INTO Job(id,username,course_name,course_class,statu,date,url) VALUES(?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, job.getId());
		this.pstmt.setString(2, job.getUsername());
		this.pstmt.setString(3, job.getCourse_name());
		this.pstmt.setString(4, job.getCourse_class());
		this.pstmt.setString(5, job.getStatu());
		this.pstmt.setString(6, job.getDate());
		this.pstmt.setString(7, job.getUrl());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean updateJob(Job job) throws SQLException {
		String sql = "UPDATE Job SET statu=?,date=?,url=? WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, job.getStatu());
		this.pstmt.setString(2, job.getDate());
		this.pstmt.setString(3, job.getUrl());
		this.pstmt.setString(4, job.getId());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean deleteJob(Job job) throws SQLException {
		String sql = "DELETE FROM Job WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, job.getId());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

}
