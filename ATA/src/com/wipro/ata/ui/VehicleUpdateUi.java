package com.wipro.ata.ui;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import com.wipro.ata.listener.VehicleListener;
import com.wipro.ata.listener.VehicleUpdateListener;

public class VehicleUpdateUi extends JFrame
{
	public static void main(String args[])
	{
		VehicleUpdateUi ui = new VehicleUpdateUi();
	}
	
	public static JLabel lblVehicleModiy , lblId ,lblName, lblType , lblHead ,lblRegistrationNo , lblSeatingCapacity, lblFarePerKm , lblMsg;
	public static JTextField txtId , txtName , txtType , txtRegistrationNo , txtSeatingCapacity , txtFarePerKm;
	public static JButton btnModify , btnEnter, btnBack ,btnCancel ,btnBack1;
	public static JOptionPane option;
	public static JFrame frame , optionFrame;
	public static Choice cType , cSeats;

	public VehicleUpdateUi()
	{
		frame = new JFrame();
		setContentPane(new JLabel(new ImageIcon("src\\image.jpg")));
		frame.setContentPane(new JLabel(new ImageIcon("src\\image.jpg")));
		
		
		setSize(1020, 750);
		setTitle("Vehicle Details Modification");
	//	setLocation(100,100);
		setLayout(null);
	//	setResizable(false);
		
		optionFrame = new JFrame();
		
		
		frame.setSize(1020, 750);
	//	frame.setLocation(100, 100);
		frame.setTitle("Vehicle Modification");
	
		frame.setLayout(null);
		
		Font font = new Font("papyrus", Font.BOLD, 20);
		Font font1 = new Font("Verdana", Font.PLAIN, 13);
		Font font2 = new Font("papyrus", Font.BOLD, 20);
		
		lblVehicleModiy = new JLabel("Modify Details");
		lblVehicleModiy.setBounds(450, 50, 150, 50);
		lblVehicleModiy.setFont(font);
		
		lblHead = new JLabel("Specify vehicle id if you want to modify vehicle details");
		lblHead.setBounds(280, 30, 600, 50);
		lblHead.setFont(font2);
		
		lblId = new JLabel(" Enter Vehicle Id");	
		lblId.setFont(font1);
		
		txtId = new JTextField(20);			
	
		
		lblName = new JLabel(" Name");						
		lblName.setBounds(360, 110, 130, 50);
		lblName.setFont(font1);
		
		lblType = new JLabel(" Type");						
		lblType.setBounds(360, 150, 130, 50);
		lblType.setFont(font1);
		
		lblRegistrationNo = new JLabel(" Registration No");		 
		lblRegistrationNo.setBounds(360, 190, 130, 50);
		lblRegistrationNo.setFont(font1);
		
		lblSeatingCapacity = new JLabel(" Seating Capacity ");		
		lblSeatingCapacity.setBounds(360, 230, 130, 50);
		lblSeatingCapacity.setFont(font1);
		
		lblFarePerKm = new JLabel(" Fare Per Km ");   
		lblFarePerKm.setBounds(360, 270, 130, 50);
		lblFarePerKm.setFont(font1);
		
		lblMsg = new JLabel("(Enter between 1 to 999)");
		lblMsg.setBounds(360, 300, 150, 50);
		
		txtName = new JTextField(20);      
		txtName.setBounds(550, 120, 130, 30);
		txtName.setEditable(false);
	//	txtName.setForeground(Color.blue);
		
		txtRegistrationNo = new JTextField(20);   
		txtRegistrationNo.setBounds(550, 200, 130, 30 );
		txtRegistrationNo.setEditable(false);
	
		txtFarePerKm = new JTextField(20);   	 
		txtFarePerKm.setBounds(550, 285, 130, 30 );
		
		cType = new Choice();
		cType.add("SMALL");
		cType.add("MEDIUM");
		cType.add("LARGE");
	//	cType.setBounds(550, 165, 130, 30 );
		
		txtType = new JTextField(20);
		txtType.setEditable(false);
		txtType.setBounds(550, 165, 130, 30 );
		
		cSeats = new Choice();						
	//	cSeats.setBounds(550, 250, 130, 30);
		txtSeatingCapacity = new JTextField(20);
		txtSeatingCapacity.setEditable(false);
		txtSeatingCapacity.setBounds(550, 250, 130, 30);
		
		btnCancel = new JButton(" Cancel ");
		btnCancel.setBounds(550, 380, 100, 30);
		
		btnBack = new JButton(" Back ");
		btnBack.setBounds(10, 10, 100, 30);
		
		btnModify = new JButton("  Modify  ");
		btnModify.setBounds(400, 380, 100, 30);
				
		btnEnter = new JButton(" View vehicle details ");
		option = new JOptionPane();
		
		lblId.setBounds(340, 100, 200, 25);
		txtId.setBounds(560, 100, 100, 25);
		btnEnter.setBounds(420, 150, 170, 30);
		btnBack1 = new JButton(" Back ");
		btnBack1.setBounds(10, 10, 100, 30);
	
		add(lblHead);
		add(lblId);				add(txtId);
		add(btnEnter);			add(btnBack1);
	
		frame.add(lblVehicleModiy);
		frame.add(lblName);   					frame.add(txtName);
		frame.add(lblType);						frame.add(txtType);  //frame.add(cType);					
		frame.add(lblRegistrationNo);   		frame.add(txtRegistrationNo);
		frame.add(lblSeatingCapacity);			frame.add(txtSeatingCapacity); //frame.add(cSeats);  
		frame.add(lblFarePerKm);				frame.add(txtFarePerKm);
		frame.add(btnModify);					frame.add(lblMsg);
		frame.add(btnBack);
		frame.add(btnCancel);
		
		cType.addItemListener(new VehicleUpdateListener(this));
		btnModify.addActionListener(new VehicleUpdateListener(this));
		btnEnter.addActionListener(new VehicleUpdateListener(this));
		btnBack.addActionListener(new VehicleUpdateListener(this));
		btnCancel.addActionListener(new VehicleUpdateListener(this));
		btnBack1.addActionListener(new VehicleUpdateListener(this));
		
		setVisible(true);
	}
}
