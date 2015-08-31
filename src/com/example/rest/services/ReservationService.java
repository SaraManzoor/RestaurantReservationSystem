package com.example.rest.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.dao.ReservationDAO;
import com.example.dao.UserDAO;
import com.example.exception.AppException;
import com.example.pojo.ReservationEntity;
import com.example.pojo.RestaurantEntity;
import com.example.pojo.UserEntity;

@Path("/reservation")
public class ReservationService {

	@GET
	@Path("/get/{confirmNumb}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getStatus(
			@PathParam("confirmNumb") String confirmationNumb) {

		AppResponse resp = new AppResponse();
		ReservationDAO reservationDAO = new ReservationDAO();
		ReservationEntity reservationEntity = null;
		try {
			reservationEntity = reservationDAO.getStatus(confirmationNumb);
			resp.setStatus("success");
			resp.setPayload(reservationEntity);

		} catch (AppException e) {
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());

		}

		return resp;
	}
	
	@GET
	@Path("/getRestaurant/{restID}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getRestaurant(@PathParam("restID") int restID){
		
		AppResponse resp = new AppResponse();
		ReservationDAO reservationDAO = new ReservationDAO();
		RestaurantEntity restaurantEntity = null;
		try{
			restaurantEntity = reservationDAO.getRestaurantDetails(restID);
			resp.setStatus("success");
			resp.setPayload(restaurantEntity);
			
		}
		catch(AppException e){
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());
			 
		}
		
		return resp;
	}
	
	
	@POST
	@Path("/owner/updateRestaurant")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse updateRestaurant(RestaurantEntity restaurantEntity){
		AppResponse resp = new AppResponse();
		System.out.println("POST data received at server: " + restaurantEntity.getRestAddress());
		
		try{
			ReservationDAO reservationDAO = new ReservationDAO();
			restaurantEntity = reservationDAO.updateRestaurant(restaurantEntity);
			resp.setStatus("success");
			resp.setPayload(restaurantEntity);
			
		}
		catch(AppException e){
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());
			 
		}
		
		return resp;
	}
	

	@GET
	@Path("/deleteReservation/{confirmNumb}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse deleteReservation(
			@PathParam("confirmNumb") String confirmationNumb) {

		AppResponse resp = new AppResponse();
		ReservationDAO reservationDAO = new ReservationDAO();
		ReservationEntity reservationEntity = null;
		try {
			reservationEntity = reservationDAO
					.deleteReservation(confirmationNumb);
			resp.setStatus("success");
			resp.setPayload(reservationEntity);

		} catch (AppException e) {
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());

		}

		return resp;
	}

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll() {

		AppResponse resp = new AppResponse();
		ReservationDAO reservationDAO = new ReservationDAO();
		List<ReservationEntity> reservationsList = null;
		try {
			reservationsList = reservationDAO.getAllReservations();
			resp.setStatus(AppResponse.SUCCESS);
			resp.setPayload(reservationsList);

		} catch (AppException e) {
			resp.setStatus(AppResponse.ERROR);
			resp.setMsg(e.getMessage());

		}

		return resp;
	}

	@POST
	@Path("/assignTable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse assignTable(ReservationEntity reservationEntity) {
		AppResponse resp = new AppResponse();
		System.out.println("Inside assign table service");
		// // System.out.println("POST data received at server: " +
		// reservationEntity.getReservationTime());
		// // System.out.println("POST data received at server: " +
		// reservationEntity.getReservationTime().getHours());
		//
		// try{
		// ReservationDAO reservationDAO = new ReservationDAO();
		// reservationEntity = reservationDAO.addReservation(reservationEntity);
		// resp.setStatus("success");
		// resp.setPayload(reservationEntity);
		//
		// }
		// catch(AppException e){
		// resp.setStatus("failure");
		// resp.setMsg(e.getMessage());
		//
		// }

		return resp;
	}

	@POST
	@Path("/owner/updateReservation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse updateReservation(ReservationEntity reservationEntity) {
		AppResponse resp = new AppResponse();
		// System.out.println("POST data received at server: " +
		// reservationEntity.getReservationTime());
		// System.out.println("POST data received at server: " +
		// reservationEntity.getReservationTime().getHours());

		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			reservationEntity = reservationDAO
					.updateReservation(reservationEntity);
			resp.setStatus("success");
			resp.setPayload(reservationEntity);

		} catch (AppException e) {
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());

		}

		return resp;
	}

	@POST
	@Path("/addReservation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addReservation(ReservationEntity reservationEntity) {
		AppResponse resp = new AppResponse();
		// System.out.println("POST data received at server: " +
		// reservationEntity.getReservationTime());
		// System.out.println("POST data received at server: " +
		// reservationEntity.getReservationTime().getHours());

		try {
			ReservationDAO reservationDAO = new ReservationDAO();
			reservationEntity = reservationDAO
					.addReservation(reservationEntity);
			resp.setStatus("success");
			resp.setPayload(reservationEntity);

		} catch (AppException e) {
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());

		}

		return resp;
	}

}