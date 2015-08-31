package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.exception.AppException;
import com.example.pojo.UserEntity;
import com.example.utils.DBConnector;

public class UserDAO {
	
	public List<UserEntity> getAll() throws AppException{
		List<UserEntity> usersList = new ArrayList<UserEntity>();
		
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("Select * from users");
			rs = ps.executeQuery();
			
			while(rs.next()){
				UserEntity user = new UserEntity();
				user.setId(rs.getInt("ID"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPhone(rs.getString("PHONE"));
				user.setCity(rs.getString("CITY"));
				user.setState(rs.getString("STATE"));
				user.setZip(rs.getInt("ZIP"));
				
				usersList.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		
		return usersList;
	}
	
	
	public UserEntity getUser(int userID) throws AppException{
		UserEntity user = new UserEntity();
		
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("Select * from users where ID=?");
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			
			if(rs.next()){
				user.setId(rs.getInt("ID"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setPhone(rs.getString("PHONE"));
				user.setCity(rs.getString("CITY"));
				user.setState(rs.getString("STATE"));
				user.setZip(rs.getInt("ZIP"));
				System.out.println("User inserted:" + user);
			}
			else{
				throw new AppException("Error: ID" + userID +" not available in the system");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		
		return user;
	}

	public UserEntity authenticateUser(String userEmail, int userPassword) throws AppException{
		UserEntity user = new UserEntity();
		
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("Select * from users where EMAIL=? && ID=?");
			ps.setString(1, userEmail);
			ps.setInt(2, userPassword);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				user.setId(rs.getInt("ID"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setPhone(rs.getString("PHONE"));
				user.setCity(rs.getString("CITY"));
				user.setState(rs.getString("STATE"));
				user.setZip(rs.getInt("ZIP"));
				System.out.println("User retrieved:" + user.getFirstName());
			}
			else{
				throw new AppException("Error: ID" + userEmail +" not available in the system");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		
		return user;
	}
	
	public UserEntity addUser(UserEntity user) throws AppException{
		
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("INSERT INTO users (FIRST_NAME, LAST_NAME, EMAIL,"
					+ "ADDRESS, CITY, ZIP, PHONE, STATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getCity());
			ps.setInt(6, user.getZip());
			ps.setString(7, user.getPhone());
			ps.setString(8, user.getState());
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				user.setId(rs.getInt(1));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		
		return user;
	}
	
	public static void main(String args[]){
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.authenticateUser("ED.CHASE@abc.com", 3);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
