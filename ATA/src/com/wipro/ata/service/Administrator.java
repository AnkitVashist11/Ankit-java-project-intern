package com.wipro.ata.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.ata.bean.DriverBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.bean.VehicleBean;
import com.wipro.ata.dao.DriverDAO;
import com.wipro.ata.dao.ReservationDAO;
import com.wipro.ata.dao.RouteDAO;
import com.wipro.ata.dao.VehicleDAO;

public class Administrator 
{
	 public VehicleBean viewVehicle(String vehicleId) 
		{
			VehicleDAO vDao = new VehicleDAO();
			VehicleBean vBean = null;
			try 
			{
				 vBean = vDao.findByID(vehicleId);
				 return vBean;
				
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return vBean;
		}	
	 
	 public String addDriver(DriverBean driverBean)
		{
			DriverDAO objdao=new DriverDAO();
			String result="FAIL";
			String id="";
			try 
			{
				if(driverBean==null)
				{
					return result;
				}
				else if(driverBean.getName().equals(null)||driverBean.getName().isEmpty()||driverBean.getName().length()<2||driverBean.getName().length()>25)
				{
					result="Name length cannot be less than 2 and more than 25";
					return result ;
				}
				else if(driverBean.getStreet().isEmpty()||driverBean.getStreet().length()>30)
				{
					result="Street field's length ranges from 1 to 30";
					return result ;
				}
				else if(driverBean.getLocation().equals("")||driverBean.getLocation().length()<2||driverBean.getLocation().length()>15)
				{
					result="Location field's length ranges from 2 to 15";
					return result;
				}
				else if(driverBean.getCity().length()<2||driverBean.getCity().length()>15)
				{
					result="City field's length ranges from 2 to 15";
					return result;
				}
				else if(driverBean.getState().length()<2||driverBean.getState().length()>15)
				{
					result="State field's length ranges from 2 to 15";
					return  result;
				}
				else if(driverBean.getPincode().isEmpty())
				{
					result="Enter  Pincode";
					return  result;
				}
				else if(driverBean.getPincode().length()!=6)
				{
					result="PinCode should be of 6 digits";
					return  result;
				}
				else if(driverBean.getMobileNo().equals(null)||driverBean.getMobileNo().length()!=10||driverBean.getMobileNo().isEmpty())
				{
					result="Enter 10 digit MobileNo";
					return  result;
				}
				else if(Long.parseLong(driverBean.getMobileNo())<1)
				{
					result="Invalid Mobile number";
					return  result;
				}
				else if(driverBean.getLicenseNumber().equals(null)||driverBean.getLicenseNumber().isEmpty())
				{
					result="Enter LicenseNo";
					return  result;
				}
				else if(driverBean.getLicenseNumber().length()!=10)
				{
					result="License number should be of 10 digits";
					return result;
				}
				else
				{
					id=objdao.generateDriverId(driverBean.getName());
					driverBean.setDriverID(id);
					result=objdao.createDriver(driverBean);
				}
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (SQLException e) 
			{
				return "ERROR";
			}
			return result;
		}
		
		public int deleteDriver(String driverID)
		{
			int number=0;
			DriverDAO objdao=new DriverDAO();
			try {
				number=objdao.deleteDriver(driverID);
				} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				return -1;
			}
			
			return number;
		}
		
		
		public boolean modifyDriver(DriverBean driverBean)
		{ 
			DriverDAO objdao=new DriverDAO();
			boolean flag=false;
			try 
			{
				flag=objdao.updateDriverDetails(driverBean);
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return flag;
		}
		
		public DriverBean findById(String driverId)
		{
			DriverDAO objdao=new DriverDAO();
			
			try 
			{
				DriverBean driverBean ;
				
				driverBean=objdao.findById(driverId);
				return driverBean;
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return null;
		}
		
		public ArrayList<DriverBean>findAllDrivers()
		{
			DriverDAO objdao=new DriverDAO();
			ArrayList<DriverBean>list=new ArrayList<DriverBean>();
			
			try {
				list=objdao.findAllDrivers();
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
		
		public String allotDriver(String reservationID, String driverID)
		{
			String result="FAIL";
			DriverDAO objdao=new DriverDAO();
			try {
				result=objdao.allotDriver(reservationID, driverID);
				} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return result;
			
		}
		public ArrayList<ReservationBean>viewAllReservationDetails()
		{
			ReservationDAO objreservationdao=new ReservationDAO();
			ArrayList<ReservationBean>list=new ArrayList<ReservationBean>();
			
			try {
				list=objreservationdao.viewAllReservationDetails();
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
		
		//*****navan
		
		public String addVehicle(VehicleBean vehicleBean)
		{
			VehicleDAO vDao = new VehicleDAO();
			String add = "FAILURE";
			
			if(vehicleBean==null )
			{
				add="Enter valid values";
				return add;
			}
			else
			{
				if(vehicleBean.getName().length()<2 )
				{
					add="Name should be greater than 2 charaters";
					return add;
				}
				if(vehicleBean.getRegistrationNumber()==null || vehicleBean.getRegistrationNumber().isEmpty() ||  vehicleBean.getRegistrationNumber().length()>12)
				{
					add="Invalid registration number.";
					return add;
				}
				
				if( vehicleBean.getType()==null || vehicleBean.getType().isEmpty()||vehicleBean.getType().length()<2)
				{
					add="Invalid Type";
					return add;
				}
				else
				{	
					if(vehicleBean.getFarePerKM()==0 || vehicleBean.getFarePerKM()<0 )
					{
						add=" Fare per km can range between 1 to 999 .";
						return add;
					}
					else
					{
						try 
						{
							 add = vDao.createVehicle(vehicleBean);
						} 
						catch (ClassNotFoundException e) 
						{
							e.printStackTrace();
						} catch (SQLException e)
						{
							e.printStackTrace();
						} 
						
					}
				}
			}
			return add;
		}
		public int deleteVehicle(String vehicleID)
		{
			VehicleDAO vDao = new VehicleDAO();
			int delete=0 ;
			try 
			{
				delete = vDao.deleteVehicle(vehicleID);
				return delete;
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				return -1;
				//e.printStackTrace();
			}
			return delete;
		}
		
		
		//  ***** view All
		
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
		
		public boolean modifyVehicle(VehicleBean vehicleBean)
		{
			VehicleDAO vDao = new VehicleDAO();
			boolean update = false;
			try
			{
				update = vDao.updateVehicle(vehicleBean);
				return update;
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			
			return update;
		}
		
		//**********ankit
		public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination)
		 {    
			ReservationDAO reserveDao=new ReservationDAO();
			ArrayList<ReservationBean> list=new ArrayList<ReservationBean>();
			
	         try {
					list=reserveDao.viewBookingDetails(journeyDate, source, destination);
					
				 } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				 } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				 }
	         
	         return list;
		 }
		public String addRoute(RouteBean routeBean)
		{ 
		  String result="ERROR";
		 	
		  if(routeBean == null)
		  {
			return null;  
		  }
		  else
		  {
			 if(routeBean.getSource()==null || routeBean.getDestination() ==null ||String.valueOf(routeBean.getDistance())==null||String.valueOf(routeBean.getTravelDuration())==null)
			 {
				 return null;
			 }
			 else
			 {
				 if(routeBean.getSource().length() <2 || routeBean.getDestination().length()<2) 
				 {
					 return "MORE THAN 2 CHARACTER VALUES MUST BE ENTER FOR SOURCE & DESTINATION";
				 }
				 else if(routeBean.getSource().equalsIgnoreCase(routeBean.getDestination()))
				 {
					 return "SOURCE & DESTINATION CAN'T BE SAME";
				 }
				 else
				 {
					 RouteDAO routeDao=new RouteDAO();
					try {
						result=routeDao.addRoute(routeBean);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						result="INVALID VALUES ENTERED";
					}
				 }
			 }
		  }
		  return result;
		}
		 
		 public int deleteRoute(String routeID)
		 {
			 RouteDAO routeDao=new RouteDAO();
			 int result=0;
			try {
					result = routeDao.deleteRoute(routeID);
					
				} catch (SQLException e) {
					return -1;
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 return result;
		 }
		 public RouteBean viewRoute(String routeID)
		 {   
			 RouteDAO routeDao=new RouteDAO();
			 RouteBean routeBean1=new RouteBean();
			try {
					routeBean1=routeDao.viewRoute(routeID);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 return routeBean1;
		 }
		 public ArrayList<RouteBean> viewAllRoutes()
		 {  
			 RouteDAO routeDao=new RouteDAO();
			 ArrayList<RouteBean> list=new ArrayList<RouteBean>();
			 try {
					list=routeDao.viewAllRoutes();
					
				 } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
			 
			 return list;
		 }
		 public boolean modifyRoute(RouteBean routeBean)
		 {   
			 boolean result=false;
			 RouteDAO routeDao=new RouteDAO();
			 
			  try {
				  result=routeDao.modifyRoute(routeBean);
				  
				  } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				  } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				  }
			  
			return result;
			 
		 }
}

