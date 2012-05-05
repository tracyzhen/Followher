package com.followher.hibernateTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.followher.launch.HibernateUtil;
import com.followher.pojo.Avatar;
import com.followher.pojo.Comment;
import com.followher.pojo.Item;
import com.followher.pojo.Post;
import com.followher.pojo.Img;
import com.followher.pojo.Profile;
import com.followher.pojo.Type;
import com.followher.pojo.User;

public class InsertData {
 
	/**
	 * @param args
	 */
	

	public static void insertUsers(){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Avatar avatar1 = new Avatar("Avatar/admin.jpeg");
			Avatar avatar2 = new Avatar("Avatar/emma.png");
			Avatar avatar3 = new Avatar("Avatar/banner.jpeg");
			Profile profile1 = new Profile("123456");
			Profile profile2 = new Profile("123456");
			Profile profile3 = new Profile("123456");
			User user1 = new User("admin", "female", avatar1, profile1);
			User user2 = new User("Emma", "female", avatar2, profile2);
			User user3 = new User("Banner", "male", avatar3, profile3);
			
			session.save(user1);
			session.save(user2);
			session.save(user3);
			
			tx.commit();
			System.out.println("Success!!");
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void insertImgs(){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Img img1=new Img("poster/poster2.jpg","http://www.ebay.com","");
			Img img2=new Img("poster/poster6.jpg","http://www.ebay.com","");
			Post post1=new Post("Good,fancy!!!", new Date(112,5,4,16,40,0));
			post1.setImgs(new ArrayList<Img>());
			post1.addImg(img1);
			post1.addImg(img2);
			//session.save(post1);
			User user2=(User) session.get(User.class, new Long(1));
			if(user2!=null){
				
				
				
				user2.addPost(post1);
				
			}
			tx.commit();
			System.out.println("Success!!");
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	public static void insertComments(){
		Session session=HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user1=(User) session.get(User.class, new Long(1));
			User user2=(User) session.get(User.class, new Long(2));
			User user3=(User) session.get(User.class, new Long(4));
			Comment comment=new Comment("Good",new Date(112,5,4,16,40,0));
			Comment comment1=new Comment("Good",new Date(112,5,4,16,40,0));
			Comment comment2=new Comment("Cool",new Date(112,5,4,16,40,0));
			Comment comment3=new Comment("Fancy",new Date(112,5,4,16,40,0));
			Comment comment4=new Comment("Oh My God",new Date(112,5,4,16,40,0));
			comment.setUser(user1);
			comment1.setUser(user1);
			comment2.setUser(user2);
			comment3.setUser(user3);
			comment4.setUser(user3);
			Post post=(Post) session.get(Post.class, new Long(1));
			Post post1=(Post) session.get(Post.class, new Long(3));
			Post post2=(Post) session.get(Post.class, new Long(6));
			Post post3=(Post) session.get(Post.class, new Long(7));
			Post post4=(Post) session.get(Post.class, new Long(5));
			
			post3.addComment(comment);
			post.addComment(comment2);
			post1.addComment(comment3);
			post2.addComment(comment4);
			post4.addComment(comment1);
			
			session.saveOrUpdate(post);
			session.saveOrUpdate(post1);
			session.saveOrUpdate(post2);
			session.saveOrUpdate(post3);
			session.saveOrUpdate(post4);
//			session.flush();
			
		
			tx.commit();
			System.out.println("Success!!");
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public static void insertPosts(){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Img img1=new Img("poster/poster1.jpg","http://www.ebay.com","");
			Img img2=new Img("poster/poster2.jpg","http://www.ebay.com","");
			Img img3=new Img("poster/poster3.jpg","http://www.ebay.com","");
			Img img4=new Img("poster/poster4.jpg","http://www.ebay.com","");
			Img img5=new Img("poster/poster5.jpg","http://www.ebay.com","");
			Img img6=new Img("poster/poster6.jpg","http://www.ebay.com","");
			Img img7=new Img("poster/poster7.jpg","http://www.ebay.com","");
			
			
			Post post1=new Post("Good,Cool", new Date(112,5,4,16,40,0));
			post1.setImgs(new ArrayList<Img>());
			post1.addImg(img1);
			
			Post post2=new Post("Cool,beautiful, fancy !", new Date(112,5,3,16,40,0));
			post2.setImgs(new ArrayList<Img>());
			post2.addImg(img2);
			
			
			Post post3=new Post("U deserve it!", new Date(112,5,3,15,40,0));
			post3.setImgs(new ArrayList<Img>());
			post3.addImg(img3);
			
			
			Post post4=new Post("Good,Cool!", new Date(112,5,10,16,40,0));
			post4.setImgs(new ArrayList<Img>());
			post4.addImg(img4);
			
			
			Post post5=new Post("Good,Cool!!!!", new Date(112,4,4,16,40,0));
			post5.setImgs(new ArrayList<Img>());
			post5.addImg(img5);
			
			
			Post post6=new Post("Fancy,Cool", new Date(112,6,4,16,40,0));
			post6.setImgs(new ArrayList<Img>());
			post6.addImg(img6);
			
			Post post7=new Post("Good,Cool!!!", new Date(112,5,1,16,40,0));
			post7.setImgs(new ArrayList<Img>());
			post7.addImg(img7);
			
			
			User user1=(User) session.get(User.class, new Long(1));
			if(user1!=null){
				
				
				user1.setPosts(new ArrayList<Post>());
				user1.addPost(post1);
				user1.addPost(post3);
				user1.addPost(post4);
			}
			
			
			User user2=(User) session.get(User.class, new Long(2));
			if(user2!=null){
				
				
				user2.setPosts(new ArrayList<Post>());
				user2.addPost(post2);
				user2.addPost(post6);
				
			}
			
			User user3=(User) session.get(User.class, new Long(3));
			if(user3!=null){
				
				
				user3.setPosts(new ArrayList<Post>());
				user3.addPost(post5);
				user3.addPost(post7);
				
			}
			
			session.saveOrUpdate(user1);
			session.saveOrUpdate(user2);
			session.saveOrUpdate(user3);
			tx.commit();
			System.out.println("Success!!");
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void insertItems(){
		Type type1=new Type(Type.COATS_JACKETS);
		Type type2=new Type(Type.DRESSES);
		Type type3=new Type(Type.JEANS);
		Type type4=new Type(Type.PANT);
		Type type5=new Type(Type.SHOES);
		Type type6=new Type(Type.SKIRTS);
		Type type7=new Type(Type.TOPS);
		
		Item item1=new Item(type1,"CSA/Coats_Jackets/Coats_Jackets1.jpg","");
		Item item2=new Item(type1,"CSA/Coats_Jackets/Coats_Jackets2.jpg","");
		Item item3=new Item(type1,"CSA/Coats_Jackets/Coats_Jackets3.jpg","");
		
		Item item4=new Item(type2,"CSA/Dresses/Dresses1.jpg","");
		Item item5=new Item(type2,"CSA/Dresses/Dresses2.jpg","");
		Item item6=new Item(type2,"CSA/Dresses/Dresses3.jpg","");
		Item item7=new Item(type2,"CSA/Dresses/Dresses4.jpg","");
		
		
		Item item8=new Item(type3,"CSA/Jeans/Jeans1.jpg","");
		Item item9=new Item(type3,"CSA/Jeans/Jeans2.jpg","");
		Item item10=new Item(type3,"CSA/Jeans/Jeans3.jpg","");
		Item item11=new Item(type3,"CSA/Jeans/Jeans4.jpg","");
		
		Item item12=new Item(type4,"CSA/pants/pants1.jpg","");
		Item item13=new Item(type4,"CSA/pants/pants2.jpg","");
		Item item14=new Item(type4,"CSA/pants/pants3.jpg","");
		
		Item item15=new Item(type5,"CSA/shoes/shoes1.jpg","");
		Item item16=new Item(type5,"CSA/shoes/shoes2.jpg","");
		Item item17=new Item(type5,"CSA/shoes/shoes3.jpg","");
		Item item18=new Item(type5,"CSA/shoes/shoes4.jpg","");
		Item item19=new Item(type5,"CSA/shoes/shoes5.jpg","");
		
		Item item20=new Item(type6,"CSA/Skirts/Skirts1.jpg","");
		Item item21=new Item(type6,"CSA/Skirts/Skirts2.jpg","");
		Item item22=new Item(type6,"CSA/Skirts/Skirts3.jpg","");
		Item item23=new Item(type6,"CSA/Skirts/Skirts4.jpg","");
		
		Item item24=new Item(type7,"CSA/Tops/Tops1.jpg","");
		Item item25=new Item(type7,"CSA/Tops/Tops2.jpg","");
		Item item26=new Item(type7,"CSA/Tops/Tops3.jpg","");
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(item1);
			session.save(item2);
			session.save(item3);
			session.save(item4);
			session.save(item5);
			session.save(item6);
			session.save(item7);
			session.save(item8);
			session.save(item9);
			session.save(item10);
			session.save(item11);
			session.save(item12);
			session.save(item13);
			session.save(item14);
			session.save(item15);
			session.save(item16);
			session.save(item17);
			session.save(item18);
			session.save(item19);
			session.save(item20);
			session.save(item21);
			session.save(item22);
			session.save(item23);
			session.save(item24);
			session.save(item25);
			session.save(item26);
			
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
