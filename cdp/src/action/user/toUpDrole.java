package action.user;

import java.util.ArrayList;

import action.BaseAction;
import dao.user.actionDao;
import dao.user.roleDao;
import entity.user.d_action;
import entity.user.d_role;

public class toUpDrole extends BaseAction{
	private int id;
	
	private d_role drole;
	
	
	private ArrayList details;//角色当前拥有的权限
	private d_role drdetail;//角色实例
	
	private ArrayList dactions;//定义未授权的权限集合
	private d_action daction;//功能实例
	
	
	public String execute() {
		if (session.get("user_session") != null) {
		roleDao rd=new roleDao();
		actionDao ad=new actionDao();
		try {
			drole=rd.findroleById(id);//获取对象
			System.out.println(id);
			System.out.println(drole.getRolecontentdetail());
			//获取权限代码和叙述的 集合
			String[] des=drole.getRolecontent().split(",");
			String[] desdetail=drole.getRolecontentdetail().split(",");
			
			details=new ArrayList();
			for(int i=0;i<des.length;i++){
				//定义新对象
				drdetail=new d_role();
				//赋值
				drdetail.setRolecontent(des[i]);
				drdetail.setRolecontentdetail(desdetail[i]);
				//放入集合
				details.add(drdetail);
			}
			
			//获取全部功能模块
			//获取全部功能模块
			dactions=ad.findAllUser();
			//System.out.println(dactions.size());
			
			for(int i=0;i<dactions.size();i++){
				//去除此角色已经拥有的权限
				daction=new d_action();
				daction=(d_action) dactions.get(i);
				//System.out.println(daction.getActionname());
				for(int p=0;p<details.size();p++){
					drdetail=new d_role();
					drdetail=(d_role) details.get(p);
					int drs=Integer.parseInt(drdetail.getRolecontent().toString());;
					
					if(daction.getId()==drs){
						//System.out.println(drs);
						dactions.remove(i);//去除重复的功能
						i--;//由于去除集合的对象后，size会减少一个，为保证下标值同步，必须同时减一
						//System.out.println(dactions.get(i));
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "toUpRole";
		}else{
			return "login";
		}
	}
	
	
	public d_role getDrole() {
		return drole;
	}

	public void setDrole(d_role drole) {
		this.drole = drole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public ArrayList getDetails() {
		return details;
	}


	public void setDetails(ArrayList details) {
		this.details = details;
	}


	public d_role getDrdetail() {
		return drdetail;
	}


	public void setDrdetail(d_role drdetail) {
		this.drdetail = drdetail;
	}


	public ArrayList getDactions() {
		return dactions;
	}


	public void setDactions(ArrayList dactions) {
		this.dactions = dactions;
	}


	public d_action getDaction() {
		return daction;
	}


	public void setDaction(d_action daction) {
		this.daction = daction;
	}
	
}
