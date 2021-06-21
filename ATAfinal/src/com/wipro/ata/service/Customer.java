package com.wipro.ata.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.CreditCardDAO;
import com.wipro.ata.dao.ReservationDAO;
import com.wipro.ata.dao.RouteDAO;
import com.wipro.ata.dao.VehicleDAO;
import com.wipro.ata.util.DBUtil;

public class Customer 
{
	public String bookVehicle(ReservationBean reservationBean)
	{
		ReservationDAO rdo=new ReservationDAO();
		try 
		{
			String s=rdo.generateReservationId();
			s=reservationBean.getBoardingPoint().substring(0,1).toUpperCase()+reservationBean.getDropPoint().substring(0,1).toUpperCase()+s;
			reservationBean.setReservationID(s);
			VehicleDAO vdo=new VehicleDAO();
			return vdo.bookVehicle(reservationBean);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "FAIL";	
	}
	public ArrayList<RouteBean> viewRouteBySAndD(String source,String dest) throws ClassNotFoundException, SQLException
	{
		RouteDAO rdo=new RouteDAO();
		ArrayList<RouteBean> al=rdo.viewRouteBySAndD(source, dest);
		return al;
	}
	public ArrayList<VehicleBean> findAll()
	{
		ArrayList<VehicleBean> list=new ArrayList<VehicleBean>();
		VehicleDAO vDao = new VehicleDAO();
		try 
		{
			list = vDao.findAll();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	public String checkReservationByVehicleId(String vehicleId,Date date)
	{
		ReservationDAO rdo=new ReservationDAO();
		try {
			return rdo.checkReservationByVehicleId(vehicleId,date);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public String checkCreditCard(CreditCardBean creditCardBean)
	{
		CreditCardDAO cdo=new CreditCardDAO();
		try 
		{
			return cdo.checkCreditCard(creditCardBean);
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			
	}
	
	//******navan
	
	
	
	//****
	
	public Date checkJourneyDate(String userID, String reservationID)
	{
		ReservationDAO reservDAO = new ReservationDAO();
		Date checkDate = null  ;
		try
		{
			checkDate = reservDAO.checkJourneyDate(userID, reservationID);
			return checkDate;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	
		return checkDate;
	}
	
	//  ****
	
	

	
	
	
	
	
	
	public boolean cancelBooking(String userID, String reservationID)
	{
		boolean cancel = false;
	
		try
		{
			ReservationDAO reservDAO = new ReservationDAO();
			cancel = reservDAO.cancelBooking(userID, reservationID);
			
			return cancel;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return cancel;
	}
	
	
	public boolean checkUserId(String userId)
	{
		boolean check = false ;
		ReservationDAO reservDAO = new ReservationDAO();
		try 
		{
			check = reservDAO.checkUserId(userId);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return check;
	}

	public boolean checkReservationId(String reservationId) 
	{
		boolean check = false ;
		ReservationDAO reservDAO = new ReservationDAO();
		try 
		{
			check = reservDAO.checkReservationId(reservationId);
			return check;
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return check;
	}
	
	
	public String checkBookingStatus(String userId, String reservationId)
	{
		String status = null ;
		ReservationDAO reservDAO = new ReservationDAO();
		try 
		{
			status = reservDAO.checkBookingStatus(userId, reservationId);
			
			return status;
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String refundMoney(String userId, String reservationId)
	{
		ReservationDAO reservDAO = new ReservationDAO();
		String refund= null;
		try 
		{
			refund = reservDAO.refundMoney(userId , reservationId);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return refund;
	}
	
	//********imneet
	
	public ReservationBean viewBookingDetails(String reservationID)
	{
		ReservationDAO objreserveDao=new ReservationDAO();
		ReservationBean reserveBean=null;
		try {
			reserveBean=objreserveDao.viewBookingDetails(reservationID);
			} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return reserveBean;
	}
	public String findById(String userId)
	{
		String name="";
		ReservationDAO objreserveDao=new ReservationDAO();
		try {
			name=objreserveDao.findById(userId);
			} 
		catch (ClassNotFoundException e) 
			{
			e.printStackTrace();
			} 
		catch (SQLException e) 
			{
			e.printStackTrace();
			}
		return name;
	}
	
	//*****ankit
	
	public ArrayList<VehicleBean> viewVehicleByType(String vehicleType)
	{  
		VehicleDAO vehicleDao=new VehicleDAO();
		ArrayList<VehicleBean> list=new ArrayList<VehicleBean>();
		
		try {
				list=vehicleDao.viewVehicleByType(vehicleType);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return list;
	}
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats)
	{
		VehicleDAO vehicleDao=new VehicleDAO();

		ArrayList<VehicleBean> list=new ArrayList<VehicleBean>();
		
		try {
				list=vehicleDao.viewVehicleBySeats(noOfSeats);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return list;
	}
	
    public ArrayList<RouteBean> viewRoutesBySourceAndByDestination(String source,String destination)
	 {
		 ArrayList<RouteBean> list=null;
		 RouteDAO routeDao=new RouteDAO();
		 
		 try {
			  list=routeDao.viewRoutesBySourceAndByDestination(source,destination);
			  
			 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		 
		 return list;
	 }
}

