package entity;

import java.sql.Timestamp;

public class UserGoods {
	String username;
	String phone;
	String address;
	Timestamp xiadan_time;
	Timestamp fukuan_time;
	Timestamp shouhuo_time;
	String state;
	String picture;
	String goodsname;
	Double price;
	Double total;
	double totals;
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	int number;
	int dingdanhao;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getXiadan_time() {
		return xiadan_time;
	}
	public void setXiadan_time(Timestamp xiadan_time) {
		this.xiadan_time = xiadan_time;
	}
	public Timestamp getFukuan_time() {
		return fukuan_time;
	}
	public void setFukuan_time(Timestamp fukuan_time) {
		this.fukuan_time = fukuan_time;
	}
	public Timestamp getShouhuo_time() {
		return shouhuo_time;
	}
	public void setShouhuo_time(Timestamp shouhuo_time) {
		this.shouhuo_time = shouhuo_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getDingdanhao() {
		return dingdanhao;
	}
	public void setDingdanhao(int dingdanhao) {
		this.dingdanhao = dingdanhao;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
