package com.te.CRUD_asgmnt;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Dynamic_Delete {

	public static void deleteDynamicQuery() {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the ID of the student: ");
		int id=sc.nextInt();
		
		Connection connection=null;
		PreparedStatement prepare=null;
		
		try {
			FileInputStream file= new FileInputStream("directory.properties");
			Properties properties= new Properties();
			properties.load(file);
			String driver=properties.getProperty("driver");
			String dburl=properties.getProperty("dburl");
			String user=properties.getProperty("user");
			String password=properties.getProperty("password");
			String query=properties.getProperty("DYqueryDelete");
			Class.forName(driver);
			connection = DriverManager.getConnection(dburl, user, password);
			
			
			prepare=connection.prepareStatement(query);
			prepare.setInt(1, id);
			
			int result=prepare.executeUpdate();
			
			if (result!=0) {
				System.out.println("Data Deleted successfully");
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