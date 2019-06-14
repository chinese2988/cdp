<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>用户管理</title>
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
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/plugins/excanvas.min.js"></script><![endif]-->
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

<body >

	     <div id="contentwrapper" class="contentwrapper">
        	
        	<div id="basicform" class="subcontent">
                                
                    
					<s:if test="id>0"> 
                    <form class="stdform" action="upuser" method="post">
                    	  <h5>用户管理</h5>
                       		 <p>
                        	<label>登陆名称</label>
                            <span class="field"><input type="text" name="user.loginname" value="<s:property value="user.loginname" />" class="smallinput" /></span>
                      		 </p>
                      		 <p>
                            <label>密码</label>
                            <span class="field"><input type="password" name="user.loginpassword" value="<s:property value="user.loginpassword" />" class="smallinput" /></span>
                      		</p>
                      	   <p>
                      		<label>姓名</label>
                            <span class="field"><input type="text" name="user.name" value="<s:property value="user.name" />" class="smallinput" /></span>
                           </p>
                           <p>
                            <label>联系方式</label>
                            <span class="field"><input type="text" name="user.telephone" value="<s:property value="user.telephone" />" class="smallinput" /></span>
                       </p>
                        <p>
                            <label>用户角色</label>
                            <span class="field">
                            <select name="user.userroleid" id="selection">
                            	<option value="">Choose One</option>
                            	<s:iterator value="droles" var="drole">
                            	<option value="<s:property value="#drole.id" />"  <s:if test="#drole.id==user.userroleid" >selected="selected"</s:if>><s:property value="#drole.rolename" /></option>
                              </s:iterator>
                            </select>
                            </span>
                        </p>
                        <p> 
                            <label>所属机构</label>
                            <span class="field">
                            <select name="user.bmbh" id="selection">
                            	<option value="">Choose One</option>
                            	<s:iterator value="depts" var="dept">
                            	<option value="<s:property value="#dept.bmbh" />"  <s:if test="#dept.bmbh==user.bmbh" >selected="selected"</s:if>><s:property value="#dept.bmmc" /></option>
                              </s:iterator>
                            </select>
                            </span>
                             <label>用户状态</label>
                            <span class="field">
                            <select name="user.userstat" id="selection">
                            	<option value="">Choose One</option>
                            	<option value="0"  <s:if test="0==user.userstat" >selected="selected"</s:if>>正常状态</option>
                              <option value="1"  <s:if test="1==user.userstat" >selected="selected"</s:if>>锁定状态</option>
                            </select>
                            </span>
                       </p>
                                     
                        <p class="stdformbutton">
                         <input  type="hidden" name="id" value="<s:property value="user.id" />"/>
                        	<button class="submit radius2" type="submit" >保存</button>
                           
                        </p>
                        
                        
                    </form>
                    </s:if>
                    
                    
                    <s:else>
                    
                       <form class="stdform" action="adduser" method="post">
                    	    <h5>用户管理</h5>
                       		 <p>
                        	<label>登陆名称</label>
                            <span class="field"><input type="text" name="user.loginname" value="<s:property value="user.loginname" />" class="smallinput" /></span>
                      		 </p>
                      		 <p>
                            <label>密码</label>
                            <span class="field"><input type="password" name="user.loginpassword" value="<s:property value="user.loginpassword" />" class="smallinput" /></span>
                      		</p>
                      	   <p>
                      		<label>姓名</label>
                            <span class="field"><input type="text" name="user.name" value="<s:property value="user.name" />" class="smallinput" /></span>
                           </p>
                           <p>
                            <label>联系方式</label>
                            <span class="field"><input type="text" name="user.telephone" value="<s:property value="user.telephone" />" class="smallinput" /></span>
                       </p>
                        <p>
                            <label>用户角色</label>
                            <span class="field">
                            <select name="user.userroleid" id="selection">
                            	<option value="">Choose One</option>
                            	<s:iterator value="droles" var="drole">
                            	<option value="<s:property value="#drole.id" />"  <s:if test="#drole.id==user.userroleid" >selected="selected"</s:if>><s:property value="#drole.rolename" /></option>
                              </s:iterator>
                            </select>
                            </span>
                        </p>
                        <p> 
                            <label>所属机构</label>
                            <span class="field">
                            <select name="user.bmbh" id="selection">
                            	<option value="">Choose One</option>
                            	<s:iterator value="depts" var="dept">
                            	<option value="<s:property value="#dept.bmbh" />"  <s:if test="#dept.bmbh==user.bmbh" >selected="selected"</s:if>><s:property value="#dept.bmmc" /></option>
                              </s:iterator>
                            </select>
                            </span>
                             <label>用户状态</label>
                            <span class="field">
                            <select name="user.userstat" id="selection">
                            	<option value="">Choose One</option>
                            	<option value="0"  <s:if test="0==user.userstat" >selected="selected"</s:if>>正常状态</option>
                              <option value="1"  <s:if test="1==user.userstat" >selected="selected"</s:if>>锁定状态</option>
                            </select>
                            </span>
                       </p>
                                     
                        <p class="stdformbutton">
                        
                        	<button class="submit radius2" type="submit" >保存</button>
                           
                        </p>
                    </form>
                    
                    </s:else>
                    <br />
                    
					</div>
        
        </div><!--contentwrapper-->

</body>
</html>
