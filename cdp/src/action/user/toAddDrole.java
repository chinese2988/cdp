package action.user;

import java.util.ArrayList;

import dao.user.actionDao;

import entity.user.d_action;
import action.BaseAction;

public class toAddDrole extends BaseAction{
	private ArrayList dactions;//定义未授权的权限集合
	private d_action daction;//功能实例
	private  String actionname="";
	public String execute() {
		if (session.get("user_session") != null) {
			actionDao ad=new actionDao();
			try {
				dactions=ad.findAllUser();
				
				return "toaddRole";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				actionname="todrole";
				return "error";
			}
			
			
		}else{
			return "login";
		}
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

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
}
