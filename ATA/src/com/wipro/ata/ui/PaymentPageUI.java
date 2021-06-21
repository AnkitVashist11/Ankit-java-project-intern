package com.wipro.ata.ui;

import java.awt.Choice;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.ata.listener.BookVehicleListener;
import com.wipro.ata.listener.PaymentPageListener;

public class PaymentPageUI extends JFrame
{
	public JFrame frame;
	public JLabel titlleLabel,creditCardNoLabel,validFromLabel,validToLabel,totalFareLabel,userIdLabel,passwordLabel;
	public JTextField creditCardNoText,totalFareText,userIdText;
	public JPasswordField passwordText;
	public Choice validFromchoice,validToChoice;
	public JButton payButton,backButton;
	public PaymentPageUI()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setTitle("Payment Page");
		setSize(1020,750);
		setLayout(null);
		titlleLabel=new JLabel("Payment Through Credit Card");
		titlleLabel.setBounds(280,20,270,25);
		titlleLabel.setFont(new Font("",Font.BOLD,18));
		add(titlleLabel);
		creditCardNoLabel=new JLabel("Credit Card No.");
		creditCardNoLabel.setBounds(300,80,125,25);
		add(creditCardNoLabel);
		validFromLabel=new JLabel("Valid From");
		validFromLabel.setBounds(300,120,75,25);
		add(validFromLabel);
		validToLabel=new JLabel("Valid To");
		validToLabel.setBounds(300,160,75,25);
		add(validToLabel);
		creditCardNoText=new JTextField(20);
		creditCardNoText.setBounds(400,80,125,25);
		add(creditCardNoText);
		validFromchoice=new Choice();
		validFromchoice.setBounds(400,120,125,25);
		add(validFromchoice);
		validToChoice=new Choice();
		validToChoice.setBounds(400,160,125,25);
		add(validToChoice);
		for(int i=2000;i<=2016;i++)
		{
			validFromchoice.add(Integer.toString(i));
		}
		for(int i=2017;i<=2040;i++)
		{
			validToChoice.add(Integer.toString(i));
		}
		totalFareLabel=new JLabel("Total Fare");
		totalFareLabel.setBounds(300,200,75,25);
		add(totalFareLabel);
		totalFareText=new JTextField(20);
		totalFareText.setBounds(400,200,125,25);
		totalFareText.setText(Double.toString(BookVehicleListener.totalFare));
		totalFareText.setEditable(false);
		add(totalFareText);
		payButton=new JButton("Proceed To Pay");
		payButton.setBounds(350,240,125,25);
		add(payButton);
		backButton=new JButton("Back");
		backButton.setBounds(10,10,75,25);
		add(backButton);
		//userIdLabel=new JLabel("User Id");
		//userIdLabel.setBounds(300,240,75,25);
		//add(userIdLabel);
		//userIdText=new JTextField(20);
		//userIdText.setBounds(400,240,125,25);
		//add(userIdText);
		//userIdText.setEditable(false);
		//passwordLabel=new JLabel("Password");
		//passwordLabel.setBounds(300,280,75,25);
		//add(passwordLabel);
		//passwordText=new JPasswordField(20);
		//passwordText.setBounds(400,280,125,25);
		//add(passwordText);
		payButton.addActionListener(new PaymentPageListener(this));
		validFromchoice.addItemListener(new PaymentPageListener(this));
		validToChoice.addItemListener(new PaymentPageListener(this));
		backButton.addActionListener(new PaymentPageListener(this));
	}
	public static void main(String args[])
	{
		new PaymentPageUI().setVisible(true);
	}
}

