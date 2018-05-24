package entity;

import org.springframework.stereotype.Component;

@Component
public class Goods {
	int idd;
	String goodsname;
	String describe;
	String picture;
	String type;
	double price;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getidd() {
		return idd;
	}
	public void setidd(int idd) {
		this.idd = idd;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}