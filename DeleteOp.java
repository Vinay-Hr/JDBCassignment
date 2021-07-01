package com.te.jdbcfirst;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DeleteOp {

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
			String query =  properties.getProperty("delquery");
			
			Class.forName(driver); //Step1
			
			//Step2 get the connection via Driver <DriverManager>
			connection = DriverManager.getConnection(dbUrl); //Step2
			
			//Step3 create a statement obj and pass the query via connection
			statement = connection.createStatement(); //Step3
			
			//Step4 Process the result returned by db
			int result = statement.executeUpdate(query); //Step4
			
			if (result !=0) {
				System.out.println(result + " no. of rows affected");
				System.out.println("Data inserted succesfully");
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
