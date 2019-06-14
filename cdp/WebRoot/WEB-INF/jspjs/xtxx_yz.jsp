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
					  <li class="active">计费查询</li>
					</ol> 
									
		</div>
            <div id="page-inner">

			
                <div class="row">
                     <!-- Advanced Tables -->
                    <div class="card">
                        <div class="card-action">
                             	<a href="#">计费查询</a>
                        </div>
                    <div class="card-content">
                    <div><table width="80%" style="text-align:center;">
					<tr >
					
					<td width="10%" class="center">
					
					</td>
					<td width="15%" class="center">
					<select style="display:block" name="htkssjs">
					
							<s:iterator value="xtxxyzs2" var="xtxxyz2">
							
							
							<option value="<s:property value="#xtxxyz2.tjsj"  />" ><s:property value="#xtxxyz2.tjsj" /></option>
							
						
						 </s:iterator>
						</select>
					
					</td>
					
					<td width="15%" class="center">
					
					<a class="waves-effect waves-light btn" onclick="btn2()"  id="dosearchXtxx"  >查询</a>
					</td>
					</tr>
				</table>
				</div>
					<div>
					
				</div>
                            <div class="table-responsive">
                               <table class="table  table-hover" >
                                    <thead>
                                        <tr>
                                        
			                         	 <th class="center">序号</th>
			                        	
			                            <th class="center">系统名称</th>
			                            <th class="center">合同开始时间</th>
			                             <th class="center"> 合同结束时间</th>
			                              <th class="center"> 单位名称</th>
			                            <th class="center">服务目录代码</th>
			                            <th class="center">服务目录名称</th>
			                            <th class="center">服务单价</th>
			                            <th class="center">服务月数</th>
			                             <th class="center">服务价格合计</th>
			                            <th class="center">主机合计</th>
			                            <th class="center">合同空间(G)</th>
			                              <th class="center">使用容量(G)</th>
			                            <th class="center">剩余容量(G)</th>
			                            <th class="center">备份策略</th>
			                              <th class="center">云服务商</th>
			                            <th class="center">保留期限(月)</th>
			                            <th class="center">统计期号</th>
			                              <th class="center">数据状态</th>
			                            <th class="center">创建人</th>
			                            <th class="center">创建时间</th>
			                         
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <s:iterator value="xtxxyzs" var="xtxxyz">
                    	
			                        <tr class="odd gradeX" onmouseover="this.style.background='#e9f0b2'" onmouseout="this.style.background=''">
			                         <td class="center"><s:property value="#xtxxyz.xuhao" /></td>
			                        
										
										 <td class="center"><s:property value="#xtxxyz.xtmc"/></td>
										 <td class="center"><s:property value="#xtxxyz.htkssj"/></td>
										 <td class="center"><s:property value="#xtxxyz.htjssj "/></td>
									
										 <td class="center"><s:property value="#xtxxyz.dwmc"/></td>
										 <td class="center"><s:property value="#xtxxyz.fwmldm"/></td>
										 <td class="center"><s:property value="#xtxxyz.fwmlmc	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.fwdj	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.fwys	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.fwjghj	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.zjhj	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.ghrl	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.syrl	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.kxrl	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.bfcl	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.ccwz	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.blqx	   "/></td>
						
										 <td class="center"><s:property value="#xtxxyz.tjsj	   "/></td>
										 <td class="center"><s:property value="#xtxxyz.update_type "/></td>
										 <td class="center"><s:property value="#xtxxyz.create_by   "/></td>
										 <td class="center"><s:property value="#xtxxyz.create_date "/></td>
			                          
			                          
			                        
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
										 <a href="xtxxyz?pageNow=1">首页</a>
										 <a href="xtxxyz?pageNow=<s:property value="pageNow-1"/>">上一页</a>
										</s:else>
										
									<s:iterator begin="startPage" end="endPage" var="i">
									<s:if test="pageNow==#i">
									 <span > <a href="#"><s:property value="#i" /></a></span>
									</s:if>
									<s:else>
									<a href="xtxxyz?pageNow=<s:property value="#i"/>"><s:property value="#i" /></a>
									</s:else>
								 
								  </s:iterator>
								  
								  
								  		<s:if test="pageNow >= totalPage">
										            <a href="#">下一页</a>  
										            <a href="#" class="pager">尾页</a>
										 </s:if>  
									        
										<s:else>
										 <a href="xtxxyz?pageNow=<s:property value="pageNow+1"/>">下一页</a>
										 <a href="xtxxyz?pageNow=<s:property value="totalPage"/>">尾页</a>
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
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
function btn2(){
var inputs=document.getElementsByName("htkssjs");
  for( var i=0;i<inputs.length;i++){
    var input=inputs[i];
    var p='dosearchXtxx?htkssjs='+input.value;
   	document.getElementById("dosearchXtxx").href =p;
  
   }
}

</script>

</body>

</html>