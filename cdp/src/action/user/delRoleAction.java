package action.user;

import dao.user.roleDao;
import entity.user.d_role;
import action.BaseAction;

public class delRoleAction extends BaseAction {
	private d_role drole;
	private int id;
	public String execute() {
		if (session.get("user_session") != null) {
			roleDao rd = new roleDao();
			try {
				rd.deleteUserById(id);
				return "todrole";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
			
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
	
}
