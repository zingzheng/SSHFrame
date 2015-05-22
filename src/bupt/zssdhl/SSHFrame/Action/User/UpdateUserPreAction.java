package bupt.zssdhl.SSHFrame.Action.User;

import java.util.Map;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserPreAction extends ActionSupport{
	
	private UserService userService;
	private UserInfo user;
	
	@Override
	public String execute() throws Exception{
		user = userService.getUserById(user.getId());
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("user", user);
		return SUCCESS;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
}
