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
					  
					  <li><a href="#">资源计费</a></li>
					  <li class="active">服务单价</li>
					</ol> 
									
		</div>
            <div id="page-inner">

			
                <div class="row">
                     <!-- Advanced Tables -->
                    <div class="card">
                        <div class="card-action">
                             	<a href="#">服务单价</a>
                        </div>
                    <div class="card-content">
					<div>
					
				</div>
                            <div class="table-responsive">
                               <table class="table  table-hover" >
                                    <thead>
                                        <tr>
                                        
			                         	 <th class="center">序号</th>
			                        	
			                            <th class="center">服务类型</th>
			                            <th class="center">服务名称</th>
			                            <th class="center">RTO</th>
			                            <th class="center">RPO</th>
			                            <th class="center">备份方式</th>
			                            <th class="center">计费标准</th>
			                           
			                            <th class="center">服务单价</th>
			                            <th class="center">计价单位</th>
			                            <th class="center">备注</th>
			                            <th class="center">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <s:iterator value="fwmls" var="fwml">
                    	
			                        <tr class="odd gradeX" onmouseover="this.style.background='#e9f0b2'" onmouseout="this.style.background=''">
			                         <td class="center"><s:property value="#fwml.id" /></td>
			                         <td class="center">
			                           
                            		 <s:if test="#fwml.fwmllx==1" >基础服务</s:if>
                            		<s:if test="#fwml.fwmllx==2" >增值服务</s:if>
                             			
			                           </td>
			                          <td class="center"><s:property value="#fwml.fwmlmc" /></td>
			                            <td class="center"><s:property value="#fwml.rto" /></td>
			                            <td class="center"><s:property value="#fwml.rpo"/></td>
			                            <td class="center"><s:property value="#fwml.bffs"/> </td>
			                             <td class="center"><s:property value="#fwml.jfbz"/> </td>
			                              <td class="center"><s:property value="#fwml.fwdj"/> </td>
								<td class="center"><s:property value="#fwml.jjdw"/> </td>
								<td class="center"><s:property value="#fwml.remarks"/> </td>
			                          
			                          
			                         <td class="center"><a href="#" title="修改" class="material-icons dp48">settings_backup_restore</a> 
											<a  href="#" title="删除" class="material-icons dp48">my_location</a></td>
			                        
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
										 <a href="fwml?pageNow=1">首页</a>
										 <a href="fwml?pageNow=<s:property value="pageNow-1"/>">上一页</a>
										</s:else>
										
									<s:iterator begin="startPage" end="endPage" var="i">
									<s:if test="pageNow==#i">
									 <span > <a href="#"><s:property value="#i" /></a></span>
									</s:if>
									<s:else>
									<a href="fwml?pageNow=<s:property value="#i"/>"><s:property value="#i" /></a>
									</s:else>
								 
								  </s:iterator>
								  
								  
								  		<s:if test="pageNow >= totalPage">
										            <a href="#">下一页</a>  
										            <a href="#" class="pager">尾页</a>
										 </s:if>  
									        
										<s:else>
										 <a href="fwml?pageNow=<s:property value="pageNow+1"/>">下一页</a>
										 <a href="fwml?pageNow=<s:property value="totalPage"/>">尾页</a>
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