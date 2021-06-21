package com.wipro.ata.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.ata.listener.LoginListener;

public class LoginUI extends JFrame
{
	public JLabel userIdLabel,passwordLabel,loginLabel,copyrightLabel;
	public JTextField userIdtextField;
	public JPasswordField passwordtextField;
	public JButton loginButton,registerButton,changePasswordButton,cancelButton;
	public JFrame frame;
	public LoginUI()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,750);
		//setSize(900,800);
		setLayout(null);
		copyrightLabel=new JLabel("Copyright @ 2014 Wipro Technologies.All rights reserved");
		copyrightLabel.setBounds(340,360,350,25);
		copyrightLabel.setFont(new Font("Serif",Font.ITALIC,13));
		loginLabel=new JLabel("AUTOMATION OF TRAVEL AGENCY");
		loginLabel.setBounds(340,100,350,25);
		loginLabel.setFont(new Font("Papyrus",Font.BOLD,13));
		userIdLabel=new JLabel("Username");
		userIdLabel.setBounds(390,160,75,25);
		passwordLabel=new JLabel("Password");
		passwordLabel.setBounds(390,200,75,25);
		userIdtextField=new JTextField(20);
		userIdtextField.setBounds(480,160,125,25);
		passwordtextField=new JPasswordField(10);
		passwordtextField.setBounds(480,200,125,25);
		add(userIdLabel);
		add(userIdtextField);
		add(passwordLabel);
		add(passwordtextField);
		loginButton=new JButton("Login");
		loginButton.setBounds(350,250,140,25);
		changePasswordButton=new JButton("Change Password");
		changePasswordButton.setBounds(350,300,140,25);
		registerButton=new JButton("Register Customer");
		registerButton.setBounds(510,300,150,25);
		cancelButton=new JButton("Cancel");
		cancelButton.setBounds(510,250,150,25);
		add(loginLabel);
		add(userIdLabel);
		add(userIdtextField);
		add(passwordLabel);
		add(passwordtextField);
		add(loginButton);
		add(changePasswordButton);
		add(registerButton);
		add(copyrightLabel);
		add(cancelButton);
		getContentPane().setBackground(Color.cyan);
		setResizable(false);
		setVisible(true);
		loginButton.addActionListener(new LoginListener(this));
		changePasswordButton.addActionListener(new LoginListener(this));
		cancelButton.addActionListener(new LoginListener(this));
		registerButton.addActionListener(new LoginListener(this));
	}
	public static void main(String[] args) 
	{
		LoginUI ui=new LoginUI();
		ui.setVisible(true);
	}

}
