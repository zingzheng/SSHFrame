package bupt.zssdhl.SSHFrame.Interceptor;

import java.util.Map;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 用户权限拦截器
 * @author zss
 *
 */
public class AdminInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map map = invocation.getInvocationContext().getSession();
		UserInfo userInfo = (UserInfo) map.get("userSession");
		ActionSupport ac = (ActionSupport) invocation.getAction();
		if(null != userInfo){
			if(userInfo.getGrade() != 0){
				ac.addActionError("您没有进行该操作的权限！");
				return "reject";
			}else{
				return invocation.invoke();
			}
		}else{
			return invocation.invoke();
		}
		
	}
	

}
