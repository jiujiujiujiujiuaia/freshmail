<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-注册</title>
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
	<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="../js/register.js"></script>
</head>
<body>
	<div class="register_con">
		<div class="l_con fl">
			<a href="http://localhost:8080/Shop/Home/" class="reg_logo"><img src="../images/logo02.png"></a>
			<div class="reg_slogan">足不出户  ·  新鲜每一天</div>
			<div class="reg_banner"></div>
		</div>

		<div class="r_con fr">
			<div class="reg_title clearfix">
				<h1>用户注册</h1>
				<a href="http://localhost:8080/Shop/Account/">登录</a>
			</div>
			<div class="reg_form clearfix">
				<form action="Register">
				<ul>
					<li>
						<label>用户名:</label>
						<input type="text" name="username" id="user_name">
						<span class="error_tip">提示信息</span>
					</li>					
					<li>
						<label>密码:</label>
						<input type="password" name="password" id="pwd">
						<span class="error_tip">提示信息</span>
					</li>
					<li>
						<label>确认密码:</label>
						<input type="password" name="cpwd" id="cpwd">
						<span class="error_tip">提示信息</span>
					</li>
					<li class="agreement">
						<input type="checkbox" name="allow" id="allow" checked="checked">
						<label>同意”天天生鲜用户使用协议“</label>
						<span class="error_tip2">提示信息</span>
					</li>
					<c:if test="${!empty err_username }">
						<div style="color:red;font-size:25px">${err_username}</div>
						</c:if>
						<c:if test="${!empty err_msg }">
						<div style="color:red;font-size:25px">${err_msg}</div>
						</c:if>
					<li class="reg_sub">
						<input type="submit" value="注 册">
					</li>
				</ul>				
				</form>
			</div>

		</div>

	</div>
<!-- <script type="text/javascript"> -->
<!-- // function Checkform(){ -->
<!-- // 	if(1==2) -->
<!-- // 		{ -->
<!-- // 		alert("44"); -->
<!-- // 		location.href="http://localhost:8080/Shop/Account/Register1" -->
<!-- // 		}else{ -->
<!-- // 			alert("55"); -->
<!-- // 			location.href="http://localhost:8080/Shop/Account/Register1" -->
<!-- // 		} -->
	
<!-- // } -->
<!-- </script> -->
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