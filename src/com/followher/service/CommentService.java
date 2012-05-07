package com.followher.service;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.followher.dao.CommentDao;
import com.followher.pojo.Comment;
import com.followher.pojo.User;

@Path("/comments")
public class CommentService {

	@GET
	@Path("/id")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommentsByPostId(@PathParam("id")long id){
		System.out.println("Get comment by post id:"+id);
		List<Comment> comments=CommentDao.getCommentByPostId(id);
		for(Comment comm : comments){
           comm.setUser(new User(comm.getUser().getName(),comm.getUser().getSex(),comm.getUser().getAvatar(),null));
		}
		final GenericEntity<List<Comment>> entity=new GenericEntity<List<Comment>>(comments){};
		return Response.ok().entity(entity).header("Access-Control-Allow-Origin","*").header("Access-Control-Allow-Methods", "POST, GET").build();
	}
}
