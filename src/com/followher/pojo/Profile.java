package com.followher.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Profile")
@Entity
@Table(name="profile")
public class Profile implements Serializable{

	
	private long id;
	
	
	private String password;

	
	public Profile(){
		
		
	}
	public Profile( String password) {
		this.password = password;
	}

	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-profile",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue="PROFILE_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-profile")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
