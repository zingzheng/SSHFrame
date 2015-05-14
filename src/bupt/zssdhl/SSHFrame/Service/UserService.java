package bupt.zssdhl.SSHFrame.Service;

import java.util.List;

import bupt.zssdhl.SSHFrame.Bean.User;


public interface UserService {
	
	public boolean loginCheck(User user);
	
	public boolean regist(User user);
	
	public List<User> listAllUsers();
	
	public User getUserById(Integer id);
	
	public void updateUser(User user);
	
	public void delUser(Integer id);
	
	public int getPageSum(int pageCount);
	
	public List<User> listUserLimit(int pageGoto,int pageCount);
}
