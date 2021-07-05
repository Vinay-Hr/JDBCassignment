package com.te.CRUD_asgmnt;

import java.util.Properties;
import java.util.Scanner;
import java.io.FileInputStream;
import java.sql.*;

public class Dynamic_Read {

	public static void selectDynamicQuery() {
		Connection connection=null;
		PreparedStatement prepare=null;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the ID of the Student whose details you want to view: ");
		int id=sc.nextInt();
		try {
			FileInputStream file= new FileInputStream("directory.properties");
			Properties properties= new Properties();
			properties.load(file);
			String driver=properties.getProperty("driver");
			String dburl=properties.getProperty("dburl");
			String user=properties.getProperty("user");
			String password=properties.getProperty("password");
			String query=properties.getProperty("DYquerySelect");
			Class.forName(driver); 
			
			connection = DriverManager.getConnection(dburl,user,password);
			
			prepare=connection.prepareStatement(query);
			prepare.setInt(1, id);
			
			ResultSet resultSet=prepare.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt(1));
				System.out.println("Name: " + resultSet.getString(2));
				System.out.println("Standard: " + resultSet.getInt(3));
				System.out.println("Marks: " + resultSet.getDouble(4));
				System.out.println("Date of Birth: " + resultSet.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				
				if (prepare!=null)
					prepare.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}