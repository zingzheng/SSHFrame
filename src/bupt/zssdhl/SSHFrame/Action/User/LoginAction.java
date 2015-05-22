package bupt.zssdhl.SSHFrame.Action.User;



import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private UserInfo user;
	private UserService userService;
	private Log _log = LogFactory.getLog(LoginAction.class);
	
	@Override
	public void validate(){
		if(null == user.getUsername() || 
				"".equals(user.getUsername().trim())){
			this.addFieldError("user.username", 
					this.getText("required",new String[]{this.getText("username")}));
		}
		
		if(null == user.getPwd() || 
				"".equals(user.getPwd().trim())){
			this.addFieldError("user.pwd",
					this.getText("required",new String[]{this.getText("password")}));
		}
		
	}
	
	
	@Override
	public String execute() throws Exception{
		
		_log.info("asking for login, username=" + user.getUsername()+" pwd="+user.getPwd());
		if(userService.loginCheck(user)){
			_log.info("login success, username="+user.getUsername());
			Map map = ActionContext.getContext().getSession();
			map.put("userSession", user);
			return SUCCESS;
		}else{
			this.addActionError( this.getText("login.faile"));
			return ERROR;
		}
		
	}
	
	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
