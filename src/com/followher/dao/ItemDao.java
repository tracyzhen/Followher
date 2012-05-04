package com.followher.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;

import com.followher.launch.HibernateUtil;
import com.followher.pojo.Item;
import com.followher.pojo.Type;

public class ItemDao {

	public static List<Item> getItemsByType(String type){
		 Session session=HibernateUtil.getSession();
		 Transaction tx=null;
		 try{
			 tx=session.beginTransaction();
			 Query query=session.createQuery(
				"select it from Item as it join it.type as type where " +
				"type.type =?"	 
			   ).setString(0, type);
			 List list=query.list();
			 Iterator it=list.iterator();
			 List<Item> items=new ArrayList<Item>();
			 while(it.hasNext()){

	                Item item=(Item)it.next();
                    items.add(item);
	         }
			 tx.commit();
			 return items;
			 
		 }catch(HibernateException e){
			 tx.rollback();
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
		 
	 }
	
	public static List<Item> getItems(){
		Session session=HibernateUtil.getSession();
		 Transaction tx=null;
		 try{
			 tx=session.beginTransaction();
			 Query query=session.createQuery(
				"select it from Item as it "	 
			   );
			 List list=query.list();
			 Iterator it=list.iterator();
			 List<Item> items=new ArrayList<Item>();
			 while(it.hasNext()){

	                Item item=(Item)it.next();
                    items.add(item);
	         }
			 tx.commit();
			 return items;
			 
		 }catch(HibernateException e){
			 tx.rollback();
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
		 
	}
}
