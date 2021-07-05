package com.te.CRUD_asgmnt;

import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.sql.*;

public class Static_Read {

	public static void selectStatic() {
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
			String query=properties.getProperty("querySelect");
			Class.forName(driver); 
			
			connection = DriverManager.getConnection(dburl,user,password);
			
			statement=connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery(query);
			
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt(1));
				System.out.println("Name: " + resultSet.getString(2));
				System.out.println("Standard: " + resultSet.getInt(3));
				System.out.println("Marks: " + resultSet.getDouble(4));
				System.out.println("Date of Birth: " + resultSet.getString(5));
				System.out.println("-----------------------------------");
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