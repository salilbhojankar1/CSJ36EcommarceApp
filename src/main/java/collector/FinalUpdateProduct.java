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

import Dao.ProductDao;
import model.Product;

/**
 * Servlet implementation class FinalUpdateProduct
 */
@WebServlet("/updateProduct")
public class FinalUpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalUpdateProduct() {
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
		int id = Integer.parseInt(request.getParameter("t1"));
		String name = request.getParameter("t2");
		String category = request.getParameter("t3");
		double  price = Double.parseDouble(request.getParameter("t4"));
		String brand = request.getParameter("t5");
		String date = request.getParameter("t6");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date mfd=null;
		
		
		try {
			mfd= sdf.parse(date);
			
		}catch(ParseException e)
		{
			System.out.println(e);
			
		}
		
		//updateProduct (int pid , Product newProduct)
		
		Product p = new Product();
		p.setProductBrand(brand);
		p.setProductCategory(category);
		p.setProductMfd(mfd);
		p.setProductName(name);
		p.setProductPrice(price);
		ProductDao dao = new ProductDao();
		
		//calling or invoking updateProduct() method
		int updateStatus = dao.updateProduct(id, p);
		
		if (updateStatus>0)
		{
			out.println("successfully updated");
			out.println("<a href = 'viewProduct.jsp'>check your updates</a>");
		}
		else {
			out.println("not able to update");
		}
		
		
	}

}
