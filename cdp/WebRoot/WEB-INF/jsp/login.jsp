<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>政务云灾备服务平台</title>
<link href="logincss/assets/css/common.css" rel="stylesheet" type="text/css" />
<link href="logincss/assets/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="logincss/assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="logincss/assets/js/jquery.min.js"></script>
<script type="text/javascript">
var w,h,className;
function getSrceenWH(){
	w = $(window).width();
	h = $(window).height();
	$('#dialogBg').width(w).height(h);
}

window.onresize = function(){  
	getSrceenWH();
}  
$(window).resize();  

$(function(){
	getSrceenWH();
	
	//显示弹框
	$('.box a').click(function(){
		className = $(this).attr('class');
		$('#dialogBg').fadeIn(300);
		$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
	});
	
	//关闭弹窗
	$('.claseDialogBtn').click(function(){
		$('#dialogBg').fadeOut(300,function(){
			$('#dialog').addClass('bounceOutUp').fadeOut();
		});
	});
});
</script>

</head>
<body onLoad="sendRequest()" >

<div class="videozz"></div>

    
<div class="box">

		
		<div id="dialogBg"></div>
		<div id="dialog" class="animated">
			<img class="dialogIco" width="50" height="50" src="logincss/assets/images/ico.png" alt="" />
			<div class="dialogTop">
				<a href="javascript:;" class="claseDialogBtn">关闭</a>
			</div>
			<s:form action="upPasswd"  theme="simple" >
			<input type="text" name="test" />
				<ul class="editInfos">
					<li><label><font color="#ff0000">* </font>用户名：<input type="text" name="loginname" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>原密码：<input type="password" name="loginpassword"   class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>新密码：<input type="password" name="newpassword"  class="ipt" /></label></li>
					<li><input type="submit" value="确认提交" class="submitBtn" /></li>
				</ul>
			</s:form>
		</div>
	<div class="box-a">
    <div class="m-2">
          <div class="m-2-1">
            <s:form action="tomain" theme="simple">
                <div class="m-2-2">
                   <input type="text" name="duser.loginname" placeholder="请输入账号" />
                </div>
                <div class="m-2-2">
                   <input type="password" name="duser.loginpassword" placeholder="请输入密码"/>
                </div>
              
                <div class="m-2-2">
                   <button type="submit" value="登录" /> 登录
                  
                </div>
          <div class="m-2-2">
			<button type="submit" /><a href="javascript:;" >修改密码</a>
			
		</div>
            </s:form>
            
       
          </div>
    </div>
    <div class="m-5"> 
    <div id="m-5-id-1"> 
    <div id="m-5-2"> 
    <div id="m-5-id-2">  
    </div> 
    <div id="m-5-id-3"></div> 
    </div> 
    </div> 
    </div>   
    <div class="m-10"></div>
    <div class="m-xz7"></div>
    <div class="m-xz8 xzleft"></div>
    <div class="m-xz9"></div>
    <div class="m-xz9-1"></div>
    <!-- <div class="m-x10"></div>
    <div class="m-x11"></div>
    <div class="m-x12 xzleft"></div>
    <div class="m-x13"></div>
    <div class="m-x14 xzleft"></div>
    <div class="m-x15"></div>
    <div class="m-x16 xzleft"></div>-->
    <div class="m-x17 xzleft"></div>
    <div class="m-x18"></div>
    <div class="m-x19 xzleft"></div>
    <div class="m-x20"></div>  
    <div class="m-8"></div>
    <div class="m-9"><div class="masked1" id="sx8">政务云灾备服务平台</div></div> 
    <div class="m-11">
    	<div class="m-k-1"><div class="t1"></div></div>
        <div class="m-k-2"><div class="t2"></div></div>
        <div class="m-k-3"><div class="t3"></div></div>
        <div class="m-k-4"><div class="t4"></div></div>
        <div class="m-k-5"><div class="t5"></div></div>
        <div class="m-k-6"><div class="t6"></div></div>
        <div class="m-k-7"><div class="t7"></div></div>
    </div>   
    <div class="m-14"><div class="ss"></div></div>
    <div class="m-15-a">
    <div class="m-15-k">
    	<div class="m-15xz1">
            <div class="m-15-dd2"></div>
        </div>
    </div>
    </div>
    <div class="m-16"></div>
    <div class="m-17"></div>
    <div class="m-18 xzleft"></div>
    <div class="m-19"></div>
    <div class="m-20 xzleft"></div>
    <div class="m-21"></div>
    <div class="m-22"></div>
    <div class="m-23 xzleft"></div>
    <div class="m-24" id="localtime"></div>
    </div>
</div>
<script src="logincss/assets/js/common.min.js"></script>
<div style="text-align:center;">
<p></p>
</div>
</body>
</html>
