package com.followher.hibernateTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.followher.launch.HibernateUtil;
import com.followher.pojo.Avatar;
import com.followher.pojo.Post;
import com.followher.pojo.Profile;
import com.followher.pojo.User;

public class Test {

	public static void test() {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Post post=new Post("Fancy,Cool", new Date(112,5,4,16,40,0));
			User user=(User) session.get(User.class, new Long(1));
			user.setPosts(new ArrayList<Post>());
			user.addPost(post);
			session.save(user);
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
