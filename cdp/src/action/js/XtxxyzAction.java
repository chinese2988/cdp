package action.js;

import java.util.ArrayList;

import action.BaseAction;
import dao.js.XtxxyzDao;
import dao.user.actionDao;
import dao.user.roleDao;
import entity.js.xtxx_yz;
import entity.user.d_action;
import entity.user.d_role;
import entity.user.d_user;

public class XtxxyzAction extends BaseAction{
	private ArrayList<d_action> dacs;
	private ArrayList<d_action> adparentIds;
	private actionDao ad = new actionDao();
	private d_role dr;
	private roleDao rd = new roleDao();
	private String bmmcyz;//jsp选择框部门名称
	private String xtxxmc;//jsp选择框系统名称
	private String htkssjs;//jsp选择框合同时间
	private String costsum="";//费用合计
	private String stjsj="";
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
	
	private xtxx_yz xtxxyz;
	private ArrayList<xtxx_yz> xtxxyzs;
	private xtxx_yz xtxxyz2;
	private ArrayList<xtxx_yz> xtxxyzs2;//选择框集合数据查询返回结果集合
	
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
			XtxxyzDao ud=new XtxxyzDao();
			 
			 num=ud.sumb();
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
			xtxxyzs=ud.findAllxtxx_yz(pageSize, pageNow);
			xtxxyzs2=ud.findAllxtxxyzHTKSSJ();
			 
			 return "xtxxyz";
	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
			
	
	}else{
		return "login";
	}
}

public String dosearchXtxx(){
	if (session.get("user_session") != null) {
		try {
			//用户登陆和权限判断
			 d_user u=(d_user) this.session.get("user_session");
			 dr= rd.findroleById(u.getUserroleid());
			 
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
			XtxxyzDao ud=new XtxxyzDao();
			 
			 num=ud.sumb(htkssjs);
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
			 
			xtxxyzs=ud.findAllxtxx_yz(pageSize, pageNow,htkssjs);
			xtxxyzs2=ud.findAllxtxxyzHTKSSJ();
			costsum=ud.findSUMxtxxyzBYHTKSSJ(htkssjs); 
			System.out.println("Content:  "+stjsj);
			 return "dosearchXtxx";
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

public xtxx_yz getXtxxyz() {
	return xtxxyz;
}

public void setXtxxyz(xtxx_yz xtxxyz) {
	this.xtxxyz = xtxxyz;
}

public ArrayList<xtxx_yz> getXtxxyzs() {
	return xtxxyzs;
}

public void setXtxxyzs(ArrayList<xtxx_yz> xtxxyzs) {
	this.xtxxyzs = xtxxyzs;
}

public ArrayList<xtxx_yz> getXtxxyzs2() {
	return xtxxyzs2;
}

public void setXtxxyzs2(ArrayList<xtxx_yz> xtxxyzs2) {
	this.xtxxyzs2 = xtxxyzs2;
}

public String getBmmcyz() {
	return bmmcyz;
}

public void setBmmcyz(String bmmcyz) {
	this.bmmcyz = bmmcyz;
}

public String getXtxxmc() {
	return xtxxmc;
}

public void setXtxxmc(String xtxxmc) {
	this.xtxxmc = xtxxmc;
}

public String getHtkssjs() {
	return htkssjs;
}

public void setHtkssjs(String htkssjs) {
	this.htkssjs = htkssjs;
}

public xtxx_yz getXtxxyz2() {
	return xtxxyz2;
}

public void setXtxxyz2(xtxx_yz xtxxyz2) {
	this.xtxxyz2 = xtxxyz2;
}

public String getCostsum() {
	return costsum;
}

public void setCostsum(String costsum) {
	this.costsum = costsum;
}

public String getStjsj() {
	return stjsj;
}

public void setStjsj(String stjsj) {
	this.stjsj = stjsj;
}


}
