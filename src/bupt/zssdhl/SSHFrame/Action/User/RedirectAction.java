package bupt.zssdhl.SSHFrame.Action.User;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectAction extends ActionSupport{

	
	public String gotoRegist() throws Exception{
		return "gotoRegist";
	}
	
	public String gotoLogin() throws Exception{
		return "gotoLogin";
	}
	
	public String gotoMain() throws Exception{
		return "gotoMain";
	}
	
	public String gotoListUser() throws Exception{
		return "gotoListUser";
	}

}
