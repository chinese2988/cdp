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
	
	<link href="Materia.css" rel="stylesheet">
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
					  
					  <li><a href="#">资源申请</a></li>
					  <li><a class="active">服务申请</a></li>
					  
					</ol> 
									
		</div>
            <div id="page-inner">

			
                <div class="card">
                        <div class="card-action">
                           
						服务申请
								
					
                        </div>
                        <div class="card-content">
                           <div class="col">
							  <ul class="tabs">
								<li class="tab col s3"><a  href="#test1">服务查询</a></li>
								<li class="tab col s3"><a  class="active" href="#test2">服务申请</a></li>
								
							  </ul>
							</div>
							<div class="clearBoth"><br/></div>
							
							<div id="test1" class="col s12">
					
				<div><table width="80%" style="text-align:center;">
					<tr >
					<td width="10%" class="center">
					选择部门
					</td>
					<td width="15%" class="center">
					<select style="display:block" name="fwsqbcx.bmmc">
						 <s:iterator value="fwsqbcxbmmcbybmbhs" var="fwsqbcx">
						  <option value="<s:property value='#fwsqbcx.bmmc'  />" selected="selected"><s:property value='#fwsqbcx.bmmc'  /></option>
						  </s:iterator>
						</select>
					
					</td>
					
					<td width="10%" class="center">
					业务系统
					</td>
					<td width="10%" class="center">
							<select style="display:block" name="fwsqbcx.xtmc">
						 <s:iterator value="fwsqbcxxtmcs" var="fwsqbcx">
						  <option value="<s:property value='#fwsqbcx.xtmc'  />" selected="selected"><s:property value='#fwsqbcx.xtmc'  /></option>
						  </s:iterator>
						</select>
						
					</td>
					
					<td width="10%" class="center">
					选择状态
					</td>
					<td width="10%" class="center">
							<select style="display:block" name="fwbjbz">
						  <option value="N" >待送审</option>
						 
						  <option value="Y">已送审</option>
						  
						</select>
					</td>
					<td width="15%" class="center">  
					<a class="waves-effect waves-light btn" href="#" onclick="btn2()">查询</a>
					</td>
					</tr>
				</table>
				</div>
				<div class="clearBoth"><br/></div>
				<div class="table-responsive">

							 <table class="table  table-hover" >
                                   <thead>
                                        <tr>
                                            <th class="center">序号</th>
                                            <th class="center">编号</th>
                                            <th class="center">部门</th>
											<th class="center">业务系统</th>
                                            <th class="center">云服务商</th>
                                            <th class="center">状态</th>
                                             <th class="center">流程状态</th>
                                            <th class="center">创建人</th>
											<th class="center">申请时间</th>
											<th class="center">操作</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <s:iterator value="fwsqbcxs" var="fwsqbcx">
                    	
			                        <tr class="odd gradeX" onmouseover="this.style.background='#e9f0b2'" onmouseout="this.style.background=''">
			                          <td class="center"><s:property value="#fwsqbcx.xuhao" /></td>
			                             <td class="center"><s:property value="#fwsqbcx.sqdbh" /></td>
			                            <td class="center"><s:property value="#fwsqbcx.bmmc" /></td>
			                            <td class="center"><s:property value="#fwsqbcx.xtmc"/></td>
			                            <td class="center"><s:property value="#fwsqbcx.ccwz"/> </td>
			                              <td class="center">
			                               <s:if test="#fwsqbcx.bjbz == 'N'">
			                              	待送审
			                              </s:if>
			                              <s:if test="#fwsqbcx.bjbz == null">
			                              	待送审
			                              </s:if>
			                              <s:if test="#fwsqbcx.bjbz == 'Y'">
			                              	已送审
			                              </s:if>
			                              </td>
			                                <td class="center">
			                               <s:if test="#fwsqbcx.lcdm==1">
			                              	服务申请
			                              </s:if>
			                              
			                              </td>
			                           <td class="center"> 
			                         <s:property value="#fwsqbcx.create_by"/></td>
                            			<td class="center">
			                           <s:property value="#fwsqbcx.create_date"/>
			                           </td>
			                           
			                         <td class="center"><a href="fwchaxun?sqdbhs='<s:property value="#fwsqbcx.sqdbh" />'" title="详情查询" class="material-icons dp48">settings_backup_restore</a> 
											
			                        
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
										 <a href="fwsqb?pageNow=1">首页</a>
										 <a href="fwsqb?pageNow=<s:property value="pageNow-1"/>">上一页</a>
										</s:else>
										
									<s:iterator begin="startPage" end="endPage" var="i">
									<s:if test="pageNow==#i">
									 <span > <a href="#"><s:property value="#i" /></a></span>
									</s:if>
									<s:else>
									<a href="fwsqb?pageNow=<s:property value="#i"/>"><s:property value="#i" /></a>
									</s:else>
								 
								  </s:iterator>
								  
								  
								  		<s:if test="pageNow >= totalPage">
										            <a href="#">下一页</a>  
										            <a href="#" class="pager">尾页</a>
										 </s:if>  
									        
										<s:else>
										 <a href="fwsqb?pageNow=<s:property value="pageNow+1"/>">下一页</a>
										 <a href="fwsqb?pageNow=<s:property value="totalPage"/>">尾页</a>
										</s:else>
								</div>
							</div>
							</div>
                            <div id="test2" class="col s12">
							
								<div class="card-action">
                           		 信息系统基本情况
                 			       </div>
                        
                        <div class="card-content">
						
							  <div class="row" style="border:1px solid #000">
							 
								<table  >
									<tr >
										<td class="center" width="10%">系统名称</td>
										<td class="center" colspan="7"  width="90%">
								
										<div class="input-field"><s:property value="fwsqb.xtmc" />
										<label for="xtmc_name"></label></div>
										
										</td>
										
									</tr>
									<tr>
										<td class="center" rowspan="2">使用单位</td>
										<td class="center" rowspan="2">
										
										
										<s:property value="fwsqb.bmmc" />
										
										</td>
										<td class="center">单位地址</td>
										<td class="center" colspan="5">
										
										<div class="input-field">
										<s:property value="fwsqb.apply_address" />
										<label for="dwdz_name"></label>
										</div>
										
										</td>
										
									</tr>
									<tr>
										
										<td class="center">单位联系人</td>
										<td class="center">
										<div class="input-field "><s:property value="fwsqb.apply_linkman" />
										
										<label for="dwyg_name"></label>
										</div>
										</td>
										<td class="center">手机</td>
										<td class="center">
										<div class="input-field ">
										<s:property value="fwsqb.apply_phone" />
										<label for="dwph_name"></label>
										</div>
										</td>
										<td class="center">邮箱</td>
										<td class="center">
										<div class="input-field ">
										
										<s:property value="fwsqb.apply_email" />
									    
										</div>
									    </td>
									
									</tr>
									<tr>
										
										<td class="center">承建/运维单位</td>
										<td class="center">
										<div class="input-field " >
										
										<s:property value="fwsqb.company" />
					
										</div>
										</td>
										<td class="center">公司联系人</td>
										<td class="center">
										<div class="input-field ">
										
										<s:property value="fwsqb.company_linkman" />
										
										</div>
										</td>
										<td class="center">手机</td>
										<td class="center">
										<div class="input-field">
										
											<s:property value="fwsqb.company_phone" />
										
										</div>
										</td>
										<td class="center">邮箱</td>
										<td class="center">
										<div class="input-field ">
										
									   	<s:property value="fwsqb.company_email" />
										</div>
									    </td>
									
									</tr>
									<tr>
										<td class="center" width="10%">系统功能</td>
										<td class="center" colspan="7"  width="90%">
										<div class="input-field"><textarea id="textarea" name="fwsqb.access_system_desc" placeholder="请输入文字" rows="" cols="" >
										<s:property value="fwsqb.access_system_desc" />
										</textarea>
											
										
										</div>
										
										</td>
										
									</tr>
									<tr>
										
										<td class="center">系统部署位置</td>
										<td class="center">
											<p>
											  <input name="cloud1" type="checkbox" id="H3C"  />
											  <label for="H3C">新华三</label>
											</p>
											<p>
											  <input name="cloud2" type="checkbox" id="SUSAN" />
											  <label for="SUSAN">曙光</label>
											</p>
											<p>
											  <input name="cloud3"  type="checkbox" id="INSUPER"  />
											  <label for="INSUPER">浪潮</label>
											</p>
											 
																				</td>
										<td class="center">备份数据类型</td>
										<td class="center">
											<p>
											  <input type="checkbox" id="db" name="bflx1" />
											  <label for="db">数据库</label>
											</p>
											<p>
											  <input type="checkbox" id="text"  name="bflx2"/>
											  <label for="text">文本文件</label>
											</p>
											<p>
											  <input type="checkbox"  id="other"  name="bflx3"/>
											  <label for="other">其他文件</label>
											</p>
											
																				</td>
										
										<td class="center">操作系统</td>
										<td class="center">
										<p>
											  <input name="system1" type="checkbox" id="system1" />
											  <label for="system1">linux</label>
											</p>
											<p>
											  <input name="system2" type="checkbox" id="system2" />
											  <label for="system2">windows</label>
											</p>
											<p>
											  <input class="system3"  type="checkbox" id="system3"  />
											  <label for="system3">其他</label>
											</p>
									    </td>
									    <td class="center">数据大小</td>
										<td class="center">
										<div class="input-field">
										<input  id="data_con" type="text" class="validate" name="fwsqb.standby_data_size">
										<label for="data_con">TB</label>
										</div>
										</td>
									
									</tr>
								</table>
								
							  </div>
						
					<div class="clearBoth"></div>

						<div class="card-action">
                           	 服务申请
                        </div>
							<div class="card-content" style="border:1px solid #000">

							<table >
								<tr >
									<td class="center">基础服务</td>
									<td class="left"> 
									<p>
											  <input name="base1" type="checkbox" id="one" />
											  <label for="one">同城一级灾备服务</label>
											 
									
											</p>
											<p>
											  <input name="base2" type="checkbox" id="two" />
											  <label for="two">同城二级灾备服务</label>
											</p>
											<p>
											  <input name="base3"  type="checkbox" id="three"  />
											  <label for="three">同城三级灾备服务</label>
											</p>
											<p>
											  <input name="base4"  type="checkbox" id="four"  />
											  <label for="four">同城四级灾备服务</label>
											</p>
											<p>
											  <input name="base5"  type="checkbox" id="five"  />
											  <label for="five">异地灾备服务</label>
											</p>
									
									</td>
									<td class="center">增值服务</td>
									<td class="center">
											<p>
											<input name="base6" type="checkbox" id="z_one" />
											  <label for="z_one">数据验证服务(次/年)</label>
											</p>
											<p>
											  <input name="base7" type="checkbox" id="z_two" />
											  <label for="z_two">数据灾备演练(次/年)</label>
											</p>
									
									</td>
									
								</tr>
								<tr >
								<td class="center" align="right"> 备份策略</td>
									<td class="center">
									<div class="input-field">
										<select style="display:block" name="bfcl">
										  <option value="每日增量" >每日增量</option>
										 
										  <option value="每日增量，每周全备" >每日增量，每周全备</option>
										  <option value="每日全备" >每日全备</option>
										  <option value="每日增量，每月全备" >每日增量，每月全备</option>
										  
										 
										</select>

									</div>
									</td>
								<td class="center"> 空间配额</td>
									<td class="center">
									<div class="input-field">
									<input  id="bf_pe" type="text" class="validate" name="kjpe">
										<label for="bf_pe">TB</label>
										</div>
									</td>
								</tr>

								<tr >
								<td></td>
									<td class="center">
									
									</td>
									
									<td class="center"> 
									
									</td>
									<td></td>
									
									
								</tr>
							
							</table>
							</div>
							</div>
							
					      <div class="clearBoth"></div>
					      
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
     <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script> 
	<script>
	$(document).ready(function(){
	 $('ul.tabs').tabs();
		$('.collapsible').collapsible({
		  accordion: false, // A setting that changes the collapsible behavior to expandable instead of the default accordion style
		  onOpen: function(el) { alert('Open'); }, // Callback for Collapsible open
		  onClose: function(el) { alert('Closed'); } // Callback for Collapsible close
		}
	  );
	});
	</script>
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


</body>

</html>