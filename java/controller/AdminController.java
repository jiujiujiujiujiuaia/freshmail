package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Admin;
import entity.Goods;
import entity.UserGoods;
import service.AdminService;
import service.GoodsService;

@Controller
@RequestMapping("/Shop/Admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private GoodsService goodsService;
@RequestMapping("/")
public String i() {
	return "admin/login";
}
@RequestMapping("/Login")
public String login(Admin admin,HttpSession session) {
	Admin a = adminService.login(admin);
	if(a!=null) {
		session.setAttribute("admin", a);
		return "redirect:/Shop/Admin/Index";
	}
	else
		return "/Admin/";
}
@RequestMapping("/Index")
public String index(HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect:/Admin/";
	}
	List<Goods> goods=adminService.getGoods();
		session.setAttribute("agoods", goods);
		return "admin/index";
}
@RequestMapping("Toaddgoods")
public String toaddgoods(Goods goods,HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect:/Admin/";
	}
	String p = goods.getPicture();
	String picture = "../images/goods/"+p;
	goods.setPicture(picture);
	boolean flag = adminService.addGoods(goods);
	if(flag)
		return "redirect:/Admin/Index";
	else
		return "redirect:/Admin/Addgoods";
}
@RequestMapping("/Addgoods")
public String addgoods(HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect://Admin/";
	}
	return "admin/addgoods";
}

@RequestMapping("/Toeditgoods")
public String toeditgoods(Goods goods,HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect:/Admin/";
	}
	String p = goods.getPicture();
	if(p.length()<= 0) {
		boolean flag = adminService.editgoods1(goods);
		if(flag) {
			session.setAttribute("amsg", "�޸ĳɹ���");
			return "redirect:/Admin/Index";
		}else {
			session.setAttribute("amsg", "�޸ĳɹ���");
			return "redirect:/Admin/Index";
		}
	}else {
		String picture = "../images/goods/"+p;
		goods.setPicture(picture);
		boolean flag = adminService.editgoods(goods);
		if(flag) {
			session.setAttribute("amsg", "�޸ĳɹ���");
			return "redirect:/Admin/Index";
		}else {
			session.setAttribute("amsg", "�޸ĳɹ���");
			return "redirect:/Admin/Index";
		}
	}
}

@RequestMapping("/Editgoodss")
public String editgoods(String idd,HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect:/Admin/";
	}
	Goods goods = goodsService.getGoodsDetail(Integer.parseInt(idd));
	if(goods!=null) {
		session.setAttribute("adetailgoods", goods);
		return "admin/editgoods";
	}else {
		return "redirect:/Admin/Index";
	}
}

@RequestMapping("/Order_list")
public String order_list(HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect:/Admin/";
	}
	List<UserGoods> userGoods = adminService.getUserGoods();
	if(userGoods!=null&&userGoods.size()>0) {
		session.setAttribute("aorder_list", userGoods);
		return "admin/order_list";
	}else
		return "redirect:/Admin/Index";
}

@RequestMapping("/Checkorder")
public String check(String dingdanhao,HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect:/Admin/";
	}
	List<UserGoods> userGoods = adminService.getUserOrder(Integer.parseInt(dingdanhao));
	if(userGoods!=null&&userGoods.size()>0) {
		double t =adminService.getTotals(Integer.parseInt(dingdanhao));
		session.setAttribute("T", t);
		session.setAttribute("adetailorder", userGoods);
		return "redirect:/Admin/Orderdetail";
	}
	else
		return "redirect:/Admin/Order_list";
}
@RequestMapping("/Orderdetail")
public String ooo(HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect:/Admin/";
	}
	return "admin/orderdetail";
}

@RequestMapping("/Fahuo")
public String fahuo(String dingdanhao,HttpSession session) {
	if(session.getAttribute("admin")==null) {
		return "redirect:/Admin/";
	}
	boolean flag = adminService.faHuo("�ѷ���", Integer.parseInt(dingdanhao));
	if(flag)
		return "redirect:/Admin/Order_list";
	else
		return "redirect:/Admin/Order_list";
}

@RequestMapping("/Adminout")
public String out(HttpSession session)
{
	session.removeAttribute("admin");
	return "redirect:/Admin/";
}

@RequestMapping("/Delete")
public String search(String idd) {
	adminService.delete(Integer.parseInt(idd));
	return "redirect:/Admin/Index";
}
}
