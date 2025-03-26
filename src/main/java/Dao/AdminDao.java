package Dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;

import Utility.DBUtil;
import model.Admin;
import service.AdminService;

public class AdminDao implements AdminService {

	
	public Admin addAdmin(Admin admin) {
		
	try
	{
		Connection con=DBUtil.getConnectWithDB();
		PreparedStatement ps= con.prepareStatement("insert into admin values(?,?,?,?,?,?,?)");
		
		ps.setInt(1, admin.getAdminId());

		ps.setString(2, admin.getAdminName());

		ps.setString(3,admin.getAdminAddress());

		ps.setString(4,admin.getAdminEmail());

		ps.setLong(5, admin.getAdminPhone());

	Date d1 = admin.getAdminDob();

		long millseconds = d1.getTime();

		java.sql.Date dob=new java.sql.Date(millseconds);
		ps.setDate(6, dob);

		ps.setInt(7, admin.getUser().getUserId());

		int adminStatus=ps.executeUpdate();

		if(adminStatus>0)

		{
			return admin;
		}

	}

		
		catch(Exception e)
		{
			System.out.println(e);
		}
	return null;
	}

}
