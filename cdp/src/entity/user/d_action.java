package entity.user;


public class d_action {
	private int	id;
	private String actionname;
	private String actiondetail;
	private int parentid;
	private String strutsaction;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public String getActiondetail() {
		return actiondetail;
	}
	public void setActiondetail(String actiondetail) {
		this.actiondetail = actiondetail;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getStrutsaction() {
		return strutsaction;
	}
	public void setStrutsaction(String strutsaction) {
		this.strutsaction = strutsaction;
	}
	

}
