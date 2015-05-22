package bupt.zssdhl.SSHFrame.Dao;


import java.util.List;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;

public interface UserDao {
	
	public void addUser(UserInfo userInfo);
	
	public void delUser(UserInfo userInfo);
	
	public void update(UserInfo userInfo);
	
	public UserInfo findUserById(Integer id);
	
	public UserInfo findUserByUsername(String username);
	
	public List<UserInfo> findAllUsers();
	
	public List<UserInfo> findUsersLimit(int firstResult,int maxResult);
	
	public int getUserCount();
	
}
