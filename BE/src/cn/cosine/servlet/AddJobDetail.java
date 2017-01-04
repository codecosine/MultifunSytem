package cn.cosine.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import cn.cosine.models.JobDetail;
import cn.cosine.models.Message;
import cn.cosine.services.TeacherService;

/**
 * Servlet implementation class AddJobDetail
 */
@WebServlet({ "/AddJobDetail", "/addJobDetail" })
public class AddJobDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeacherService teacherService = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJobDetail() {
        super();
        teacherService = new TeacherService();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8") ;
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(),"utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while((temp = br.readLine())!=null) {
			sb.append(temp);
		}
		br.close();
	    JobDetail insert = JSON.parseObject(sb.toString(), JobDetail.class);
	    Boolean result = teacherService.addJobDetail(insert);
	    if(result){
		    Message msg = new Message(true,"添加成功");
		    response.getWriter().write(JSON.toJSONString(msg));
	    } else {
	    	Message msg = new Message(false,"添加失败");
		    response.getWriter().write(JSON.toJSONString(msg));
	    }
	}

}
