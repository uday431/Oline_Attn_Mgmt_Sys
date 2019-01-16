package com.live.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddTimeSheetAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddTimeSheetAction() {
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
		String tsdate="";
		if(request.getParameter("add").equalsIgnoreCase("ADD TimeSheet"))
		{
			System.out.println("in session");
			String hour=request.getParameter("hour");
			System.out.println("insdfdsaf"+hour);
			String work=request.getParameter("work");
			String status=request.getParameter("status");
			tsdate=request.getParameter("tdate");
			String sesvar1=work+","+status+","+tsdate;
			sess.setAttribute(hour, sesvar1);

			flag=true;
		}
		
			if(flag)
				target="TimeSheet.jsp?tsdate="+tsdate;
			else
				target="TimeSheet.jsp";
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
