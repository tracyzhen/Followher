package com.followher.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PostImg")
public class PostImg {

	 private String id;
	 private String postId;
	 private String url;
	 private String ebaylink;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEbaylink() {
		return ebaylink;
	}
	public void setEbaylink(String ebaylink) {
		this.ebaylink = ebaylink;
	}
	 
	 
}
