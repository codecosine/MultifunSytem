package cn.cosine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.cosine.models.JobDetail;
import cn.cosine.utils.DBConnection;

public class JobDetailDaoImpl implements JobDetailDAO {
	private static JobDetailDaoImpl instance = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private JobDetailDaoImpl() throws Exception{
		conn = new DBConnection().getConnection();
	}
	public static JobDetailDaoImpl getInstance() {
		if (instance == null){
			try {
				instance = new JobDetailDaoImpl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	@Override
	public List<JobDetail> findAll() throws SQLException {
		List<JobDetail> result = new ArrayList<JobDetail>();
		String sql = "SELECT id,jobname,operator,coursename,courseclass,requirements,deadTime FROM JobDetail";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		JobDetail temp = null;
		while (rs.next()) {
			temp = new JobDetail(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			result.add(temp);
		}
		return result;
	}

	@Override
	public boolean insertJobDetail(JobDetail jobdetail) throws SQLException  {
		String sql = "INSERT INTO JobDetail(jobname,operator,coursename,courseclass,requirements,deadTime) VALUES(?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, jobdetail.getJobname());
		this.pstmt.setString(2, jobdetail.getOperator());
		this.pstmt.setString(3, jobdetail.getCoursename());
		this.pstmt.setString(4, jobdetail.getCourseclass());
		this.pstmt.setString(5, jobdetail.getRequirements());
		this.pstmt.setString(6, jobdetail.getDeadTime());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean updateJobDetail(JobDetail jobdetail) throws SQLException  {
		String sql = "UPDATE JobDetail SET jobname=?,operator=?,coursename=?,courseclass=?,requirements=?,deadTime=? WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, jobdetail.getJobname());
		this.pstmt.setString(2, jobdetail.getOperator());
		this.pstmt.setString(3, jobdetail.getCoursename());
		this.pstmt.setString(4, jobdetail.getCourseclass());
		this.pstmt.setString(5, jobdetail.getRequirements());
		this.pstmt.setString(6, jobdetail.getDeadTime());
		this.pstmt.setInt(7, jobdetail.getId());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean deleteJobDetail(JobDetail jobdetail) throws SQLException  {
		String sql = "DELETE FROM JobDetail WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(7, jobdetail.getId());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}


}
