package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import service.ProductService;
import Utility.DBUtil;
import model.Product;

public class ProductDao implements ProductService{

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtil.getConnectWithDB();
			String insertQuery = "insert into Product_Table(product_name,product_category,product_price,product_brand,product_mfd) values(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setDouble(3, product.getProductPrice());
			ps.setString(4, product.getProductBrand());
			java.util.Date d1 = product.getProductMfd();
			long milliseconds = d1.getTime();
			java.sql.Date mfd = new java.sql.Date(milliseconds);
			ps.setDate(5, mfd);
			int insertStatus = ps.executeUpdate();
			if(insertStatus>0) {
				return product;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> listOfProduct = new ArrayList();
		try {
			Connection con = DBUtil.getConnectWithDB();
			String selectQuery = "Select * from Product_Table";
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt(1);
				String pname = rs.getString(2);
				String pcat = rs.getString(3);
				double price = rs.getDouble(4);
				String brand = rs.getString(5);
				java.sql.Date d1 = rs.getDate(6);
				long milsec = d1.getTime();
				java.util.Date mfd = new java.util.Date(milsec);
				//constructing product object by fetching data from database
				Product pObj = new Product(pid,pname,pcat,price,brand,mfd);
				listOfProduct.add(pObj);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return listOfProduct;
	}

	@Override
	public Product viewByProductId(int pid) {
		// TODO Auto-generated method stub
		Product product=null;

		try {

		Connection con=DBUtil.getConnectWithDB();

		String selectQueryById="select * from Product_Table where product_id=?";

		PreparedStatement ps=con.prepareStatement(selectQueryById);

		ps.setInt(1, pid);

		ResultSet rs=ps.executeQuery();

		if(rs.next())
		{

		product = new Product();

		int id=rs.getInt(1);

		String name=rs.getString(2);

		String category=rs.getString(3);

		double price=rs.getDouble(4);

		String brand=rs.getString(5);

		java.sql.Date d1=rs.getDate(6);
		
		long milisec=d1.getTime();

		java.util.Date mfd=new java.util.Date(milisec);

		product.setProductId(id);

		product.setProductName(name);

		product.setProductCategory(category);

		product.setProductPrice(price);

		product.setProductBrand(brand);

		product.setProductMfd(mfd);

		return product;
		}

	}catch(Exception e)
		{
		System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Product> viewByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> viewByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(int pid, Product newProduct) {
		
	try {
		Connection con=DBUtil.getConnectWithDB();
		String updateQuery = "UPDATE Product_Table SET product_name=?,product_category=?,product_price=?,product_brand=?,product_mfd=? where product_id=? " ;
		PreparedStatement ps=con.prepareStatement(updateQuery);
		ps.setString(1, newProduct.getProductName());
		ps.setString(2, newProduct.getProductCategory());
		ps.setDouble(3, newProduct.getProductPrice());
		ps.setString(4, newProduct.getProductBrand());
		
		ps.setDate(5, new java.sql.Date(newProduct.getProductMfd().getTime()));
		ps.setInt(6, pid);
		
		int updateStatus=ps.executeUpdate();
		
		if(updateStatus>0) {
			return updateStatus;
		}

	}catch(Exception e) {
		System.out.println(e);
	}
	return 0;
	}

	@Override
	public int removeProduct(int pid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
