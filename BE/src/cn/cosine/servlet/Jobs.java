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

import cn.cosine.models.User;
import cn.cosine.services.StudentService;

/**
 * Servlet implementation class Jobs
 */
@WebServlet({ "/Jobs", "/jobs" })
public class Jobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService studentservice = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jobs() {
        super();
    	studentservice = new StudentService();
        // TODO Auto-generated constructor stub
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
	    User user = JSON.parseObject(sb.toString(), User.class);
	    String json = JSON.toJSONString(studentservice.getUserJobs(user.getUsername()));
		response.getWriter().write(json);
	}

}
