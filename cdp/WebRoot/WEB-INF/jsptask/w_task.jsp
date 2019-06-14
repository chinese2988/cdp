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
                
                <a class="navbar-brand waves-effect waves-dark" href="index.html">成都市灾备服务平台</a>
				
		<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

           
        </nav>
		<!-- Dropdown Structure -->
<ul id="dropdown1" class="dropdown-content">

<li><a href="#"><i class="fa fa-gear fa-fw"></i> 信息设置</a>
</li> 
<li><a href="#"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
</li>
</ul>

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
					  
					  <li><a href="#">我的工单</a></li>
					  <li class="active">待签工单</li>
					</ol> 
									
		</div>
            <div id="page-inner">

			            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="card">
                        <div class="card-action">
                             	待签工单
                        </div>
                    <div class="card-content">
					<div><table width="80%" style="text-align:center;">
					<tr >
					<td width="10%" class="center">
						选择流程
					</td>
					<s:form  action="taskcha"  method="post" name="taskcha">
					<td width="15%" class="center">
					<select style="display:block" name="lcmc">
						  <option value="服务申请"   selected="selected">服务申请</option>
						 
						  <option value="服务取消">服务取消</option>
						  <option value="服务变更">服务变更</option>
						</select>
					
					</td>
					<td width="10%" class="center">
					创建时间(开始时间选择)
					</td>
					<td width="10%" class="center">
					<input type="text"  placeholder="请日期开始范围" id="startTime" name="startTime">
					</td>
					<td width="10%" class="center">
					创建时间(结束时间选择)
					</td>
					<td width="10%" class="center" >
					<input type="text"  placeholder="请日期结束范围" id="endTime" name="endTime">
					</td>
					<td width="15%" class="center">  
					<a class="waves-effect waves-light btn" href='javascript:document.taskcha.submit();'>查询</a>
					</td>
					</s:form>
					</tr>
				</table>
				</div>
                            <div class="table-responsive">
                               <table class="table  table-hover" >
                                    <thead>
                                        <tr>
                                            <th class="center">序号</th>
                                            <th class="center">标题</th>
                                            <th class="center">当前环节</th>
                                            <th class="center">流程名称</th>
                                            <th class="center">创建时间</th>
											<th class="center">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <s:iterator value="fwsqbcxs" var="fwsqbcx">
                                        <tr class="odd gradeX">
                                            <td class="center"><s:property value="#fwsqbcx.xuhao" /></td>
                                            <td class="center"><s:property value="#fwsqbcx.sqbt" /></td>
                                            <td class="center"><s:property value="#fwsqbcx.jdmc" /></td>
                                            <td class="center"><s:property value="#fwsqbcx.lcmc" /></td>
                                            <td class="center"><s:property value="#fwsqbcx.create_date" /></td>
											<td class="center"><a href="qianshou?sqdbh=<s:property value="#fwsqbcx.sqdbh" />" title="任务签收" class="material-icons dp48">settings_backup_restore</a> 
											<a  href="task_jindu01.html" title="任务跟踪" class="material-icons dp48">my_location</a></td>
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
										 <a href="task?pageNow=1">首页</a>
										 <a href="task?pageNow=<s:property value="pageNow-1"/>">上一页</a>
										</s:else>
										
									<s:iterator begin="startPage" end="endPage" var="i">
									<s:if test="pageNow==#i">
									 <span > <a href="#"><s:property value="#i" /></a></span>
									</s:if>
									<s:else>
									<a href="task?pageNow=<s:property value="#i"/>"><s:property value="#i" /></a>
									</s:else>
								 
								  </s:iterator>
								  
								  
								  		<s:if test="pageNow >= totalPage">
										            <a href="#">下一页</a>  
										            <a href="#" class="pager">尾页</a>
										 </s:if>  
									        
										<s:else>
										 <a href="task?pageNow=<s:property value="pageNow+1"/>">下一页</a>
										 <a href="task?pageNow=<s:property value="totalPage"/>">尾页</a>
										</s:else>
								</div>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                
			
                <!-- /. ROW  --> 
		
                    <div class="col-md-8 col-sm-12 col-xs-12">

		
				<footer><p>Copyright &copy; 2016.Company name All rights reserved.</p>
				
        
				</footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
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
	 <!-- DATA TABLE SCRIPTS -->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
  
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script> 
<script src="laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script>
lay('#version').html('-v'+ laydate.v);

//执行一个laydate实例
laydate.render({
  elem: '#startTime' //指定元素
});
laydate.render({
  elem: '#endTime' //指定元素
});
</script>

<script type="text/javascript">
function btn2(){
var inputs=document.getElementsByName("sed");
  for( var i=0;i<inputs.length;i++){
    var input=inputs[i];
    alert(input.value);
   }
}

</script>

</body>

</html>