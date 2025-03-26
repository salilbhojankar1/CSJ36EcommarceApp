package collector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import model.User;

/**
 * Servlet implementation class CrendentialCreator
 */
@WebServlet("/BasicReg")
public class CrendentialCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrendentialCreator() {
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
		UserDao dao = new UserDao();
		int userId=Integer.parseInt(request.getParameter("t1"));

		String userName=request.getParameter("t2");

		String userPass=request.getParameter("t3");

		String userType=request.getParameter("t4");

		User userObj=new User (userId, userName, userPass,userType);

		User insertuser = dao.addUser(userObj);
		
		if(insertuser!=null)
		{
			User user=dao.getUserById(userId);
			if(user!=null)
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("user-key", user);
				out.println("<script>alter('user crendential created')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("AdminReg.jsp");

				rd.include(request,response);
				
			}//end of inner if
				else
				
				{

					out.println("<h3><font color='red'>User Not Able To Register</font></h3>");
				}
	
					//end of the doPost()
			}
		}
	}


