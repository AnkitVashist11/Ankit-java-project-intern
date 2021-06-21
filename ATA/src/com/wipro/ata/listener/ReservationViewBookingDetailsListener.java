package com.wipro.ata.listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.service.Administrator;
import com.wipro.ata.service.Customer;
import com.wipro.ata.ui.CustomerUI;
import com.wipro.ata.ui.DriverViewAllForm;
import com.wipro.ata.ui.ReservationViewBookingDetailsForm;

public class ReservationViewBookingDetailsListener implements ActionListener
{
	ReservationViewBookingDetailsForm objviewform;
	public ReservationViewBookingDetailsListener(ReservationViewBookingDetailsForm objviewform)
	{
		this.objviewform=objviewform;
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		Customer objcustom=new Customer();
		ReservationBean reserveBean=new ReservationBean();
		if(ae.getSource()==objviewform.btnBack)
		{
			new CustomerUI().setVisible(true);
			objviewform.dispose();
		}
		if(ae.getSource()==objviewform.btnView)
		{
			if(objviewform.txtId.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill your Reservation Id First");
				}
			else
				{
					objviewform.dfTableModel.getDataVector().removeAllElements();
					
					reserveBean=objcustom.viewBookingDetails(objviewform.txtId.getText());
					 
				if(reserveBean!=null)
				{
					objviewform.col[0]=reserveBean.getReservationID();
					objviewform.col[1]=reserveBean.getUserID();
					objviewform.col[2]=reserveBean.getVehicleID();
					objviewform.col[3]=reserveBean.getRouteID();
					objviewform.col[4]=reserveBean.getBookingDate();
					objviewform.col[5]=reserveBean.getJourneyDate();
					objviewform.col[6]=reserveBean.getDriverID();
					objviewform.col[7]=reserveBean.getBookingStatus();
					objviewform.col[8]=reserveBean.getTotalFare();
					objviewform.col[9]=reserveBean.getBoardingPoint();
					objviewform.col[10]=reserveBean.getDropPoint();
					objviewform.dfTableModel.addRow(objviewform.col);
				}	
				else 
				{
					JOptionPane.showMessageDialog(null, "Invalid Reservation Id");
				}
			
		}
		}
		if(ae.getSource()==objviewform.btnPrint)
		{
			if(objviewform.txtId.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please fill your Reservation Id First");
			}
			
			else
			{
				if(!(objviewform.txtId.getText().equals(objviewform.col[0])))
				{
					System.out.println(reserveBean.getReservationID());
					JOptionPane.showMessageDialog(null, "No Such Reservation Id Exists");
				}
				else
				{
					objviewform.lblId.setVisible(false);
					objviewform.txtId.setVisible(false);
					objviewform.btnView.setVisible(false);
					objviewform.table.setVisible(false);
					objviewform.scrollpane.setVisible(false);
					objviewform.btnPrint.setVisible(false);
					objviewform.btnBack.setVisible(false);
					objviewform.lblstatus.setVisible(false);
					
					objviewform.lblTitle.setVisible(true);
					
					objviewform.lblIdd.setVisible(true);
					objviewform.lblIdd.setForeground(Color.BLACK);
					
					objviewform.lblIddd.setVisible(true);
					objviewform.lblIddd.setForeground(Color.BLUE);
					objviewform.lblIddd.setText(objviewform.txtId.getText());
					
					
					objviewform.lblName.setVisible(true);
					objviewform.lblName.setForeground(Color.BLACK);
					
					objviewform.lblNames.setVisible(true);
					objviewform.lblNames.setForeground(Color.BLUE);
					objviewform.lblNames.setText(objcustom.findById(objviewform.col[1].toString()));
					
					
					objviewform.lblJourneyDate.setVisible(true);
					objviewform.lblJourneyDate.setForeground(Color.BLACK);
					
					objviewform.lblJourneyDates.setVisible(true);
					objviewform.lblJourneyDates.setForeground(Color.BLUE);
					objviewform.lblJourneyDates.setText(objviewform.col[5].toString());
					
					objviewform.lblFare.setVisible(true);
					objviewform.lblFare.setForeground(Color.BLACK);
					
					objviewform.lblFares.setVisible(true);
					objviewform.lblFares.setForeground(Color.BLUE);
					objviewform.lblFares.setText(objviewform.col[8].toString());
					
					
					objviewform.lblBoardingPoint.setVisible(true);
					objviewform.lblBoardingPoint.setForeground(Color.BLACK);
					
					objviewform.lblBoardingPoints.setVisible(true);
					objviewform.lblBoardingPoints.setForeground(Color.BLUE);
					objviewform.lblBoardingPoints.setText(objviewform.col[9].toString());
					
					objviewform.lblDropPoint.setVisible(true);
					objviewform.lblDropPoint.setForeground(Color.BLACK);
					objviewform.lblDropPoints.setVisible(true);
					objviewform.lblDropPoints.setForeground(Color.BLUE);
					objviewform.lblDropPoints.setText(objviewform.col[10].toString());
					
					objviewform.lblType.setVisible(true);
					objviewform.lblType.setForeground(Color.BLACK);
					objviewform.lblTypes.setVisible(true);
					objviewform.lblTypes.setForeground(Color.BLUE);
					objviewform.lblMsg.setVisible(true);
				}
			}
		}
	}
}
