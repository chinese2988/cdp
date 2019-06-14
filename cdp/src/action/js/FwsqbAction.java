package action.js;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import action.BaseAction;
import dao.fwsq.flow_blqkDao;
import dao.fwsq.fwsqdao;
import dao.user.actionDao;
import dao.user.departmentDao;
import dao.user.roleDao;
import entity.fwsq.flow_config;
import entity.fwsq.fwsqb;
import entity.fwsq.fwsqbcx;
import entity.fwsq.xtxx;
import entity.user.d_action;
import entity.user.d_role;
import entity.user.d_user;
import entity.user.department;

public class FwsqbAction extends BaseAction{
	private ArrayList<d_action> dacs;
	private ArrayList<d_action> adparentIds;
	private actionDao ad = new actionDao();
	private d_role dr;
	private roleDao rd = new roleDao();
	private int xuhao;//序号
	private int num; // 总数
	private int pageNow = 1; // 初始化为1,默认从第一页开始显示
	private int pageSize = 5; // 每页显示5条记录
	private int totalPage; // 总页数
	private int pageNum;// 页数
	// 开始页码
	private int startPage = 1;
	// 结束页码
	private int endPage = 10;
	private  d_role drole;
	private String bmbh;
	private ArrayList<fwsqbcx> fwsqbcxs;
	private fwsqbcx fwsqbcx;
	private fwsqb fwsqb;
	public fwsqb fwsqb2=new fwsqb();
	private ArrayList<fwsqbcx> fwsqbcxbmmcbybmbhs;
	private ArrayList<fwsqbcx> fwsqbcxxtmcs;
	private ArrayList<fwsqbcx> fwsqbcxlcmcs;
	private ArrayList<xtxx> xtxxs;
	private int xtxxsSize;//用于jsp页面判断系统是否存在
	private xtxx xtxx;
	
	private String cloud1; //jsp云checkbox选项状态值
	private String cloud2; //jsp云checkbox选项状态值
	private String cloud3; //jsp云checkbox选项状态值
	private String bflx1; //备份类型checkbox选项
	private String bflx2;//备份类型checkbox选项
	private String bflx3;//备份类型checkbox选项
	private String system1;//操作系统类型checkbox选项
	private String system2;//操作系统类型checkbox选项
	private String system3;//操作系统类型checkbox选项
	private String base1;//基础服务类型checkbox选项
	private String base2;//基础服务类型checkbox选项
	private String base3;//基础服务类型checkbox选项
	private String base4;//基础服务类型checkbox选项
	private String base5;//基础服务类型checkbox选项
	private String base6;//增值服务类型checkbox选项
	private String base7;//增值服务类型checkbox选项
	private String bfcl;//备份策略
	private String kjpe;//空间配额
	private String bmmc="";// 部門名稱
	private ArrayList<department> depts;//
	private int deptsSize;//用于jsp页面判断部门是否存在
	private department department;
	private String H3C;
	private String sqdbhs;
	
	
public ArrayList roles(String role){
		
		
		ArrayList roles=new ArrayList();
		String[] ro=role.split(",");
		for(int i=0;i<ro.length;i++){
			int p =Integer.parseInt(ro[i].toString());
			roles.add(p);
		}
		return roles;
	}

public String execute() {
	
	if (session.get("user_session") != null) {
		try {
			//用户登陆和权限判断
			 d_user u=(d_user) this.session.get("user_session");
			 dr= rd.findroleById(u.getUserroleid());
			 departmentDao dp=new departmentDao();
			 bmbh=u.getBmbh()+"";
			 bmmc=dp.findDeptById(bmbh);
			 
			adparentIds=ad.findparentIdS();
			 dacs=ad.findAllUser();
			 ArrayList roles=this.roles(dr.getRolecontent());
			 for(int i=0;i<dacs.size();i++){
				 	int pid=dacs.get(i).getParentid();
					int s=dacs.get(i).getId();
					for(int p=0;p<roles.size();p++){
						int ss=(Integer) roles.get(p);
						
						if(s==ss){
						
							dacs.get(i).setParentid(pid);
							break;
						}else{
							dacs.get(i).setParentid(0);
						}
					}
				}
				//END用户登陆和权限判断结束 
			fwsqdao ud=new fwsqdao();
			 
			 num=ud.sumb(bmbh);
			 if ((num % pageSize) / pageSize == 0) {
					totalPage = (num / pageSize) + 1;
				} else {
					totalPage = num / pageSize;
				}
			 // 显示页码计算
				
			 if (pageNow > 4) {  
		            startPage = pageNow - 4;  
		            endPage = pageNow + 5;  
		        }
			 
			 
			 if (endPage>totalPage){
				 if(totalPage>10)
					 {startPage=totalPage-9;}
				 else{endPage=totalPage;}
		    }
			 
			 if (startPage < 1) {  
		            startPage = 1;  
		        }  
		
			
			 drole=rd.findroleById(u.getUserroleid());
			 //通过权限控制查询条件
			 if(drole.getRolestyle()==1900){
				 fwsqbcxbmmcbybmbhs=ud.findAllBMMCbybmbh(bmbh);
				 fwsqbcxxtmcs=ud.findAllXTMCbybmbh(bmbh);
				 fwsqbcxlcmcs=ud.findAllLCMC(bmbh);
				 xtxxs=ud.findXtxxByBmbh(bmbh);
				 depts=ud.findALLDeptByBmbh(bmbh);
				 department=depts.get(0);
				 fwsqbcxs=ud.findAllUser(pageSize, pageNow, bmbh);
				 System.out.println(fwsqbcxs.size());
				 System.out.println(department.getBmmc());
				 xtxxsSize=xtxxs.size();
			 }else  if(drole.getRolestyle()==2000 || drole.getRolestyle()==2100){
				 fwsqbcxbmmcbybmbhs=ud.findAllBMMC();
				 fwsqbcxxtmcs=ud.findAllXTMCbybmbh();
				 fwsqbcxlcmcs=ud.findAllLCMC();
				 xtxxs=ud.findALLXtxx();
				 fwsqbcxs=ud.findAllUser(pageSize, pageNow);
				 System.out.println();
				 xtxxsSize=xtxxs.size();
				 depts=ud.findALLDept();
			 }
			 
			 return "fwsqb";
	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
			
	
	}else{
		return "login";
	}
}
public String zancun(){
	
	if (session.get("user_session") != null) {
		try {
			//用户登陆和权限判断
			 d_user u=(d_user) this.session.get("user_session");
			 dr= rd.findroleById(u.getUserroleid());
			 bmbh=u.getBmbh()+"";
			adparentIds=ad.findparentIdS();
			 dacs=ad.findAllUser();
			 ArrayList roles=this.roles(dr.getRolecontent());
			 for(int i=0;i<dacs.size();i++){
				 	int pid=dacs.get(i).getParentid();
					int s=dacs.get(i).getId();
					for(int p=0;p<roles.size();p++){
						int ss=(Integer) roles.get(p);
						
						if(s==ss){
						
							dacs.get(i).setParentid(pid);
							break;
						}else{
							dacs.get(i).setParentid(0);
						}
					}
				}
				//END用户登陆和权限判断结束 
	//服务申请
	fwsqb.setLcdm("01");
	
	//服务流程节点
	fwsqdao fd=new fwsqdao();
	String jddm;
	try {
		
		jddm = fd.findjddm(fwsqb.getBmmc(), fwsqb.getXtmc());
		if(jddm==""){
			fwsqb.setJddm(1);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//云服务商
	String ccwz="0";
	if(cloud1!=null){
		ccwz="H3C";
	}
	if(cloud2!=null){
		ccwz="曙光";
	}
	if(cloud3!=null){
		ccwz="浪潮";
	}
	if(cloud1!=null&&cloud2!=null){
		ccwz="H3C"+","+"曙光";
	}
	if(cloud1!=null&&cloud3!=null){
		ccwz="H3C"+","+"浪潮";
	}
	if(cloud2!=null&&cloud3!=null){
		ccwz="曙光"+","+"浪潮";
	}
	if(cloud1!=null&&cloud2!=null&&cloud3!=null){
		ccwz="H3C"+","+"曙光"+","+"浪潮";
	}
	fwsqb.setCcwz(ccwz);
	System.out.println(fwsqb.getCcwz().toString());
	
	//基础服务
	
	if(base1!=null){
		fwsqb.setTc_disaster_preparedness1("Y");
		fwsqb.setTc_dp1_backup_strategy(bfcl);
		fwsqb.setTc_dp1_space_quotas(kjpe);
		

	}
	if(base2!=null){
		fwsqb.setTc_disaster_preparedness2("Y");
		fwsqb.setTc_dp2_backup_strategy(bfcl);
		fwsqb.setTc_dp2_space_quotas(kjpe);
		

	}
	if(base3!=null){
		fwsqb.setTc_disaster_preparedness3("Y");
		fwsqb.setTc_dp3_backup_strategy(bfcl);
		fwsqb.setTc_dp3_space_quotas(kjpe);
	
	}
	if(base4!=null){
		fwsqb.setTc_disaster_preparedness4("Y");
		fwsqb.setTc_dp4_backup_strategy(bfcl);
		fwsqb.setTc_dp4_space_quotas(kjpe);
		
		
	}

	
	if(base5!=null){
		fwsqb.setRemote_disaster_preparedness("Y");
		fwsqb.setRemote_dp_backup_strategy2(bfcl);
		fwsqb.setRemote_dp_space_quotas2(kjpe);
		
		
	}
	//增值服务
	if(base6!=null){
		fwsqb.setData_validation_service("Y");
	}
	if(base7!=null){
		fwsqb.setData_disaster_preparedness_drill("Y");
	}
	
	
	//操作系统类型
	if(system1!=null){
		fwsqb.setOp_system_type("linux");
	}
	if(system2!=null){
		fwsqb.setOp_system_type("windows");
		}
	if(system3!=null){
		fwsqb.setOp_system_type("other");
	}
	if(system1!=null&&system2!=null){
		fwsqb.setOp_system_type("linux,windows");
	}
	if(system1!=null&&system3!=null){
		fwsqb.setOp_system_type("linux,other");
	}
	if(system2!=null&&system3!=null){
		fwsqb.setOp_system_type("windows,other");
	}
	if(system1!=null&&system2!=null&&system3!=null){
		fwsqb.setOp_system_type("linux,windows,other");
	}
	
	
	//备份类型
	if(bflx1!=null){
		fwsqb.setStandby_data_type("数据库");
	}
	if(bflx2!=null){
		fwsqb.setStandby_data_type("文本文件");
	}
	if(bflx3!=null){
		fwsqb.setStandby_data_type("其他文件");
	}
	if(bflx1!=null&&bflx2!=null){
		fwsqb.setStandby_data_type("数据库,文本文件");
	}
	if(bflx1!=null&&bflx3!=null){
		fwsqb.setStandby_data_type("数据库,其他文件");
	}
	if(bflx2!=null&&bflx3!=null){
		fwsqb.setStandby_data_type("文本文件,其他文件");
	}
	if(bflx1!=null&&bflx2!=null||bflx3!=null){
		fwsqb.setStandby_data_type("数据库,文本文件,其他文件");
	}
	
	//创建人
	fwsqb.setCreate_by(u.getName().toString());
	//创建时间
	
	
	// 执行业务逻辑2 更新系统信息表
	//赋值给系统信息
	System.out.println(fwsqb.getXtbh());
	System.out.println(fwsqb.getBmbh());
	xtxx xtbhbmmc=new xtxx();
	flow_config flow_config=new flow_config();
	xtbhbmmc=fd.findALLXtxxByBmbhAndXtbh(fwsqb.getBmbh(),fwsqb.getXtbh());
	fwsqb.setBmmc(xtbhbmmc.getBmmc());
	fwsqb.setXtmc(xtbhbmmc.getXtmc());
	flow_config=fd.findflowconfigBylcdmjddm(fwsqb.getLcdm(), fwsqb.getJddm());
	
	
	
	xtxx xt=new xtxx();
	xt.setApply_address(fwsqb.getApply_address());
	xt.setXtbh(fwsqb.getXtbh());			
	xt.setXtmc(fwsqb.getXtmc());			
	xt.setBmbh(fwsqb.getBmbh());			
	xt.setBmmc(fwsqb.getBmmc());			
	xt.setApply_address(fwsqb.getApply_address());		
	xt.setApply_linkman(fwsqb.getApply_linkman());		
	xt.setApply_phone(fwsqb.getApply_phone());		
	xt.setApply_email	(fwsqb.getApply_email());	
	xt.setCompany	(fwsqb.getCompany());		
	xt.setCompany_linkman(fwsqb.getCompany_linkman());		
	xt.setCompany_phone(fwsqb.getCompany_phone());		
	xt.setCompany_email(fwsqb.getCompany_email());		
	xt.setSystem_dep_location(fwsqb.getSystem_dep_location());
	fd.updateXtxx(xt);
	
	//产生服务申请待审记录
	String sqbt=fwsqb.getBmmc()+"_"+fwsqb.getXtmc()+"_"+flow_config.getLcmc()+" "+flow_config.getJdmc();
	fwsqb.setSqbt(sqbt);
	fwsqb.setBjbz("Y");
	//创建人
	fwsqb.setCreate_by(u.getName());
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String create_date=df.format(new Date());
	fwsqb.setCreate_date(create_date);
	String sqdbh=fwsqb.getBmbh()+""+fwsqb.getXtbh()+""+create_date;
	
	fwsqb.setSqdbh(sqdbh);
	//插入
	fd.insertfwsqb(fwsqb);
	//2）产生服务申请日志记录
	flow_blqkDao fbldao=new flow_blqkDao();
	fbldao.insertflow_blqkWithFwsqb(fwsqb.getLcdm(), u.getLoginname(),fwsqb.getSqdbh());
			return "success";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
			
	
	}else{
		return "login";
	}
}


//转服务查询
public String chaxun(){
	
	if (session.get("user_session") != null) {
		try {
			//用户登陆和权限判断
			 d_user u=(d_user) this.session.get("user_session");
			 dr= rd.findroleById(u.getUserroleid());
			 bmbh=u.getBmbh()+"";
			adparentIds=ad.findparentIdS();
			 dacs=ad.findAllUser();
			 ArrayList roles=this.roles(dr.getRolecontent());
			 for(int i=0;i<dacs.size();i++){
				 	int pid=dacs.get(i).getParentid();
					int s=dacs.get(i).getId();
					for(int p=0;p<roles.size();p++){
						int ss=(Integer) roles.get(p);
						
						if(s==ss){
						
							dacs.get(i).setParentid(pid);
							break;
						}else{
							dacs.get(i).setParentid(0);
						}
					}
				}
				//END用户登陆和权限判断结束
fwsqdao ud=new fwsqdao();
			 
			 num=ud.sumb(bmbh);
			 if ((num % pageSize) / pageSize == 0) {
					totalPage = (num / pageSize) + 1;
				} else {
					totalPage = num / pageSize;
				}
			 // 显示页码计算
				
			 if (pageNow > 4) {  
		            startPage = pageNow - 4;  
		            endPage = pageNow + 5;  
		        }
			 
			 
			 if (endPage>totalPage){
				 if(totalPage>10)
					 {startPage=totalPage-9;}
				 else{endPage=totalPage;}
		    }
			 
			 if (startPage < 1) {  
		            startPage = 1;  
		        }  
		
			
			 drole=rd.findroleById(u.getUserroleid());
			 //通过权限控制查询条件
			 if(drole.getRolestyle()==1900){
				 fwsqbcxbmmcbybmbhs=ud.findAllBMMCbybmbh(bmbh);
				 fwsqbcxxtmcs=ud.findAllXTMCbybmbh(bmbh);
				 fwsqbcxlcmcs=ud.findAllLCMC(bmbh);
				 xtxxs=ud.findXtxxByBmbh(bmbh);
				 depts=ud.findALLDeptByBmbh(bmbh);
				 department=depts.get(0);
				 fwsqbcxs=ud.findAllUser(pageSize, pageNow, bmbh);
				 System.out.println(fwsqbcxs.size());
				 System.out.println(department.getBmmc());
				 xtxxsSize=xtxxs.size();
			 }else  if(drole.getRolestyle()==2000 || drole.getRolestyle()==2100){
				 fwsqbcxbmmcbybmbhs=ud.findAllBMMC();
				 fwsqbcxxtmcs=ud.findAllXTMCbybmbh();
				 fwsqbcxlcmcs=ud.findAllLCMC();
				 xtxxs=ud.findALLXtxx();
				 fwsqbcxs=ud.findAllUser(pageSize, pageNow);
				 System.out.println();
				 xtxxsSize=xtxxs.size();
				 depts=ud.findALLDept();
			 }
			//查询所有fwsqb信息
			 fwsqdao fds=new fwsqdao();
			 fwsqb=fds.findFwsqbBySqbt(sqdbhs);
			 
	
			return "fwchaxun";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
			
	
	}else{
		return "login";
	}
}

//服务送审
public ArrayList<d_action> getDacs() {
	return dacs;
}

public void setDacs(ArrayList<d_action> dacs) {
	this.dacs = dacs;
}

public ArrayList<d_action> getAdparentIds() {
	return adparentIds;
}

public void setAdparentIds(ArrayList<d_action> adparentIds) {
	this.adparentIds = adparentIds;
}

public actionDao getAd() {
	return ad;
}

public void setAd(actionDao ad) {
	this.ad = ad;
}

public d_role getDr() {
	return dr;
}

public void setDr(d_role dr) {
	this.dr = dr;
}

public roleDao getRd() {
	return rd;
}

public void setRd(roleDao rd) {
	this.rd = rd;
}

public int getXuhao() {
	return xuhao;
}

public void setXuhao(int xuhao) {
	this.xuhao = xuhao;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public int getPageNow() {
	return pageNow;
}

public void setPageNow(int pageNow) {
	this.pageNow = pageNow;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public int getTotalPage() {
	return totalPage;
}

public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

public int getPageNum() {
	return pageNum;
}

public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}

public int getStartPage() {
	return startPage;
}

public void setStartPage(int startPage) {
	this.startPage = startPage;
}

public int getEndPage() {
	return endPage;
}

public void setEndPage(int endPage) {
	this.endPage = endPage;
}

public String getBmbh() {
	return bmbh;
}

public void setBmbh(String bmbh) {
	this.bmbh = bmbh;
}

public ArrayList<fwsqbcx> getFwsqbcxs() {
	return fwsqbcxs;
}

public void setFwsqbcxs(ArrayList<fwsqbcx> fwsqbcxs) {
	this.fwsqbcxs = fwsqbcxs;
}

public fwsqbcx getFwsqbcx() {
	return fwsqbcx;
}

public void setFwsqbcx(fwsqbcx fwsqbcx) {
	this.fwsqbcx = fwsqbcx;
}

public d_role getDrole() {
	return drole;
}

public void setDrole(d_role drole) {
	this.drole = drole;
}

public ArrayList<fwsqbcx> getFwsqbcxbmmcbybmbhs() {
	return fwsqbcxbmmcbybmbhs;
}

public void setFwsqbcxbmmcbybmbhs(ArrayList<fwsqbcx> fwsqbcxbmmcbybmbhs) {
	this.fwsqbcxbmmcbybmbhs = fwsqbcxbmmcbybmbhs;
}

public ArrayList<fwsqbcx> getFwsqbcxxtmcs() {
	return fwsqbcxxtmcs;
}

public void setFwsqbcxxtmcs(ArrayList<fwsqbcx> fwsqbcxxtmcs) {
	this.fwsqbcxxtmcs = fwsqbcxxtmcs;
}

public ArrayList<fwsqbcx> getFwsqbcxlcmcs() {
	return fwsqbcxlcmcs;
}

public void setFwsqbcxlcmcs(ArrayList<fwsqbcx> fwsqbcxlcmcs) {
	this.fwsqbcxlcmcs = fwsqbcxlcmcs;
}

public String getCloud1() {
	return cloud1;
}

public void setCloud1(String cloud1) {
	this.cloud1 = cloud1;
}

public String getH3C() {
	return H3C;
}

public void setH3C(String h3c) {
	H3C = h3c;
}

public fwsqb getFwsqb() {
	return fwsqb;
}

public void setFwsqb(fwsqb fwsqb) {
	this.fwsqb = fwsqb;
}

public String getCloud2() {
	return cloud2;
}

public void setCloud2(String cloud2) {
	this.cloud2 = cloud2;
}

public String getCloud3() {
	return cloud3;
}

public void setCloud3(String cloud3) {
	this.cloud3 = cloud3;
}

public String getBflx1() {
	return bflx1;
}

public void setBflx1(String bflx1) {
	this.bflx1 = bflx1;
}

public String getBflx2() {
	return bflx2;
}

public void setBflx2(String bflx2) {
	this.bflx2 = bflx2;
}

public String getBflx3() {
	return bflx3;
}

public void setBflx3(String bflx3) {
	this.bflx3 = bflx3;
}

public String getSystem1() {
	return system1;
}

public void setSystem1(String system1) {
	this.system1 = system1;
}

public String getSystem2() {
	return system2;
}

public void setSystem2(String system2) {
	this.system2 = system2;
}

public String getSystem3() {
	return system3;
}

public void setSystem3(String system3) {
	this.system3 = system3;
}

public String getBase1() {
	return base1;
}

public void setBase1(String base1) {
	this.base1 = base1;
}

public String getBase2() {
	return base2;
}

public void setBase2(String base2) {
	this.base2 = base2;
}

public String getBase3() {
	return base3;
}

public void setBase3(String base3) {
	this.base3 = base3;
}

public String getBase4() {
	return base4;
}

public void setBase4(String base4) {
	this.base4 = base4;
}

public String getBase5() {
	return base5;
}

public void setBase5(String base5) {
	this.base5 = base5;
}

public String getBase6() {
	return base6;
}

public void setBase6(String base6) {
	this.base6 = base6;
}

public String getBase7() {
	return base7;
}

public void setBase7(String base7) {
	this.base7 = base7;
}

public String getBfcl() {
	return bfcl;
}

public void setBfcl(String bfcl) {
	this.bfcl = bfcl;
}

public String getKjpe() {
	return kjpe;
}

public void setKjpe(String kjpe) {
	this.kjpe = kjpe;
}

public ArrayList<xtxx> getXtxxs() {
	return xtxxs;
}

public void setXtxxs(ArrayList<xtxx> xtxxs) {
	this.xtxxs = xtxxs;
}

public xtxx getXtxx() {
	return xtxx;
}

public void setXtxx(xtxx xtxx) {
	this.xtxx = xtxx;
}

public int getXtxxsSize() {
	return xtxxsSize;
}

public void setXtxxsSize(int xtxxsSize) {
	this.xtxxsSize = xtxxsSize;
}

public String getBmmc() {
	return bmmc;
}

public void setBmmc(String bmmc) {
	this.bmmc = bmmc;
}

public ArrayList<department> getDepts() {
	return depts;
}

public void setDepts(ArrayList<department> depts) {
	this.depts = depts;
}

public int getDeptsSize() {
	return deptsSize;
}

public void setDeptsSize(int deptsSize) {
	this.deptsSize = deptsSize;
}

public department getDepartment() {
	return department;
}

public void setDepartment(department department) {
	this.department = department;
}

public String getSqdbhs() {
	return sqdbhs;
}

public void setSqdbhs(String sqdbhs) {
	this.sqdbhs = sqdbhs;
}

public fwsqb getFwsqb2() {
	return fwsqb2;
}

public void setFwsqb2(fwsqb fwsqb2) {
	this.fwsqb2 = fwsqb2;
}



}
