package com.followher.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Subscribe")
public class Subscribe {

	private String id;
	private String userId;
	private String followId;
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
	public String getFollowId() {
		return followId;
	}
	public void setFollowId(String followId) {
		this.followId = followId;
	}
	
	
	   
}
