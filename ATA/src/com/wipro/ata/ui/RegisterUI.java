package com.wipro.ata.ui;

import java.awt.Font;
import java.util.Date;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.wipro.ata.listener.RegisterListener;

public class RegisterUI extends JFrame
{
	public JFrame frame;
	public JLabel titleLabel,firstNameLabel,lastNameLabel,dobLabel,genderLabel,streetLabel,locationLabel,cityLabel,stateLabel,pincodeLabel,mobNoLabel,emailIdLabel;
	public JTextField firstNameText,lastNameText,dobText,streetText,locationText,cityText,stateText,pincodeText,mobNoText,emailIdText;
	public JRadioButton maleButton,femaleButton;
	public JButton submitButton,cancelButton,backButton;
	public JLabel maleLabel,femaleLabel,useridLabel,userval,passwordLabel;
	public JPasswordField passField;
	public JButton okButton;
	public JDateChooser chooser;
	public RegisterUI()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setTitle("Register Page");
		setSize(1000,750);
		setLayout(null);
		
		titleLabel=new JLabel("Register Customer");
		titleLabel.setFont(new Font("Papyrus",Font.BOLD,18));
		titleLabel.setBounds(340,20,205,25);
		add(titleLabel);
		firstNameLabel=new JLabel("First Name");
		firstNameLabel.setBounds(40,60,125,25);
		firstNameText=new JTextField(20);
		firstNameText.setBounds(150,60,125,25);
		lastNameLabel=new JLabel("Last Name");
		lastNameLabel.setBounds(40,110,125,25);
		lastNameText=new JTextField(20);
		lastNameText.setBounds(150,110,125,25);
		dobLabel=new JLabel("Date Of Birth");
		dobLabel.setBounds(40,160,125,25);
		chooser=new JDateChooser();
		chooser.setLocale(Locale.US);
		chooser.setMaxSelectableDate(new Date());
		add(chooser);
		chooser.setBounds(150,160,125,25);
		genderLabel=new JLabel("Gender");
		genderLabel.setBounds(40,210,125,25);
		maleButton=new JRadioButton();
		maleButton.setBounds(150,210,25,25);
		maleLabel=new JLabel("Male");
		maleLabel.setBounds(180,210,125,25);
		femaleButton=new JRadioButton();
		femaleButton.setBounds(220,210,25,25);
		femaleLabel=new JLabel("Female");
		femaleLabel.setBounds(250,210,125,25);
		ButtonGroup bg=new ButtonGroup();
		bg.add(maleButton);
		bg.add(femaleButton);
		streetLabel=new JLabel("Street");
		streetLabel.setBounds(40,260,125,25);
		streetText=new JTextField(20);
		streetText.setBounds(150,260,125,25);
		locationLabel=new JLabel("Location");
		locationLabel.setBounds(40,310,125,25);
		locationText=new JTextField(20);
		locationText.setBounds(150,310,125,25);
		cityLabel=new JLabel("City");
		cityLabel.setBounds(40,360,125,25);
		cityText=new JTextField(20);
		cityText.setBounds(150,360,125,25);
		stateLabel=new JLabel("State");
		stateLabel.setBounds(40,410,125,25);
		stateText=new JTextField(20);
		stateText.setBounds(150,410,125,25);
		pincodeLabel=new JLabel("Pin Code");
		pincodeLabel.setBounds(40,460,125,25);
		pincodeText=new JTextField(20);
		pincodeText.setBounds(150,460,125,25);
		mobNoLabel=new JLabel("Mobile No");
		mobNoLabel.setBounds(40,510,125,25);
		mobNoText=new JTextField(20);
		mobNoText.setBounds(150,510,125,25);
		emailIdLabel=new JLabel("E-Mail Id");
		emailIdLabel.setBounds(40,560,125,25);
		emailIdText=new JTextField(20);
		emailIdText.setBounds(150,560,125,25);
		
		useridLabel=new JLabel("Your User Id is");
		useridLabel.setBounds(550,180,150,25);
		useridLabel.setVisible(false);
		userval=new JLabel("");
		userval.setBounds(550,230,150,25);
		passwordLabel=new JLabel("Password");
		passwordLabel.setBounds(40,610,160,25);
		passField=new JPasswordField(20);
		passField.setBounds(150,610, 125, 25);
		
		
		submitButton=new JButton("Submit");
		submitButton.setBounds(60,660,75,25);
		
		cancelButton=new JButton("Cancel");
		cancelButton.setBounds(170,660,75,25);
		
		backButton=new JButton("Back");
		backButton.setBounds(10,10,75,25);
		
		okButton=new JButton("OK");
		okButton.setBounds(560,350,75,25);
		okButton.setVisible(false);
		add(firstNameLabel);
		add(lastNameLabel);
		add(dobLabel);
		add(genderLabel);
		add(streetLabel);
		add(locationLabel);
		add(cityLabel);
		add(stateLabel);
		add(pincodeLabel);
		add(mobNoLabel);
		add(emailIdLabel);
		add(firstNameText);
		add(lastNameText);
		//add(dobText);
		add(streetText);
		add(locationText);
		add(cityText);
		add(stateText);
		add(pincodeText);
		add(mobNoText);
		add(emailIdText);
		add(submitButton);
		add(cancelButton);
		add(maleButton);
		add(maleLabel);
		add(femaleButton);
		add(femaleLabel);
		add(useridLabel);
		add(userval);
		add(passwordLabel);
		add(passField);
		add(backButton);
		
		submitButton.addActionListener(new RegisterListener(this));
		maleButton.addActionListener(new RegisterListener(this));
		femaleButton.addActionListener(new RegisterListener(this));
		okButton.addActionListener(new RegisterListener(this));
		backButton.addActionListener(new RegisterListener(this));
		cancelButton.addActionListener(new RegisterListener(this));
	}
}
