package action.user;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import action.BaseAction;

import com.opensymphony.xwork2.ActionContext;


import dao.user.actionDao;
import dao.user.roleDao;
import dao.user.userDao;

import entity.user.d_action;
import entity.user.d_role;
import entity.user.d_user;

public class loginAction extends BaseAction{
	
	
	private d_user duser;
	
	private userDao ud =new userDao();
	private roleDao rd=new roleDao();
	private actionDao ad=new actionDao();
	
	private String message;
	private String lis;
	private ArrayList<d_action> adparentIds;
	private  d_role drole;
	private ArrayList<d_action> dacs;
	private d_action daction;
	private d_action daction2;
	private int sumfwxxs=0;
private   HttpServletRequest request;
private HttpServletResponse response;
private  HttpSession  sessions;
	public String execute() {
			try {
				d_user u=ud.findUserByUsernameAndPassword(duser);
				if(u != null){
					//ActionContext.getContext().getSession().put("user_session",u);
					this.session.put("user_session",u);
					
					
					
					 drole=rd.findroleById(u.getUserroleid());
					
					
					 adparentIds=ad.findparentIdS();
				     
					 dacs=ad.findAllUser();
					 
					 ArrayList roles=this.roles(drole.getRolecontent());
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
						
					
					
					return "tomain";
					 
					
				}else{
					message="用户名或密码无效";
				}
				
				return "error";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message=e.toString();
				return "error";
			}
		
		
	
	}
	
	public static void main (String[] args){
		userDao ud =new userDao();
		actionDao ad=new actionDao();
		d_user duser=new d_user();
		duser.setLoginname("test");
		duser.setLoginpassword("1");
		
		try {
			d_user u=ud.findUserByUsernameAndPassword(duser);
			ArrayList<d_action> adparentIds=ad.findparentIdS();
			roleDao rd=new roleDao();
			d_role drole;
			ArrayList<d_action> dacs;
			drole=rd.findroleById(u.getUserroleid());
				
				
			
		     
			 dacs=ad.findAllUser();
			 
			 ArrayList roles=new ArrayList();
				String[] ro=drole.getRolecontent().split(",");
				for(int i=0;i<ro.length;i++){
					int p =Integer.parseInt(ro[i].toString());
					roles.add(p);
				}
			 
			System.out.println(dacs.size());
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
			 
			 System.out.println(adparentIds.size()+" "+dacs.size());
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public d_role getDrole() {
		return drole;
	}


	public void setDrole(d_role drole) {
		this.drole = drole;
	}


	public d_action getDaction() {
		return daction;
	}


	public void setDaction(d_action daction) {
		this.daction = daction;
	}







	


	

	public ArrayList<d_action> getDacs() {
		return dacs;
	}


	public void setDacs(ArrayList<d_action> dacs) {
		this.dacs = dacs;
	}


	public d_user getDuser() {
		return duser;
	}
	public void setDuser(d_user duser) {
		this.duser = duser;
	}

	public userDao getUd() {
		return ud;
	}
	public void setUd(userDao ud) {
		this.ud = ud;
	}
	public roleDao getRd() {
		return rd;
	}
	public void setRd(roleDao rd) {
		this.rd = rd;
	}
	public actionDao getAd() {
		return ad;
	}
	public void setAd(actionDao ad) {
		this.ad = ad;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLis() {
		return lis;
	}
	public void setLis(String lis) {
		this.lis = lis;
	}




	public ArrayList<d_action> getAdparentIds() {
		return adparentIds;
	}


	public void setAdparentIds(ArrayList<d_action> adparentIds) {
		this.adparentIds = adparentIds;
	}


	public d_action getDaction2() {
		return daction2;
	}


	public void setDaction2(d_action daction2) {
		this.daction2 = daction2;
	}


	



	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public HttpServletResponse getResponse() {
		return response;
	}


	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}


	public HttpSession getSessions() {
		return sessions;
	}


	public void setSessions(HttpSession sessions) {
		this.sessions = sessions;
	}


	public ArrayList roles(String role){
		ArrayList roles=new ArrayList();
		String[] ro=role.split(",");
		for(int i=0;i<ro.length;i++){
			int p =Integer.parseInt(ro[i].toString());
			roles.add(p);
		}
		return roles;
	}


	

	public int getSumfwxxs() {
		return sumfwxxs;
	}


	public void setSumfwxxs(int sumfwxxs) {
		this.sumfwxxs = sumfwxxs;
	}
	
}

