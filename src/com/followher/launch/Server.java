package com.followher.launch;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;


import com.followher.hibernateTest.Test;
import com.followher.pojo.Avatar;
import com.followher.pojo.Profile;
import com.followher.pojo.User;
import com.followher.service.UserService;

public class Server {

	public static void main(String[] args){
		
		 
		Test.test();
		  // startServer();
		
	}
	
	public static void startServer(){
		  UserService userService =new UserService();
		   
		  JAXRSServerFactoryBean restServer =new JAXRSServerFactoryBean();
		  restServer.setResourceClasses(User.class, Avatar.class,Profile.class );
		  restServer.setServiceBean(userService);
		  restServer.setAddress("http://10.249.72.72:9999/");
		  restServer.create();
		  
		   
	} 
	
}
