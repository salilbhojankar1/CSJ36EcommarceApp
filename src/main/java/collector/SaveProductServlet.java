package collector;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;
import model.Product;

/**
 * Servlet implementation class SaveProductServlet
 */
@WebServlet("/SaveProduct")
public class SaveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveProductServlet() {
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
		
		
		String pname=request.getParameter("t1");
		String pcat = request.getParameter("t2");
		double price = Double.parseDouble(request.getParameter("t3"));
		String brand =request.getParameter("t4");
		String pdate =request.getParameter("t5");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date mfd = null;
		
		try {
			mfd = sdf.parse(pdate);
			
		}catch(ParseException e)
		{
			System.out.println(e);
		}
		
		Product productObj = new Product();
		productObj.setProductName(pname);
		productObj.setProductCategory(pcat);
		productObj.setProductPrice(price);
		productObj.setProductBrand(brand);
		productObj.setProductMfd(mfd);
	
		
		ProductDao dao = new ProductDao();
		Product insertedProduct = dao.addProduct(productObj);
		
		if(insertedProduct!=null)
		{
			out.println("<script>alter('product added successfully')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("adminTask.jsp");

			rd.include(request, response);

			}else



			{ out.println("<h3><font color='red'>not able to add product</font></h3>");

			}
		}
		
		
	}


