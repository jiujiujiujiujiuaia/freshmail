<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-登录</title>
	<link rel="stylesheet" type="text/css" href="../../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../../css/main.css">
	<script type="text/javascript" src="../../js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="../../js/register.js"></script>
</head>
<body>
	<div class="login_top clearfix">
		<a href="http://localhost:8080/Shop/Home/" class="login_logo"><img src="../../images/logo02.png"></a>
	</div>

	<div class="login_form_bg">
		<div class="login_form_wrap clearfix">
			<div class="login_banner fl"></div>
			<div class="slogan fl">日夜兼程 · 急速送达</div>
			<div class="login_form fr">
				<div class="login_title clearfix">
					<h1>用户登录</h1>
					<a href="http://localhost:8080/Shop/Account/Register1">立即注册</a>
				</div>
				<div class="form_input">
					<form action="/Shop/Account/Login">
						<input  type="text" name="username" class="name_input" id="user_name" placeholder="请输入用户名">
						<span class="error_tip">提示信息</span>
						<input type="password" name="password"  class="pass_input" id="pwd" placeholder="请输入密码">
						<span class="error_tip">提示信息</span>
						<div class="more_input clearfix">
							<input type="checkbox" name="">
							<label>记住用户名</label>
						</div>
						<input type="submit" name="" value="登录" class="input_submit">
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="footer no-mp">
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