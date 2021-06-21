package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.ata.bean.CredentialsBean;
import com.wipro.ata.bean.CreditCardBean;
import com.wipro.ata.bean.ReservationBean;
import com.wipro.ata.dao.CreditCardDAO;
import com.wipro.ata.service.Customer;
import com.wipro.ata.ui.BookVehicleUI;
import com.wipro.ata.ui.CustomerUI;
import com.wipro.ata.ui.PaymentPageUI;
import com.wipro.ata.util.Authentication;

public class PaymentPageListener implements ActionListener,ItemListener
{
	static public String validFrom;
	static public String validTo;
	PaymentPageUI pui;
	
	public PaymentPageListener(PaymentPageUI pui) 
	{
		this.pui = pui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==pui.payButton)
		{
			if(pui.creditCardNoText.getText().equals(""))
			{
				JOptionPane.showMessageDialog(pui.frame,"Enter your Credit Card Number");
			}
			else if(!pui.creditCardNoText.getText().trim().matches("[0-9]+"))
			{
				JOptionPane.showMessageDialog(pui.frame,"Credit Card Number can be of numeric type only");
			}
			else if(pui.creditCardNoText.getText().trim().length()!=16)
			{
				JOptionPane.showMessageDialog(pui.frame,"Credit Card Number should be of 16 digits");
			}
			else if(pui.creditCardNoText.getText().trim().length()>16)
			{
				JOptionPane.showMessageDialog(pui.frame,"Credit Card Number cannot greater than 16");
			}
			else
			{
				Customer customer=new Customer();
				CreditCardBean ccb=new CreditCardBean();
				ccb.setCreditCardNumber(pui.creditCardNoText.getText());
				ccb.setValidFrom(validFrom);
				ccb.setValidto(validTo);
				String s=customer.checkCreditCard(ccb);
				String ss[]=s.split(" ");
				if(s.equals("INVALID"))
				{
					JOptionPane.showMessageDialog(pui.frame,"Credit Card Details are not Correct");
				}
				else if(!ss[0].equals(LoginListener.userId))
				{
					JOptionPane.showMessageDialog(pui.frame,"Credit Card Details are not Correct");
				}
				else
				{
					Authentication ath=new Authentication();
					try 
					{
						double balance=Double.parseDouble(ss[1]);
						if(balance<Double.parseDouble(pui.totalFareText.getText()))
						{
							JOptionPane.showMessageDialog(pui.frame,"Not Enough Credit Balance in your Account");
						}
						else
						{
							int n=JOptionPane.showConfirmDialog(null,"Are you sure you want to proceed?");
							if(n==JOptionPane.OK_OPTION)
							{
								ReservationBean rb=new ReservationBean();
								rb.setUserID(LoginListener.userId);
								rb.setRouteID(BookVehicleListener.routeId);
								rb.setVehicleID(BookVehicleListener.vehicleId);
								rb.setDropPoint(BookVehicleListener.destination.toUpperCase());
								rb.setBoardingPoint(BookVehicleListener.source.toUpperCase());
								rb.setJourneyDate(BookVehicleListener.date);
								rb.setTotalFare(Double.parseDouble(pui.totalFareText.getText()));
								String str=customer.bookVehicle(rb);
								if(str.equals("FAIL"))
								{
									JOptionPane.showMessageDialog(pui.frame,"Booking Unsuccessfull");
								}
								else
								{
									CreditCardDAO cdo=new CreditCardDAO();
									boolean bb=cdo.updateBalance(ccb,BookVehicleListener.totalFare);
									if(bb)
									{
										JOptionPane.showMessageDialog(pui.frame,"Booking Successfull "+"Reservation Id: "+str);
										new CustomerUI().setVisible(true);
										pui.dispose();
									}
									else
									{
										JOptionPane.showMessageDialog(pui.frame,"Booking Unsuccessfull");
									}
								}
							}
							else if(n==JOptionPane.CANCEL_OPTION)
							{

							}
							else if(n==JOptionPane.NO_OPTION)
							{

							}
						}
						
					} 
					catch (ClassNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		if(arg0.getSource()==pui.backButton)
		{
			int n=JOptionPane.showConfirmDialog(null,"Are you sure you want to go back?");
			if(n==JOptionPane.OK_OPTION)
			{
				new BookVehicleUI().setVisible(true);
				pui.dispose();
			}
			else if(n==JOptionPane.CANCEL_OPTION)
			{
				
			}
			else if(n==JOptionPane.NO_OPTION)
			{
				
			}
			
		}
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
		if(arg0.getSource()==pui.validFromchoice)
		{
			validFrom=pui.validFromchoice.getSelectedItem();
		}
		if(arg0.getSource()==pui.validToChoice)
		{
			validTo=pui.validToChoice.getSelectedItem();
			
		}
	}

}
