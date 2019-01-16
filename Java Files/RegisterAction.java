package com.live.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.live.dao.ProfileDAO;
import com.live.form.RegisterForm;

public class RegisterAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegisterForm rf=new RegisterForm();
		String target="";
		rf.setUname(request.getParameter("uname"));
		rf.setLoginname(request.getParameter("loginname"));
		rf.setPassword(request.getParameter("password"));
		rf.setEmail(request.getParameter("email"));
		rf.setSecretquestionid(Integer.parseInt(request.getParameter("secretquestionid")));
		rf.setOwnsecretquestion(request.getParameter("ownsecretquestion"));
		rf.setSecretanswer(request.getParameter("secretanswer"));
		rf.setLogintype("guide");
		try {
			boolean flag=new ProfileDAO().registration(rf);
			if(flag)
				target="LoginForm.jsp";
			else
				target="Register.jsp";
			RequestDispatcher rd=request.getRequestDispatcher(target);
			rd.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
