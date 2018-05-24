package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Admin;
import entity.Goods;
import entity.UserGoods;
import mapper.IAdminMapper;
import mapper.IUserMapper;


@Service
public class AdminService {
	private IAdminMapper iAdminMapper;
	@Autowired
	public AdminService(IAdminMapper iAdminMapper) { 
		this.iAdminMapper=iAdminMapper; 
		}
	public Admin login(Admin admin) {
		Admin a = iAdminMapper.findAdmin(admin);
		return a;
	}
	public List<Goods> getGoods(){
		List<Goods> goods=iAdminMapper.getGoods();
		if(goods!=null)
			return goods;
		return null;
	}
	@Transactional
	public boolean addGoods(Goods goods)
	{
		int flag = iAdminMapper.addGoods(goods);
		if(flag>0)
			return true;
		else
			return false;
	}
	@Transactional
	public boolean editgoods(Goods goods) {
		int  flag = iAdminMapper.editGoods(goods);
		if(flag>0)
			return true;
		else
			return false;
	}
	@Transactional
	public boolean editgoods1(Goods goods) {
		int  flag = iAdminMapper.editGoods1(goods);
		if(flag>0)
			return true;
		else
			return false;
	}
	
	public List<UserGoods> getUserGoods(){
		List<UserGoods> userGoods = iAdminMapper.getUserGoods();
		if(userGoods!=null&&userGoods.size()>0) {
			return userGoods;
		}else
			return null;
	}
	
    public List<UserGoods> getUserOrder(int m){
    	List<UserGoods> userGoods = iAdminMapper.getCartGoods(m);
    	if(userGoods!=null&&userGoods.size()>0)
    		return userGoods;
    	else
    		return null;
    }
    
    public double getTotals(int m) {
		double t = iAdminMapper.getTotals(m);
		return t;
	}
    @Transactional
    public boolean faHuo(String state,int id)
    {
    	int flag = iAdminMapper.Fahuo(state, id);
    	if(flag>0)
    		return true;
    	else
    		return false;
    }
    @Transactional
    public boolean delete(int id)
    {
    	int flag = iAdminMapper.delete(id);
    	if(flag>0)
    		return true;
    	else
    		return false;
    }

}
