<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-提交订单</title>
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
// $(document).ready(function(){
// 	var number=$("#number").text();
// 	var price=$("#price").text();
// 	$("#total").text(parseFloat(price)*parseInt(number));
// 	$("#totala").text(parseFloat(price)*parseInt(number));
// 	var total = $("#totala").text();
// 	$("#totals").text(parseFloat(price)*parseInt(number)+10);
// });
</script>
	<div class="header_con">
		<div class="header">
			<div class="welcome fl">欢迎来到天天生鲜!</div>
			<div class="fr">
			<c:choose>
			<c:when test="${ user !=null }">
				<div class="login_info fl">
					欢迎您：<em>${user.username}</em>
				</div>
				<div class="user_link fl">
					<span>|</span>
					<a href="http://localhost:8080/Shop/Account/Userinfo">用户中心</a>
					<span>|</span>
					<a href="http://localhost:8080/Shop/Account/Tocart?uid=${user.id }">我的购物车</a>
					<span>|</span>
					<a href="http://localhost:8080/Shop/Account/User_order">我的订单</a>
					<span>|</span>
					<a href="http://localhost:8080/Shop/Account/Userout">退出</a>
				</div>
			</c:when>
			<c:otherwise>
			<div class="login_btn fl">
					<a href="http://localhost:8080/Shop/Account/">登录</a>
					<span>|</span>
					<a href="http://localhost:8080/Shop/Account/Register1">注册</a>
			</div>
			</c:otherwise>
		</c:choose>
			</div>
		</div>		
	</div>

	<div class="search_bar clearfix">
		<a href="http://localhost:8080/Shop/Home/" class="logo fl"><img src="../images/logo.png"></a>
		<div class="search_con fl">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>
	</div>
	
	<h3 class="common_title">确认收货地址</h3>

	<div class="common_list_con clearfix">
		<dl>
			<dt>寄送到：</dt>
			<dd><input type="radio" name="" checked="">${user.address }（${user.username } 收） ${user.phone }</dd>
		</dl>
		<a href="user_center_site.html" class="edit_site">编辑收货地址</a>

	</div>
	
	<h3 class="common_title">支付方式</h3>	
	<div class="common_list_con clearfix">
		<div class="pay_style_con clearfix">
			<input type="radio" name="pay_style" checked>
			<label class="cash">货到付款</label>
			<input type="radio" name="pay_style">
			<label class="weixin">微信支付</label>
			<input type="radio" name="pay_style">
			<label class="zhifubao"></label>
			<input type="radio" name="pay_style">
			<label class="bank">银行卡支付</label>
		</div>
	</div>

	<h3 class="common_title">商品列表</h3>
	
	<div class="common_list_con clearfix">
		<ul class="goods_list_th clearfix">
			<li class="col01">商品名称</li>
			<li class="col02">商品单位</li>
			<li class="col03">商品价格</li>
			<li class="col04">数量</li>
			<li class="col05">小计</li>		
		</ul>
		<ul class="goods_list_td clearfix">
			<li class="col01">1</li>			
			<li class="col02"><img src="${detail[0].picture }"></li>
			<li class="col03">${detail[0].goodsname }</li>
			<li class="col04">500g</li>
			<li  class="col05"><span id="price">${detail[0].price }</span>元</li>
			<li  class="col06"><span id="number">${detail[0].number }</span></li>
			<li class="col07"><span id="total"></span></li>	
		</ul>
	</div>

	<h3 class="common_title">总金额结算</h3>

	<div class="common_list_con clearfix">
		<div class="settle_con">
			<div class="total_goods_count">共<em>${n }</em>件商品，总金额<b><span id="totala">${detail[0].total }</span>元</b></div>
			<div class="transit">运费：<b><span id="yunfei">10</span>元</b></div>
			<div class="total_pay">实付款：<b><span id="totals"></span>${detail[0].total+10 }元</b></div>
		</div>
	</div>

	<div class="order_submit clearfix">
		<a href="http://localhost:8080/Shop/Account/Topay?dingdanhao=${detail[0].dingdanhao }" id="order_btn">确认支付</a>
	</div>	

	<div class="footer">
		<div class="foot_link">
			<a href="#">关于我们</a>
			<span>|</span>
			<a href="#">联系我们</a>
			<span>|</span>
			<a href="#">招聘人才</a>
			<span>|</span>
			<a href="#">友情链接</a>		
		</div>
		<p>CopyRight © 2016 北京天天生鲜信息技术有限公司 All Rights Reserved</p>
		<p>电话：010-****888    京ICP备*******8号</p>
	</div>

	<div class="popup_con">
		<div class="popup">
			<p>支付成功！</p>
		</div>
		
		<div class="mask"></div>
	</div>
	<script type="text/javascript" src="js/jquery-1.12.2.js"></script>
	<script type="text/javascript">
		$('#order_btn').click(function() {
			localStorage.setItem('order_finish',2);

			$('.popup_con').fadeIn('fast', function() {

				setTimeout(function(){
					$('.popup_con').fadeOut('fast',function(){
						window.location.href = 'index.html';
					});	
				},3000)
				
			});
		});
		
		
	</script>
</body>
</html>