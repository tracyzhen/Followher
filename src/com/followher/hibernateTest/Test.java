package com.followher.hibernateTest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.followher.launch.HibernateUtil;
import com.followher.pojo.Avatar;
import com.followher.pojo.Profile;
import com.followher.pojo.User;

public class Test {

	public static void test() {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			/* Test User-Avatar, USer-Profile One to One relationship
			Avatar avatar1 = new Avatar("follower/1.jpg");
			Avatar avatar2 = new Avatar("follower/2.jpg");
			Profile profile1 = new Profile("11111");
			Profile profile2 = new Profile("22222");
			User user1 = new User("admin", "male", avatar1, profile1);
			User user2 = new User("kevin", "male", avatar2, profile2);
			session.save(user1);
			session.save(user2);
			*/
			
			/*Test User-User many to many relationship*/
			Avatar avatar1 = new Avatar("follower/5.jpg");
			Avatar avatar2 = new Avatar("follower/6.jpg");
			Profile profile1 = new Profile("111111");
			Profile profile2 = new Profile("222222");
			User user1 = new User("test4", "female", avatar1, profile1);
			User user2 = new User("test5", "male", avatar2, profile2);
	        List<User> users=new ArrayList<User>();
	        users.add(user2);
	        user1.setFollowers(users);
	        session.save(user2);
			session.save(user1);
			
			tx.commit();
			System.out.println("Success!!");
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
