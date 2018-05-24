<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
       <h2 class="fl">修改商品</h2>
       <a href="http://localhost:8080/Shop/Admin/Index" class="fr top_rt_btn">返回产品列表</a>
      </div>
     <section>
      <form action="Toeditgoods"  enctype="multipart/form-data">
      <input type="hidden" name="idd" value="${adetailgoods.idd }">
      <ul class="ulColumn2">
       <li>
        <span class="item_name" style="width:120px;">商品名称：</span>
        <input name="goodsname" type="text" class="textbox textbox_295" value="${adetailgoods.goodsname }"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">商品描述：</span>
        <input name="describe" type="text" class="textbox" value="${adetailgoods.describe }"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">种类：</span>
        <input name="type" type="text" class="textbox" value="${adetailgoods.type }"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">单价：</span>
        <input name="price" type="text" class="textbox" value="${adetailgoods.price }"/>
       </li>
       <li>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <img src="${adetailgoods.picture }" width="100" height="150"/></li>
       <li>
        <span class="item_name" style="width:120px;">更换图片：</span>
        <label class="uploadImg">
         <input type="file" name="picture"/>
         <span>更换图片</span>
        </label>
       </li>
      <li>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       &nbsp;&nbsp;&nbsp;
       <input type="submit" value="确定"  class="group_btn"/>
      </li>
      </ul>
      </form>
     </section>
 </div>
</section>
</body>
</html>