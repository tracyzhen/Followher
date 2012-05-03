package com.followher.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PostImg")
@Entity
@Table(name="postimg")
public class PostImg {

	private long id;
	private String url;
	private String ebaylink;
	private String css;

	
	public PostImg(){
		
		
	}
	
	public PostImg(String url, String ebaylink, String css){
		this.url=url;
		this.ebaylink=ebaylink;
		this.css=css;
	}
	
	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-postimg",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue="POSTIMG_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-postimg")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name="ebaylink")
	public String getEbaylink() {
		return ebaylink;
	}

	public void setEbaylink(String ebaylink) {
		this.ebaylink = ebaylink;
	}

	@Column(name="css")
	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}
	
	

}
