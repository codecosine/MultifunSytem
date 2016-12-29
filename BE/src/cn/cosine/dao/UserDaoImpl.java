package cn.cosine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.cosine.models.User;
import cn.cosine.utils.DBConnection;

public class UserDaoImpl implements UserDAO {
	private static UserDaoImpl instance = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private UserDaoImpl() throws Exception{
		conn = new DBConnection().getConnection();
	}
	public static UserDaoImpl getInstance() {
		if (instance == null){
			try {
				instance = new UserDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	@Override
	public List<User> findAll() throws SQLException{
		List<User> result = new ArrayList<User>();
		String sql = "SELECT id,username,password,role FROM User";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		User temp = null;
		while (rs.next()) {
			temp = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			result.add(temp);
		}
		return result;
	}
	@Override
	public List<User> findById(int id) throws SQLException {
		List<User> result = new ArrayList<User>();
		String sql = "SELECT id,username,password,role FROM User WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		User temp = null;
		while (rs.next()) {
			temp = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			result.add(temp);
		}
		return result;
	}

	@Override
	public List<User> findByUserName(String username) throws SQLException {
		List<User> result = new ArrayList<User>();
		String sql = "SELECT id,username,password,role FROM User WHERE username=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ResultSet rs = this.pstmt.executeQuery();
		User temp = null;
		while (rs.next()) {
			temp = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			result.add(temp);
		}
		return result;
	}


	@Override
	public boolean insertUser(User user) throws SQLException {
		String sql = "INSERT INTO User(username,password,role) VALUES(?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUsername());
		this.pstmt.setString(2, user.getPassword());
		this.pstmt.setString(3, user.getRole());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		String sql = "UPDATE User SET username=?,password=?,role=? WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUsername());
		this.pstmt.setString(2, user.getPassword());
		this.pstmt.setString(3, user.getRole());
		this.pstmt.setInt(4, user.getId());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean deleteUser(User user) throws SQLException {
		String sql = "DELETE FROM User WHERE id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, user.getId());
		if (this.pstmt.executeUpdate()>0) {
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}
	
}
