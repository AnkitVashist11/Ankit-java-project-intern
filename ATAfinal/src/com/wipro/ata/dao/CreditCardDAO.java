package com.wipro.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.util.DBUtil;

public class CreditCardDAO
{
	public String checkCreditCard(CreditCardBean creditCardBean) throws ClassNotFoundException, SQLException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("select userId,CreditBalance from ATA_TBL_CreditCard where CreditCardNumber=? and ValidFrom=? and ValidTo=?");
		pst.setString(1,creditCardBean.getCreditCardNumber());
		pst.setString(2,creditCardBean.getValidFrom());
		pst.setString(3,creditCardBean.getValidto());
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			return rs.getString(1)+" "+rs.getInt(2);
		}
		else
		{
			return "INVALID";
		}	
	}
	public boolean updateBalance(CreditCardBean creditCardBean,double totalFare) throws ClassNotFoundException, SQLException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("update ATA_TBL_CreditCard set CreditBalance=CreditBalance-? where CreditCardNumber=?");
		pst.setDouble(1,totalFare);
		pst.setString(2,creditCardBean.getCreditCardNumber());
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
}
