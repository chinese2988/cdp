package action;

public class loginOut extends BaseAction{
	public String execute() {
		this.session.clear();
		return "login";
	}

}
