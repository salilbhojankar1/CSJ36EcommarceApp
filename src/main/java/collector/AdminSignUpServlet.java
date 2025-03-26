package collector;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AdminDao;
import model.Admin;
import model.User;

/**
 * Servlet implementation class AdminSignUpServlet
 */
@WebServlet("/AdminReg")//
public class AdminSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//reading all inputs from client
		int adminId=Integer.parseInt(request.getParameter("id"));
		String adminName= request.getParameter("name");
		String adminAddress=request.getParameter("address");
		String adminMail = request.getParameter("mail");
		long ph= Long.parseLong(request.getParameter("phone"));
		String dob=request.getParameter("dob");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date adminDob =null;
		try
		{	
			
			//parse method converting string into java.util.date
			//java.util.date parse(string  )throws parseException
			adminDob = format.parse(dob);
			
		}catch(ParseException e)
		{
			System.out.println(e);
		}
		
		
		//getting user object from session
		HttpSession session = request.getSession(true);
		User user=(User)session.getAttribute("user-key");
		
		Admin adminObj = new Admin(adminId, adminName, adminAddress, adminMail,ph,adminDob,user);

		
			AdminDao dao = new AdminDao();
		Admin insertedStatus=	dao.addAdmin(adminObj);
			
			if(insertedStatus!=null)
			{
				out.println("<center><h3><font color='blue'>Registration Completed Successfully></font></h3></center>");
						out.println("<a href='login.jsp'>Login Here</a>");
			}
			else
			{
				out.print("<center><h3><font color='red'>Registration Failed</font></h3></center>");
			}
			}
}

