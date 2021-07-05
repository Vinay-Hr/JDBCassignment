package com.te.CRUD_asgmnt;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Static_Create {
	
	public static void insertStatic() {
		Connection connection=null;
		Statement statement=null;
		try {
			FileInputStream file= new FileInputStream("crudinfo.properties");
			Properties properties= new Properties();
			properties.load(file);
			String driver=properties.getProperty("driver");
			String dburl=properties.getProperty("dburl");
			String user=properties.getProperty("user");
			String password=properties.getProperty("password");
			String query=properties.getProperty("queryInsert");
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			statement=connection.createStatement();
			
			int result=statement.executeUpdate(query);
			
			if (result!=0) {
				System.out.println("Data inserted successfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				
				if (statement!=null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}