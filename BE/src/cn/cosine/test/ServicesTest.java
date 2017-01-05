package cn.cosine.test;

import org.junit.Test;

import cn.cosine.models.Job;
import cn.cosine.services.StudentService;

public class ServicesTest {
	@Test
	public void StudentTest(){
		// 增删改查
		// Job add = new Job("cosine","testJob","statu1","sj","22222");
		// Job update = new Job(2,"cosine","update","status2","submitTIme","22222");
		Job delete = new Job(2);
		StudentService ss = new StudentService();
		// ss.addJob(add);
		ss.deleteJob(delete);
	}

}
