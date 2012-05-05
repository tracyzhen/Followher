package com.followher.service;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.followher.dao.PostDao;
import com.followher.pojo.Post;

@Path("/posts")
public class PostService {

	  @GET
	  @Path("/")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response getPosts(){
		  System.out.println("Get all posts");
		  List<Post> posts=PostDao.getPosts();
		  for(Post p : posts){
				 p.setComments(null);
	      }
		  final GenericEntity<List<Post>> entity=new GenericEntity<List<Post>>(posts){};
		  return Response.ok().entity(entity).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods", "POST, GET").build();
	  }
}
