package com.followher.pojo;

import java.io.Serializable;
import java.util.List;

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
	
	private List<Post> posts;
	
	private List<Post> faves;

	private List<Post> likes;
   
	private List<User> following;  // 关注
//	@Transient
	private List<User> followers;  //粉丝
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
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="avatar")
	public Avatar getAvatar(){
		return avatar;
		
	}
	
	public void setAvatar(Avatar avatar){
		this.avatar=avatar;
	}
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="profile")
	public Profile getProfile(){
		return profile;
		
	}
	
	public void setProfile(Profile profile){
		this.profile=profile;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="subscribe", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = { @JoinColumn(name = "followid") })
	public List<User> getFollowing(){
		return this.following;
	}
	
	public void setFollowing(List<User> following){
		this.following=following;
	}
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="subscribe", joinColumns = { @JoinColumn(name = "followid") }, inverseJoinColumns = { @JoinColumn(name = "userid") })
	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = { @JoinColumn(name = "id") })
	public List<Post> getPosts() {
		return posts;
	}



	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="fave", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = { @JoinColumn(name = "postid") })    
	public List<Post> getFaves() {
		return faves;
	}



	public void setFaves(List<Post> faves) {
		this.faves = faves;
	}


	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="like", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = { @JoinColumn(name = "postid") })    
	public List<Post> getLikes() {
		return likes;
	}



	public void setLikes(List<Post> likes) {
		this.likes = likes;
	}

	
	
}
