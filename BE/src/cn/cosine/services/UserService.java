package cn.cosine.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	public static String parseStrToMd5L32(String str){
		String reStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(str.getBytes());
			StringBuffer stringBuffer = new StringBuffer();
			for (byte b : bytes){
				int bt = b&0xff;
				if (bt < 16){
					stringBuffer.append(0);
				} 
				stringBuffer.append(Integer.toHexString(bt));
			}
			reStr = stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return reStr;
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
	public boolean registerUserForStudent(User register) {
		register.setRole("student");
		register.setPassword(parseStrToMd5L32(register.getPassword()));
		try {
			return userdao.insertUser(register);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean registerUserForTeacher(User register) {
		register.setRole("teacher");
		register.setPassword(parseStrToMd5L32(register.getPassword()));
		try {
			return userdao.insertUser(register);
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
				reset.setPassword(parseStrToMd5L32(resetPass));
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
