package bupt.zssdhl.SSHFrame.Action.User;



import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bupt.zssdhl.SSHFrame.Bean.User;
import bupt.zssdhl.SSHFrame.Service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private User user;
	private UserService userService;
	private Log _log = LogFactory.getLog(LoginAction.class);
	
	@Override
	public void validate(){
		if(null == this.getUser().getUsername() || 
				"".equals(this.getUser().getUsername().trim())){
			this.addFieldError("user.username", this.getText("username.required"));
		}
		
		if(null == this.getUser().getPwd() || 
				"".equals(this.getUser().getPwd().trim())){
			this.addFieldError("user.pwd", this.getText("pwd.required"));
		}
		
	}
	
	
	@Override
	public String execute() throws Exception{
		
		_log.info("asking for login, username=" + user.getUsername()+" pwd="+user.getPwd());
		if(userService.loginCheck(user)){
			_log.info("login success, username="+user.getUsername());
			Map map = ActionContext.getContext().getSession();
			map.put("user", user);
			return SUCCESS;
		}else{
			this.addFieldError("user.username", this.getText("login.faile"));
			return ERROR;
		}
		
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
