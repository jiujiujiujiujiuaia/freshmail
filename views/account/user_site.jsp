<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-用户中心</title>
	<link rel="stylesheet" type="text/css" href="../../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../../css/main.css">
</head>
<body>
	<div class="header_con">
		<div class="header">
			<div class="welcome fl">欢迎来到天天生鲜!</div>
			<div class="fr">
			<c:choose>
			<c:when test="${ user !=null }">
				<div class="login_info fl">
					欢迎您：<em>${user.username}</em>
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
			</div>
		</div>		
	</div>

	<div class="search_bar clearfix">
		<a href="http://localhost:8080/Shop/Home/" class="logo fl"><img src="../images/logo.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
		<div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>		
	</div>

	<div class="main_con clearfix">
		<div class="left_menu_con clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="http://localhost:8080/Shop/Account/Userinfo" >· 个人信息</a></li>
				<li><a href="http://localhost:8080/Shop/Account/User_order" >· 全部订单</a></li>
				<li><a href="http://localhost:8080/Shop/Account/User_site" class="active">· 收货地址</a></li>
			</ul>
		</div>
		<div class="right_content clearfix">
				<h3 class="common_title2">收货地址</h3>
				<div class="site_con">
					<dl>
						<dt>当前地址：</dt>
						<dd>${user.address } （${user.username } 收）${user.phone }</dd>
					</dl>					
				</div>
				<h3 class="common_title2">编辑地址</h3>
				<div class="site_con">
					<form action="Edit">
					<input type="hidden" name="id" value="${user.id }">
					<input type="hidden" name="password" value="${user.password }">
						<div class="form_group">
							<label>收件人：</label>
							<input type="text" name="username" value="${user.username }">
						</div>
						<div class="form_group form_group2">
							<label>详细地址：</label>
							<input type="text" name="address" value="${user.address }"></textarea>
						</div>
						<div class="form_group">
							<label>手机：</label>
							<input type="text" name="phone" value="${user.phone }">
						</div>
						<input type="submit" name="" value="提交" class="info_submit">
					</form>
				</div>
		</div>
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
	
</body>
</html>