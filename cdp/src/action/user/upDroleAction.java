package action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import action.BaseAction;
import dao.user.roleDao;
import entity.user.d_role;

public class upDroleAction extends BaseAction {

	private String rolename;
	private d_role drole;
	private String dactio = "";
	private String dactions;
	private String message = "";

	public String execute() {
		if (session.get("user_session") != null) {
			dactio = this.denglu();
			drole.setRolecontent(dactio);
			roleDao rd = new roleDao();
			try {
				if (drole.getRolestyle() == 1900) {
					
					drole.setRolestyledetail("后台管理");
					//System.out.println(19000000);
				} else if (drole.getRolestyle() == 2000) {
					drole.setRolestyledetail("用户单位管理");
				} else if (drole.getRolestyle() == 2100) {
					drole.setRolestyledetail("主管单位管理");
				}

				
				rd.updateRole(drole);
				rd.updateRolectiondetail(drole.getId());
				message = "更新成功";
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "更新失败："+e.toString();
				return "error";
			}

		} else {
			return "login";
		}
	}

	public String denglu() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String[] selectedComs = request.getParameterValues("selectedComs");

		for (int i = 0; i < selectedComs.length; i++) {
			dactio = dactio + "," + selectedComs[i].toString();
		}
		String dacs = dactio.substring(1);
		return dacs;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public d_role getDrole() {
		return drole;
	}

	public void setDrole(d_role drole) {
		this.drole = drole;
	}

	public String getDactio() {
		return dactio;
	}

	public void setDactio(String dactio) {
		this.dactio = dactio;
	}

	public String getDactions() {
		return dactions;
	}

	public void setDactions(String dactions) {
		this.dactions = dactions;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
