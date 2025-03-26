package collector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/userLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName =request.getParameter("userName");
		String password =request.getParameter("userPass");
		
		UserDao dao = new UserDao();
		User userObj= dao.signIn(userName, password);
		
		if(userObj!=null)

		{

		HttpSession session = request.getSession(true);

		session.setAttribute("loginInfo", userObj);

		if(userObj.getUserType().equalsIgnoreCase("ADMIN"))

		{
			response.sendRedirect("AdminTask.jsp");
		}

		

		else if(userObj.getUserType().equalsIgnoreCase("customer"))

		{

		response.sendRedirect("customerPage.jsp");
		}
		
		

		}
		}
	}
