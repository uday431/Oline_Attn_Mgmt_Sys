package com.live.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.live.dao.ProjectDAO;
import com.live.form.ProjectForm;

public class AddProjectStatusAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddProjectStatusAction() {
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

		ProjectForm pf=new ProjectForm();
		String target="";
		boolean flag=false;
		pf.setStatus(request.getParameter("status"));
		pf.setPrjid(Integer.parseInt(request.getParameter("projname")));
		pf.setPercent(Double.parseDouble(request.getParameter("percent")));
		flag=new ProjectDAO().updateProjectStatus(pf);
		
		if(flag)
		{
			target="AddProjectStatus.jsp";
			System.out.println("Success");
		}	
		else
			target="AddProjectStatus.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
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
