package com.te.jdbcfirst;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SelectOp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			FileInputStream fileInputStream = new FileInputStream("dbinfo.properties");	
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			//Step1 : Load and register the Driver
			String driver = properties.getProperty("driver");
			String dbUrl = properties.getProperty("dbUrl");
			String query =  properties.getProperty("selquery");
			
			Class.forName(driver); //Step1
			
			//Step2 get the connection via Driver <DriverManager>
			connection = DriverManager.getConnection(dbUrl); //Step2
			
			//Step3 create a statement obj and pass the query via connection
			statement = connection.createStatement(); //Step3
			
			//Step4 Process the result returned by db
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				System.out.println("Id:" +resultSet.getInt(1));
				System.out.println("Name:" +resultSet.getString(2));
				System.out.println("Date:" +resultSet.getString(3));
				System.out.println("Address:" +resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

}
