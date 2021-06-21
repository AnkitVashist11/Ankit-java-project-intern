package com.wipro.ata.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import com.wipro.ata.listener.VehicleListener;
import com.wipro.ata.listener.VehicleListenerView;
import com.wipro.ata.listener.VehicleViewAllListener;

public class VehicleViewUi extends JFrame
{
	public static JLabel  lblVehicleId  , lblHead ,lblName, lblType ,lblRegistrationNo , lblSeatingCapacity, lblFarePerKm , lblMsg;
	public static JTextField txtVehicleId , txtName ,txtType, txtRegistrationNo , txtSeatingCapacity , txtFarePerKm;
	public static JButton btnView , btnBack , btnCancel;
	public static JOptionPane option;
	public static JFrame frame;
	public static Choice cType , cVehicleId;
	
	public static void main(String args[])
	{
		VehicleViewUi ui = new VehicleViewUi();
	}
	
	public VehicleViewUi()
	{
		setContentPane(new JLabel(new ImageIcon("src\\image.jpg")));
		
	//	setLocation(100,100);
		setSize(1020 , 750);
		setTitle(" View Vehicle");
		setLayout(null);
	
		Font font = new Font("Papyrus", Font.BOLD, 20);
		Font font1 = new Font("Verdana", Font.PLAIN, 12);
		
		lblHead = new JLabel("Vehicle Details");
		lblHead.setFont(font);
		lblHead.setBounds(420, 30, 150, 50);
			
		lblVehicleId = new JLabel(" Vehicle Id");	
		lblVehicleId.setFont(font1);
		lblVehicleId.setBounds(350, 80, 130, 50);
		
		lblName = new JLabel(" Name");
		lblName.setBounds(350, 120, 130, 50);
		lblName.setFont(font1);
		
		lblType = new JLabel(" Type");
		lblType.setBounds(350, 160, 130, 50);
		lblType.setFont(font1);
		
		lblRegistrationNo = new JLabel(" Registration No");
		lblRegistrationNo.setBounds(350, 200, 130, 50);
		lblRegistrationNo.setFont(font1);		
		
		lblSeatingCapacity = new JLabel(" Seating Capacity");
		lblSeatingCapacity.setBounds(350, 240, 130, 50);
		lblSeatingCapacity.setFont(font1);
		
		lblFarePerKm = new JLabel(" Fare Per Km");
		lblFarePerKm.setBounds(350, 280, 130, 50);
		lblFarePerKm.setFont(font1);
		
		lblMsg = new JLabel("(Enter between 1 to 999)");
		lblMsg.setBounds(350, 310, 150, 50);
		
		cVehicleId = new Choice();
		cVehicleId.setBounds(520, 90, 130, 30);
		
	//	txtVehicleId = new JTextField(20);
	//	txtVehicleId.setToolTipText("Enter vehicle id");
	//	txtVehicleId.setBounds(520, 90, 130, 30);
		
		txtName = new JTextField(20);
		txtName.setBounds(520, 130, 130, 30);
		txtName.setEditable(false);
		
		txtType = new JTextField(20);
		txtType.setBounds(520, 170, 130, 30);
		txtType.setEditable(false);
		
		txtRegistrationNo = new JTextField(20);
		txtRegistrationNo.setBounds(520, 210, 130, 30);
		txtRegistrationNo.setEditable(false);
		
		txtSeatingCapacity = new JTextField(20);
		txtSeatingCapacity.setBounds(520, 250, 130, 30);
		txtSeatingCapacity.setEditable(false);
		
		txtFarePerKm = new JTextField(20);
		txtFarePerKm.setBounds(520, 290, 130, 30);
		txtFarePerKm.setEditable(false);
		
		btnView = new JButton("View Vehicle");
	//	btnView.setBounds(380, 380, 120, 50);
		
		btnBack = new JButton("  Back  ");
		btnBack.setBounds(10, 10, 100, 30);
		
		btnCancel = new JButton("  Cancel  ");
		btnCancel.setBounds(450, 380, 100, 30);
		
		option = new JOptionPane();
		frame = new JFrame();
		
		cType = new Choice();
		cType.add("SMALL");
		cType.add("MEDIUM");
		cType.add("LARGE");
		cType.setBounds(180, 110, 130, 30);
		
		add(lblHead);
		add(lblVehicleId);				add(cVehicleId);    //add(txtVehicleId);
		add(lblName);   				add(txtName);
		add(lblType);					add(txtType);						
		add(lblRegistrationNo);   		add(txtRegistrationNo);
		add(lblSeatingCapacity);		add(txtSeatingCapacity);
		add(lblFarePerKm);				add(txtFarePerKm);
	//	add(btnView);				
		add(btnCancel);
		add(btnBack);					add(lblMsg);
		
		addWindowListener(new VehicleListenerView(this)); 
		cVehicleId.addItemListener(new VehicleListenerView(this));
		btnView.addActionListener(new VehicleListenerView(this));
		btnBack.addActionListener(new VehicleListenerView(this));
		btnCancel.addActionListener(new VehicleListenerView(this));
		
		setVisible(true);
	}
}
