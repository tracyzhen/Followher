package com.followher.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.JoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.IndexColumn;

@XmlRootElement(name = "Post")
@Entity
@Table(name="post")
public class Post implements Serializable{

	private long id;
	private String content;
	private Date createTime;
	private List<Img> imgs;
	private List<Comment> comments;
	
//	private User user;
	
	public Post(){
		
	}
	
	public Post(String content, Date createTime){
		this(content,createTime,null,null);
	}
	public Post(String content, Date createTime, List<Img> imgs,List<Comment> comments){
		this.content=content;
		this.createTime=createTime;
		this.imgs=imgs;
		this.comments=comments;
	}
	
	
	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-post",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue="POST_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-post")
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="createtime")
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@IndexColumn(name="id")
	@JoinTable(name = "imgpost", joinColumns = { @JoinColumn(name = "postid") }, inverseJoinColumns = { @JoinColumn(name = "imgid") })
	public List<Img> getImgs() {
		return this.imgs;
	}
	public void setImgs(List<Img> imgs) {
		this.imgs = imgs;
	}
	
	
	public void addImg(Img img){
		this.imgs.add(img);
	}

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@IndexColumn(name="id")
    @JoinTable(name = "comment", joinColumns = { @JoinColumn(name = "postid") }, inverseJoinColumns = { @JoinColumn(name = "id") })
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

//	@ManyToOne(cascade = CascadeType.ALL)
//	@Joincolumn()
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
	
}
