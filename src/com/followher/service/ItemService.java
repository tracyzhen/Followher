package com.followher.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.followher.dao.ItemDao;
import com.followher.pojo.Item;


@Path("/items")
public class ItemService {

	@GET
	@Path("/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response getItemsByType(@PathParam("type")String type){
		System.out.println("get item by type = "+ type);
		List<Item> items=ItemDao.getItemsByType(type);
		final GenericEntity<List<Item>> entity = new GenericEntity<List<Item>>(items) { };
		return Response.ok().entity(entity).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods", "POST, GET").build();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItems(){
		System.out.println("get all items ");
		List<Item> items=ItemDao.getItems();
		final GenericEntity<List<Item>> entity = new GenericEntity<List<Item>>(items) { };
		return Response.ok().entity(entity).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods", "POST, GET").build();
	}
}
