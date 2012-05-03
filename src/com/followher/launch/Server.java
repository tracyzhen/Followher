package com.followher.launch;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;


import com.followher.hibernateTest.InsertData;
import com.followher.hibernateTest.Test;
import com.followher.pojo.Avatar;
import com.followher.pojo.Profile;
import com.followher.pojo.User;
import com.followher.service.ItemService;
import com.followher.service.UserService;

public class Server {

	public static void main(String[] args){
		
		 
		//Test.test();
		   startServer();
        //InsertData.insertItems(); 		
	}
	
	public static void startServer(){
		  UserService userService =new UserService();
		  ItemService itemService=new ItemService();
		  
		  JAXRSServerFactoryBean restServer =new JAXRSServerFactoryBean();
		  restServer.setResourceClasses(User.class, Avatar.class,Profile.class );
		  restServer.setServiceBeanObjects(userService,itemService);
		  restServer.setAddress("http://127.0.0.1:9999/");
		  restServer.create();
		  
		   
	} 
	
}
