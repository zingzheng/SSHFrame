package bupt.zssdhl.SSHFrame.Action.User;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserAction extends ActionSupport{
	
	private UserService userService;
	private UserInfo user;
	private String newpwd;
	private String repwd;
	


	@Override
	public void validate(){
		if(null == user.getUsername() || 
				"".equals(user.getUsername().trim())){
			this.addFieldError("user.username",
					this.getText("required",new String[]{this.getText("username")}));
		}
		
		if(null != newpwd && !"".equals(newpwd.trim())){
			if(null == repwd ||
					"".equals(repwd.trim())){
				this.addFieldError("repwd",
						this.getText("required",new String[]{this.getText("repwd")}));
			}
			
			else if(!newpwd.equals(repwd)){
				this.addFieldError("repwd", this.getText("repwd.different"));
			}
		}
		
		
		if(null == user.getInvitaCode() ||
				"".equals(user.getInvitaCode().trim())){
			this.addFieldError("user.invitaCode", this.getText("required",
					new String[]{this.getText("invitaCode")}));
		}
		
	}
	
	@Override
	public String execute() throws Exception{
		
		if(null != newpwd && !"".equals(newpwd.trim())){
			user.setPwd(newpwd);
		}
		userService.updateUser(user);
		addActionMessage("ÐÞ¸Ä³É¹¦£¡");
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
	
	public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

}
