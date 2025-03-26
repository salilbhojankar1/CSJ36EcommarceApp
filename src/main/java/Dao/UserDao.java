package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utility.DBUtil;
import model.User;
import service.UserService;

public class UserDao implements UserService {
	
	
	
	@Override
	public User addUser(User user)
	{
		try
		{
			
			Connection con =DBUtil.getConnectWithDB();
			PreparedStatement ps=con.prepareStatement("insert into User_Table value(?,?,?,?)");
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getUserPass());
			ps.setString(4, user.getUserType());
			int status=ps.executeUpdate();
			if(status>0)
			{
				return user;
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public User getUserById(int userId) {
		User user=null;
		try
		{
			Connection con =DBUtil.getConnectWithDB();
			PreparedStatement ps = con.prepareStatement("Select * from User_Table where user_id=?");
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())

			{
			 user =new User();
			int id=rs.getInt(1);
			String userName=rs.getString(2);
			String userPass=rs.getString(3);
			String userType=rs.getString(4);
			user.setUserId(userId);
			user.setUserName (userName);
			user.setUserPass (userPass);
			user.setUserType(userType);
			}

		}
		catch(Exception e) 
		{
			System.out.println(e);
		}

		return user;
	}



	@Override
	public User signIn(String userName, String password) {
		
		try {
			Connection con = DBUtil.getConnectWithDB();
			PreparedStatement ps = con.prepareStatement("select * from User_Table where user_name=? and user_password=?");
			
			ps.setString(1,userName);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())

			{

			User user =new User();
			int uid=rs.getInt(1);
			String uname=rs.getString(2);
			String upass=rs.getString(3);
			String utype=rs.getString(4);

			user.setUserId(uid);
			user.setUserName(uname);
			user.setUserPass(upass);
			user.setUserType(utype);

			return user;

			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return null;
	}
}

