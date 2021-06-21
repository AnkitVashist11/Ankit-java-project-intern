package com.wipro.ata.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.wipro.ata.listener.CustomerListener;

public class CustomerUI extends JFrame
{
	public JFrame frame;
	public JLabel label1,titleLabel;
	public JButton customerlogout,viewVehicleOrRouteDetailsButton,viewVehicleBySeats,viewRoute,bookVehicleOnlineButton,cancelBooking,viewBookingButton;
	public CustomerUI()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setTitle("Customer Page");
		setSize(1000,750);
		setLayout(null);
		 titleLabel=new JLabel("CUSTOMER PAGE");
			titleLabel.setFont(new Font("Papyrus",Font.BOLD,20));
			titleLabel.setBounds(385,90,350,25);
		label1=new JLabel("Enter the desired Operation:");
		label1.setBounds(400,140,350,25);
		customerlogout=new JButton("Logout");
		customerlogout.setBounds(10,10,100,25);
		viewVehicleOrRouteDetailsButton=new JButton("View Vehicle By Type");
		viewVehicleOrRouteDetailsButton.setBounds(405,180,180,25);
		viewVehicleBySeats=new JButton("View Vehicle By Seats");
		viewVehicleBySeats.setBounds(405,220,180,25);
		viewRoute=new JButton("View Route");
		viewRoute.setBounds(405,260,180,25);
		bookVehicleOnlineButton=new JButton("Book Vehicle");
		bookVehicleOnlineButton.setBounds(405,300,180,25);
		cancelBooking=new JButton("Cancel Booking");
		cancelBooking.setBounds(405,340,180,25);
		viewBookingButton=new JButton("View Booking Status");
		viewBookingButton.setBounds(405,380,180,25);
		add(titleLabel);
		add(customerlogout);
		add(label1);
		add(viewVehicleOrRouteDetailsButton);
		add(viewVehicleBySeats);
		add(viewRoute);
		add(bookVehicleOnlineButton);
		add(cancelBooking);
		add(viewBookingButton);
		customerlogout.addActionListener(new CustomerListener(this));
		viewBookingButton.addActionListener(new CustomerListener(this));
		viewVehicleOrRouteDetailsButton.addActionListener(new CustomerListener(this));
		viewVehicleBySeats.addActionListener(new CustomerListener(this));
		viewRoute.addActionListener(new CustomerListener(this));
		cancelBooking.addActionListener(new CustomerListener(this));
		bookVehicleOnlineButton.addActionListener(new CustomerListener(this));
	}
	public static void main(String[] args) 
	{
		new CustomerUI().setVisible(true);
	}
}
