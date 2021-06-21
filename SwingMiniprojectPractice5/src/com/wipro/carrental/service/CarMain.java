package com.wipro.carrental.service;

import java.sql.SQLException;
import java.util.Calendar;

import com.wipro.carrental.bean.CarBookingBean;
import com.wipro.carrental.dao.CarBookingDAO;

public class CarMain 
{
CarBookingBean cBean=new CarBookingBean();
	
	public String bookACar(CarBookingBean cBean)
	{ 
		String result=null;
		
	   if(cBean==null|| cBean.getCustomerName().isEmpty() || String.valueOf(cBean.getDateOfHire()).isEmpty() ||cBean.getPhoneNumber().length()!=10)
	   {
		   result="FAILURE";
	   }
	
	   else
		{
		    Calendar doh=Calendar.getInstance();
		    doh.setTime(cBean.getDateOfHire());
		    Calendar today=Calendar.getInstance();
		
	      if(doh.get(Calendar.YEAR)<today.get(Calendar.YEAR) &&(doh.get(Calendar.DAY_OF_YEAR)<today.get(Calendar.DAY_OF_YEAR)))
	        {
		     result="INVALID DATE FOR BOOKING";
	        }
	
	      else 
	       { 
		    CarBookingDAO Cdao=new CarBookingDAO();
	        String cartype=cBean.getCartype();
		    int number;
		  try { 
			
			  number = Cdao.getAvailableCars(cartype);
			 if(number==0)
			  {
				  result="NO CARS OF THE GIVEN TYPE AVAILABLE";
			  }
			  else
			  {   
			      String carType=cBean.getCartype();
				  int number2=Cdao.findBookedCarsByDate(cBean.getDateOfHire(), carType);
				  if( (number- number2) <=0)
				  {
					  result ="NO CARS AVAILABLE ON GIVEN DATE";
				  }
				  else
				  {  String id=Cdao.getBookingID(carType);
				     cBean.setBookingId(id);
					 boolean val=Cdao.bookACar(cBean); 
					 if(val==true)
					 {
						 result="SUCCESS";
						 
					 }
					 else
					 {
						 result="FAILURE";
					 }
				  }
			  }
		   }
	       
		     catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		  
		  }
		}
		return result;
	}
	
	public String cancelACar(String bookingId)
	{  String result="NO SUCH ID EXISTS";
	   CarBookingDAO Cdao1=new CarBookingDAO();
	   
	   boolean result01;
	try {
		 result01 = Cdao1.cancelACar(bookingId);
		 if(result01==true)
		   {
			   result="CANCELLED";
		   }
		 else
		   {
			 
			 result= "NO SUCH ID EXIST";
	       }
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
	  
		return result;
		
	}
	
	
 
	public static void main(String[] args) {

       // System.out.println(new CarMain().cancelACar("sm1046"));

      }

}
