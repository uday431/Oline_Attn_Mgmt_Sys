package com.live.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live.dao.SecurityDAO;
import com.live.form.RegisterForm;

public class LoginAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginAction() {
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

		RegisterForm ef=new RegisterForm();
		ef.setLoginname(request.getParameter("loginname"));
		ef.setPassword(request.getParameter("password"));
		String responsekey="LoginForm.jsp";
		try{
		 String role=new SecurityDAO().loginCheck(ef);
         System.out.println("r"+role);
         HttpSession session=request.getSession();
         if(role.equalsIgnoreCase("admin"))
         { 
        	responsekey="AdminHome.jsp";
            session.setAttribute("user",ef.getLoginname());
            session.setAttribute("role",role);
         } 
         else if(role.equalsIgnoreCase("guide"))
         {
      	 
      		 int status = new SecurityDAO().checkFirstLogin(ef.getLoginname());
      		 if(status==1)
      		 {
      			 responsekey="GuideHomePage.jsp";
      			 session.setAttribute("user",ef.getLoginname());
      			 session.setAttribute("role",role);
      		 }
      	 } 
         else if(role.equalsIgnoreCase("team"))
         {
      	 
      		 int status = new SecurityDAO().checkFirstLogin(ef.getLoginname());
      		 if(status==1)
      		 {
      			 responsekey="TeamHomePage.jsp";
      			 session.setAttribute("user",ef.getLoginname());
      			 session.setAttribute("role",role);
      		 }
      	 } 
         //}
         else  
        	 responsekey="LoginForm.jsp";
            }catch(Exception e){} 
 			 System.out.println("responsekey"+responsekey);
 			RequestDispatcher rd=request.getRequestDispatcher(responsekey);
			rd.forward(request,response);
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
