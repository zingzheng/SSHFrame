package bupt.zssdhl.SSHFrame.Interceptor;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * �û���¼������
 * @author zss
 *
 */
public class AuthInterceptor extends AbstractInterceptor{

	@Override
	@SuppressWarnings("rawtypes")
	public String intercept(ActionInvocation invocation) throws Exception {
		Map map = invocation.getInvocationContext().getSession();
		ActionSupport ac = (ActionSupport) invocation.getAction();
		if(null == map.get("userSession")){
			ac.addActionError("��¼�Ѿ�ʧЧ�������µ�¼��");
			return Action.LOGIN;
		}else{
			return invocation.invoke();
		}
	}

}
