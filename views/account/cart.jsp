<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-购物车</title>
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
		<a href="http://localhost:8080/Shop/Home/" class="logo fl"><img src="../../images/logo.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;购物车</div>
		<div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>		
	</div>
<form action="Tocartpay" name="frm">
	<div class="total_count">全部商品<em>${N }</em>件</div>	
	<ul class="cart_list_th clearfix">
		<li class="col01">商品名称</li>
		<li class="col02">商品单位</li>
		<li class="col03">商品价格</li>
		<li class="col04">数量</li>
		<li class="col05">小计</li>
		<li class="col06">操作</li>
	</ul>
	<c:forEach items="${cart }" var="cart">
	<ul class="cart_list_td clearfix">
		<li class="col01"><input type="checkbox" name="delid" value="${cart.id }" checked></li>
		<li class="col02"><img src="../../${cart.picture }"></li>
		<li class="col03">${cart.goodsname }<br><em>${cart.price }元/500g</em></li>
		<li class="col04">500g</li>
		<li class="col05">${cart.price }元</li>
		<li class="col06">
				<span >${cart.number }</span>
		</li>
		<li class="col07">${cart.total }元</li>
		<li class="col08"><a href="javascript:void(0);" onclick="deleteid(${cart.id })">删除</a></li>
	</ul>
</c:forEach>
	<ul class="settlements">
<!-- 		<li class="col02"><button type="button" class="btn btn-danger btn-xs" onClick="checkdel(frm.delid,frm)">删除</button></li> -->
		<li class="col01"><input  type="checkbox"
                onClick="CheckAll(frm.delid,frm.checkbox)" checked> 全选</li>
       <li class="col02"><button type="button" class="btn btn-danger btn-xs" onClick="checkdel(frm.delid,frm)">删除</button></li>
		<div id="ch" style="display: none">
                <input name="delid" type="checkbox" value="0">
         </div>
		<li class="col03">合计(不含运费)：<span>¥</span><em>${M }</em><br>共计<b>${N }</b>件商品</li>
		<li class="col04"><a href="javascript:void(0);" onclick="sub(frm.delid,frm)">去结算</a></li>
	</ul>
	</form>
<script type="text/javascript">
function CheckAll(elementsA, elementsB) {
    for (i = 0; i < elementsA.length; i++) {
        elementsA[i].checked = true;
    }
    if (elementsB.checked == false) {
        for (j = 0; j < elementsA.length; j++) {
            elementsA[j].checked = false;
        }
    }
}
function checkdel(delid, formname) {
    var flag = false;
    for (i = 0; i < delid.length; i++) {
        if (delid[i].checked) {
            flag = true;
            break;
        }
    }
    if (!flag) {
        alert("请选择要删除的记录！");
        return false;
    } else {
        if (confirm("确定要删除吗？")) {
            formname.submit();
        }
    }
}

function sub(delid,formname){
	var flag = false;
    for (i = 0; i < delid.length; i++) {
        if (delid[i].checked) {
            flag = true;
            break;
        }
    }
    if (!flag) {
        alert("请选择要付款的商品！");
        return false;
    } else {
        if (confirm("确定要付款吗？")) {
            formname.submit();
        }
    }
}
function deleteid(id){
	if (confirm("确定要删除吗？")) {
		 window.location.href="http://localhost:8080/Shop/Account/Deletecart?id="+id;
    }
	
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