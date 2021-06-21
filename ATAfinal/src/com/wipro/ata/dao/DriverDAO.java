package com.wipro.ata.dao;

import java.awt.print.Book;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.util.DBUtil;

public class DriverDAO 
{
	public String createDriver(DriverBean driverBean) throws ClassNotFoundException, SQLException
	{
		String result="FAIL";
		if(checkLicense(driverBean.getLicenseNumber()).equalsIgnoreCase("Licence already exists"))
		{
			return "Licence already exists";
		}
		else
		{
		PreparedStatement prep1=DBUtil.getDBConnection().prepareStatement("insert into  ATA_TBL_Driver values(?,?,?,?,?,?,?,?,?)");
		prep1.setString(1,driverBean.getDriverID());
		prep1.setString(2,driverBean.getName());
		prep1.setString(3,driverBean.getStreet());
		prep1.setString(4,driverBean.getLocation());
		prep1.setString(5,driverBean.getCity());
		prep1.setString(6,driverBean.getState());
		prep1.setString(7,driverBean.getPincode());
		prep1.setString(8,driverBean.getMobileNo());
		prep1.setString(9,driverBean.getLicenseNumber());
		int rows=prep1.executeUpdate();
		if(rows==1)
		{
			result="New Driver Added Successfully";
		}
		}
		return result;
	}
	
	public String generateDriverId(String name) throws ClassNotFoundException, SQLException
	{
		String id="";
		String driverId="";
		PreparedStatement prep2=DBUtil.getDBConnection().prepareStatement("select ata_seq_driverId.nextval from dual");
		ResultSet rs=prep2.executeQuery();
		while(rs.next())
		{
			id=rs.getString(1);
			driverId=name.substring(0,2).toUpperCase()+id;
		}
		return driverId;
		
	}
	public String checkLicense(String licenseNumber) throws ClassNotFoundException, SQLException
	{
		String result="FAIL";
		PreparedStatement prep3=DBUtil.getDBConnection().prepareStatement("select * from  ATA_TBL_Driver where LicenseNumber=?");
		prep3.setString(1, licenseNumber);
		ResultSet rs=prep3.executeQuery();
		while(rs.next())
		{
			result="Licence already exists";
		}
		return result;
	}
	
	public int deleteDriver(String driverId) throws ClassNotFoundException, SQLException
	{
		int count=0;
		PreparedStatement prep2=DBUtil.getDBConnection().prepareStatement("delete from  ATA_TBL_Driver where driverID =?");
		prep2.setString(1,driverId);
		int rows=prep2.executeUpdate();
		if(rows>0)
		{
			count++;
		}
		return count;
	}
	
	public boolean updateDriverDetails(DriverBean driverBean) throws ClassNotFoundException, SQLException
	{
		boolean flag=false;
		if(checkLicense(driverBean.getLicenseNumber()).equalsIgnoreCase("Licence already exists"))
		{
			return false;
		}
		else
		{
			PreparedStatement prep4=DBUtil.getDBConnection().prepareStatement("update ATA_TBL_Driver set Name=?,Street=?,Location=?,City=?,State=?,Pincode=?,MobileNo=?,LicenseNumber=? where driverId=?");
			prep4.setString(1, driverBean.getName());
			prep4.setString(2, driverBean.getStreet());
			prep4.setString(3, driverBean.getLocation());
			prep4.setString(4, driverBean.getCity());
			prep4.setString(5, driverBean.getState());
			prep4.setString(6, driverBean.getPincode());
			prep4.setString(7, driverBean.getMobileNo());
			prep4.setString(8, driverBean.getLicenseNumber());
			prep4.setString(9, driverBean.getDriverID());
			int rows=prep4.executeUpdate();
			if(rows>0)
			{
				System.out.println(1);
				flag=true;
			}
			return flag;
		}
	}
	
	public DriverBean findById(String driverId) throws ClassNotFoundException, SQLException
	{
		DriverBean driverBean = null;
		PreparedStatement prep5=DBUtil.getDBConnection().prepareStatement("select * from ATA_TBL_Driver where driverId=?");
		prep5.setString(1, driverId);
		ResultSet rs=prep5.executeQuery();
		if(rs.next())
		{
			driverBean = new DriverBean();
			driverBean.setDriverID(rs.getString(1));
			driverBean.setName(rs.getString(2));
			driverBean.setStreet(rs.getString(3));
			driverBean.setLocation(rs.getString(4));
			driverBean.setCity(rs.getString(5));
			driverBean.setState(rs.getString(6));
			driverBean.setPincode(rs.getString(7));
			driverBean.setMobileNo(rs.getString(8));
			driverBean.setLicenseNumber(rs.getString(9));
			return driverBean;
		}
		else
		{
			return null;
		}
		
		
	}
	public ArrayList<DriverBean>findAllDrivers() throws ClassNotFoundException, SQLException
	{
		DriverBean driverBean = null;
		ArrayList<DriverBean>list=new ArrayList<DriverBean>();
		PreparedStatement prep6=DBUtil.getDBConnection().prepareStatement("select * from ATA_TBL_Driver");
		ResultSet rs=prep6.executeQuery();
		while(rs.next())
		{
			driverBean = new DriverBean();
			driverBean.setDriverID(rs.getString(1));
			driverBean.setName(rs.getString(2));
			driverBean.setStreet(rs.getString(3));
			driverBean.setLocation(rs.getString(4));
			driverBean.setCity(rs.getString(5));
			driverBean.setState(rs.getString(6));
			driverBean.setPincode(rs.getString(7));
			driverBean.setMobileNo(rs.getString(8));
			driverBean.setLicenseNumber(rs.getString(9));
			list.add(driverBean);
		}
		return list;
	}
	public String allotDriver(String reservationID, String driverID) throws ClassNotFoundException, SQLException
	{
		Date date = null;
		String resultt;
		ReservationBean reserveBean=new ReservationBean();
		boolean flag=false;
		PreparedStatement prep9=DBUtil.getDBConnection().prepareStatement("select JourneyDate,BookingStatus,driverId from  ATA_TBL_Reservation where reservationId=?");
		prep9.setString(1, reservationID);
		ResultSet rs=prep9.executeQuery();
		if(rs.next())
		{
			flag=true;
			
			date=new Date(rs.getDate(1).getTime());
			resultt=rs.getString(2);
			if(resultt.equalsIgnoreCase("Unbooked"))
			{
				return "UNBOOKED";
			}
			if(rs.getString(3)!=null)
			{
				return "Already Allotted";
			}
		}
		if(flag==false)
		{
			return "INVALID";
		}
		PreparedStatement prep7=DBUtil.getDBConnection().prepareStatement("select DriverId from  ATA_TBL_Reservation where driverId=? and JourneyDate=?");
		prep7.setString(1, driverID);
		prep7.setDate(2,new java.sql.Date(date.getTime()));
		ResultSet rst=prep7.executeQuery();
		if(rst.next())
		{
			flag=true;
			return "DRIVER BUSY";
		}
		else
		{
			PreparedStatement prep8=DBUtil.getDBConnection().prepareStatement("update ATA_TBL_Reservation set DriverId=? where reservationId=?");
			prep8.setString(1, driverID);
			prep8.setString(2, reservationID);
			int rows=prep8.executeUpdate();
			if(rows>0)
			{
				flag=false;
			}
		}
		return "SUCCESS";
	}                                                                                                               


}

