package action.user;

import action.BaseAction;
import dao.user.userDao;
import entity.user.d_user;

public class updateUserPasswdAction  extends BaseAction{
	private String newpassword;
	private String loginname;
	private String loginpassword;
	private String message;
	public String execute(){
		
			
			userDao ud=new userDao();
			d_user u=new d_user();
			u.setLoginname(loginname);
			u.setLoginpassword(loginpassword);
			try {
				if(ud.findUserByUsernameAndPasswd(u)){
					ud.updateUserPasswd(u, newpassword);
					
				}else{
					message="用户名或密码错误";
					return "error";
					
				};
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				message=e.toString();
				return "error";
			}
		return "login";
	}
	
	

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}



	public String getLoginname() {
		return loginname;
	}



	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}



	public String getLoginpassword() {
		return loginpassword;
	}



	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
