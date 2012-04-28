package com.followher.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
@Entity
@Table(name="user")
public class User implements Serializable{

	
	
	private long id;
	
	
	private String name;
	
	private String sex;
	
	
	private Avatar avatar;
	
	
	private Profile profile;
	
//	@Transient
//	private ArrayList<Post> posts;
//	@Transient
//	private ArrayList<Comment> comments;
//	@Transient
//	private ArrayList<Fave> faves;
//	@Transient
//	private ArrayList<Like> likes;
//	@Transient
//	private ArrayList<User> following;  // 关注
//	@Transient
//	private ArrayList<User> followers;  //粉丝
//	
	
	public User(){
		
		
	}

	public User( String name, String sex, Avatar avatar,
			Profile profile) {
		
		this.name = name;
		this.sex = sex;
		this.avatar = avatar;
		this.profile = profile;
	}

	
	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-user",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue="USER_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-user")
	public long getId() {

		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@JoinColumn(name="avatar")
	@OneToOne(cascade= CascadeType.ALL)
	public Avatar getAvatar(){
		return avatar;
		
	}
	
	public void setAvatar(Avatar avatar){
		this.avatar=avatar;
	}
	
	@JoinColumn(name="profile")
	@OneToOne(cascade= CascadeType.ALL)
	public Profile getProfile(){
		return profile;
		
	}
	
	public void setProfile(Profile profile){
		this.profile=profile;
	}

}
