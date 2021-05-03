package com.mvc.util;
 
import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.OracleConnection;


import java.sql.*;
import java.util.Properties;

public class DBConnection  {
 public static Connection createConnection() throws ClassNotFoundException
 {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection conn = null;
     Properties properties = new Properties();
     properties.setProperty("user", "system");
     properties.setProperty("password", "system");
     properties.setProperty(OracleConnection.CONNECTION_PROPERTY_THIN_NET_CONNECT_TIMEOUT, "10000");
     try 
     {
    	 	System.out.println("****** Starting JDBC Connection test *******");
          String sqlQuery = "select sysdate from dual";

          conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", properties);
          conn.setAutoCommit(false);
          Statement statement = conn.createStatement();
          System.out.println("Running SQL query: [{}]"+ sqlQuery);
          ResultSet resultSet = statement.executeQuery(sqlQuery);

          while (resultSet.next()) {
          	System.out.println("Result of SQL query: [{}]"+ resultSet.getString(1));
          }

         // statement.close();
         // conn.close();

          System.out.println("JDBC connection test successful!");
     } 
     catch (Exception e) 
     {
        e.printStackTrace();
     }

	return conn; 
 }
}