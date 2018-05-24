package entity;

public class Cart {
   int id;
   int uid;
   int gid;
   String picture;
   double price;
   String goodsname;
   int number;
   int state;
   double total;
   public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getGid() {
	return gid;
}
public void setGid(int gid) {
	this.gid = gid;
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
public String getGoodsname() {
	return goodsname;
}
public void setGoodsname(String goodsname) {
	this.goodsname = goodsname;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
}
