package cn.cosine.services;

import java.sql.SQLException;
import java.util.List;

import cn.cosine.dao.JobDetailDaoImpl;
import cn.cosine.dao.UserDaoImpl;
import cn.cosine.models.JobDetail;
import cn.cosine.models.User;

public class UserService {
	private UserDaoImpl userdao = null;
	private JobDetailDaoImpl jobdetaildao = null;
	public UserService(){
		userdao = UserDaoImpl.getInstance();
		jobdetaildao = JobDetailDaoImpl.getInstance();
	}
	public boolean authUser(User user) {
		User findUser = null;
		try {
			findUser = userdao.findByUserName(user.getUsername()).get(0);
			return findUser.equals(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean resetPassword(User user,String resetPass) {
		User reset = new User();
		try {
			if (this.authUser(user)) {
				reset.setId(user.getId());
				reset.setUsername(user.getUsername());
				reset.setPassword(resetPass);
				reset.setRole(user.getRole());
				return userdao.updateUser(reset);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reset = null;
		return false;
		
	}
	public List<JobDetail> getJobDetails(){
		try {
			return jobdetaildao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
