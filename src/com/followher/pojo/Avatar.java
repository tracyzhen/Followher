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






@XmlRootElement(name = "Avatar")
@Entity
@Table(name="avatar")
public class Avatar implements Serializable{

	
	private long id;
	
	
	
	private String fileLocation;
	
	public Avatar(){
		
	}
	
	public Avatar(String fileLocation) {
		
		this.fileLocation = fileLocation;
	}

	
	
	
	

	
	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-avatar",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue="AVATAR_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-avatar")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	@Column(name="filelocation")
	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}
