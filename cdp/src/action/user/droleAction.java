package action.user;

import java.util.ArrayList;

import dao.user.actionDao;
import dao.user.roleDao;

import entity.user.d_action;
import entity.user.d_role;
import entity.user.d_user;
import action.BaseAction;

public class droleAction extends BaseAction{
	private ArrayList<d_action> dacs;
	private ArrayList<d_action> adparentIds;
	private actionDao ad=new actionDao();
	private  d_role dr;
	private roleDao rd=new roleDao();
	
	
	private int num; // 总数
	private int pageNow = 1; // 初始化为1,默认从第一页开始显示
	private int pageSize = 5; // 每页显示5条记录
	private int totalPage; // 总页数
	private int pageNum;// 页数
	// 开始页码
	private int startPage = 1;
	// 结束页码
	private int endPage = 10;
	private ArrayList<d_role> dacsl;//
	
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
			 
			 num=rd.sumb();
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
			 dacsl=rd.findAllUserByPage(pageSize, pageNow);
			 System.out.println(dacsl.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return "drole";}else{
			return "login";
		}
	}
	public ArrayList<d_role> getDacsl() {
		return dacsl;
	}
	public void setDacsl(ArrayList<d_role> dacsl) {
		this.dacsl = dacsl;
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
	
}
