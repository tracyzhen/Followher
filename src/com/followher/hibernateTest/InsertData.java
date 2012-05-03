package com.followher.hibernateTest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.followher.launch.HibernateUtil;
import com.followher.pojo.Item;
import com.followher.pojo.Type;

public class InsertData {
 
	/**
	 * @param args
	 */
	

	
	
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
