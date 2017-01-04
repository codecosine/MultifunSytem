package cn.cosine.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.cosine.models.Message;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**s
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
        InputStream in=request.getInputStream();
        Date time = new Date();
        String root = request.getServletContext().getRealPath("/");
        File f = new File(root+"tmp/upload/"+time.getTime());
        FileOutputStream fout = new FileOutputStream(f);
        byte[] b=new byte[1024];
        int n=0;
        while ((n=in.read(b))!=-1){
            fout.write(b,0,n);
        }
        fout.close();
        in.close();
        Message msg = new Message(true,"上传成功",JSON.toJSONString(time.getTime()));
	    response.getWriter().write(JSON.toJSONString(msg));
	}

}
