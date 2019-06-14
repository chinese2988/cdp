package action;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;




public class BaseAction  extends ActionSupport implements SessionAware,ServletRequestAware, ServletResponseAware {
    
	protected Map<String, Object> session;
	public HttpServletRequest request;
    private HttpServletResponse response;    
    public Map<String, Object> getSession() {
		return session;
	}
public ArrayList roles(String role){
		
		
		ArrayList roles=new ArrayList();
		String[] ro=role.split(",");
		for(int i=0;i<ro.length;i++){
			int p =Integer.parseInt(ro[i].toString());
			roles.add(p);
		}
		return roles;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
   
    //set注入request对象
    public void setServletRequest(HttpServletRequest request) {
        this.request= request;
    }
    //set注入response对象
    public void setServletResponse(HttpServletResponse response) {
        this.response= response;
    }
   
	
}
