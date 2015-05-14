package bupt.zssdhl.SSHFrame.Dao;


import java.util.List;

import bupt.zssdhl.SSHFrame.Bean.User;

public interface UserDao {
	
	public void addUser(User user);
	
	public void delUser(User user);
	
	public void update(User user);
	
	public User findUserById(Integer id);
	
	public User findUserByUsername(String username);
	
	public List<User> findAllUsers();
	
	public List<User> findUsersLimit(int firstResult,int maxResult);
	
	public int getUserCount();
	
}
