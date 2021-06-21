package com.wipro.carrental.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil 
{ public static Connection getDBConnection() throws ClassNotFoundException, SQLException
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","B44766766543","B44766766543");
	return con;
}

}
