package com.followher.pojo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="type")
public class Type implements Serializable {
    
	public static String COATS_JACKETS="coats_jacketS";
	public static String DRESSES="dresses";
	public static String JEANS="jeans";
	public static String PANT="pants";
	public static String SHOES="shoes";
	public static String SKIRTS="skirts";
	public static String TOPS="tops";
	
	
	private long id;
	private String type;

	public Type(){
		
		
	}
	
	public Type(String type){
		this.type=type;
	}
	
	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-type",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue="TYPE_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-type")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
