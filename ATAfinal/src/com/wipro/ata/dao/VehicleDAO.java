package com.wipro.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.util.DBUtil;

public class VehicleDAO 
{
	public String bookVehicle(ReservationBean reservationBean) throws ClassNotFoundException, SQLException
	{
		java.sql.Date d=new java.sql.Date(reservationBean.getJourneyDate().getTime());
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("insert into ATA_TBL_Reservation values(?,?,?,?,sysdate,?,?,?,?,?,?)");
		pst.setString(1,reservationBean.getReservationID());
		pst.setString(2,reservationBean.getUserID());
		pst.setString(3,reservationBean.getVehicleID());
		pst.setString(4,reservationBean.getRouteID());
		pst.setDate(5,d);
		pst.setString(6,null);
		pst.setString(7,"BOOKED");
		pst.setDouble(8,reservationBean.getTotalFare());
		pst.setString(9,reservationBean.getBoardingPoint());
		pst.setString(10,reservationBean.getDropPoint());
		int n=pst.executeUpdate();
		if(n==1)
		{
			return reservationBean.getReservationID();
		}
		else
		{
			return "FAIL";
		}	
	}
	public ArrayList<VehicleBean> findAll() throws ClassNotFoundException, SQLException
	{
		ArrayList<VehicleBean> a1 = new ArrayList<VehicleBean>();
		
		Connection con = DBUtil.getDBConnection();
		PreparedStatement pstmt = con.prepareStatement("Select * from ATA_TBL_Vehicle ");
	
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			VehicleBean vBean = new VehicleBean();
			vBean.setVehicleID(rs.getString(1));
			vBean.setName(rs.getString(2));
			vBean.setType(rs.getString(3));
			vBean.setRegistrationNumber(rs.getString(4));
			vBean.setSeatingCapacity(rs.getInt(5));
			vBean.setFarePerKM(rs.getDouble(6));
			a1.add(vBean);
		}
		
		return a1;
	}
	public VehicleBean findByID(String vehicleId) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		
		PreparedStatement pstmt = con.prepareStatement("Select * from ATA_TBL_Vehicle where vehicleId=?");
		pstmt.setString(1, vehicleId);
		ResultSet rs = pstmt.executeQuery();
		
		VehicleBean vBean = null ;
		
		while(rs.next())
		{
			vBean = new VehicleBean();
			vBean.setVehicleID(vehicleId);
			vBean.setName(rs.getString(2));
			vBean.setType(rs.getString(3));
			vBean.setRegistrationNumber(rs.getString(4));
			vBean.setSeatingCapacity(rs.getInt(5));
			vBean.setFarePerKM(rs.getDouble(6));

		}
		return vBean;
	}  
	
	//**** navan 
	
	public String createVehicle(VehicleBean vehicleBean) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		String name = vehicleBean.getName();
		
		String id = generateVehicleID(name);
		vehicleBean.setVehicleID(id);
		String result = "FAILURE";
		
		String regis = vehicleBean.getRegistrationNumber();
		String regCheck = checkRegistrationNo(regis);
		if(regCheck.equals("Registration no. already exist"))
		{
			return regCheck;
		}
		else
		{
			PreparedStatement pstmt = con.prepareStatement("insert into ATA_TBL_Vehicle values(?,?,?,?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, vehicleBean.getName().toUpperCase());
			pstmt.setString(3, vehicleBean.getType());
			pstmt.setString(4, vehicleBean.getRegistrationNumber());
			pstmt.setInt(5, vehicleBean.getSeatingCapacity());
			pstmt.setDouble(6, vehicleBean.getFarePerKM());
			int rows = pstmt.executeUpdate();
			
			if(rows==1)
			{
				result = "Vehicle added";
				return result;
			}
		}
		return result;
	}
	
	public String generateVehicleID(String vehicleName) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		String name = vehicleName.substring(0, 2).toUpperCase();
		
		PreparedStatement pstmt = con.prepareStatement("Select ata_seq_vehicleId.nextval from dual");
		ResultSet rs = pstmt.executeQuery();
		
		String id;
		int seq = 0;
		while(rs.next())
		{
			seq = rs.getInt(1);
		}
		id= name.concat(Integer.toString(seq));
		return id;
	}
	
	public String checkRegistrationNo(String regNo) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
	
		PreparedStatement pstmt = con.prepareStatement("Select * from ATA_TBL_Vehicle where RegistrationNumber=?");
		pstmt.setString(1, regNo);
		ResultSet rs = pstmt.executeQuery();
		
		String result="New Registration";
		while(rs.next())
		{
			result = "Registration no. already exist";
		}
		return result;
	}

	
	public int deleteVehicle(String vehicleId) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.getDBConnection();
		int delete =0;
		PreparedStatement pstmt = con.prepareStatement("delete from ATA_TBL_Vehicle where vehicleId=?");
		pstmt.setString(1, vehicleId);
		int rows = pstmt.executeUpdate();
	
		if(rows>0)
		{
			delete=rows;
		}
		return delete;
	}
	public boolean updateVehicle(VehicleBean vBean) throws SQLException, ClassNotFoundException
	{
		boolean update = false;
		int rows;
		
		Connection con = DBUtil.getDBConnection();
		PreparedStatement pstmt = con.prepareStatement("update ATA_TBL_Vehicle set name=?, type=?, RegistrationNumber=?, SeatingCapacity=?, FarePerKM=?  where vehicleId=?");
		pstmt.setString(1, vBean.getName().toUpperCase());
		pstmt.setString(2, vBean.getType());
		pstmt.setString(3, vBean.getRegistrationNumber());
		pstmt.setInt(4, vBean.getSeatingCapacity());
		pstmt.setDouble(5, vBean.getFarePerKM());
		pstmt.setString(6, vBean.getVehicleID());
		rows = pstmt.executeUpdate();
		
		if(rows>0)
		{
			update = true;
			return update;
		}
		return update;
	}
	
	//********ankit
	
	public ArrayList<VehicleBean> viewVehicleByType(String vehicleType) throws ClassNotFoundException, SQLException
	{
		ArrayList<VehicleBean> list=new ArrayList<VehicleBean>();
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pt =connection.prepareStatement("Select * from ATA_TBL_Vehicle where Type=?");
		pt.setString(1, vehicleType);
		ResultSet rs=pt.executeQuery();
		 while(rs.next())
		 {
			 VehicleBean vehicleBean=new VehicleBean();
			 vehicleBean.setVehicleID(rs.getString(1));
			 vehicleBean.setName(rs.getString(2));
			 vehicleBean.setType(vehicleType);
			 vehicleBean.setRegistrationNumber(rs.getString(4));
			 vehicleBean.setSeatingCapacity(rs.getInt(5));
			 vehicleBean.setFarePerKM(rs.getInt(6));
			 list.add(vehicleBean);
		 }
		return list;
	}
	
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats) throws ClassNotFoundException, SQLException
	{
		ArrayList<VehicleBean> list=new ArrayList<VehicleBean>();
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pt =connection.prepareStatement("Select * from ATA_TBL_Vehicle where SeatingCapacity=?");
		pt.setInt(1, noOfSeats);
		ResultSet rs=pt.executeQuery();
		 while(rs.next())
		 {
			 VehicleBean vehicleBean=new VehicleBean();
			 vehicleBean.setVehicleID(rs.getString(1));
			 vehicleBean.setName(rs.getString(2));
			 vehicleBean.setType(rs.getString(3));
			 vehicleBean.setRegistrationNumber(rs.getString(4));
			 vehicleBean.setSeatingCapacity(noOfSeats);
			 vehicleBean.setFarePerKM(rs.getInt(6));
			 list.add(vehicleBean);
		 }
		return list;
	}
	
	
}

