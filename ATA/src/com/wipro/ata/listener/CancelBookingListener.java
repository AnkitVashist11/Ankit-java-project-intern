package com.wipro.ata.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.wipro.ata.dao.ReservationDAO;
import com.wipro.ata.service.Customer;
import com.wipro.ata.ui.AdminUI;
import com.wipro.ata.ui.CancelBookingUi;
import com.wipro.ata.ui.CustomerUI;
import com.wipro.ata.ui.VehicleUpdateUi;

public class CancelBookingListener implements ActionListener
{
	CancelBookingUi uiObj;
	public CancelBookingListener(CancelBookingUi uiObj)
	{
		this.uiObj = uiObj;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==CancelBookingUi.btnCancelReserv)
		{
			boolean cancel = false;
			
			if(CancelBookingUi.txtUserId.getText().trim().equals(""))
			{
				VehicleUpdateUi.option.showMessageDialog(VehicleUpdateUi.optionFrame, "Enter User id");
			}
			
			else if(CancelBookingUi.txtReservationId.getText().trim().equals("")) 
			{
				VehicleUpdateUi.option.showMessageDialog(VehicleUpdateUi.optionFrame, "Enter Reservation id");
			}
			else if(!CancelBookingUi.txtUserId.getText().equals(LoginListener.userId))
			{
				VehicleUpdateUi.option.showMessageDialog(VehicleUpdateUi.optionFrame, "Enter Valid UserId");
			}
			else
			{
				ReservationDAO revDao = new ReservationDAO();
				Customer customer = new Customer();
				
				String reservationId = CancelBookingUi.txtReservationId.getText().trim();
				String userId = CancelBookingUi.txtUserId.getText().trim();
			
				boolean userIdValid = customer.checkUserId(userId);
				if(userIdValid==true)
				{
					boolean reservationIdValid = customer.checkReservationId(reservationId);
					if(reservationIdValid==true)
					{
						//****
						Date checkDate = customer.checkJourneyDate(userId, reservationId);
						Calendar  cal = null ;
						
						Date today = new Date();
						today = cal.getInstance().getTime();
					
					
						if(checkDate.getYear()<today.getYear())   
						{
							System.out.println("q");
							CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame,  "Booking is not valid.");
							
						}
						if(checkDate.getYear()==today.getYear())
						{
							System.out.println("w");
							if(checkDate.getMonth()<today.getMonth())
							{
								System.out.println("e");
								CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame,  "Booking is not valid.");
							}
							if(checkDate.getMonth()==today.getMonth())
							{
								System.out.println("r");
								if(checkDate.getDay()<today.getDay())
								{
									System.out.println("t");
									CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame,  "Booking is not valid.");
								}
								else
								{
									System.out.println("y");
									
									String bookingStatus = customer.checkBookingStatus(userId, reservationId);
									
									if(bookingStatus.equals("UNBOOKED"))
									{
										CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame,  "Booking is already cancelled.");
										
										CancelBookingUi.txtReservationId.setText("");
										CancelBookingUi.txtUserId.setText("");
									}
									
									else
									{
										String refund;
										
										int btnYes = CancelBookingUi.option.showConfirmDialog(CancelBookingUi.frame,  "Do you want to cancel the booking?");
										
										if(btnYes == CancelBookingUi.option.YES_OPTION)
										{	
											try 
											{
												cancel = revDao.cancelBooking(userId, reservationId);
											} 
											catch (SQLException e)
											{
												e.printStackTrace();
											}
											catch (ClassNotFoundException e)
											{
												e.printStackTrace();
											}
											
											if(cancel==true)
											{
												CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "Booking cancelled.");
												
												 refund = customer.refundMoney(userId, reservationId);
												
												 if(refund=="REFUNDED")
												 {
													 CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, refund);
												 }
												 
												 else
												 {
													 CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, refund);
												 }
											}
											else
											{
												CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "Cancellation cannot be performed due to invalid user id or reservation id.");
											}
										}
										else if(btnYes == CancelBookingUi.option.NO_OPTION)
										{
											CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "'NO' button pressed.Booking is not cancelled.");
										}
										else if(btnYes == CancelBookingUi.option.CANCEL_OPTION)
										{
											CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "'CANCEL' button pressed.Booking is not cancelled.");
										}
									}
									CancelBookingUi.txtReservationId.setText("");
									CancelBookingUi.txtUserId.setText("");
								}
							}
							else
							{
								String bookingStatus = customer.checkBookingStatus(userId, reservationId);
								
								if(bookingStatus.equals("UNBOOKED"))
								{
									CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame,  "Booking is already cancelled.");
									
									CancelBookingUi.txtReservationId.setText("");
									CancelBookingUi.txtUserId.setText("");
								}
								
								else
								{
									String refund;
									
									int btnYes = CancelBookingUi.option.showConfirmDialog(CancelBookingUi.frame,  "Do you want to cancel the booking?");
									
									if(btnYes == CancelBookingUi.option.YES_OPTION)
									{	
										try 
										{
											cancel = revDao.cancelBooking(userId, reservationId);
										} 
										catch (SQLException e)
										{
											e.printStackTrace();
										}
										catch (ClassNotFoundException e)
										{
											e.printStackTrace();
										}
										
										if(cancel==true)
										{
											CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "Booking cancelled.");
											
											 refund = customer.refundMoney(userId, reservationId);
											
											 if(refund=="REFUNDED")
											 {
												 CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, refund);
											 }
											 
											 else
											 {
												 CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, refund);
											 }
										}
										else
										{
											CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "Cancellation cannot be performed due to invalid user id or reservation id.");
										}
									}
									else if(btnYes == CancelBookingUi.option.NO_OPTION)
									{
										CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "'NO' button pressed.Booking is not cancelled.");
									}
									else if(btnYes == CancelBookingUi.option.CANCEL_OPTION)
									{
										CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "'CANCEL' button pressed.Booking is not cancelled.");
									}
								}
								CancelBookingUi.txtReservationId.setText("");
								CancelBookingUi.txtUserId.setText("");
							}
						}
						else
						{
							String bookingStatus = customer.checkBookingStatus(userId, reservationId);
							
							if(bookingStatus.equals("UNBOOKED"))
							{
								CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame,  "Booking is already cancelled.");
								
								CancelBookingUi.txtReservationId.setText("");
								CancelBookingUi.txtUserId.setText("");
							}
							
							else
							{
								String refund;
								
								int btnYes = CancelBookingUi.option.showConfirmDialog(CancelBookingUi.frame,  "Do you want to cancel the booking?");
								
								if(btnYes == CancelBookingUi.option.YES_OPTION)
								{	
									try 
									{
										cancel = revDao.cancelBooking(userId, reservationId);
									} 
									catch (SQLException e)
									{
										e.printStackTrace();
									}
									catch (ClassNotFoundException e)
									{
										e.printStackTrace();
									}
									
									if(cancel==true)
									{
										CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "Booking cancelled.");
										
										 refund = customer.refundMoney(userId, reservationId);
										
										 if(refund=="REFUNDED")
										 {
											 CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, refund);
										 }
										 
										 else
										 {
											 CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, refund);
										 }
									}
									else
									{
										CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "Cancellation cannot be performed due to invalid user id or reservation id.");
									}
								}
								else if(btnYes == CancelBookingUi.option.NO_OPTION)
								{
									CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "'NO' button pressed.Booking is not cancelled.");
								}
								else if(btnYes == CancelBookingUi.option.CANCEL_OPTION)
								{
									CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "'CANCEL' button pressed.Booking is not cancelled.");
								}
							}
							CancelBookingUi.txtReservationId.setText("");
							CancelBookingUi.txtUserId.setText("");
						}
						
					}
					else
					{
						CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "Invalid Reservation id.");
					}
				}
				else
				{
					CancelBookingUi.option.showMessageDialog(CancelBookingUi.frame, "Invalid User id.");
				}
			}
		}
		
		if(ae.getSource()==CancelBookingUi.btnBack)
		{
			new CustomerUI().setVisible(true);
			uiObj.dispose();
		}
	}
}
