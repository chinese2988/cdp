package action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import action.BaseAction;
import dao.user.actionDao;
import dao.user.roleDao;
import entity.user.d_action;
import entity.user.d_role;

public class addDroleAction extends BaseAction {
	private d_role drole;
	private String message = "";
	private String dactio = "";
	private  String actionname="";
	private String rolename;
	
	public String execute() {
		if (session.get("user_session") != null) {
			roleDao rd = new roleDao();
			
			/*
			 * 获取role的权限功能描述
			 */
			actionDao ad=new actionDao();
			
			dactio = this.denglu();
			drole.setRolecontent(dactio);
			try {
				
				String[] des=dactio.split(",");
				d_action da=new d_action();
				String rolecontentdetail="";
				for(int i=0;i<des.length;i++){
					int p=Integer.parseInt(des[i].toString());
					da=ad.findDactionByParentId(p);
					rolecontentdetail=rolecontentdetail+","+da.getActionname();
				}
				 rolecontentdetail=rolecontentdetail.substring(1);
				//END获取完毕
				drole.setRolecontentdetail(rolecontentdetail);
				if (drole.getRolestyle() == 1900) {
					
					drole.setRolestyledetail("后台管理");
					
				} else if (drole.getRolestyle() == 2000) {
					drole.setRolestyledetail("用户单位管理");
				} else if (drole.getRolestyle() == 2100) {
					drole.setRolestyledetail("主管单位管理");
				}
				drole.setRolename(rolename);
				System.out.println(rolename.toString());
				rd.insertUser(drole);
				actionname="todrole";
				message="角色新增成功";
				return "success";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message="角色新增失败"+e.toString();
				return "error";
			}
			
		}else {
			return "login";
		}
	}
	
	public d_role getDrole() {
		return drole;
	}
	public void setDrole(d_role drole) {
		this.drole = drole;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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

	public String getDactio() {
		return dactio;
	}

	public void setDactio(String dactio) {
		this.dactio = dactio;
	}

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
	
	
	

}
