<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>成都市政务数据灾备服务平台</title>
	
	<<link href="Materia.css" rel="stylesheet">
	<link rel="stylesheet" href="assets/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
 <link href='OpenSans.css' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css"> 
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                
                <a class="navbar-brand waves-effect waves-dark" href="tomain">成都市灾备服务平台</a>
				
		<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

           
        </nav>
		<!-- Dropdown Structure -->
<ul id="dropdown1" class="dropdown-content">

<li><a href="#"><i class="fa fa-gear fa-fw"></i> 信息设置</a>
</li> 
<li><a href="outLogin"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
</li>
</ul>
<ul id="dropdown2" class="dropdown-content w250">
  <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> 信息任务系统告警
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 信息任务系统告警
                                    <span class="pull-right text-muted small">12 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> 信息任务系统告警
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> 信息任务系统告警
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> 信息任务系统告警
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>任务告警详细查询</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
</ul>
<ul id="dropdown3" class="dropdown-content dropdown-tasks w250">
<li>
		<a href="#">
			<div>
				<p>
					<strong>信息系统资源申请</strong>
					<span class="pull-right text-muted">60% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
						<span class="sr-only">60% Complete (success)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>信息系统资源申请</strong>
					<span class="pull-right text-muted">28% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="28" aria-valuemin="0" aria-valuemax="100" style="width: 28%">
						<span class="sr-only">28% Complete</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>信息系统资源申请</strong>
					<span class="pull-right text-muted">60% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
						<span class="sr-only">60% Complete (warning)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>信息系统资源申请</strong>
					<span class="pull-right text-muted">85% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
						<span class="sr-only">85% Complete (danger)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li> 
	<li>
                            <a class="text-center" href="#">
                                <strong>资源申请详细查询</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
	<li>
</ul>   
<ul id="dropdown4" class="dropdown-content dropdown-tasks w250">
  <li>
                            <a href="#">
                                <div>
                                    <strong>John Doe</strong>
                                    <span class="pull-right text-muted">
                                        <em>2019-05-12 12:00:00</em>
                                    </span>
                                </div>
                                <div>完成信息系统的故障处理</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>2019-05-11 12:00:00</em>
                                    </span>
                                </div>
                                <div>完成信息系统的重点保障</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>2019-05-11 12:00:00</em>
                                    </span>
                                </div>
                                <div>完成信息系统的故障处理</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>维护管理详细查询</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
</ul> 
<!-- Dropdown Structure -->
 
	   <!--/. NAV TOP  -->

       <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
             		 
                  
            <s:iterator value="adparentIds" id="da" >
				 
					<li><a href="#<s:property value="#da.strutsaction"/>" class="active-menu waves-effect waves-dark"> <i class="fa fa-desktop"></i> <s:property
								value="#da.actionname" />
						</a>
						<ul id="<s:property value="#da.strutsaction"/>" class="nav nav-second-level">
							<s:iterator value="dacs" id="daction">

							<s:if test="#da.parentid==#daction.parentid">
								<li><a href="<s:property value="#daction.strutsaction"/>"
									target="_blank"> <s:property value="#daction.actionname" />
								</a>
								</li>
							</s:if>


						</s:iterator>
					</li>
					</ul>
					</s:iterator>
				</ul>
			
                


            </div>

        </nav>
        <!-- /. NAV SIDE  -->
      
		<div id="page-wrapper">
		  <div class="header"> 
                    
						<ol class="breadcrumb">
					  
					  <li><a href="#">系统管理</a></li>
					  <li class="active">用户管理</li>
					</ol> 
									
		</div>
            <div id="page-inner">

			
                <div class="row">
                     <!-- Advanced Tables -->
                    <div class="card">
                        <div class="card-action">
                             	<a href="toadd">用户管理</a>
                        </div>
                    <div class="card-content">
					<div>
					
				</div>
                            <div class="table-responsive">
                               <table class="table  table-hover" >
                                    <thead>
                                        <tr>
                                        
			                         	 <th class="center">序号</th>
			                        	
			                            <th class="center">登陆账户</th>
			                            <th class="center">姓名</th>
			                            <th class="center">电话</th>
			                            <th class="center">用户角色</th>
			                            <th class="center">所属机构</th>
			                            <th class="center">用户状态</th>
			                            <th class="center">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <s:iterator value="users" var="user">
                    	
			                        <tr class="odd gradeX" onmouseover="this.style.background='#e9f0b2'" onmouseout="this.style.background=''">
			                          <td class="center"><s:property value="#user.xuhao" /></td>
			                            <td class="center"><s:property value="#user.loginname" /></td>
			                            <td class="center"><s:property value="#user.name"/></td>
			                            <td class="center"><s:property value="#user.telephone"/> </td>
			                           <td class="center">
			                           <select name="user.userroleid" id="selection" style="display:block">
                            			<s:iterator value="droles" var="drole">
                            			<option value="<s:property value="#drole.id" />"  <s:if test="#drole.id==#user.userroleid" >selected="selected"</s:if>><s:property value="#drole.rolename" /></option>
                             			 </s:iterator>
			                           </td>
			                           <td class="center">
			                           <select name="user.bmbh" id="selection"   style="display:block">
                            	<s:iterator value="depts" var="dept">
                            	<option value="<s:property value="#dept.bmbh" />"  <s:if test="#dept.bmbh==#user.bmbh" >selected="selected"</s:if>><s:property value="#dept.bmmc" /></option>
                              </s:iterator>
			                           
			                           </td>
			                           <td class="center">
			                           <select name="user.userstat" id="selection " style="display:block">
                            	
                            	<option value="0"  <s:if test="0==#user.userstat" >selected="selected"</s:if>>正常状态</option>
                              <option value="1"  <s:if test="1==#user.userstat" >selected="selected"</s:if>>锁定状态</option>
                            </select>
			                           
			                            </td>
			                         <td class="center"><a href="toadd?id=<s:property value="#user.id" />" title="修改" class="material-icons dp48">settings_backup_restore</a> 
											<a  href="deluser?id=<s:property value="#user.id" />" title="删除" class="material-icons dp48">my_location</a></td>
			                        
			                        </tr>
			                        
			                       </s:iterator>
										
                                    </tbody>
                                </table>
								 <div class="digg">
										<s:if test="pageNow <= 1">
										            <a href="#">首页</a>  
										            <a href="#" class="pager">上一页</a>
										 </s:if>  
									        
										<s:else>
										 <a href="user?pageNow=1">首页</a>
										 <a href="user?pageNow=<s:property value="pageNow-1"/>">上一页</a>
										</s:else>
										
									<s:iterator begin="startPage" end="endPage" var="i">
									<s:if test="pageNow==#i">
									 <span > <a href="#"><s:property value="#i" /></a></span>
									</s:if>
									<s:else>
									<a href="user?pageNow=<s:property value="#i"/>"><s:property value="#i" /></a>
									</s:else>
								 
								  </s:iterator>
								  
								  
								  		<s:if test="pageNow >= totalPage">
										            <a href="#">下一页</a>  
										            <a href="#" class="pager">尾页</a>
										 </s:if>  
									        
										<s:else>
										 <a href="user?pageNow=<s:property value="pageNow+1"/>">下一页</a>
										 <a href="user?pageNow=<s:property value="totalPage"/>">尾页</a>
										</s:else>
								</div>
                            </div>
                            
                        </div>
                    </div>
		</div><!--/.row-->
			
		
				
				
		    <div class="col-md-8 col-sm-12 col-xs-12">
		
				<footer><p>Copyright &copy; 2019.Company name All rights reserved.</p>
				
        
				</footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
	
	<!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
	
	<script src="assets/materialize/js/materialize.min.js"></script>
	
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script> 


</body>

</html>