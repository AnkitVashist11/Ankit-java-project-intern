package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.BookingDetailsViewForm;

public class BookingDetailsViewListener implements ActionListener
{
	BookingDetailsViewForm obj;
	
	public BookingDetailsViewListener(BookingDetailsViewForm in)
	{
		obj=in;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{

		Administrator adminService=new Administrator();
		if(arg0.getSource()==obj.btnView)
		{
			 
		  if(obj.txtSource.getText().isEmpty() || obj.txtDestination.getText().isEmpty())
		   {	
			JOptionPane.showMessageDialog(obj.frame, "Mandatory to fill all Fields");
		}
		else
		{ 
			
			if(obj.txtSource.getText()==null || obj.txtDestination.getText() ==null )
			 {
				JOptionPane.showMessageDialog(obj.frame,"Fill All Details");
			 }
			else if(obj.txtSource.getText().trim().length() <2 || obj.txtDestination.getText().trim().length()<2) 
			 {
				 JOptionPane.showMessageDialog(obj.frame,"ATLEAST 2 CHARACTER VALUES MUST BE ENTER FOR SOURCE & DESTINATION");
			 }
			else if(obj.txtSource.getText().trim().equalsIgnoreCase(obj.txtDestination.getText().trim()))
			 {
				JOptionPane.showMessageDialog(obj.frame,"SOURCE AND DESTINATION CAN'T BE SAME");

			 }
			else if (!(obj.txtSource.getText().trim().matches("[a-zA-Z ]+")) && !(obj.txtDestination.getText().trim().matches("[a-zA-Z ]+")))
            {
              JOptionPane.showMessageDialog(null, "Please enter a valid character For SOURCE and DESTINATION", "Error", JOptionPane.ERROR_MESSAGE);
            }
		   
            else if(!(obj.txtSource.getText().trim().matches("[a-zA-Z ]+")))
            {
         	   JOptionPane.showMessageDialog(null, "Please Enter Valid Character For Source");
            }
            else if(!(obj.txtDestination.getText().trim().matches("[a-zA-Z ]+")))
            {
         	   JOptionPane.showMessageDialog(null, "Please Enter Valid Character For Destination");
            }
            else if(obj.txtSource.getText().trim().length()>20)             
            {
	          JOptionPane.showMessageDialog(null, "FAILED: YOU EXCEED THE ENTRY LIMIT OF 20 CHARACTER Of SOURCE");

            } 
            else if(obj.txtDestination.getText().trim().length()>20)             
            {
	          JOptionPane.showMessageDialog(null, "FAILED: YOU EXCEED THE ENTRY LIMIT OF 20 CHARACTER Of DESTINATION");

            }
            else
		    {
            	obj.dfTableModel.getDataVector().removeAllElements();
					String source=obj.txtSource.getText();
					String destination=obj.txtDestination.getText();
					Date journeyDate=obj.cDate.getDate();
				    			
				   
					ArrayList<ReservationBean>list=adminService.viewBookingDetails(journeyDate, source, destination);
					if(list.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "No bookings on the day");
					}
					else
					{
						Iterator<ReservationBean>itr=list.iterator();
						while(itr.hasNext())
						{
							ReservationBean reserveBean=new ReservationBean();
							reserveBean=itr.next();
							obj.col[0]=reserveBean.getReservationID();
							obj.col[1]=reserveBean.getUserID();
							obj.col[2]=reserveBean.getVehicleID();
							obj.col[3]=reserveBean.getRouteID();
							obj.col[4]=reserveBean.getBookingDate();
							obj.col[5]=reserveBean.getJourneyDate();
							obj.col[6]=reserveBean.getDriverID();
							obj.col[7]=reserveBean.getBookingStatus();
							obj.col[8]=reserveBean.getTotalFare();
							obj.col[9]=reserveBean.getBoardingPoint();
							obj.col[10]=reserveBean.getDropPoint();
							
							obj.dfTableModel.addRow(obj.col);
						}
					}
					
		      }
		  }
		}
		if(arg0.getSource()==obj.btnCancel)
		{
			obj.txtSource.setText("");
			obj.txtDestination.setText("");
			
		}
		if(arg0.getSource()==obj.btnBack)
		{
			new AdminUI().setVisible(true);
			obj.frame.setVisible(false);
		}
		
	}
}

