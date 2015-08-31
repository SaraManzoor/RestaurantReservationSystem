package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	private final static String USER = "admin";
	private final static String PASSWORD = "admin";
	private final static String DB_URL = "jdbc:mysql://173.194.84.39:3306/user_reg_db";
	
	public static Connection connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Error in loading driver" + e.getLocalizedMessage());
			
		}
		
		Connection conn = null;
		
		try{
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connection established");
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Error in getting connection" + e.getMessage());
		}
		return conn;
	}
	
	public static void closeResources(PreparedStatement ps, ResultSet rs, Connection connection){
		try{
			if(ps!=null){
				ps.close();
			}
			if(rs!=null){
				ps.close();
			}
			if(connection!=null){
				ps.close();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		DBConnector.connect();
	}
}
