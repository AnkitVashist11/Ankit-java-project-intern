package com.wipro.ata.ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.ata.listener.ChangePasswordListener;

public class ChangePasswordUI extends JFrame
{
	public JFrame frame;
	public JLabel userIdLabel,passwordLabel,newPasswordLabel,confirmNewPassword,titleLabel;
	public JTextField userIdText;
	public JPasswordField passwordText,newPasswordText,confirmPasswordText;
	public JButton okButton,cancelButton,backButton;
	public ChangePasswordUI() 
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setTitle("Change Password Page");
		setSize(1020,750);
		setLayout(null);
		titleLabel=new JLabel("Change Password");
		titleLabel.setFont(new Font("Papyrus",Font.BOLD,20));
		titleLabel.setBounds(385,100,350,25);
		userIdLabel=new JLabel("Enter UserId");
		userIdLabel.setBounds(340,160,75,25);
		passwordLabel=new JLabel("Type Old Password");
		passwordLabel.setBounds(340,200,125,25);
		newPasswordLabel=new JLabel("Type New Password");
		newPasswordLabel.setBounds(340,240,150,25);
		confirmNewPassword=new JLabel("Retype New Password");
		confirmNewPassword.setBounds(340,280, 150, 25);
		userIdText=new JTextField(20);
		userIdText.setBounds(480,160,125,25);
		passwordText=new JPasswordField(20);
		passwordText.setBounds(480,200,125,25);
		newPasswordText=new JPasswordField(20);
		newPasswordText.setBounds(480,240,125,25);
		confirmPasswordText=new JPasswordField(20);
		confirmPasswordText.setBounds(480, 280, 125, 25);
		okButton=new JButton("Submit");
		okButton.setBounds(410,330,110,25);
		cancelButton=new JButton("Cancel");
		cancelButton.setBounds(410,370,110,25);
		backButton=new JButton("Back");
		backButton.setBounds(10,10,75,25);
		add(confirmPasswordText);
		add(confirmNewPassword);
		add(titleLabel);
		add(userIdLabel);
		add(passwordLabel);
		add(newPasswordLabel);
		add(userIdText);
		add(passwordText);
		add(newPasswordText);
		add(okButton);
		add(cancelButton);
		add(backButton);
		okButton.addActionListener(new ChangePasswordListener(this));
		cancelButton.addActionListener(new ChangePasswordListener(this));
		backButton.addActionListener(new ChangePasswordListener(this));
	}
}

