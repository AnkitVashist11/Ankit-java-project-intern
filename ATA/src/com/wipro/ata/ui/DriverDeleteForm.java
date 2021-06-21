package com.wipro.ata.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.ata.listener.DriverDeleteListener;

public class DriverDeleteForm extends JFrame
{
	public JFrame frame;
	public JPanel panel;
	public JLabel lblName,lblId;
	public JTextField txtId;
	public JButton btnDelete,btnBack,btnCancel;
	
	public DriverDeleteForm()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		
		//panel=new JPanel();
		setTitle("Delete Driver Details");
		setSize(1020,750);
		//panel.
		setLayout(null);
		setLocation(20, 20);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		lblName=new JLabel("Delete Driver");
		 //lblName.setBounds(410,120, 300, 25);
		lblName.setBounds(340,60,300,25);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Papyrus",Font.BOLD,20));
		//panel.
		add(lblName);
		
		
		lblId=new JLabel("Enter Driver Id");
		lblId.setBounds(300,120,150,25);
		lblId.setForeground(Color.BLACK);
		//lblId.setFont(new Font("Serif",Font.BOLD,18));
		//panel.
		add(lblId);
		
		/*list=new Choice();
		list.setBounds(400,120,130,25);
		panel.add(list);*/
		
		txtId=new JTextField(10);
		txtId.setToolTipText("Enter valid value for DriverId");
		txtId.setBounds(430,120,120,25);
		//panel.
		add(txtId);
		
		btnDelete=new JButton("Delete");
		btnDelete.setToolTipText("Press to Delete Driver Details");
		btnDelete.setBounds(300,170,100,25);
		btnDelete.setForeground(Color.BLACK);
		//btnDelete.setFont(new Font("Serif",Font.BOLD,18));
		//panel.
		add(btnDelete);
		btnDelete.addActionListener(new DriverDeleteListener(this));
		
		btnBack=new JButton("Back");
		btnBack.setToolTipText("Back to Login Screen");
		btnBack.setBounds(10,10,100,25);
		btnBack.setForeground(Color.BLACK);
		//btnBack.setFont(new Font("Serif",Font.BOLD,18));
		//panel.
		add(btnBack);
		btnBack.addActionListener(new DriverDeleteListener(this));
		
		btnCancel=new JButton("Cancel");
		btnCancel.setToolTipText("you changed your mind");
		//panel.
		add(btnCancel);
		btnCancel.setBounds(420,170,100,25);
		btnCancel.setForeground(Color.BLACK);
		//btnCancel.setFont(new Font("Serif",Font.BOLD,18));
		btnCancel.addActionListener(new DriverDeleteListener(this));
		
		//add(panel);
		
	}

	public static void main(String[] args)
	{
		new DriverDeleteForm();
	}

}
