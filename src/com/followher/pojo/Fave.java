package com.followher.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Fave")
public class Fave {

	private String id;
	private String userId;
	private String postId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

}
