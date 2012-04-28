package com.followher.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.followher.dao.UserDAO;
import com.followher.pojo.User;

@Path("/user")

public class UserService {
    
	@GET
	@Path("/{id}")
	//@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id")String id){
		System.out.println("get user by id= "+ id);
		User user=UserDAO.getUser(id);
		return Response.ok(user).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods", "POST, GET").build();
		
	}
	
}
