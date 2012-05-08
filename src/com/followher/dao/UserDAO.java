package com.followher.dao;



import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.followher.launch.HibernateUtil;
import com.followher.pojo.User;

public class UserDAO {

	
	public static User getUser(long id){
	   
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(
			    "select new User(user.id, user.name, user.avatar ) from User as user where user.id=? "		
			).setLong(0, id);
			Iterator it=query.iterate();
			if(it.hasNext()){
				User user=(User)it.next();
				return user;
			}
			return null;
			
			
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
			return null;
		}finally{
			tx.commit();
			session.close();
		}
		
	}
}
