package com.example;

public class Product {

	private Integer pid;
	private String pname;
	private Integer rating;
	private Double price;
	private String imgpath;
	private String description;
	public Product(Integer pid,String pname,Double price){
		this.pid=pid;
		this.pname=pname;
		this.price=price;
	}
	public Product(Integer pid,String pname,Double price,Integer rating,String imgpath,String description){
		this.pid=pid;
		this.pname=pname;
		this.rating=rating;
		this.price=price;
		this.imgpath=imgpath;
		this.description=description;
	}
	public Integer getPid()
	{
		return this.pid;
	}
	public String getPname() {
		return this.pname;
	}
	public Integer getRating() {
		return this.rating;
		
	}
	public Double getPrice() {
		return this.price;
	}
	public String getImgPath() {
		return this.imgpath;
	}
	public String getDescription() {
		return this.description;
	}
	public void setPid(Integer pid)
	{
		this.pid=pid;
	}
	public void setPname(String pname) {
		this.pname=pname;
	}
	public void  setRating(Integer rating) {
		this.rating=rating;
		
	}
	public void setPrice(Double price) {
		 this.price=price;
	}
	public void setImgPath(String imgpath) {
		 this.imgpath=imgpath;
	}
	public void  setDescription(String description) {
		 this.description=description;
	}
	
}
