package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.exception.AppException;
import com.example.pojo.ReservationEntity;
import com.example.pojo.RestaurantEntity;
import com.example.pojo.UserEntity;
import com.example.rest.services.ReservationService;
import com.example.utils.DBConnector;

public class ReservationDAO {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
	
	public ReservationEntity getStatus(String confirmationNumb) throws AppException{
		ReservationEntity reservationEntity = new ReservationEntity();
		
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("Select * from reservations where CONFIRM_NUMB=?");
			ps.setString(1, confirmationNumb);
			rs = ps.executeQuery();
			
			if(rs.next()){
				reservationEntity.setId(rs.getInt("ID"));
				reservationEntity.setConfirmationNum(rs.getString("CONFIRM_NUMB"));
				reservationEntity.setName(rs.getString("NAME"));
				reservationEntity.setPhone(rs.getString("PHONE"));
				reservationEntity.setEmail(rs.getString("EMAIL"));
				reservationEntity.setGender(rs.getString("GENDER"));
				reservationEntity.setAddress(rs.getString("ADDRESS"));
				reservationEntity.setPartySize(rs.getInt("PARTY_SIZE"));
				
				Timestamp timestamp = rs.getTimestamp("RESERV_TIME");
				java.util.Date reservationDate = timestamp; // You can just upcast.
				
				reservationEntity.setReservationTime(reservationDate);
				reservationEntity.setReservationTable(rs.getInt("RESERV_TABLE"));
				reservationEntity.setReservationStatus(rs.getString("RESERV_STATUS"));
				System.out.println("Reservation retrieved : " + reservationEntity);
			}
			else{
				throw new AppException("Error: Confirmation #" + confirmationNumb +" not available in the system");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		
		return reservationEntity;
	}
	
	
	public ReservationEntity addReservation(ReservationEntity reservation) throws AppException{
		
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("INSERT INTO reservations (CONFIRM_NUMB, NAME,"
					+ " PHONE, EMAIL, ADDRESS, PARTY_SIZE, RESERV_TIME) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, reservation.getConfirmationNum());
			ps.setString(2, reservation.getName());
			ps.setString(3, reservation.getPhone());
			ps.setString(4, reservation.getEmail());
			ps.setString(5, reservation.getAddress());
			ps.setInt(6, reservation.getPartySize());
			
//			java.util.Date date = reservation.getReservationTime();
//			Timestamp timestamp = new Timestamp(date.getTime());
			
			java.util.Date utilDate = reservation.getReservationTime();
			Calendar cal = Calendar.getInstance();
			cal.setTime(utilDate);
			cal.set(Calendar.HOUR, 5);
			System.out.println(new java.sql.Timestamp(utilDate.getTime()));
			System.out.println(new java.sql.Timestamp(cal.getTimeInMillis()));
		    
//			java.sql.Timestamp reserveTime = new java.sql.Timestamp(utilDate.getTime());
//			java.sql.Timestamp reserveTime = new java.sql.Timestamp(cal.getTimeInMillis());
			ps.setTimestamp(7, new java.sql.Timestamp(cal.getTimeInMillis()));
			
			
			
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				reservation.setId(rs.getInt(1));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		System.out.println("RESERVATION created: " + reservation.toString());
		return reservation;
	}
	
	public RestaurantEntity updateRestaurant(RestaurantEntity restaurant) throws AppException{

		RestaurantEntity updatedRestaurant = new RestaurantEntity();
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("UPDATE restaurant SET REST_NAME = ?, REST_PHONE = ?, "
					+ "REST_EMAIL = ?, REST_ADDRESS = ?, REST_TIMINGS = ?, "
					+ "AUTO_ASSIGN = ? WHERE REST_ID = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, restaurant.getRestName());
			ps.setString(2, restaurant.getRestPhone());
			ps.setString(3, restaurant.getRestEmail());
			ps.setString(4, restaurant.getRestAddress());
			ps.setString(5, restaurant.getRestTimings());
			ps.setInt(6, restaurant.getAutoAssign());
			ps.setInt(7, restaurant.getRestID());
			
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		System.out.println("Restaurant updated: " + restaurant.toString());
		return restaurant;
	}
	

	
	public List<ReservationEntity> getAllReservations() throws AppException{
		List<ReservationEntity> reservationsList = new ArrayList<ReservationEntity>();
		
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("Select * from reservations");
			rs = ps.executeQuery();
			
			while(rs.next()){
				ReservationEntity reservation = new ReservationEntity();
				reservation.setId(rs.getInt("ID"));
				reservation.setConfirmationNum(rs.getString("CONFIRM_NUMB"));
				reservation.setName(rs.getString("NAME"));
				reservation.setPhone(rs.getString("PHONE"));
				reservation.setEmail(rs.getString("EMAIL"));
				reservation.setGender(rs.getString("GENDER"));
				reservation.setAddress(rs.getString("ADDRESS"));
				reservation.setPartySize(rs.getInt("PARTY_SIZE"));
				Timestamp timestamp = rs.getTimestamp("RESERV_TIME");
				java.util.Date reservationDate = timestamp; // You can just upcast.
				
				reservation.setReservationTime(reservationDate);
				reservation.setReservationTable(rs.getInt("RESERV_TABLE"));
				reservation.setReservationStatus(rs.getString("RESERV_STATUS"));
				
				reservationsList.add(reservation);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		
		return reservationsList;
	}


	public ReservationEntity deleteReservation(String confirmationNumb) throws AppException{
    ReservationEntity reservationEntity = new ReservationEntity();

    Connection connection = DBConnector.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
    ps = connection.prepareStatement("DELETE FROM reservations WHERE CONFIRM_NUMB= ?");
    ps.setString(1, confirmationNumb);
    ps.executeUpdate();
    System.out.println("Successfully deleted reservation");
    } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    throw new AppException(e.getMessage(), e.getCause());
    }
    finally{
    DBConnector.closeResources(ps, rs, connection);

    }

    return reservationEntity;
    }

	public ReservationEntity updateReservation(ReservationEntity reservation) throws AppException{

		ReservationEntity updatedReservation = new ReservationEntity();
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("UPDATE reservations SET RESERV_TABLE = ?,"
					+ " RESERV_STATUS = ? WHERE CONFIRM_NUMB = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, reservation.getReservationTable());
			ps.setString(2, reservation.getReservationStatus());
			ps.setString(3, reservation.getConfirmationNum());
			
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if(rs.next()){
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		System.out.println("RESERVATION updated: " + updatedReservation.toString());
		return reservation;
	}
	
	public RestaurantEntity getRestaurantDetails(int restID) throws AppException{
		RestaurantEntity restaurantEntity = new RestaurantEntity();
		
		Connection connection = DBConnector.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("Select * from restaurant where REST_ID=?");
			ps.setInt(1, restID);
			rs = ps.executeQuery();
			
			if(rs.next()){
				restaurantEntity.setRestID(rs.getInt("REST_ID"));
				restaurantEntity.setRestName(rs.getString("REST_NAME"));
				restaurantEntity.setRestPhone(rs.getString("REST_PHONE"));
				restaurantEntity.setRestEmail(rs.getString("REST_EMAIL"));
				restaurantEntity.setRestAddress(rs.getString("REST_ADDRESS"));
				restaurantEntity.setRestTimings(rs.getString("REST_TIMINGS"));
				restaurantEntity.setAutoAssign(rs.getInt("AUTO_ASSIGN"));
				
				System.out.println("Reservation retrieved : " + restaurantEntity.toString());
			}
			else{
				throw new AppException("Error: Confirmation #" + restID +" not available in the system");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage(), e.getCause());
		}
		finally{
			DBConnector.closeResources(ps, rs, connection);
			
		}
		
		return restaurantEntity;
	}
	
/**
	public static void main(String args[]) throws ParseException{
		
		ReservationEntity reservation = new ReservationEntity();
		reservation.setConfirmationNum("ATCT12345678");
		reservation.setName("GAUSTTA");
		reservation.setEmail("gautmc@gmail.com");
		reservation.setPhone("1231121231");
		reservation.setAddress("Chicago, IL");
		reservation.setPartySize(9);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    Date parsedDate = dateFormat.parse("2015-12-31 14:45:39");
	    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
	    
	    System.out.println("Parsed date: " + parsedDate); //Thu Dec 31 14:45:39 CST 2015
	    System.out.println("Time stamp set in DB: " + timestamp); //2015-12-31 14:45:39.0

		reservation.setReservationTime(timestamp);
		
		
		try {
			
			ReservationDAO.addReservation(reservation);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
**/

}