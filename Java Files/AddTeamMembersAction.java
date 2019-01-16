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

public class AddTeamMembersAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddTeamMembersAction() {
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
		response.setContentType("text/html");
		HttpSession sess=request.getSession();
		
		if(request.getParameter("add").equalsIgnoreCase("ADD TEAM"))
		{
			System.out.println("in session");
			String uname=request.getParameter("uname");
			System.out.println("insdfdsaf"+uname);
			String email=request.getParameter("email");
			String regdno=request.getParameter("regdno");
			String sesvar=uname+","+email;
			sess.setAttribute(regdno, sesvar);
			
			flag=true;
		}
		
			if(flag)
				target="AddTeamMembers.jsp";
			else
				target="AddTeamMembers.jsp";
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
