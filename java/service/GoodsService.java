package service;


import java.lang.annotation.Retention;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.User;
import entity.*;
import mapper.IGoodsMapper;


@Service
public class GoodsService { // �˴������ǽӿ����ͣ�����@Autowired 
	private IGoodsMapper iGoodsMapper;
@Autowired
public GoodsService(IGoodsMapper iGoodsMapper) { 
	this.iGoodsMapper=iGoodsMapper; 
	}
public List<Goods> getGoods(String type) {
	List<Goods> u = iGoodsMapper.getGoods(type);
	if(u!=null&&u.size()>0) {
		return u;
	}else {
		return null;
	}
}

public Goods getGoodsDetail(int id) {
	Goods goods = iGoodsMapper.getGoodsDetail(id);
	if(goods!=null)
		return goods;
	else
		return null;
}
@Transactional
public int addDingdan(int uid,int gid,int number,Timestamp datetime,int dingdanhao,double total) {
	boolean flag = iGoodsMapper.addDingdan(uid, gid, number, datetime,dingdanhao,total);
	if(flag)
		return number;
	else
		return 0;
}
@Transactional
public boolean updateDingdan(String state,Timestamp datetime,int id) {
	int flag = iGoodsMapper.updateDingdan(state,datetime,id);
	if(flag>0) {
		return true;
	}
	else {
		return false;
	}
}
public int getDingdanid(int uid,int gid) {
	int flag = iGoodsMapper.getDingdanid(uid, gid);
	if(flag>0)
		return flag;
	else
		return 0;
}
@Transactional
public boolean addCart(Cart cart) {
	boolean flag = iGoodsMapper.addCart(cart);
	if(flag)
		return true;
	else
		return false;
}

public int  getNumber(int uid,int s) {
	int flag = iGoodsMapper.getNumber(uid, s);
	if(flag>0)
		return flag;
	else
		return 0;
}
public double  getTotal(int uid,int s) {
	double flag = iGoodsMapper.getTotal(uid, s);
	if(flag>0)
		return flag;
	else
		return 0;
}

@Transactional
public boolean updateDingdans(String state,Timestamp datetime,int id) {
	int flag = iGoodsMapper.updateDingdans(state,datetime,id);
	if(flag>0) {
		return true;
	}
	else {
		return false;
	}
}
}
