package com.followher.launch;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.hibernate.Session;


import com.followher.dao.PostDao;
import com.followher.hibernateTest.InsertData;
import com.followher.hibernateTest.Test;
import com.followher.pojo.Avatar;
import com.followher.pojo.Profile;
import com.followher.pojo.User;
import com.followher.service.CommentService;
import com.followher.service.ItemService;
import com.followher.service.MyMarshaller;
import com.followher.service.PostService;
import com.followher.service.UserService;

public class Server {

	public static void main(String[] args){
		
		 
//		Test.test();
		   startServer();
        //InsertData.insertItems();
//		InsertData.insertUsers();
//		InsertData.insertPosts();
//		InsertData.insertImgs();
//		InsertData.insertComments();
//		PostDao.getPostsByUserId(new Long(1));
	}
	
	public static void startServer(){
		  UserService userService =new UserService();
		  ItemService itemService=new ItemService();
		  PostService postService=new PostService();
		  CommentService commentService =new CommentService();
		 // MyMarshaller marshaller=new MyMarshaller();
		  
		  JAXRSServerFactoryBean restServer =new JAXRSServerFactoryBean();
		  restServer.setResourceClasses(User.class, Avatar.class,Profile.class );
		  restServer.setServiceBeanObjects(userService,itemService,postService,commentService);
		 // restServer.setProvider(marshaller);
		  restServer.setAddress("http://127.0.0.1:9999/");
		  restServer.create();
		  Session session=HibernateUtil.getSession();
		  session.close();
		  
		  
		   
	} 
	
}
