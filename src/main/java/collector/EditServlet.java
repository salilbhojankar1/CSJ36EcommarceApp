package collector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;
import model.Product;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditProduct")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		int id=Integer.parseInt(request.getParameter("p1"));
		ProductDao dao=new ProductDao();
		Product pobj= dao.viewByProductId(id);

		out.println("<form action='updateProduct' method='post'>");
		out.println("<label for='ID'>Enter ID: </label>");
		out.println("<input type='text' name='t1' value="+pobj.getProductId()+"><br>");
		
		out.println("<label for='ID'>Enter Name: </label>");
		out.println("<input type='text' name='t2' value="+pobj.getProductName()+"><br>");
		
		out.println("<lebel for='ID'>Enter Category: </label>");
		out.println("<input type='text' name='t3' value="+pobj.getProductCategory()+"><br>");
		
		out.println("<label for='ID'>Enter Price: </label>");
		out.println("<input type='text' name='t4' value="+pobj.getProductPrice()+"><br>");
		
		out.println("<label for='ID'>Enter Brand: </label>");
		out.println("<input type='text' name='t5' value="+pobj.getProductBrand()+"><br>");
		
		out.println("<lebel for='ID'>Enter Date: </label>");
		out.println("<input type='date' name='t6' value="+pobj.getProductMfd()+"><br>");
		
		out.println("<input type='submit' value='Update'>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
