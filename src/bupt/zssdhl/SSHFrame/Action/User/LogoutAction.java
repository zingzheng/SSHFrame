package bupt.zssdhl.SSHFrame.Action.User;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

	@Override
	public String execute() throws Exception{
		Map map = ActionContext.getContext().getSession();
		map.clear();
		return SUCCESS;
	}
}
