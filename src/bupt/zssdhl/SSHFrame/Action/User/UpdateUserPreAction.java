package bupt.zssdhl.SSHFrame.Action.User;

import java.util.Map;

import bupt.zssdhl.SSHFrame.Bean.User;
import bupt.zssdhl.SSHFrame.Service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserPreAction extends ActionSupport{
	
	private UserService userService;
	private User user;
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
