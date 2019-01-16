package com.live.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live.dao.ProfileDAO;
import com.live.form.RegisterForm;

public class TeamRegisterAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TeamRegisterAction() {
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

		boolean flag=false;
		String target="";
		RegisterForm rf=new RegisterForm();
		response.setContentType("text/html");
		HttpSession sess=request.getSession();
		if((sess.isNew()))
		{	
			sess=request.getSession();
		} 
//		if(request.getParameter("add").equalsIgnoreCase("ADD TEAM"))
//		{
			System.out.println("in session");
			String bno=request.getParameter("batchno");
			System.out.println("insdfdsaf"+bno);
			sess.setAttribute("bno",bno);
			String year=request.getParameter("year");
			sess.setAttribute("year",year);
			String loginname=request.getParameter("loginname");
			sess.setAttribute("loginname",loginname);
			String password=request.getParameter("password");
			sess.setAttribute("password",password);
			String uname=request.getParameter("uname");
			sess.setAttribute("uname",uname);
			String email=request.getParameter("email");
			sess.setAttribute("email",email);
			String prjname=request.getParameter("prjname");
			sess.setAttribute("prjname",prjname);
			String techused=request.getParameter("techused");
			sess.setAttribute("techused",techused);
			String secretquestionid=request.getParameter("secretquestionid");
			sess.setAttribute("secretquestionid",secretquestionid);
			if(request.getParameter("ownsecretquestion")!=null){
				String ownsecretquestion=request.getParameter("ownsecretquestion");
				sess.setAttribute("ownsecretquestion",ownsecretquestion);
			}
			String secretanswer=request.getParameter("secretanswer");
			sess.setAttribute("secretanswer",secretanswer);
			String projtype=request.getParameter("projtype");
			sess.setAttribute("projtype", projtype);
			flag=true;
//		}
		
			if(flag)
				target="AddTeamMembers.jsp";
			else
				target="TeamRegister.jsp";
			RequestDispatcher rd=request.getRequestDispatcher(target);
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
