package com.example.rest.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.dao.UserDAO;
import com.example.exception.AppException;
import com.example.pojo.UserEntity;

@Path("/user")
public class UserService {

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll(){
		
		AppResponse resp = new AppResponse();
		UserDAO userDAO = new UserDAO();
		List<UserEntity> usersList = null;
		try{
			usersList = userDAO.getAll();
			resp.setStatus(AppResponse.SUCCESS);
			resp.setPayload(usersList);
			
		}
		catch(AppException e){
			resp.setStatus(AppResponse.ERROR);
			resp.setMsg(e.getMessage());
			 
		}
		
		return resp;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getUser(@PathParam("id") int userId){
		
		AppResponse resp = new AppResponse();
		UserDAO userDAO = new UserDAO();
		UserEntity user = null;
		try{
			user = userDAO.getUser(userId);
			resp.setStatus("success");
			resp.setPayload(user);
			
		}
		catch(AppException e){
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());
			 
		}
		
		return resp;
	}

	@GET
	@Path("/get/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getUser(@PathParam("email") String userEmail, @PathParam("password") String userPassword){
		
		AppResponse resp = new AppResponse();
		UserDAO userDAO = new UserDAO();
		UserEntity user = null;
		try{
			user = userDAO.authenticateUser(userEmail, Integer.parseInt(userPassword));
			resp.setStatus("success");
			resp.setPayload(user);
			
		}
		catch(AppException e){
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());
			 
		}
		
		return resp;
	}

	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addUser(UserEntity user){
		AppResponse resp = new AppResponse();
		
		try{
			UserDAO userDAO = new UserDAO();
			user = userDAO.addUser(user);
			resp.setStatus("success");
			resp.setPayload(user);
			
		}
		catch(AppException e){
			resp.setStatus("failure");
			resp.setMsg(e.getMessage());
			 
		}
		
		return resp;
	}

}
