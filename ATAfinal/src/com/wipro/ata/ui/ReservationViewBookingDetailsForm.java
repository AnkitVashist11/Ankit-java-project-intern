package com.wipro.ata.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.ata.listener.ReservationViewBookingDetailsListener;

public class ReservationViewBookingDetailsForm extends JFrame
{
	public JFrame frame;
	public JPanel panel;
	public JLabel lblId;
	public JLabel lblIdd,lblName,lblJourneyDate,lblFare,lblBoardingPoint,lblDropPoint,lblMsg;
	public JLabel lblstatus,lblTitle,lblType,lblTypes,lblIddd,lblNames,lblJourneyDates,lblFares,lblBoardingPoints,lblDropPoints;
	public JTextField txtId;
	public JComboBox cmbId;
	public JButton btnView,btnPrint,btnBack;
	public JTable table;
	public DefaultTableModel dfTableModel;
	public JOptionPane pane;
	public JScrollPane scrollpane;
	public Object col[]=new Object[11];
	public ReservationViewBookingDetailsForm()
	{
		setContentPane(new JLabel(new ImageIcon("src\\caaaar.jpeg")));
		setVisible(true);
		//frame=new JFrame();
		//panel=new JPanel();
		setSize(1000,750);
		//panel.setLayout(new FlowLayout());
		//panel.
		setLayout(null);
		//setLocation(400, 100);
		setTitle("View Booking Details");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnBack=new JButton("Back");
		btnBack.setBounds(10,10,100,25);
		
		
		lblstatus=new JLabel("View Booking Status");
		lblstatus.setFont(new Font("papyrus",Font.BOLD,20));
		lblstatus.setBounds(400,20,240,30);
		//panel.
		add(lblstatus);
		
		lblId=new JLabel("Enter Reservation Id");
		lblId.setBounds(300,70,200,30);
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Times New Roman",Font.BOLD,18));
		//panel.
		add(lblId);
		
		cmbId=new JComboBox();
		
		
		
		txtId=new JTextField(10);
		txtId.setToolTipText("Fill id which was allotted to you");
		txtId.setBounds(550,70,100,30);
		//panel.
		add(txtId);
		
		btnView=new JButton("View Details");
		btnView.setToolTipText("Press to view Booking Details");
		btnView.setBounds(400,120,180,30);
		//btnView.setForeground(Color.BLACK);
		//btnView.setFont(new Font("papyrus",Font.BOLD,18));
		//panel.
		add(btnView);
		btnView.addActionListener(new ReservationViewBookingDetailsListener(this));
		
		dfTableModel=new DefaultTableModel();
		dfTableModel.addColumn("Reservation ID");
		dfTableModel.addColumn("User ID");
		dfTableModel.addColumn("Vehicle ID");
		dfTableModel.addColumn("Route ID");
		dfTableModel.addColumn("Booking Date");
		dfTableModel.addColumn("Journey Date");
		dfTableModel.addColumn("Driver ID");
		dfTableModel.addColumn("Booking Status");
		dfTableModel.addColumn("Total Fare");
		dfTableModel.addColumn("Boarding Point");
		dfTableModel.addColumn("Drop Point");
		
		table=new JTable(dfTableModel);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.getColumnModel().getColumn(10).setPreferredWidth(100);
		table.setSize(700,500);
		
		scrollpane=new JScrollPane(table);
		scrollpane.setSize(700,500);
		scrollpane.setBounds(180,170,700,300);
		
		//panel.
		add(scrollpane);
		btnPrint=new JButton("Print");
		btnPrint.setBounds(470,500,80,30);
		//btnPrint.setForeground(Color.BLACK);
		//btnPrint.setFont(new Font("papyrus",Font.BOLD,18));
		btnPrint.setToolTipText("Click here to print");
		//panel.
		add(btnPrint);
		btnPrint.addActionListener(new ReservationViewBookingDetailsListener(this));
		btnBack.addActionListener(new ReservationViewBookingDetailsListener(this));
		
		
		
		lblTitle=new JLabel("VAIN TRAVELS");
		lblTitle.setVisible(false);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Papyrus",Font.ITALIC,26));
		lblTitle.setBounds(450,30,250,40);
		//panel.
		add(lblTitle);
		
		
		lblIdd=new JLabel("Reservation Id");
		lblIdd.setVisible(false);
		lblIdd.setBounds(380,100,300,30);
		lblIdd.setFont(new Font("Times New Roman",Font.ITALIC,20));
		
		
		lblIddd=new JLabel();
		lblIddd.setBounds(600,100,200,30);
		lblIddd.setFont(new Font("Times New Roman",Font.ITALIC,22));
		lblIddd.setVisible(false);
		
		lblName=new JLabel("Name");
		lblName.setBounds(380,140,150,30);
		lblName.setFont(new Font("Times New Roman",Font.ITALIC,20));
		lblName.setVisible(false);
		
		lblNames=new JLabel();
		lblNames.setBounds(600,140,200,30);
		lblNames.setFont(new Font("Times New Roman",Font.ITALIC,22));
		lblNames.setVisible(false);
		
		lblJourneyDate=new JLabel("Journey Date");
		lblJourneyDate.setBounds(380,180,200, 30);
		lblJourneyDate.setFont(new Font("Times New Roman",Font.ITALIC,20));
		lblJourneyDate.setVisible(false);
		
		lblJourneyDates=new JLabel();
		lblJourneyDates.setBounds(600,180,200,30);
		lblJourneyDates.setFont(new Font("Times New Roman",Font.ITALIC,22));
		lblJourneyDates.setVisible(false);
		
		lblFare=new JLabel("Total Fare");
		lblFare.setBounds(380,220,200,30);
		lblFare.setFont(new Font("Times New Roman",Font.ITALIC,20));
		lblFare.setVisible(false);
		
		lblFares=new JLabel();
		lblFares.setBounds(600,220,200,30);
		lblFares.setFont(new Font("Times New Roman",Font.ITALIC,22));
		lblFares.setVisible(false);
		
		
		lblBoardingPoint=new JLabel("Boarding Point");
		lblBoardingPoint.setBounds(380,260,200,30);
		lblBoardingPoint.setFont(new Font("Times New Roman",Font.ITALIC,20));
		lblBoardingPoint.setVisible(false);
		
		lblBoardingPoints=new JLabel();
		lblBoardingPoints.setBounds(600,260,200, 30);
		lblBoardingPoints.setFont(new Font("Times New Roman",Font.ITALIC,22));
		lblBoardingPoints.setVisible(false);
		
		lblDropPoint=new JLabel("Drop Point");
		lblDropPoint.setBounds(380,300,200,30);
		lblDropPoint.setFont(new Font("Times New Roman",Font.ITALIC,20));
		lblDropPoint.setVisible(false);
		
		
		lblDropPoints=new JLabel();
		lblDropPoints.setBounds(600,300,200,30);
		lblDropPoints.setFont(new Font("Times New Roman",Font.ITALIC,22));
		lblDropPoints.setVisible(false);
		
		lblType=new JLabel("Ticket Type");
		lblType.setFont(new Font("Times New Roman",Font.ITALIC,20));
		lblType.setBounds(380,340,170,30);
		lblType.setVisible(false);
		
		lblTypes=new JLabel("e-Ticket");
		lblTypes.setFont(new Font("Times New Roman",Font.ITALIC,22));
		lblTypes.setBounds(600,340,200,30);
		
		lblMsg=new JLabel("Happy Travelling");
		lblMsg.setFont(new Font("Times New Roman",Font.BOLD,20));
		lblMsg.setBounds(450,400,200,30);
		lblMsg.setForeground(Color.BLACK);
		
		lblMsg.setVisible(false);
		//panel.
		add(btnBack);
		//panel.
		add(lblIdd);
		//panel.
		add(lblIddd);
		//panel.
		add(lblName);
		//panel.
		add(lblNames);
		//panel.
		add(lblJourneyDate);
		//panel.
		add(lblJourneyDates);
		//panel.
		add(lblFare);
		//panel.
		add(lblFares);
		//panel.
		add(lblBoardingPoint);
		//panel.
		add(lblBoardingPoints);
		//panel.
		add(lblDropPoint);
		//panel.
		add(lblDropPoints);
		//panel.
		add(lblType);
		//panel.
		add(lblTypes);
		//panel.
		add(lblMsg);
		
		//add(panel);
	}
		
	public static void main(String args[])
	{
		new ReservationViewBookingDetailsForm();
	}
	
}

