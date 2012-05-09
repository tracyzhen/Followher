package com.followher.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;


import com.followher.dao.UserDAO;
import com.followher.pojo.User;



public class UserService {
    
	@GET
	@Path("/user/{id}")
	//@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id")long id){
		System.out.println("get user by id= "+ id);
		User user=UserDAO.getUser(id);
		return Response.ok(user).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods", "POST, GET").build();
		
	}
	
	@GET 
	@Path("/postuser/{postid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostUser(@PathParam("postid")long id){
		 System.out.println("get user by postidid= "+ id);
		   User user=UserDAO.getPostUser(id);
		  return Response.ok(user).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods", "POST, GET").build();
		 /*
		  if(user == null){
			  return (StreamingOutput) new WebApplicationException(Response.Status.NOT_FOUND);
		  }
		  return new StreamingOutput() {     
		        public void write(OutputStream outputStream) throws IOException,     
		                WebApplicationException {     
		        	outputentity(outputStream, user);
		        }     
		    }; 
		    */    
	}
	
	private void outputentity(OutputStream os, User entity){
		 PrintWriter pw=new PrintWriter(os);
		 Response.ok(entity).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods", "POST, GET").build();
	}
	
	
}
