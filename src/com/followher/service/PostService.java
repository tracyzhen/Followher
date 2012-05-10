package com.followher.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.followher.dao.PostDao;
import com.followher.pojo.Img;
import com.followher.pojo.Post;

@Path("/posts")
public class PostService {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPosts() {
		System.out.println("Get all posts");
		List<Post> posts = PostDao.getPosts();
		for (Post p : posts) {
			p.setComments(null);
		}
		final GenericEntity<List<Post>> entity = new GenericEntity<List<Post>>(
				posts) {
		};
		return Response.ok().entity(entity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET").build();
	}

	@GET
	@Path("/id")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostsByUserId(@PathParam("id") long id) {
		System.out.println("Get posts by userid:" + id);
		List<Post> posts = PostDao.getPostsByUserId(id);
		for (Post p : posts) {
			p.setComments(null);
		}
		final GenericEntity<List<Post>> entity = new GenericEntity<List<Post>>(
				posts) {
		};
		return Response.ok().entity(entity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET").build();
	}

	@POST
	@Path("new/{userid}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response addPost(@PathParam("userid") long userid, InputStream is) {
		// userid 发post的user
		Post post = readPost(is);
		boolean result=PostDao.NewPost(userid,post);
		if(result)
		  return Response.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET").build();
		else
		  return Response.serverError().header("Access-Control-Allow-Origin", "*")
			.header("Access-Control-Allow-Methods", "POST, GET").build();

	}

	/* Post XML formate
	 * <post>
	 *    <content>
	 *    </content>
	 *    <createtime>
	 *    </createtime>
	 *    <imgs>
	 *       <img>
	 *          <url>
	 *          </url>
	 *          <ebaylink>
	 *          </ebaylink>
	 *          <css>
	 *          </css>
	 *       </img>
	 *       <img>
	 *          <url>
	 *          </url>
	 *          <ebaylink>
	 *          </ebaylink>
	 *          <css>
	 *          </css>
	 *        </img>
	 *        ...
	 *     </imgs>
	 * </post>
	 * 
	 * */
	private Post readPost(InputStream is) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.parse(is);
			Element root = doc.getDocumentElement();
			Post post = new Post();
			post.setImgs(new ArrayList<Img>());
			
			
			NodeList nodes = root.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node item = nodes.item(i);
				if (item instanceof Element) {
					Element element = (Element) nodes.item(i);
					if (element.getTagName().equals("content")) {
						post.setContent(element.getTextContent());
					}else if(element.getTagName().equals("createtime")){
						post.setCreateTime(new Date(element.getTextContent()));
						
					}else if(element.getTagName().equals("imgs")){
						NodeList imgs=element.getChildNodes();
						for(int j=0;j<imgs.getLength();j++){
							Node img= imgs.item(j);
							if(img instanceof Element){
								if(((Element) img).getTagName().equals("img")){
									NodeList l=img.getChildNodes();
									post.addImg(new Img(
											l.item(0).getTextContent(),l.item(1).getTextContent(),l.item(2).getTextContent()));
								}
							}
						}
					}
				}else{
					continue;
				}
			}
			return post;
		} catch (Exception e) {
			throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
		}
	}

}
