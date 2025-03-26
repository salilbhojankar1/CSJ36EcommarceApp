package Utility;

import java.sql.Connection;
import java.sql.DriverManager;

/*This class will define a static method which will establish connection
 * with database and return an object of Connection
 * 
 */
public class DBUtil {
	public static Connection getConnectWithDB()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CSJ36WebDB1","root","06March@1999");
			System.out.println("Connection Established");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}