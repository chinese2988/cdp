package entity.user;

public class d_role {
	private int id;
	private String rolename;
	private String rolecontent; 
	private int rolestyle;//1900后台维护 2000 用户前台展示 2100 主管单位前台展示
	private String rolestyledetail;//登录类型描述
	private String rolecontentdetail; //权限描述
	private int xuhao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRolecontent() {
		return rolecontent;
	}
	public void setRolecontent(String rolecontent) {
		this.rolecontent = rolecontent;
	}
	public int getRolestyle() {
		return rolestyle;
	}
	public void setRolestyle(int rolestyle) {
		this.rolestyle = rolestyle;
	}
	public String getRolestyledetail() {
		return rolestyledetail;
	}
	public void setRolestyledetail(String rolestyledetail) {
		this.rolestyledetail = rolestyledetail;
	}
	public String getRolecontentdetail() {
		return rolecontentdetail;
	}
	public void setRolecontentdetail(String rolecontentdetail) {
		this.rolecontentdetail = rolecontentdetail;
	}
	public int getXuhao() {
		return xuhao;
	}
	public void setXuhao(int xuhao) {
		this.xuhao = xuhao;
	}
	
}
