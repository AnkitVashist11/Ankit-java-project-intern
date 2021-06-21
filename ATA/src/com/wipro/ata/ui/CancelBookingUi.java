package com.wipro.ata.ui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import com.wipro.ata.listener.CancelBookingListener;
import com.wipro.ata.listener.VehicleListener;

public class CancelBookingUi extends JFrame
{
	public static void main(String[] args) 
	{
		CancelBookingUi cancelUi = new CancelBookingUi();
	}

	public static JLabel lblUserId , lblReservationId , lblHeading;
	public static JTextField txtUserId , txtReservationId;
	public static JButton btnCancelReserv , btnBack;
	public static JOptionPane option;
	public static JFrame frame;
	
	public CancelBookingUi()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		
		setSize(1020,750);
		setTitle(" Cancel Booking ");
	//	setLocation(100,100);
		setLayout(null);
		setResizable(false);
		
		Font font = new Font("papyrus", Font.BOLD, 20);
		Font font1 = new Font("Verdana", Font.BOLD, 14);
		
		frame = new JFrame();
		
		lblHeading = new JLabel("Cancel Booking");
		
		lblUserId = new JLabel("Enter User id");
		lblUserId.setFont(font1);
		lblReservationId = new JLabel("Enter reservation id");
		lblReservationId.setFont(font1);
		
		txtUserId = new JTextField(20);
		txtReservationId = new JTextField(20);
		
		txtUserId.setToolTipText("Enter user id");
		txtReservationId.setToolTipText("Enter reservation id");
		
		btnCancelReserv = new JButton(" Cancel Booking ");
		btnBack = new JButton(" Back ");
		option = new JOptionPane();
		
		lblHeading.setBounds(380,  80, 200, 25);
		lblHeading.setFont(font);
		lblUserId.setBounds(320, 140, 130	, 25);
		txtUserId.setBounds(530, 140, 100, 25);
		lblReservationId.setBounds(320, 200, 170, 25);
		txtReservationId.setBounds(530, 200, 100, 25);
		btnCancelReserv.setBounds(410, 260, 130, 40);
		btnBack.setBounds(10, 10,100, 40);
		
		add(lblHeading);
		add(lblUserId);  				add(txtUserId);
		add(lblReservationId);			add(txtReservationId);
		add(btnCancelReserv);			add(btnBack);
		
		btnCancelReserv.addActionListener(new CancelBookingListener(this));
		btnBack.addActionListener(new CancelBookingListener(this));
		setVisible(true);
	}
}
