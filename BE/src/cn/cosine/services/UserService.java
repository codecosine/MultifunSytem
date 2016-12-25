package cn.cosine.services;

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
	public boolean authUser(User user) throws Exception {
		User findUser = userdao.findById(user.getId()).get(0);
		if (findUser.getId() != null) {
			if (findUser.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	public boolean resetPassword(User user,String resetPass) throws Exception {
		User reset = new User();
		if (this.authUser(user)) {
			reset.setId(user.getId());
			reset.setName(user.getName());
			reset.setPassword(resetPass);
			reset.setRole(user.getRole());
			return userdao.updateUser(reset);
		} else {
			reset = null;
			return false;
		}
	}
	public List<JobDetail> getJobs(){
		return jobdetaildao.findAll();
	}


}
