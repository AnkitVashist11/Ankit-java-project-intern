package com.wipro.ata.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.ProfileBean;

public class Authentication 
{
	public boolean authenticate(CredentialsBean credentialsBean) throws ClassNotFoundException, SQLException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("select * from ATA_TBL_User_Credentials where Userid=? and password=?");
		pst.setString(1,credentialsBean.getUserID());
		pst.setString(2,credentialsBean.getPassword());
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int checkLoginStatus(String userID,String password)
	{
		Connection connection;
		try {
			connection = DBUtil.getDBConnection();
			PreparedStatement pst=connection.prepareStatement("select Loginstatus from ATA_TBL_User_Credentials where Userid=? and password=?");
			pst.setString(1,userID);
			pst.setString(2,password);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return -1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public String authorize(String userID) throws SQLException, ClassNotFoundException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("select Usertype from ATA_TBL_User_Credentials where Userid=?");
		pst.setString(1,userID);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			return rs.getString(1);
		}
		else
		{
			return null;
		}
	}
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) throws SQLException, ClassNotFoundException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("update ATA_TBL_User_Credentials set Loginstatus=? where userId=?");
		pst.setInt(1,loginStatus);
		pst.setString(2,credentialsBean.getUserID());
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	public String register(ProfileBean profileBean) throws ClassNotFoundException, SQLException
	{
		java.sql.Date sqlDate=new java.sql.Date(profileBean.getDateOfBirth().getTime());
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("insert into ATA_TBL_User_Profile values(?,?,?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1,profileBean.getUserID());
		pst.setString(2,profileBean.getFirstName());
		pst.setString(3,profileBean.getLastName());
		pst.setDate(4,sqlDate);
		pst.setString(5,profileBean.getGender());
		pst.setString(6,profileBean.getStreet());
		pst.setString(7,profileBean.getLocation());
		pst.setString(8,profileBean.getCity());
		pst.setString(9,profileBean.getState());
		pst.setString(10,profileBean.getPincode());
		pst.setString(11,profileBean.getMobileNo());
		pst.setString(12,profileBean.getEmailID());
		int n=pst.executeUpdate();
		if(n==1)
		{
			return profileBean.getUserID();
		}
		else
		{
			return "FAIL";
		}
	}
	public boolean addUser(CredentialsBean credentialsBean) throws ClassNotFoundException, SQLException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement ps=connection.prepareStatement("insert into ATA_TBL_User_Credentials values(?,?,'C','0')");
		ps.setString(1,credentialsBean.getUserID());
		ps.setString(2,credentialsBean.getPassword());
		int n=ps.executeUpdate();
		if(n==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String generateUserId(String firstName) throws ClassNotFoundException, SQLException
	{
		int n=0;
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("select ata_seq_userId.nextval from dual");
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			n=rs.getInt(1);
		}
		return firstName.substring(0,2).toUpperCase()+n;
	}
}
