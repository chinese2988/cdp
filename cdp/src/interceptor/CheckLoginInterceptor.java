package interceptor;

import java.util.Map;



import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
	 System.out.println("开始执行拦截器");
		//获取sessioin
		Map<String,Object> session = 
			actionInvocation.getInvocationContext().getSession();
		
		/*Map<String,Object> session = 
		 ActionContext.getContext().getSession();*/
		//判断用户是否登录
		if(session.get("user_session") !=null){
			 String result = actionInvocation.invoke();
			System.out.println("执行完毕");
			return result;
		}
		return "login";
	}


}
