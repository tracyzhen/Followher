package com.followher.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.followher.launch.HibernateUtil;
import com.followher.pojo.Comment;
import com.followher.pojo.Post;

public class CommentDao {

	public static List<Comment> getCommentByPostId(long id){
		  
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(
			    " select post from Post as post where post.id = ?"		
			).setLong(0, id);
			Iterator it=query.iterate();
			while(it.hasNext()){
				Post post=(Post)it.next();
				List<Comment> comments=post.getComments();
				Hibernate.initialize(comments);
				return comments;
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
