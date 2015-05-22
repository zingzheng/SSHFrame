package bupt.zssdhl.SSHFrame.Action.User;

import java.util.List;
import java.util.Map;

import bupt.zssdhl.SSHFrame.Bean.Page;
import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取用户列表的action
 * @author zss
 *
 */
public class ListUserAction extends ActionSupport{
	
	private UserService userService;

	private Page page;
	
	
	@Override
	public String execute() throws Exception{
		
		//非通过页码选择发送请求
		if(null == page){
			page = new Page();
			page.setPageGoto(1);
		}
		//设置每页显示5个用户
		page.setPageCount(5);
		page.setPageCurrent(page.getPageGoto());
		page.setPageSum(userService.getPageSum(page.getPageCount()));
		List<UserInfo> users = userService.listUserLimit(page.getPageGoto(), page.getPageCount());
		//List<User> users = userService.listAllUsers();
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("users", users);
		request.put("page", page);
		return SUCCESS;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
