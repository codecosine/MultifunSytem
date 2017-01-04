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

import cn.cosine.models.Job;
import cn.cosine.models.Message;
import cn.cosine.services.StudentService;

/**
 * Servlet implementation class UpdateJob
 */
@WebServlet({ "/UpdateJob", "/updatejob" })

public class UpdateJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService studentservice = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJob() {
        super();
    	studentservice = new StudentService();
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
	    Job update = JSON.parseObject(sb.toString(), Job.class);
	    Boolean result = studentservice.updateJob(update);
	    if(result){
		    Message msg = new Message(true,"修改成功");
		    response.getWriter().write(JSON.toJSONString(msg));
	    } else {
	    	Message msg = new Message(false,"修改失败");
		    response.getWriter().write(JSON.toJSONString(msg));
	    }
	}

}
