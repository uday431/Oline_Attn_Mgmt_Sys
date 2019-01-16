package com.live.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.live.dao.ProjectDAO;
import com.live.form.ProjectForm;

public class AddProjectDocAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddProjectDocAction() {
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
		pf.setPdoc(request.getParameter("pdoc"));
		pf.setTeamid(request.getParameter("user"));
		pf.setPrjid(Integer.parseInt(request.getParameter("prjid")));
		System.out.println("projinaction"+pf.getPrjid());
		flag=new ProjectDAO().AddProjectDoc(pf);
		
		if(flag)
		{
			target="AddProjectDocs.jsp";
			System.out.println("Success");
		}	
		else
			target="AddProjectDocs.jsp";
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
