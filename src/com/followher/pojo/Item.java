package com.followher.pojo;
import javax.persistence.*;

@Entity
@Table(name="items")
public class Item {

	
	private long id;
	private Type type;
	private String filelocation;
	private String ebaylink;
	
	public Item(){
		
		
	}
	public Item(Type type, String filelocation, String ebaylink) {
//		super();
		this.type = type;
		this.filelocation = filelocation;
		this.ebaylink = ebaylink;
	}
	
	@Id
	@Column(name="id")
	@TableGenerator(
         name="tab-store-item",
         table="GENERATOR_TABLE",
         pkColumnName = "G_KEY",
         pkColumnValue= "ITEM_PK",
         valueColumnName = "G_VALUE",
         allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE,generator="tab-store-item")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="type")
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	@Column(name="filelocation")
	public String getFilelocation() {
		return filelocation;
	}
	public void setFilelocation(String filelocation) {
		this.filelocation = filelocation;
	}
	
	@Column(name="ebaylink")
	public String getEbaylink() {
		return ebaylink;
	}
	public void setEbaylink(String ebaylink) {
		this.ebaylink = ebaylink;
	}
	
	
	
	
	
}
