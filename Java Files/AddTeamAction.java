package com.live.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.live.dao.ProfileDAO;
import com.live.dao.SecurityDAO;
import com.live.form.RegisterForm;

public class AddTeamAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddTeamAction() {
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
		HttpSession sess=request.getSession();
		boolean flag=false;
		try{
			rf.setBatchno((String)sess.getAttribute("bno"));
			rf.setYear(Integer.parseInt((String)sess.getAttribute("year")));
			rf.setLoginname((String)sess.getAttribute("loginname"));
			rf.setPassword((String)sess.getAttribute("password"));
			rf.setUname((String)sess.getAttribute("uname"));
			rf.setPrjname((String)sess.getAttribute("prjname"));
			rf.setTechused((String)sess.getAttribute("techused"));
			rf.setSecretquestionid(Integer.parseInt(((String)sess.getAttribute("secretquestionid"))));
			rf.setOwnsecretquestion((String)sess.getAttribute("ownsecretquestion"));
			rf.setSecretanswer((String)sess.getAttribute("secretanswer"));
			rf.setLogintype("team");
			
			flag=new ProfileDAO().registration(rf);
			
			if(flag)
			{
				Enumeration em=sess.getAttributeNames();
				while(em.hasMoreElements())
				{
					String dd=(String)em.nextElement();
					System.out.println("attrib"+dd);
					if(dd.equalsIgnoreCase("bno") || dd.equalsIgnoreCase("role") || dd.equalsIgnoreCase("year") || dd.equalsIgnoreCase("loginname") || dd.equalsIgnoreCase("password") || dd.equalsIgnoreCase("uname") || dd.equalsIgnoreCase("email") || dd.equalsIgnoreCase("prjname") || dd.equalsIgnoreCase("techused") || dd.equalsIgnoreCase("secretquestionid") || dd.equalsIgnoreCase("secretanswer") || dd.equalsIgnoreCase("ownsecretquestion") || dd.equalsIgnoreCase("projtype"))
					{
						System.out.println("Sorry");
					}
					else{
						//String did=(String)(em.nextElement());
						String svar=(String)sess.getAttribute(dd);
	    	 			String s[]=svar.split(",");
	    	 			System.out.println("hiiii"+svar);
	    	 			String mname=s[0];
	    	 			String mail=s[1];
						rf.setMname(mname);
						rf.setMemail(mail);
						rf.setRegdno(dd);
						flag=new ProfileDAO().AddTeamMembers(rf);
					}
				}		
			}
		}catch(Exception e)
			{e.printStackTrace();}
			if(flag)
			{
				String user=(String)sess.getAttribute("user");
				System.out.println("user"+user);
				String role=null;
				try {
					role=new SecurityDAO().getLoginType(user);
					System.out.println("role"+role);
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sess.invalidate();
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			session.setAttribute("role", role);
			target="TeamRegister.jsp";
		}	
		else
			target="TeamRegister.jsp";
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
