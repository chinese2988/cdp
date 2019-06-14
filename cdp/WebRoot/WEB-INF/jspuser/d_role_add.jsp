<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE >
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>角色授权</title>
<link rel="stylesheet" href="table/css/style.default.css" type="text/css" />
<script type="text/javascript" src="table/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="table/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="table/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="table/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="table/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="table/js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="table/js/plugins/charCount.js"></script>
<script type="text/javascript" src="table/js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="table/js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="table/js/custom/general.js"></script>
<script type="text/javascript" src="table/js/custom/forms.js"></script>

<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body >

 <script>
function getDactions(){
var selectedComs = document.getElementById("selectedComs");

for(var i=0;i<selectedComs.length;i++){
selectedComs.options[i].selected = true;
}

return true;
}
</script>
    
            <div class="centercontent">
        
        <div id="contentwrapper" class="contentwrapper">
        		 <div class="pageheader">
        		 <table width="80%">
        		 <tr>
        		 <td>
					 <h1 class="pagetitle">角色管理</h1> </td>
					
				
				</tr>
				</table>
				 </div><!--pageheader-->
 
					<div>
					<s:if test="id>0"> 
					<form id="form1" class="stdform"  action="upDrole" onsubmit="return getDactions()" method="post" >
					 	<p>
                        	<label>角色名称</label>
                            <span class="field">
                            <input type="text" name="drole.rolename" value="<s:property value="drole.rolename"/>"  /></span>
                        </p>
                        
                        <p>
                        	<label>角色类型</label>
                            <span class="field">
                            <select name="drole.rolestyle" id="selection">
                            	<option value="">Choose One</option>
                            	<option value="1900" <s:if test="drole.rolestyle==1900" >selected="selected"</s:if>> 后台管理</option>
                               <option value="2100" <s:if test="drole.rolestyle==2100" >selected="selected"</s:if>>主管单位管理</option>
                               <option value="2000" <s:if test="drole.rolestyle==2000" >selected="selected"</s:if>>用户单位管理</option>
                            </select>
                            </span>
                        </p>
                        
                                          
                        <p>
                        	<label>功能授权</label>
                            <span id="dualselect" class="dualselect">
                            	<select class="uniformselect"  multiple="multiple" size="20">
                                   <s:iterator value="dactions" var="daction">
                                    <option value="<s:property value="#daction.id" />"  selected="selected"><s:property value="#daction.actionname" /></option>
                                    </s:iterator>
                                </select>
                                <span class="ds_arrow">
                                	<span class="arrow ds_prev">&laquo;</span>
                                    <span class="arrow ds_next">&raquo;</span>
                                </span>
                                <select class="uniformselect"  id="selectedComs" name="selectedComs"  multiple="multiple" size="20">
                                	 <s:iterator value="details" var="drdetail">
                                    <option value="<s:property value="#drdetail.rolecontent" />" selected="selected"><s:property value="#drdetail.rolecontentdetail" /></option>
                                    </s:iterator>
                                </select>
                            </span> 
                        </p>
                        
                        <p class="stdformbutton">
                          <input  type="hidden" name="drole.id" value="<s:property value="drole.id" />"/>
                        	<button class="submit radius2">提交更新</button>
                        </p>
					
					</form>
					</s:if>
					<s:else>
					 <form id="form1" class="stdform"  action="addDrole" onsubmit="return getDactions()" method="post">
					
                    	<p>
                        	<label>角色名称</label>
                            <span class="field">
                            <input type="text" name="rolename" value="<s:property value="drole.rolename"/>"  /></span>
                        </p>
                        
                        <p>
                        	<label>角色类型</label>
                            <span class="field">
                            <select name="drole.rolestyle" id="selection">
                            	<option value="">Choose One</option>
                            	<option value="1900" <s:if test="drole.rolestyle==1900" >selected="selected"</s:if>> 用户单位管理</option>
                               <option value="2100" <s:if test="drole.rolestyle==2100" >selected="selected"</s:if>>主管用户单位管理</option>
                               <option value="2000" <s:if test="drole.rolestyle==2000" >selected="selected"</s:if>>主管单位管理</option>
                            </select>
                            </span>
                        </p>
                        
                                          
                        <p>
                        	<label>功能授权</label>
                            <span id="dualselect" class="dualselect">
                            	<select class="uniformselect"  multiple="multiple" size="20">
                                   <s:iterator value="dactions" var="daction">
                                    <option value="<s:property value="#daction.id" />"  selected="selected"><s:property value="#daction.actionname" /></option>
                                    </s:iterator>
                                </select>
                                <span class="ds_arrow">
                                	<span class="arrow ds_prev">&laquo;</span>
                                    <span class="arrow ds_next">&raquo;</span>
                                </span>
                                <select class="uniformselect"  id="selectedComs" name="selectedComs"  multiple="multiple" size="20">
                                	 <s:iterator value="details" var="drdetail">
                                    <option value="<s:property value="#drdetail.rolecontent" />" selected="selected"><s:property value="#drdetail.rolecontentdetail" /></option>
                                    </s:iterator>
                                </select>
                            </span> 
                        </p>
                        
                        <p class="stdformbutton">
                        	<button class="submit radius2">提交更新</button>
                        </p>
                        
                    </form>
                    </s:else> 
					</div>
        	</div>
        </div>
	
    


</body>
</html>
