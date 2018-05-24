<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<a href="http://localhost:8080/Account/">登录</a>
					<span>|</span>
					<a href="http://localhost:8080/Account/Register1">注册</a>
			</div>
			</c:otherwise>
		</c:choose>
				<div class="user_link fl">
					<span>|</span>
					<a href="http://localhost:8080/Account/Userinfo">用户中心</a>
					<span>|</span>
					<a href="http://localhost:8080/Account/Tocart?uid=${user.id }">我的购物车</a>
					<span>|</span>
					<a href="http://localhost:8080/Account/User_order">我的订单</a>
					<span>|</span>
					<a href="http://localhost:8080/Account/Userout">退出</a>
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
				<li><a href="http://localhost:8080/Shop/Account/User_order" class="active">· 全部订单</a></li>
				<li><a href="http://localhost:8080/Shop/Account/User_site">· 收货地址</a></li>
			</ul>
		</div>
		<div class="right_content clearfix">
				<h3 class="common_title2">全部订单</h3>
				<c:forEach items="${dingdan }" var="dingdan">
				<ul class="order_list_th w978 clearfix">
					<li class="col01">${dingdan.xiadan_time }</li>
					<li class="col02">订单号：${dingdan.dingdanhao }</li>
					<li class="col02 stress">${dingdan.state }</li>		
				</ul>

				<table class="order_list_table w980">
					<tbody>
						<tr>
							<td width="55%">
								<ul class="order_goods_list clearfix">					
									<li class="col01"><img src="../../${dingdan.picture }"></li>
									<li class="col02">${dingdan.goodsname }<em>${dingdan.price }元/500g</em></li>	
									<li class="col03">${dingdan.number }个</li>
									<li class="col04">${dingdan.price }元</li>	
								</ul>
							</td>
							<td width="15%">${dingdan.total }元</td>
							<td width="15%">${dingdan.state }</td>
							<c:if test="${dingdan.state=='未付款'}">
							<td width="15%"><a href="http://localhost:8080/Shop/Account/Pay?dingdanhao=${dingdan.dingdanhao }" class="oper_btn">去付款</a></td>
							<td width="15%"><a href="http://localhost:8080/Shop/Account/Delete?dingdanhao=${dingdan.dingdanhao }" class="oper_btn">删除</a></td>
							</c:if>
							<c:if test="${dingdan.state=='已发货'}">
							<td width="15%"><a href="http://localhost:8080/Shop/Account/Shouhuo?dingdanhao=${dingdan.dingdanhao }" class="oper_btn">确认收货</a></td>
							<td width="15%"><a href="http://localhost:8080/Shop/Account/Delete?dingdanhao=${dingdan.dingdanhao }" class="oper_btn">删除</a></td>
							</c:if>
							<c:if test="${dingdan.state=='已收货'}">
							<td width="15%"><a href="http://localhost:8080/Shop/Account/Delete?dingdanhao=${dingdan.dingdanhao }" class="oper_btn">删除</a></td>
							</c:if>
							<c:if test="${dingdan.state=='待发货'}">
							<td width="15%"><a href="javascript:void(0);" onclick="tip()" class="oper_btn">催货</a></td>
							</c:if>
						</tr>
			
					</tbody>
				</table>
				</c:forEach>

				<div class="pagenation">
					<a href="#">上一页</a>
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">下一页></a>
				</div>
		</div>
	</div>
<script>
function tip(){
	alert("卖家已收到您的催货！");
	return;
}
</script>


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