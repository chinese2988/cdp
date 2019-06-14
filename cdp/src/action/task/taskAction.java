package action.task;

import java.util.ArrayList;

import org.apache.poi.poifs.property.Parent;

import action.BaseAction;
import dao.fwsq.fwsqdao;
import dao.user.actionDao;
import dao.user.departmentDao;
import dao.user.roleDao;
import entity.fwsq.fwsqb;
import entity.fwsq.fwsqbcx;
import entity.fwsq.xtxx;
import entity.user.d_action;
import entity.user.d_role;
import entity.user.d_user;

public class taskAction extends BaseAction{
	
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
	private String bmmc;
	private ArrayList<fwsqbcx> fwsqbcxs;
	private fwsqbcx fwsqbcx;
	private fwsqb fwsqb;
	public fwsqb fwsqb2=new fwsqb();
	private ArrayList<fwsqbcx> fwsqbcxbmmcbybmbhs;
	private ArrayList<fwsqbcx> fwsqbcxxtmcs;
	private ArrayList<fwsqbcx> fwsqbcxlcmcs;
	private ArrayList<xtxx> xtxxs;
	private String lcdm;
	private String sqdbh;
	private String lcmc;
	
public String execute() {
		
	
	if (session.get("user_session") != null) {
			try {
				//用户登陆和权限判断
				 d_user u=(d_user) this.session.get("user_session");
				 dr= rd.findroleById(u.getUserroleid());
				 departmentDao dp=new departmentDao();
				 bmbh=u.getBmbh()+"";
				 bmmc=dp.findDeptById(bmbh);
				 drole=rd.findroleById(u.getUserroleid());
				adparentIds=ad.findparentIdS();
				 dacs=ad.findAllUser();
				 ArrayList roles=super.roles(dr.getRolecontent());
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
				 
					//END用户登陆和权限判断结束 
					fwsqdao ud=new fwsqdao();
					 
					 num=ud.sumtask(drole.getRolestyle());
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
					 
					
					
					//查询信息
					 fwsqbcxs=ud.findAllTask(pageSize, pageNow, drole.getRolestyle());
				
					 System.out.println(lcmc);
					 
				 return "task";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
				
		
		}else{
			return "login";
		
		}
	}
	

public String qianshou(){
	if (session.get("user_session") != null) {
		try {
			//用户登陆和权限判断
			 d_user u=(d_user) this.session.get("user_session");
			 dr= rd.findroleById(u.getUserroleid());
			 departmentDao dp=new departmentDao();
			 bmbh=u.getBmbh()+"";
			 bmmc=dp.findDeptById(bmbh);
			 drole=rd.findroleById(u.getUserroleid());
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
			 
				//END用户登陆和权限判断结束 
				fwsqdao ud=new fwsqdao();
				 
				//签收执行
				 ud.updateTask(sqdbh, u.getLoginname());
				
				
				 num=ud.sumtask(drole.getRolestyle());
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
				 
				
				
				
			 
				
				 
				//查询信息
				 fwsqbcxs=ud.findAllTask(pageSize, pageNow, drole.getRolestyle());
				
				 return "qianshou";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
			
	
	}else{
		return "login";
	
	}
	
	
}

public String taskcha(){
	if (session.get("user_session") != null) {
		try {
			//用户登陆和权限判断
			 d_user u=(d_user) this.session.get("user_session");
			 dr= rd.findroleById(u.getUserroleid());
			 departmentDao dp=new departmentDao();
			 bmbh=u.getBmbh()+"";
			 bmmc=dp.findDeptById(bmbh);
			 drole=rd.findroleById(u.getUserroleid());
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
			 
				//END用户登陆和权限判断结束 
				fwsqdao ud=new fwsqdao();
				 
				//签收执行
				 ud.updateTask(sqdbh, u.getLoginname());
				
				
				 num=ud.sumtask(drole.getRolestyle());
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
				 
				
				
				
			 
				
				
				//查询信息
				 fwsqbcxs=ud.findAllTask(pageSize, pageNow, drole.getRolestyle());
				
				 return "taskcha";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
			
	
	}else{
		return "login";
	
	}
	
	
}
	
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
	public d_role getDrole() {
		return drole;
	}
	public void setDrole(d_role drole) {
		this.drole = drole;
	}
	public String getBmbh() {
		return bmbh;
	}
	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}
	public String getBmmc() {
		return bmmc;
	}
	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
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
	public fwsqb getFwsqb() {
		return fwsqb;
	}
	public void setFwsqb(fwsqb fwsqb) {
		this.fwsqb = fwsqb;
	}
	public fwsqb getFwsqb2() {
		return fwsqb2;
	}
	public void setFwsqb2(fwsqb fwsqb2) {
		this.fwsqb2 = fwsqb2;
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
	public ArrayList<xtxx> getXtxxs() {
		return xtxxs;
	}
	public void setXtxxs(ArrayList<xtxx> xtxxs) {
		this.xtxxs = xtxxs;
	}
	public String getLcdm() {
		return lcdm;
	}
	public void setLcdm(String lcdm) {
		this.lcdm = lcdm;
	}
	public String getSqdbh() {
		return sqdbh;
	}
	public void setSqdbh(String sqdbh) {
		this.sqdbh = sqdbh;
	}


	public String getLcmc() {
		return lcmc;
	}


	public void setLcmc(String lcmc) {
		this.lcmc = lcmc;
	}
	
	
	
	
}
