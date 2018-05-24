package controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpSession;
import javax.swing.text.Position.Bias;

import org.springframework.aop.IntroductionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.Cart;
import entity.User;
import entity.UserGoods;
import service.GoodsService;
import service.UserService;

@Controller
@RequestMapping("/Shop/Account")
public class AccountController {
@Autowired
private UserService userService;
@Autowired
private GoodsService goodsService;

@RequestMapping("/")
public String index() {
	return "account/login";
}
@RequestMapping("/Welcome")
public String welcome() {
	return "account/welcome";
}
@RequestMapping("/Register1")
public String register() {
	return "account/register";
}
@RequestMapping("/Userinfo")
public String userinfo() {
	return "account/userinfo";
}
@RequestMapping("/Login")
public String login(User user, HttpSession session) {
	User u = userService.login(user);
	if(u!=null) {
		int N = goodsService.getNumber(u.getId(), 0);
		session.setAttribute("N", N);
		session.setAttribute("user", u); 
		return "redirect:/Shop/Home/";
	}else {
		session.setAttribute("err","�û������������");
		return "redirect:/Shop/Account/";
	}
}
@RequestMapping("/Register")
public String register(User user,RedirectAttributes redirectAttributes) {
	boolean flag = userService.findUser(user.getUsername());
	if(flag) {
		redirectAttributes.addFlashAttribute("err_username","�û����Ѵ���");
		return "redirect:/Account/Register1";
	}else {
		boolean add_flag = userService.register(user);
		if(add_flag) {
			redirectAttributes.addFlashAttribute("user",user);   
			return "redirect:/Home/";
		}else {
			redirectAttributes.addFlashAttribute("err_msg","ע��ʧ��");   
			return "redirect:/Account/Register1";
		}
	}
}
@RequestMapping("/Userout")
public String userout(HttpSession session) {
	session.removeAttribute("user");
	return "redirect:/Home/";
}
@RequestMapping("/Order")
public String order() {
	return "account/user_order";
}

@RequestMapping("/User_order")
public String user_order(HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/Shop/Account/Login";
	}
	List<UserGoods> userGoods = userService.getUserGoods();
		session.setAttribute("dingdan", userGoods);
		return "redirect:/Shop/Account/Order";
}
@RequestMapping("/Tocart")
public String tocart(String uid,HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/Shop/Account/Login";
	}
	List<Cart> cart = userService.getCart(Integer.parseInt(uid), 0);
	if(cart!=null) {
		double M = goodsService.getTotal(Integer.parseInt(uid),0);
		session.setAttribute("M", M);
		session.setAttribute("cart", cart);
		return "redirect:/Shop/Account/Cart";
	}
	else
		return "/Home/";
}
@RequestMapping("/Cart")
public String cart(HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/Account/Login";
	}
	List<Cart> cart = userService.getCart(1, 0);
	if(cart!=null) {
		double M = goodsService.getTotal(1,0);
		session.setAttribute("M", M);
		session.setAttribute("cart", cart);
	}
	return "account/cart";
}

@RequestMapping("/Tocartpay")
public String tocartpay(String delid[],HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/Account/Login";
	}
	int count=0;
	Date date=new Date();
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time=df.format(date);
    Timestamp datetime = Timestamp.valueOf(time);  
	StringBuilder str=new StringBuilder();//����䳤�ַ���
	Random random=new Random();
	//����������֣�����ӵ��ַ���
	for(int j=0;j<8;j++){
	    str.append(random.nextInt(10));
	}
	//���ַ���ת��Ϊ���ֲ����
	int num=Integer.parseInt(str.toString());
	if(delid.length>0) {
		for(int i=0;i<delid.length;i++) {
			Cart cart = userService.getCart1(Integer.parseInt(delid[i]));
			int uid = cart.getUid();
			int gid = cart.getGid();
			int number = cart.getNumber();
			double total = cart.getTotal();
			int flag = goodsService.addDingdan(uid, gid, number, datetime, num, total);
			if(flag>0) {
				if(userService.deleteCart(Integer.parseInt(delid[i])))
				count++;
			}
		}
	}
	if(count==delid.length) {
		List<UserGoods> userGoods = userService.getCartGoods(num);
		double t = userService.getTotals(num);
		session.setAttribute("totals", t);
		if(userGoods.size()>0&&userGoods!=null) {
			session.setAttribute("cartpay", userGoods);
			return "redirect:/Account/Cartpay";
		}else
			return "redirect:/Home/";
	}else
	return "redirect:/Home/";
}
@RequestMapping("/Cartpay")
public String cartpay() {
	
	return "account/cartpay";
}
@RequestMapping("/User_site")
public String user_site() {
	
	return "account/user_site";
}

@RequestMapping("/Edit")
public String edit(User user,HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/Account/Login";
	}
	boolean flag = userService.updateUsers(user);
	if(flag) {
		User u = userService.login(user);
		if(u!=null) {
			session.setAttribute("user", u);
			return "redirect:/Account/Userinfo";
		}else
			return "redirect:/Account/User_site";
	}
	else
		return "redirect:/Account/User_site";
}

@RequestMapping("/Delete")
public String delete(String dingdanhao) {
	
	boolean flag = userService.delete(Integer.parseInt(dingdanhao));
	if(flag)
	{
		return "redirect:/Account/User_order";
	}else
		return "redirect:/Account/User_order";
}

@RequestMapping("/Pay")
public String pay(String dingdanhao,HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/Account/Login";
	}
	List<UserGoods> userGoods = userService.getCartGoods(Integer.parseInt(dingdanhao));
	if(userGoods!=null&&userGoods.size()>0) {
		session.setAttribute("detail", userGoods);
		return "redirect:/Account/Pays";
	}
	else {
		return "redirect:/Account/User_order";
	}
}
@RequestMapping("/Pays")
public String pays() {
	
	return "account/pays";
}
@RequestMapping("/Topay")
public String topay(String dingdanhao) {

	Date date=new Date();
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time=df.format(date);
    Timestamp datetime = Timestamp.valueOf(time); 
	boolean flag = userService.Pay("������", datetime,Integer.parseInt(dingdanhao));
	if(flag) {
		return "redirect:/Account/User_order";
	}else
		return "redirect:/Home/";
}
@RequestMapping("/Shouhuo")
public String shouhuo(String dingdanhao) {
	
	Date date=new Date();
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time=df.format(date);
    Timestamp datetime = Timestamp.valueOf(time); 
	boolean flag = userService.Shouhuo("���ջ�", datetime,Integer.parseInt(dingdanhao));
	if(flag) {
		return "redirect:/Account/User_order";
	}else
		return "redirect:/Home/";
}

@RequestMapping("/Deletecart")
public String de(String id,HttpSession session) {
	if(session.getAttribute("user")==null) {
		return "redirect:/Account/Login";
	}
	boolean flag = userService.deleteCart(Integer.parseInt(id));
		List<Cart> cart = userService.getCart(1, 0);
		if(cart!=null) {
			int N = goodsService.getNumber(1, 0);
			session.setAttribute("N", N);
			double M = goodsService.getTotal(1,0);
			session.setAttribute("M", M);
			session.setAttribute("cart", cart);
		}
		return "account/cart";
}
}
