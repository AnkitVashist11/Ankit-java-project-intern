package com.wipro.ata.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wipro.ata.listener.RouteDeleteListener;

public class RouteDeleteForm 
{
	public JFrame frame;
    //public JPanel panel=new JPanel();
	public JLabel lblName,lblrouteId;
	public JTextField txtRouteId;
	public JButton btnDelete,btnCancel,btnBack;
	
	
  public RouteDeleteForm()
  {
	 frame=new JFrame();
	 frame.setVisible(true);
	 frame.setTitle("Route Delete Form");
	 frame.setSize(1000, 750);
	 //frame.setLocation(200,200);
	 frame.setResizable(false);
	 frame.setLayout(null);
	 lblName=new JLabel("Delete Route");
	 lblName.setFont(new Font("Papyrus", Font.BOLD, 20));
	 lblName.setForeground(Color.WHITE);
	 lblrouteId=new JLabel("Enter RouteId");
	 lblrouteId.setForeground(Color.WHITE);
	 txtRouteId=new JTextField(10);
	 btnDelete=new JButton("DELETE");
	 btnCancel=new JButton("CANCEL");
	 btnBack=new JButton("BACK");
	 
	 ImageIcon imageIcon = new ImageIcon("src\\car33.jpg");
	 frame.setContentPane(new JLabel(imageIcon));
	 
	 txtRouteId.setToolTipText("Enter Valid RouteID");
	 btnDelete.setToolTipText("Click Here To Perform Delete");
	 btnCancel.setToolTipText("Click Here To Cancel Entered Values");
	 btnBack.setToolTipText("Click Here To Go Back");
	 
	 lblName.setBounds(410,120, 300, 25);
	 lblrouteId.setBounds(320, 180, 100, 25);
	 txtRouteId.setBounds(440,180,150,25);
	 btnDelete.setBounds(380,230,170,25);
	 btnCancel.setBounds(380,270,170,25);
	 btnBack.setBounds(10,10,100,25);
	 frame.add(lblName);
	 frame.add(lblrouteId);
	 frame.add(txtRouteId);
	 frame.add(btnDelete);
	 frame.add(btnCancel);
	 frame.add(btnBack);
	 //frame.add(panel);
	 /*ImageIcon imageIco = new ImageIcon("src\\com\\wipro\\ata\\ui\\car3.jpg");
	   frame.setContentPane(new JLabel(imageIco));*/
	 
	 btnDelete.addActionListener(new RouteDeleteListener(this));
	 btnCancel.addActionListener(new RouteDeleteListener(this));
	 btnBack.addActionListener(new RouteDeleteListener(this));
	 
	 
  }
  public static void main(String args[])
  {
	  new RouteDeleteForm(); 
  }
}
