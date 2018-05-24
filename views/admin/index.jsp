<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台管理系统</title>
    <meta name="author" content="DeathGhost" />
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <!--[if lt IE 9]>
    <script src="../../js/html5.js"></script>
    <![endif]-->
    <script src="../../js/jquery.js"></script>
    <script src="../../js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script>
    $(document).ready(function(){
    	var number=$("#msg").value();
    	if(number==""){
    		return;
    	}else{
    		alert(number);
    		return;
    	}
    });
		$(document)
        (function($){
            $(window).load(function(){

                $("a[rel='load-content']").click(function(e){
                    e.preventDefault();
                    var url=$(this).attr("href");
                    $.get(url,function(data){
                        $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                        //scroll-to appended content
                        $(".content").mCustomScrollbar("scrollTo","h2:last");
                    });
                });

                $(".content").delegate("a[href='top']","click",function(e){
                    e.preventDefault();
                    $(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
                });

            });
        })(jQuery);
    </script>
</head>
<body>
<!--header-->
<header>
<input type="hidden" id="msg" value="${amsg}">

    <h1><img src="../../images/admin_logo.png"/></h1>
    <ul class="rt_nav">
        <li><a href="#" class="clear_icon">清除缓存</a></li>
        <li><a href="#" class="admin_icon">${admin.adminname }</a></li>
        <li><a href="#" class="set_icon">账号设置</a></li>
        <li><a href="http://localhost:8080/Shop/Admin/Adminout" class="quit_icon">安全退出</a></li>
    </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
    <h2><a href="#"></a></h2>
    <ul>
        <li>
            <dl>
                <dt>商品</dt>
                <!--当前链接则添加class:active-->
                <dd><a href="http://localhost:8080/Shop/Admin/Index" class="active">商品列表</a></dd>
                <dd><a href="http://localhost:8080/Shop/Admin/Addgoods">添加商品</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>订单信息</dt>
                <dd><a href="http://localhost:8080/Shop/Admin/Order_list">订单列表</a></dd>
            </dl>
        </li>
    </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">商品列表</h2>
            <a href="http://localhost:8080/Shop/Admin/Addgoods" class="fr top_rt_btn add_icon">添加商品</a>
        </div>
        <form action="Search" method="post">
        <section class="mtb">
            <input type="text" name="search" class="textbox textbox_225" placeholder="输入产品关键词..."/>
            <input type="submit" value="查询" class="group_btn"/>
        </section>
         </form>
        <table class="table">
            <tr>
                <th>序号</th>
                <th>商品名称</th>
                <th>商品图</th>
                <th>描述</th>
                <th>单价</th>
                <th>种类</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${agoods }" var="agoods">
            <tr>
                <td class="center">${agoods.idd }</td>
                <td class="center">${agoods.goodsname }</td>
                <td class="center"><img src="${agoods.picture }" width="60" height="60"/></td>
                <td class="center">${agoods.describe }</td>
                <td class="center">${agoods.price }</td>
                <td class="center">${agoods.type }</td>
                <td class="center">
                    <a href="http://localhost:8080/Shop/Admin/Editgoodss?idd=${agoods.idd }" title="编辑" class="link_icon">&#101;</a>
                    <a href="javascript:void(0);"  onclick="deletes(${agoods.idd })" title="下架" class="link_icon">&#100;</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        
    </div>
</section>
<script type="text/javascript">
function deletes(id){
	if(confirm("确定删除吗？")){
		window.location.href="http://localhost:8080/Shop/Admin/Delete/?idd="+id;
	}
}
	
</script>
</body>
</html>