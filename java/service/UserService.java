package service;

import java.lang.annotation.Retention;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Cart;
import entity.User;
import entity.UserGoods;
import mapper.IUserMapper;

@Service
public class UserService { // �˴������ǽӿ����ͣ�����@Autowired 
	private IUserMapper iUserMapper;
@Autowired
public UserService(IUserMapper iUserMapper) { 
	this.iUserMapper=iUserMapper; 
	}
public User login(User user) {
	User u = iUserMapper.findUser(user);
	if(u!=null) {
		return u;
	}else {
		return null;
	}
}
@Transactional
public boolean register(User user) {
	int cnt = iUserMapper.addUser(user);
	if(cnt!=0)
		return true;
	else
		return false;
}
public boolean findUser(String username) {
	User u= iUserMapper.findUserByUserName(username);
	if(u!=null)
		return true;
	else
		return false;
}
public User findUser(int id) {
	User u= iUserMapper.getUserById(id);
	if(u!=null)
		return u;
	else
		return null;
}

public List<UserGoods> getUserGoods() {
	List<UserGoods> flag = iUserMapper.getUserGoods();
	if(flag!=null&&flag.size()>0)
		return flag;
	else
		return null;
}

public List<Cart> getCart(int uid,int state){
	List<Cart> cart = iUserMapper.getCart(uid, state);
	if(cart!=null)
		return cart;
	else
		return null;
}

public Cart getCart1(int id) {
	return iUserMapper.getCart1(id);
}
@Transactional
public boolean deleteCart(int id) {
	int flag = iUserMapper.deleteCart(id);
	if(flag>0) {
		return true;
	}else
		return false;
}
public List<UserGoods> getCartGoods(int m) {
	List<UserGoods> userGoods = iUserMapper.getCartGoods(m);
	if(userGoods!=null&&userGoods.size()>0) {
		return userGoods;
	}else
		return null;
}

public double getTotals(int m) {
	double flag = iUserMapper.getTotals(m);
	if(flag>0)
	return flag;
	else
		return 0;
}
@Transactional
public boolean updateUsers(User user) {
	int flag = iUserMapper.updateUsers(user);
	if(flag>0)
		return true;
	else
		return false;
}
@Transactional
public boolean delete(int id) {
	int flag = iUserMapper.delete(id);
	if(flag>0)
		return true;
	else
		return false;
}
@Transactional
public boolean Pay(String state,Timestamp d,int id)
{
	int flag=iUserMapper.Pay(state,d, id);
	if(flag>0)
		return true;
	else
		return false;
}
@Transactional
public boolean Shouhuo(String state,Timestamp d,int id)
{
	int flag=iUserMapper.Shouhuo(state,d, id);
	if(flag>0)
		return true;
	else
		return false;
}



}
