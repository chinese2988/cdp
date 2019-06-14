package action.user;

import action.BaseAction;

public class TestAction extends BaseAction{
	private String rolename;
	
	public String execute() {
		
		System.out.println(rolename);
		return "test";
	}
	public String totest(){
		
		return "totest";
	}
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
}
