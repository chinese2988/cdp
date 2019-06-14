package action.user;


import java.util.ArrayList;

import dao.user.departmentDao;
import action.BaseAction;
import entity.user.department;

public class toAddDept extends BaseAction{
	private department dept;
	private int bmbh;
	private ArrayList<department> depts;
	public String execute() {
		if (session.get("user_session") != null) {
			
			try {
			//System.out.println(dept.getBmbh());
				 departmentDao dpd=new departmentDao();
				 dept=dpd.findDeptById(bmbh);
				 //System.out.println(dept.getBmmc());
				return "toadddept";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
				return "error";
			}
			
			
		}else{
			return "login";
		}
	}
	public department getDept() {
		return dept;
	}
	public void setDept(department dept) {
		this.dept = dept;
	}
	public int getBmbh() {
		return bmbh;
	}
	public void setBmbh(int bmbh) {
		this.bmbh = bmbh;
	}
	public ArrayList<department> getDepts() {
		return depts;
	}
	public void setDepts(ArrayList<department> depts) {
		this.depts = depts;
	}
	
}
