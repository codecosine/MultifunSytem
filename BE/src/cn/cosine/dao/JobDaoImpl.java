package cn.cosine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.cosine.models.Job;
import cn.cosine.utils.DBConnection;

public class JobDaoImpl implements JobDAO {
	private static JobDaoImpl instance = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private JobDaoImpl() throws Exception {
		conn = new DBConnection().getConnection();

	}
	public static JobDaoImpl getInstance() {
		if (instance == null){
			try {
				instance = new JobDaoImpl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	@Override
	public List<Job> findAll() throws SQLException {
		List<Job> result = new ArrayList<Job>();
		String sql = "SELECT id,username,jobname,statu,submitTime,fileid FROM Job";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Job temp = null;
		while (rs.next()) {
			temp = new Job(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			result.add(temp);
		}
		return result;
	}
	@Override
	public List<Job> findByUsername(String username) throws SQLException {
		List<Job> result = new ArrayList<Job>();
		String sql = "SELECT id,jobname,statu,submitTime,url FROM Job WHERE username=?";
		this.pstmt.setString(1, username);
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Job temp = null;
		while (rs.next()) {
			temp = new Job(rs.getInt(1),username,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			result.add(temp);
		}
		return result;
	}
	@Override
	public List<Job> findByJobname(String jobname) throws SQLException {
		List<Job> result = new ArrayList<Job>();
		String sql = "SELECT id,username,statu,submitTime,url FROM Job WHERE jobname=?";
		this.pstmt.setString(1, jobname);
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		Job temp = null;
		while (rs.next()) {
			temp = new Job(rs.getInt(1),rs.getString(2),jobname,rs.getString(3),rs.getString(4),rs.getString(5));
			result.add(temp);
		}
		return result;
	}


	@Override
	public boolean insertJob(Job job) throws SQLException {
		String sql = "INSERT INTO Job(username,jobname,statu,submitTime,fileid) VALUES(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, job.getUsername());
		this.pstmt.setString(2, job.getJobname());
		this.pstmt.setString(3, job.getStatu());
		this.pstmt.setString(4, job.getSubmitTime());
		this.pstmt.setString(5, job.getFileid());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean updateJob(Job job) throws SQLException {
		String sql = "UPDATE Job SET username=?,jobname=?,statu=?,submitTime=?,fileid=? WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, job.getUsername());
		this.pstmt.setString(2, job.getJobname());
		this.pstmt.setString(3, job.getStatu());
		this.pstmt.setString(4, job.getSubmitTime());
		this.pstmt.setString(5, job.getFileid());
		this.pstmt.setInt(6, job.getId());
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
		this.pstmt.setInt(1, job.getId());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

}
