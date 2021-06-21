package com.wipro.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.ata.bean.ProfileBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.util.DBUtil;

public class ReservationDAO
{
	public String generateReservationId() throws ClassNotFoundException, SQLException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("select ata_seq_reservationId.nextval from dual");
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			return rs.getString(1);
		}
		return null;
	}
	public String checkReservationByVehicleId(String vehicleId,Date date) throws ClassNotFoundException, SQLException
	{
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("select bookingStatus,journeydate from ATA_TBL_Reservation where vehicleId=?");
		pst.setString(1,vehicleId);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			Date dat=new Date(rs.getDate(2).getTime());
			if(dat.getDate()==date.getDate())
			{
				if(rs.getString(1).equalsIgnoreCase("Unbooked"))
				{
					return "unbooked";
				}
				else
				{
					return "booked";
				}
			}
			else
			{
				return "Not Present";
			}
			
		}
		else
		{
			return "Not Present";
		}
	}
	public ReservationBean viewBookingDetails(String reservationID) throws ClassNotFoundException, SQLException
	{
		ReservationBean reserveBean=null;
		PreparedStatement prep1=DBUtil.getDBConnection().prepareStatement("Select * from  ATA_TBL_Reservation where reservationId=?");
		prep1.setString(1, reservationID);
		ResultSet rs=prep1.executeQuery();
		while(rs.next())
		{
			reserveBean=new ReservationBean();
			reserveBean.setReservationID(rs.getString(1));
			reserveBean.setUserID(rs.getString(2));
			reserveBean.setVehicleID(rs.getString(3));
			reserveBean.setRouteID(rs.getString(4));
			reserveBean.setBookingDate(rs.getDate(5));
			reserveBean.setJourneyDate(rs.getDate(6));
			reserveBean.setDriverID(rs.getString(7));
			reserveBean.setBookingStatus(rs.getString(8));
			reserveBean.setTotalFare(rs.getDouble(9));
			reserveBean.setBoardingPoint(rs.getString(10));
			reserveBean.setDropPoint(rs.getString(11));
		}
		return reserveBean;
		
	}
	
	
	//*************imneet
	
	/*public ReservationBean viewBookingDetails(String reservationID) throws ClassNotFoundException, SQLException
	{
		ReservationBean reserveBean=null;
		PreparedStatement prep1=DBUtil.getDBConnection().prepareStatement("Select * from  ATA_TBL_Reservation where reservationId=?");
		prep1.setString(1, reservationID);
		ResultSet rs=prep1.executeQuery();
		while(rs.next())
		{
			reserveBean=new ReservationBean();
			reserveBean.setReservationID(rs.getString(1));
			reserveBean.setUserID(rs.getString(2));
			reserveBean.setVehicleID(rs.getString(3));
			reserveBean.setRouteID(rs.getString(4));
			reserveBean.setBookingDate(rs.getDate(5));
			reserveBean.setJourneyDate(rs.getDate(6));
			reserveBean.setDriverID(rs.getString(7));
			reserveBean.setBookingStatus(rs.getString(8));
			reserveBean.setTotalFare(rs.getDouble(9));
			reserveBean.setBoardingPoint(rs.getString(10));
			reserveBean.setDropPoint(rs.getString(11));
		}
		return reserveBean;
	}*/
	public ArrayList<ReservationBean> viewAllReservationDetails() throws ClassNotFoundException, SQLException
	{
		
		ArrayList<ReservationBean>list=new ArrayList<ReservationBean>();
		PreparedStatement prepstmt=DBUtil.getDBConnection().prepareStatement("select * from  ATA_TBL_Reservation");
		ResultSet rs=prepstmt.executeQuery();
		while(rs.next())
		{
			ReservationBean reserveBean=new ReservationBean();
			reserveBean.setReservationID(rs.getString(1));
			list.add(reserveBean);
		}
		return list;
	}
	public String findById(String userId) throws ClassNotFoundException, SQLException
	{
		ProfileBean pfBean=new ProfileBean();
		String firstName;
		String lastName;
		PreparedStatement prep2=DBUtil.getDBConnection().prepareStatement("select Firstname,Lastname from ATA_TBL_User_Profile where UserId=?");
		prep2.setString(1, userId);
		ResultSet rs=prep2.executeQuery();
		while(rs.next())
		{
			
			firstName=rs.getString(1);
			lastName=rs.getString(2);
			
			pfBean.setFirstName(firstName);
			pfBean.setLastName(lastName);
			return firstName+" "+lastName;
		}
		return null;
	}
	
	//***navan
	
	public boolean cancelBooking(String userID, String reservationID) throws SQLException, ClassNotFoundException
	{
		Connection con = DBUtil.getDBConnection();
		boolean update = false;
		int rows;
		String book ="UNBOOKED";
		
		PreparedStatement pstmt = con.prepareStatement("update ATA_TBL_Reservation set BookingStatus=?,vehicleid=null,driverid=null,routeid=null where UserId=? and reservationId=?");
		pstmt.setString(1, book);
		pstmt.setString(2, userID);
		pstmt.setString(3, reservationID);
		rows = pstmt.executeUpdate();
		
		if(rows>0)
		{
			update = true;
			return update;
		}
		return update;
	}
	
	// ****
	
	
	public Date checkJourneyDate(String userID, String reservationID) throws SQLException, ClassNotFoundException
	{
		Connection con = DBUtil.getDBConnection();
		Date checkDate = null ;
		
		PreparedStatement pstmt = con.prepareStatement("select JourneyDate from ATA_TBL_Reservation where UserId=? and reservationId=?");
		pstmt.setString(1, userID);
		pstmt.setString(2, reservationID);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			checkDate = rs.getDate(1);
			return checkDate;
		}
		return checkDate;
	}
	
	
	// ****
	public boolean checkUserId(String userId) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		boolean check = false;
		
		PreparedStatement pstmt = con.prepareStatement("select * from ATA_TBL_Reservation where UserId=?");
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			check = true;
			return check;
		}
		return check;
	}
	
	public boolean checkReservationId(String reservationId) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		boolean check = false;
		
		PreparedStatement pstmt = con.prepareStatement("select * from ATA_TBL_Reservation where reservationId=?");
		pstmt.setString(1, reservationId);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			check = true;
			return check;
		}
		return check;
	}
	
	public String checkBookingStatus(String userId, String reservationId) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		String status = null ;
		
		PreparedStatement pstmt = con.prepareStatement("select BookingStatus from ATA_TBL_Reservation where reservationId=? and UserId=?");
		pstmt.setString(1, reservationId);
		pstmt.setString(2, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			status = rs.getString(1);
			return status;
		}
		return status;
	}
	
	public String refundMoney(String userId, String reservationId) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		String refund = "NOT REFUNDED" ;
		
		Double fare = creditCardUpdate(userId , reservationId);
		
		PreparedStatement pstmt = con.prepareStatement("update ATA_TBL_CreditCard set CreditBalance=CreditBalance+? where UserId=?");
		pstmt.setString(2, userId);
		pstmt.setDouble(1,fare);
		int rows = pstmt.executeUpdate();
		System.out.println(rows);
		
		if(rows>0)
		{
			return "REFUNDED";
		}
		return refund;
	}
	
	public Double creditCardUpdate(String userId, String reservationId) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		Double totalFare = null ;
		
		PreparedStatement pstmt = con.prepareStatement("select TotalFare from ATA_TBL_Reservation where reservationId=? and UserId=?");
		pstmt.setString(1, reservationId);
		pstmt.setString(2, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			totalFare = Double.parseDouble(rs.getString(1));
			return totalFare;
		}
		return totalFare;
	}
	
	//**********ankit
	
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination) throws ClassNotFoundException, SQLException 
	{
		ArrayList<ReservationBean> list=new ArrayList<ReservationBean>();
		Connection connection=DBUtil.getDBConnection();
		ReservationBean reserveBean=null;
		PreparedStatement pt=connection.prepareStatement("Select * from  ATA_TBL_Reservation where JourneyDate=? and BoardingPoint=? and DropPoint=?");
		pt.setDate(1, new java.sql.Date(journeyDate.getTime()));
		pt.setString(2, source.toUpperCase().trim());
		pt.setString(3, destination.toUpperCase().trim());
		ResultSet rs=pt.executeQuery();
		while(rs.next())
		{
			reserveBean=new ReservationBean();
			reserveBean.setReservationID(rs.getString(1));
			reserveBean.setUserID(rs.getString(2));
			reserveBean.setVehicleID(rs.getString(3));
			reserveBean.setRouteID(rs.getString(4));
			reserveBean.setBookingDate(rs.getDate(5));
			reserveBean.setJourneyDate(rs.getDate(6));
			reserveBean.setDriverID(rs.getString(7));
			reserveBean.setBookingStatus(rs.getString(8));
			reserveBean.setTotalFare(rs.getDouble(9));
			reserveBean.setBoardingPoint(rs.getString(10));
			reserveBean.setDropPoint(rs.getString(11));
			list.add(reserveBean);
		}
		return list;
	}
}

