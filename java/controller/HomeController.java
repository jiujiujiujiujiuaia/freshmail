package controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Goods;
import service.GoodsService;
import service.UserService;


@Controller
@RequestMapping("/Shop/Home")
public class HomeController {
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/")
	public String index(HttpSession session) {
		List<Goods> goods1 =goodsService.getGoods("新鲜水果");
		if(goods1!=null&&goods1.size()>0)
			session.setAttribute("goods1", goods1);
		List<Goods> goods2 =goodsService.getGoods("海鲜水产");
		if(goods2!=null&&goods2.size()>0)
			session.setAttribute("goods2", goods2);
		List<Goods> goods3 =goodsService.getGoods("猪肉羊肉");
		if(goods3!=null&&goods3.size()>0)
			session.setAttribute("goods3", goods3);
		int N = goodsService.getNumber(1, 0);
		session.setAttribute("N", N);
		return "home/index";
	}
//	public void goods(HttpSession session) {
//		List<Goods> goods =goodsService.getGoods("����ˮ��");
//		if(goods!=null&&goods.size()>0)
//			session.setAttribute("goods1", goods);
//	}
}
