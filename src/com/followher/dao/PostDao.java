package com.followher.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.followher.launch.HibernateUtil;
import com.followher.pojo.Post;

public class PostDao {

	
	public static List<Post> getPostsByUser(String user){
		return null;
	}
	
	
	public static List<Post> getPosts(){
		 Session session=HibernateUtil.getSession();
		 Transaction tx=null;
		 try{
			 tx=session.beginTransaction();
			 Query query=session.createQuery(
				" select post from Post as post order by post.createTime DESC "	 
			   );
			 Iterator it=query.iterate();
			 List<Post> posts=new ArrayList<Post>();
			 while(it.hasNext()){
                    
	                Post post=(Post)it.next();
	                Hibernate.initialize(post.getImgs());
	               // Hibernate.initialize(post.getComments());
                    posts.add(post);
	         }
			 tx.commit();
			 
			 return posts;
			 
		 }catch(HibernateException e){
			 tx.rollback();
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
		 
	}
}
