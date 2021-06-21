package com.wipro.ata.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.ata.listener.DriverAddListener;

public class DriverAddForm extends JFrame
{
	public JFrame frame;
	public JPanel panel;
	public JLabel lblTitle,lblId,lblName,lblStreet,lblLoc,lblCity,lblState,lblPin,lblMob,lblLicense;
	public JTextField txtId,txtName,txtStreet,txtLoc,txtCity,txtState,txtPin,txtMob,txtLicense;
	public JButton btnAdd,btnBack,btnCancel;
	
	public DriverAddForm()
	{
		
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		
		//panel=new JPanel();
		setVisible(true);
		setSize(1020,750);
		setLayout(null);
		
		setTitle("ADD DRIVER DETAILS");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		lblTitle=new JLabel("Add Driver");
		lblTitle.setFont(new Font("Times New Roman",Font.BOLD,20));
		//lblTitle.setForeground(Color.red);
		lblTitle.setBounds(250, 60, 350, 30);
		
		
		
		lblId=new JLabel("Driver ID");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblId.setBounds(150,120,150,30);
		//add(lblId);
		
		txtId=new JTextField(10);
		txtId.setBounds(330,120,150,30);
		//add(txtId);
		txtId.setEditable(false);
		
		lblName=new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblName.setBounds(150, 180, 150, 30);
		//add(lblName);
		
		
		txtName=new JTextField(10);
		txtName.setBounds(330,180,150,30);
		txtName.setToolTipText("Enter valid Name");
		//add(txtName);
		
		lblStreet=new JLabel("Street");
		lblStreet.setForeground(Color.BLACK);
		lblStreet.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblStreet.setBounds(150,220,150,30);
		//add(lblStreet);
		
		
		txtStreet=new JTextField(10);
		txtStreet.setToolTipText("Enter valid Street");
		txtStreet.setBounds(330,220,150,30);
		//add(txtStreet);
		
		lblLoc=new JLabel("Location");
		lblLoc.setForeground(Color.BLACK);
		lblLoc.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblLoc.setBounds(150,260,150,30);
		//add(lblLoc);
		
		txtLoc=new JTextField(10);
		txtLoc.setBounds(330,260,150,30);
		txtLoc.setToolTipText("Enter valid Location");
		//add(txtLoc);
		
		lblCity=new JLabel("City");
		lblCity.setForeground(Color.BLACK);
		lblCity.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblCity.setBounds(150, 300, 150, 30);
		//add(lblCity);
		
		
		txtCity=new JTextField(10);
		txtCity.setToolTipText("Enter valid City Name");
		txtCity.setBounds(330,300,150,30);
		//add(txtCity);
		
		lblState=new JLabel("State");
		lblState.setForeground(Color.BLACK);
		lblState.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblState.setBounds(150,340,150, 30);
		//add(lblState);
		
		
		txtState=new JTextField(10);
		txtState.setToolTipText("Enter valid State name");
		txtState.setBounds(330,340,150,30);
		//add(txtState);
		
				
		
		lblPin=new JLabel("PinCode");
		lblPin.setForeground(Color.BLACK);
		lblPin.setBounds(150,380,150, 30);
		lblPin.setFont(new Font("Times New Roman",Font.BOLD,18));
		//add(lblPin);
		
		txtPin=new JTextField(10);
		txtPin.setToolTipText("Enter valid Pincode");
		txtPin.setBounds(330,380,150,30);
		//add(txtPin);
		
		lblMob=new JLabel("Mobile No");
		lblMob.setForeground(Color.BLACK);
		lblMob.setBounds(150,420,150, 30);
		lblMob.setFont(new Font("Times New Roman",Font.BOLD,18));
		//add(lblMob);
		
		
		txtMob=new JTextField(10);
		txtMob.setToolTipText("Enter valid Mobile No");
		txtMob.setBounds(330,420,150,30);
		//add(txtMob);
		
		lblLicense=new JLabel("License No");
		lblLicense.setForeground(Color.BLACK);
		lblLicense.setBounds(150,460,150, 30);
		lblLicense.setFont(new Font("Times New Roman",Font.BOLD,18));
		//add(lblLicense);
		
		
		txtLicense=new JTextField(10);
		txtLicense.setToolTipText("Enter valid License No");
		txtLicense.setBounds(330,460,150,30);
		//add(txtLicense);
		
		
		btnAdd=new JButton("Add Driver");
		//btnAdd.setForeground(Color.BLACK);
		//btnAdd.setFont(new Font("Papyrus",Font.BOLD,20));
		btnAdd.setBounds(290,530,150,30);
		btnAdd.setToolTipText("Click here to add Driver");
		//add(btnAdd);
		
		
		
		btnBack=new JButton("Back");
		//btnBack.setForeground(Color.BLACK);
		//btnBack.setFont(new Font("Papyrus",Font.BOLD,20));
		btnBack.setBounds(10,10,75,25);
		btnBack.setToolTipText("Click here to go back");
		
		//add(btnBack);
		
		btnCancel=new JButton("Cancel");
		//btnCancel.setForeground(Color.BLACK);
		//btnCancel.setFont(new Font("Papyrus",Font.BOLD,20));
		btnCancel.setBounds(290,570,150,30);
		btnCancel.setToolTipText("Click here to cancel Entered Values");
		add(btnCancel);
		
		
		
		add(lblTitle);
		add(lblId);
		add(txtId);
		add(lblName);
		add(txtName);
		add(lblStreet);
		add(txtStreet);
		add(lblLoc);
		add(txtLoc);
		add(lblCity);
		add(txtCity);
		add(lblState);
		add(txtState);
		add(lblPin);
		add(txtPin);
		add(lblMob);
		add(txtMob);
		add(lblLicense);
		add(txtLicense);
		add(btnAdd);
		add(btnBack);
		add(btnCancel);
		btnAdd.addActionListener(new DriverAddListener(this));
		btnBack.addActionListener(new DriverAddListener(this));
		btnCancel.addActionListener(new DriverAddListener(this));
		
	}
	
	
	
	public static void main(String[] args) 
	{
		new DriverAddForm();
	}

}

