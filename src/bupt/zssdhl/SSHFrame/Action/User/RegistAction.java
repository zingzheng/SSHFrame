package bupt.zssdhl.SSHFrame.Action.User;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import bupt.zssdhl.SSHFrame.Bean.User;
import bupt.zssdhl.SSHFrame.Service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport{
	
	private User user;
	private UserService userService;
	private String repwd;
	private Log _log = LogFactory.getLog(RegistAction.class);
	
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
		
		if(null == repwd ||
				"".equals(repwd.trim())){
			this.addFieldError("repwd",
					this.getText("required",new String[]{this.getText("repwd")}));
		}
		
		if(!user.getPwd().equals(repwd)){
			this.addFieldError("repwd", this.getText("repwd.different"));
		}
		
		if(null == user.getInvitaCode() ||
				"".equals(user.getInvitaCode().trim())){
			this.addFieldError("user.invitaCode", this.getText("required",
					new String[]{this.getText("invitaCode")}));
		}
		
	}
	
	
	@Override
	public String execute() throws Exception{
		
		_log.info("asking for regist");
		if(userService.regist(user)){
			_log.info("regist sucessful");
			return SUCCESS;
		}else{
			this.addActionError(this.getText("regist.faile"));
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


	public String getRepwd() {
		return repwd;
	}


	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	
}
