package com.wipro.carrental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.carrental.bean.CarBookingBean;
import com.wipro.carrental.util.DbUtil;

public class CarBookingDAO 
{  
	public boolean bookACar(CarBookingBean bean) throws ClassNotFoundException, SQLException
	{
		boolean result=false;
	 Connection connection=DbUtil.getDBConnection();
     PreparedStatement pt=connection.prepareStatement("insert into carbooking_tbl values(?,?,?,?,?)");
     pt.setString(1,bean.getBookingId());
     /*Date d=new Date();
		bean.setDateOfHire(d);
		java.sql.Date sqldate=new java.sql.Date(d.getTime());
		pt.setDate(4,sqldate);*/
     pt.setDate(2, new java.sql.Date(bean.getDateOfHire().getTime()));
     pt.setString(3,bean.getCartype());
     pt.setString(4,bean.getCustomerName());
     pt.setString(5,bean.getPhoneNumber());
     
     int i=pt.executeUpdate();
     if(i==1)
     {
   	  result=true;
     }
	    return result;
	}
	
	public boolean cancelACar(String bookingId) throws ClassNotFoundException, SQLException
    { boolean result=false; 
	  Connection connection=DbUtil.getDBConnection(); 
       PreparedStatement pt=connection.prepareStatement("delete from CAR_BOOKING_TBL where Booking_ID=? ");
       pt.setString(1,bookingId);
       int i=pt.executeUpdate();
       if(i==1)
       {result=true;  
       }
	  return result;
     }
  public int findBookedCarsByDate (java.util.Date hireDate,String carType) throws ClassNotFoundException, SQLException
  { int result=0;
    int count=0;
    CarBookingBean bean=new CarBookingBean();
    Connection connection=DbUtil.getDBConnection(); 
     
    PreparedStatement pt=connection.prepareStatement("select Booking_ID from CAR_BOOKING_TBL where  Date_of_hire=? and Car_type=? ");
    pt.setDate(1,new java.sql.Date(bean.getDateOfHire().getTime()) );
    pt.setString(2, carType);
    ResultSet rs=pt.executeQuery();
    while(rs.next())
    {
    	result=count++;
    	
    }
	  return result;
  }
  public int getAvailableCars(String cartype) throws ClassNotFoundException, SQLException
  { 
	int result=0;
	
    Connection connection=DbUtil.getDBConnection();
    
    PreparedStatement pt=connection.prepareStatement("select No_of_cars_Available from CAR_TBL where Car_Type=?");
    pt.setString(1,cartype);
    ResultSet rs=pt.executeQuery();
     while(rs.next())
     {
    	 result=rs.getInt(1);
    	 
    	 
     }
     
    
	  return result;
  }
  public String getBookingID(String carType) throws SQLException, ClassNotFoundException
  {    int id=0;
	   String result=null;
	   Connection connection=DbUtil.getDBConnection();
	   
	   PreparedStatement pt=connection.prepareStatement("select carbooking_sequence.nextval from dual");
	   ResultSet rs=pt.executeQuery();
	   while(rs.next())
	   {
		   id=rs.getInt(1);
		  
	   }
	   result=carType.substring(0,2)+Integer.toString(id);
	  return result;
  }
}
