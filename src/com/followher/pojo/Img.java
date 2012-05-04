package com.followher.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Img")
@Entity
@Table(name="img")
public class Img {

	private long id;
	private String url;
	private String ebaylink;
	private String css;

	
	public Img(){
		
		
	}
	
	public Img(String url, String ebaylink, String css){
		this.url=url;
		this.ebaylink=ebaylink;
		this.css=css;
	}
	
	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-img",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue="IMG_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-img")
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
