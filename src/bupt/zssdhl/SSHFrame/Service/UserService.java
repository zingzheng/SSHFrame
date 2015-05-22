package bupt.zssdhl.SSHFrame.Service;

import java.util.List;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;


public interface UserService {
	
	public boolean loginCheck(UserInfo userInfo);
	
	public boolean regist(UserInfo userInfo);
	
	public List<UserInfo> listAllUsers();
	
	public UserInfo getUserById(Integer id);
	
	public void updateUser(UserInfo userInfo);
	
	public void delUser(Integer id);
	
	public int getPageSum(int pageCount);
	
	public List<UserInfo> listUserLimit(int pageGoto,int pageCount);
}
