package com.wipro.ata.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.wipro.ata.listener.VehicleDeleteListener;
import com.wipro.ata.listener.VehicleListener;

public class VehicleUi extends JFrame
{	
	public static void main(String args[])
	{
		VehicleUi ui = new VehicleUi();
	}
	
	public static JLabel lblVehicleAddition , lblEmpty , lblId ,lblName, lblType ,lblRegistrationNo , lblSeatingCapacity, lblFarePerKm , lblMsg;
	public static JTextField txtId , txtName  , txtRegistrationNo , txtSeatingCapacity , txtFarePerKm;
	public static JButton btnAdd , btnBack ,btnCancel;
	public static JOptionPane option;
	public static JFrame frame;
	public static Choice cType , cSeats;
	
	public VehicleUi()
	{
		setContentPane(new JLabel(new ImageIcon("src\\image.jpg")));
				
		setSize(1020,750);
		setTitle("Vehicle Addition");
	//	setLocation(100,100);
		setLayout(null);
	//	setResizable(false);
	
		frame = new JFrame();
		
		Font font = new Font("papyrus", Font.BOLD, 22);
		
		lblVehicleAddition = new JLabel(" Add Vehicle ");
		lblVehicleAddition.setFont(font);
		lblVehicleAddition.setBounds(400 , 50 , 200 , 50);
	//	lblVehicleAddition.setForeground(Color.WHITE);
		
		Font font1 = new Font("Verdana", Font.BOLD, 12);
		lblId = new JLabel(" ID");	    
		lblId.setBounds(350, 100, 130, 50);
		lblId.setFont(font1);
	//	lblId.setForeground(Color.WHITE);
		
		lblName = new JLabel(" Name");  
		lblName.setBounds(350, 140, 130, 50);
		lblName.setFont(font1);
	//	lblName.setForeground(Color.WHITE);
		
		lblType = new JLabel(" Type");    
		lblType.setBounds(350, 190, 130, 50);
		lblType.setFont(font1);
	//	lblType.setForeground(Color.WHITE);
		
		lblRegistrationNo = new JLabel(" Registration No");     
		lblRegistrationNo.setBounds(350, 240, 130, 50);
		lblRegistrationNo.setFont(font1);
	//	lblRegistrationNo.setForeground(Color.WHITE);
		
		lblSeatingCapacity = new JLabel(" Seating Capacity ");  
		lblSeatingCapacity.setBounds(350, 290, 130, 50);
		lblSeatingCapacity.setFont(font1);
	//	lblSeatingCapacity.setForeground(Color.WHITE);
		
		lblFarePerKm = new JLabel(" Fare Per Km ");  
		lblFarePerKm.setBounds(350, 340, 130, 50);
		lblFarePerKm.setFont(font1);
	//	lblFarePerKm.setForeground(Color.WHITE);
		
		lblMsg = new JLabel("(Enter between 1 to 999)");
		lblMsg.setBounds(350, 360, 150, 50);
	//	lblMsg.setForeground(Color.WHITE);
		
		txtId = new JTextField(20);      				 
		txtId.setBounds(500, 110, 130, 30);
		txtId.setToolTipText("Enter vehicle id");
		txtId.setEditable(false);						
		txtId.setFont(font1);
	
		txtName = new JTextField(20);					
		txtName.setBounds(500, 150, 130, 30);
		txtName.setToolTipText("Enter vehicle name");
	//	txtName.setForeground(Color.BLUE);
		
		txtRegistrationNo = new JTextField(20);			 
		txtRegistrationNo.setBounds(500, 250, 130, 30);
		txtRegistrationNo.setToolTipText("Enter vehicle registration number");
	
		txtFarePerKm = new JTextField(20);				 
		txtFarePerKm.setBounds(500, 350, 130, 30);
		txtFarePerKm.setToolTipText("Enter fare");
		
		cType = new Choice();
		cType.add("SMALL");
		cType.add("MEDIUM");
		cType.add("LARGE");
		cType.setBounds(500, 200, 130, 30);
		
		cSeats = new Choice();
		cSeats.setBounds(500, 300, 130, 30);
		
		btnCancel = new JButton(" CANCEL ");		
		btnCancel.setBounds(515, 430, 100, 30);
		btnBack = new JButton(" BACK ");			
		btnBack.setBounds(10, 10, 100, 30);
		btnAdd = new JButton("  ADD  ");			
		btnAdd.setBounds(385, 430, 100, 30);
		option = new JOptionPane();
		
		add(lblVehicleAddition);  	
		add(lblId);						add(txtId);
		add(lblName);   				add(txtName);
		add(lblType);					add(cType);					
		add(lblRegistrationNo);   		add(txtRegistrationNo);
		add(lblSeatingCapacity);		add(cSeats);   
		add(lblFarePerKm);				add(txtFarePerKm);
		add(btnAdd);					add(btnBack);
		add(btnCancel);					add(lblMsg);
		
		cType.addItemListener(new VehicleListener(this));
		btnAdd.addActionListener(new VehicleListener(this));
		btnBack.addActionListener(new VehicleListener(this));
		btnCancel.addActionListener(new VehicleListener(this));
		
		setVisible(true);
		
	}
}

