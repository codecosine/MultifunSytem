package cn.cosine.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.cosine.services.UserService;

/**
 * Servlet implementation class JobDetails
 */
@WebServlet({ "/JobDetails", "/jobDetails" })
public class JobDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userservice = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDetails() {
        super();
        userservice = new UserService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    String json = JSON.toJSONString(userservice.getJobDetails());
		response.getWriter().write(json);
	}

}
