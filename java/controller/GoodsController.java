package controller;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import entity.Cart;
import entity.Goods;
import service.GoodsService;

@Controller
@RequestMapping("/Shop/Goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/Detail")
	public String detail(String idd,HttpSession session) {
		int id = Integer.parseInt(idd);
		Goods goods = goodsService.getGoodsDetail(id);
		if(goods!=null) {
			session.setAttribute("detail", goods);
			return "goods/detail";
		}else
			return "home/index";
	}
	
	@RequestMapping("/Buy")
	public String tobuy() {
			return "goods/order";
	}
	@RequestMapping("/Tobuy")
	public String buy(String gid,String uid,String number,String price,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/Account/Login";
		}
		Date date=new Date();
	    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=df.format(date);
	    Timestamp datetime = Timestamp.valueOf(time);  
		StringBuilder str=new StringBuilder();//����䳤�ַ���
		Random random=new Random();
		//����������֣�����ӵ��ַ���
		for(int i=0;i<8;i++){
		    str.append(random.nextInt(10));
		}
		//���ַ���ת��Ϊ���ֲ����
		int num=Integer.parseInt(str.toString());
		double total=Double.parseDouble(price)*Integer.parseInt(number);
		int flag = goodsService.addDingdan( Integer.parseInt(gid),Integer.parseInt(uid), Integer.parseInt(number), datetime,num,total);
		if(flag!=0)
		{
			session.setAttribute("n", flag);
			return "redirect:/Goods/Buy";
		}
		else
			return "redirect:/Home";
	}
	@RequestMapping("/Topay")
	public String topay(String uid,String gid,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/Account/Login";
		}
		int id=goodsService.getDingdanid(Integer.parseInt(uid), Integer.parseInt(gid));
		Date date=new Date();
	    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=df.format(date);
	    Timestamp datetime = Timestamp.valueOf(time); 
		boolean flag = goodsService.updateDingdan("������",datetime,id);
		if(flag) {
			
			return "redirect:/Account/User_order";
		}
		else
			return "redirect:/Home/";
	}
	
	@RequestMapping("/Tocart")
	public String tocart(String uid,String gid,String picture,String price,String goodsname,String number,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/Account/Login";
		}
		int uid1 = Integer.parseInt(uid);
		int gid1 = Integer.parseInt(gid);
		double price1=Double.parseDouble(price);
		int num = Integer.parseInt(number);
		Cart cart = new Cart();
		cart.setGid(gid1);
		cart.setGoodsname(goodsname);
		cart.setId(0);
		cart.setNumber(num);
		cart.setPicture(picture);
		cart.setPrice(price1);
		cart.setTotal(num*price1);
		cart.setUid(uid1);
		cart.setState(0);
		boolean flag = goodsService.addCart(cart);
		if(flag) {
			int N = goodsService.getNumber(uid1, 0);
			session.setAttribute("N", N);
			return "redirect:/Shop/Home/";
		}
		else
			return "redirect:/Account/User_order";
	}
	
	@RequestMapping("/Tocartpay")
	public String topay(String dingdanhao,HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/Account/Login";
		}
		Date date=new Date();
	    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=df.format(date);
	    Timestamp datetime = Timestamp.valueOf(time); 
		boolean flag = goodsService.updateDingdans("������",datetime,Integer.parseInt(dingdanhao));
		if(flag) {
			return "redirect:/Account/User_order";
		}
		else
			return "redirect:/Home/";
	}
}
