package com.wipro.ata.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.ata.listener.DriverModifyListener;

public class DriverModifyForm extends JFrame
{
	JFrame frame;
	public JPanel panel1;
	public JLabel lblTitle,lblId,lblName,lblStreet,lblLoc,lblCity,lblState,lblPin,lblMob,lblLicense;
	public JTextField txtId,txtName,txtStreet,txtLoc,txtCity,txtState,txtPin,txtMob,txtLicense;
	public JButton btnUpdate,btnBack,btnCancel,btnEnter;
	public DriverModifyForm()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setVisible(true);
		//panel1=new JPanel();
		
		setSize(700,700);
		//panel1.
		setLayout(null);
		setLocation(10,10);
		setTitle("MODIFY DRIVER DETAILS");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblTitle=new JLabel("Modify Driver");
		//lblTitle.setForeground(Color.red);
		//titleLabel.setBounds(415,90,350,25);
		lblTitle.setBounds(260, 60, 350, 25);
		lblTitle.setFont(new Font("Papyrus",Font.BOLD,20));
		//panel1.
		add(lblTitle);
		
		lblId=new JLabel("Driver ID");
		lblId.setBounds(150,120,150,30);
		
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblId);
		
		
		txtId=new JTextField(10);
		txtId.setBounds(330,120,150,30);
		txtId.setToolTipText("Enter valid Driver Id");
		//panel1.
		add(txtId);
		
		lblName=new JLabel("Name");
		lblName.setBounds(150, 180, 150, 30);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblName);
		
		
		lblName.setVisible(false);
		
		txtName=new JTextField(10);
		txtName.setBounds(330,180,150,30);
		txtName.setToolTipText("Enter a valid name");
		//panel1.
		add(txtName);
		txtName.setVisible(false);
		
		lblStreet=new JLabel("Street");
		lblStreet.setBounds(150,220,150,30);
		lblStreet.setForeground(Color.BLACK);
		lblStreet.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblStreet);
		lblStreet.setVisible(false);
		
		txtStreet=new JTextField(10);
		txtStreet.setBounds(330,220,150,30);
		txtStreet.setToolTipText("Enter a valid Street");
		//panel1.
		add(txtStreet);
		txtStreet.setVisible(false);
		
		lblLoc=new JLabel("Location");
		lblLoc.setBounds(150,260,150,30);
		lblLoc.setForeground(Color.BLACK);
		lblLoc.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblLoc);
		lblLoc.setVisible(false);
		
		txtLoc=new JTextField(10);
		txtLoc.setBounds(330,260,150,30);
		txtLoc.setToolTipText("Enter valid location");
		//panel1.
		add(txtLoc);
		txtLoc.setVisible(false);
		
		lblCity=new JLabel("City");
		lblCity.setBounds(150, 300, 150, 30);
		lblCity.setForeground(Color.BLACK);
		lblCity.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblCity);
		lblCity.setVisible(false);
		
		txtCity=new JTextField(10);
		txtCity.setBounds(330,300,150,30);
		txtCity.setToolTipText("Enter valid City");
		//panel1.
		add(txtCity);
		txtCity.setVisible(false);
		
		lblState=new JLabel("State");
		lblState.setBounds(150,340,150, 30);
		lblState.setForeground(Color.BLACK);
		lblState.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblState);
		lblState.setVisible(false);
		
		txtState=new JTextField(10);
		txtState.setBounds(330,340,150,30);
		txtState.setToolTipText("Enter valid State");
		//panel1.
		add(txtState);
		txtState.setVisible(false);
		
		lblPin=new JLabel("PinCode");
		lblPin.setBounds(150,380,150, 30);
		lblPin.setForeground(Color.BLACK);
		lblPin.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblPin);
		lblPin.setVisible(false);
		
		txtPin=new JTextField(10);
		txtPin.setBounds(330,380,150,30);
		txtPin.setToolTipText("Enter valid Pin");

		//panel1.
		add(txtPin);
		txtPin.setVisible(false);
		
		lblMob=new JLabel("Mobile No");
		lblMob.setBounds(150,420,150, 30);
		lblMob.setForeground(Color.BLACK);
		lblMob.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblMob);
		lblMob.setVisible(false);
		
		txtMob=new JTextField(10);
		txtMob.setBounds(330,420,150,30);
		txtMob.setToolTipText("Enter valid Mobile No");
		//panel1.
		add(txtMob);
		txtMob.setVisible(false);
		
		lblLicense=new JLabel("License No");
		lblLicense.setBounds(150,460,150, 30);
		lblLicense.setForeground(Color.BLACK);
		lblLicense.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel1.
		add(lblLicense);
		lblLicense.setVisible(false);
		
		txtLicense=new JTextField(10);
		txtLicense.setBounds(330,460,150,30); 
		txtLicense.setToolTipText("Enter valid License No");
		//panel1.
		add(txtLicense);
		txtLicense.setVisible(false);
		
		btnUpdate=new JButton("Update ");
		//btnUpdate.setForeground(Color.BLACK);
		//btnUpdate.setFont(new Font("Papyrus",Font.BOLD,18));
		btnUpdate.setBounds(290,530,100,30);
		btnUpdate.setToolTipText("Click here to Update");
		//panel1.
		add(btnUpdate);
		btnUpdate.setVisible(false);
		btnUpdate.addActionListener(new DriverModifyListener(this));
		
		btnBack=new JButton("Back");
		//btnBack.setForeground(Color.BLACK);
		//btnBack.setFont(new Font("Papyrus",Font.BOLD,18));
		btnBack.setBounds(10,10,75,25);
		btnBack.setToolTipText("Click here to go back");
		//panel1.
		add(btnBack);
		btnBack.setVisible(true);
		btnBack.addActionListener(new DriverModifyListener(this));
		
		btnEnter=new JButton("View");
		//btnEnter.setForeground(Color.BLACK);
		//btnEnter.setFont(new Font("Papyrus",Font.BOLD,18));
		btnEnter.setBounds(290,530,100,30);
		btnEnter.setToolTipText("Click here to view Driver Details");
		//panel1.
		add(btnEnter);
		btnEnter.addActionListener(new DriverModifyListener(this));
		
		btnCancel=new JButton("Cancel");
		btnCancel.setBounds(290,570,100,30);
		btnCancel.setToolTipText("Click here to cancel");
		//btnCancel.setForeground(Color.BLACK);
		//btnCancel.setFont(new Font("Papyrus",Font.BOLD,18));
		//panel1.
		add(btnCancel);
		btnCancel.addActionListener(new DriverModifyListener(this));
		
		//add(panel1);
	}
	public static void main(String[] args) 
	{
		new DriverModifyForm();
	}

}
