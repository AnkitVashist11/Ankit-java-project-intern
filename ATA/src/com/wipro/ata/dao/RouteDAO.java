package com.wipro.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.ata.bean.RouteBean;
import com.wipro.ata.util.DBUtil;

public class RouteDAO 
{
	public ArrayList<RouteBean> viewRouteBySAndD(String source,String dest) throws ClassNotFoundException, SQLException
	{
		ArrayList<RouteBean> al=new ArrayList<RouteBean>();
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pst=connection.prepareStatement("select * from ATA_TBL_Route where source=? and destination=?");
		pst.setString(1,source);
		pst.setString(2,dest);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			RouteBean rb=new RouteBean();
			rb.setRouteID(rs.getString(1));
			rb.setSource(rs.getString(2));
			rb.setDestination(rs.getString(3));
			rb.setDistance(rs.getInt(4));
			rb.setTravelDuration(rs.getDouble(5));
			al.add(rb);
		}
		return al;
	}
	 
	 //************ankit
	 
	 public String addRoute(RouteBean routeBean) throws ClassNotFoundException, SQLException
		{
			String result="FAIL";
			int rows=0;
			routeBean.setRouteID(generateRouteID(routeBean));
			Connection connection=DBUtil.getDBConnection();
			PreparedStatement pt=connection.prepareStatement("insert into ATA_TBL_Route values(?,?,?,?,?)");
			pt.setString(1, routeBean.getRouteID());
			pt.setString(2,routeBean.getSource());
			pt.setString(3, routeBean.getDestination());
			pt.setInt(4, routeBean.getDistance());
			pt.setDouble(5, routeBean.getTravelDuration());
			rows=pt.executeUpdate();
			 if(rows>0)
			 {
				 result="A New Route is Added Successfully";
			 }
			return result;
			
		}
	    public String generateRouteID(RouteBean routeBean) throws ClassNotFoundException, SQLException
	    {   
	    	String routeID;
	        int id=0;
	    	Connection connection=DBUtil.getDBConnection();
	    	PreparedStatement pt=connection.prepareStatement("select ata_seq_routeId.nextval from dual");
	    	ResultSet rs=pt.executeQuery();
	    	 while(rs.next())
	    	 {
	    		  id=rs.getInt(1);
	    	 }
		    String Id1=String.valueOf(id);
		    Id1=Id1.substring(0,4);
		    String Fsource=routeBean.getSource().substring(0,2).toUpperCase();
		    String Fdestination=routeBean.getDestination().substring(0,2).toUpperCase();
		    routeID=Fsource+Fdestination+Id1;
		    return routeID;
	    	
	    }
	    public int deleteRoute(String routeID) throws SQLException, ClassNotFoundException
	    {   
	    	Connection connection=DBUtil.getDBConnection();
	    	int count=0;
	    	int rows=0;
	        PreparedStatement pt=connection.prepareStatement("delete from ATA_TBL_Route where routeId=?" );
	    	pt.setString(1,routeID);
	    	rows=pt.executeUpdate();
	    	  if(rows>0)
	    		{
	    			count++;
	    		}
	        	 
	    	
	    	return count;
	    }
	    public RouteBean viewRoute(String routeID) throws ClassNotFoundException, SQLException
	    {
	    	Connection connection=DBUtil.getDBConnection();
	    	PreparedStatement pt=connection.prepareStatement("select * from ATA_TBL_Route where routeId=?");
	    	pt.setString(1, routeID);
	    	ResultSet rs=pt.executeQuery();
	    	 if(rs.next())
	    	 {
	    		 RouteBean routeBean =new RouteBean();
	    		 routeBean.setRouteID(rs.getString(1));
	    		 routeBean.setSource(rs.getString(2));
	    		 routeBean.setDestination(rs.getString(3));
	    		 routeBean.setDistance(rs.getInt(4));
	    		 routeBean.setTravelDuration(rs.getDouble(5));
	    		 return routeBean;
	    	 }
	    	 else
	    	 { 
	    		 return null;
	    	 }
	    }
	    public ArrayList<RouteBean> viewAllRoutes() throws ClassNotFoundException, SQLException
	    {
	    	ArrayList<RouteBean> list=new ArrayList<RouteBean>();
	    	Connection connection=DBUtil.getDBConnection();
	    	PreparedStatement pt=connection.prepareStatement("select * from ATA_TBL_Route ");
	    	ResultSet rs=pt.executeQuery();
	    	 while(rs.next())
	    	 {
	    		 RouteBean routeBean=new RouteBean();
	    		 routeBean.setRouteID(rs.getString(1));
	    		 routeBean.setSource(rs.getString(2));
	    		 routeBean.setDestination(rs.getString(3));
	    		 routeBean.setDistance(rs.getInt(4));
	    		 routeBean.setTravelDuration(rs.getDouble(5));
	    		 list.add(routeBean);
	    	 }
	    	 return list;
	    }
	    
	    public boolean modifyRoute(RouteBean routeBean) throws SQLException, ClassNotFoundException
	    {   
	    	int rows=0;
	    	Connection connection=DBUtil.getDBConnection();
	        PreparedStatement pt=connection.prepareStatement("update ATA_TBL_Route set Source=?,Destination=?, Distance=?, TravelDuration=? where routeId=?");
		   pt.setString(1, routeBean.getSource());
		   pt.setString(2, routeBean.getDestination());
		   pt.setInt(3, routeBean.getDistance());
		   pt.setDouble(4, routeBean.getTravelDuration());
		   pt.setString(5, routeBean.getRouteID());
		   rows=pt.executeUpdate();
		    if(rows>0)
		    {
		    	return true;
		    }
		    else
		    {
		    	return false;
		    }
		  	
	    }
	    
	   
	    
	    public ArrayList<RouteBean> viewRoutesBySourceAndByDestination(String source,String destination) throws ClassNotFoundException, SQLException
	    {
	    	
	    	ArrayList<RouteBean> list=new ArrayList<RouteBean>();
	    	Connection connection=DBUtil.getDBConnection();
	    	PreparedStatement pt=connection.prepareStatement("Select * from ATA_TBL_Route where Source=? and Destination=?");
	    	pt.setString(1, source.trim());
	    	pt.setString(2, destination.trim());
	    	
	    	ResultSet rs=pt.executeQuery();
	    	
	    	 while(rs.next())
	    	 {
	    		 RouteBean routeBean=new RouteBean();
	    		 routeBean.setRouteID(rs.getString(1));
	    		 routeBean.setSource(rs.getString(2));
	    		 routeBean.setDestination(rs.getString(3));
	    		 routeBean.setDistance(rs.getInt(4));
	    		 routeBean.setTravelDuration(rs.getDouble(5));
	    		 list.add(routeBean);
	    		 
	    	 }
	    	 return list;
	    }
}
