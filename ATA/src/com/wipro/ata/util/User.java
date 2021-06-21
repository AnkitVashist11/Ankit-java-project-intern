package com.wipro.ata.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.ProfileBean;

public class User
{
	public String login(CredentialsBean credentialsBean) throws ClassNotFoundException, SQLException
	{
		if(credentialsBean.getUserID().isEmpty() ||credentialsBean.getPassword().isEmpty())
		{
			return "Don't leave blank fields...";
		}
		Authentication ath=new Authentication();
		boolean b=ath.authenticate(credentialsBean);
		if(b==false)
		{
			return "Invalid Username or Password";
		}
		String s=ath.authorize(credentialsBean.getUserID());
		if(!s.equalsIgnoreCase("a") && !s.equalsIgnoreCase("c"))
		{
			return "User is not authorized";
		}
		boolean bb=ath.changeLoginStatus(credentialsBean,1);
		if(bb)
		{
			return s;
		}
		else
		{
			return "Problem in Login...Retry...";
		}
	}
	public String changePassword(CredentialsBean credentialsBean, String newPassword) throws ClassNotFoundException, SQLException
	{
		Authentication ath=new Authentication();
		boolean b=ath.authenticate(credentialsBean);
		if(b==false)
		{
			return "Username or Password is Invalid...";
		}
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("update ATA_TBL_User_Credentials set password=? where userid=? and password=?");
		pst.setString(1,newPassword);
		pst.setString(2,credentialsBean.getUserID());
		pst.setString(3,credentialsBean.getPassword());
		int n=pst.executeUpdate();
		if(n==1)
		{
			return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}		
	}
	public boolean logout(String userId) throws SQLException, ClassNotFoundException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("update ATA_TBL_User_Credentials set Loginstatus=0 where userId=?");
		pst.setString(1,userId);
		int n=pst.executeUpdate();
		if(n==1)
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
		Authentication ath=new Authentication();
		String ss=ath.register(profileBean);
		return ss;
	}

}
