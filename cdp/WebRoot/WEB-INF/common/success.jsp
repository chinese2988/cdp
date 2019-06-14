<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>操作正确</title>
<link rel="stylesheet" href="table/css/style.default.css" type="text/css" />
<script type="text/javascript" src="table/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="table/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="table/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="table/js/custom/general.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
<div class="bodywrapper">
    <div class="topheader orangeborderbottom5">
        <div class="left">
            <h1 class="logo"></h1>
            <span class="slogan">万国数据管理系统</span>
            
            
            
            <br clear="all" />
            
        </div><!--left-->
        
        
    </div><!--topheader-->
    
    
    <div class="contentwrapper padding10">
    	<div class="errorwrapper error404">
        	<div class="errorcontent">
                <h1>Page SUCCESS</h1>
                <h3><s:property value="message"/></h3>
                <button  class="stdbtn btn_yellow" onclick="winclose()">关闭</button>
                <br />
               
           		
            </div><!--errorcontent-->
        </div><!--errorwrapper-->
    </div>    
    
    
</div><!--bodywrapper-->
<script language="JavaScript" type="text/javascript">

	//弹出违规事实内容窗口
	function winclose(){
		
		
		window.close();
	}
	
</script>
</body>
</html>
