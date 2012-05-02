package com.followher.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;

@XmlRootElement(name = "Comment")
@Entity
@Table(name="comment")
public class Comment {

	private long id;
	private User user; // 发评论的人
	private String conetent;
	private Date createtime;

	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-comment",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue="COMMENT_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-comment")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="content")
	public String getConetent() {
		return conetent;
	}

	public void setConetent(String conetent) {
		this.conetent = conetent;
	}

	@Column(name="createtime")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
