package action.user;

import java.util.ArrayList;

import action.BaseAction;
import dao.user.actionDao;
import dao.user.departmentDao;
import dao.user.roleDao;
import entity.user.d_action;
import entity.user.d_role;
import entity.user.d_user;
import entity.user.department;

public class addDeptAction extends BaseAction{
	private ArrayList<d_action> dacs;
	private ArrayList<d_action> adparentIds;
	private actionDao ad=new actionDao();
	private  d_role dr;
	private roleDao rd=new roleDao();
	
	
	private department dept;

	
	private String message="";
	
public ArrayList roles(String role){
		
		
		ArrayList roles=new ArrayList();
		String[] ro=role.split(",");
		for(int i=0;i<ro.length;i++){
			int p =Integer.parseInt(ro[i].toString());
			roles.add(p);
		}
		return roles;
	}

	private ArrayList<department> depts;
public String execute() {
	if (session.get("user_session") != null) {
		
		 departmentDao dpd=new departmentDao();
		
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
			 
			 
			
			dpd.insertUser(dept);
			
			
			 //depts=dpd.findAllDepts(pageSize, pageNow);
			 depts=dpd.findAllDepts();
			 message="新增成功";
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 message="新增失败？"+e.toString();
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
public department getDept() {
	return dept;
}
public void setDept(department dept) {
	this.dept = dept;
}

public ArrayList<department> getDepts() {
	return depts;
}
public void setDepts(ArrayList<department> depts) {
	this.depts = depts;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
