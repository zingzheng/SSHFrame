package bupt.zssdhl.SSHFrame.ServiceImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bupt.zssdhl.SSHFrame.Bean.User;
import bupt.zssdhl.SSHFrame.Dao.UserDao;
import bupt.zssdhl.SSHFrame.Service.UserService;

/**
 * 用户相关操作service的impl
 * @author zss
 *
 */

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private static Log _log = LogFactory.getLog(UserServiceImpl.class);

	/**
	 * 登陆时检查用户名密码是否正确
	 */
	@Override
	public boolean loginCheck(User user) {
		User userCheck = userDao.findUserByUsername(user.getUsername());
		if(null == userCheck){
			_log.warn("this username is not regist" + user.getUsername() );
			return false;
		}else{
			if(!userCheck.getPwd().equals(user.getPwd())){
				_log.warn("pwd is not correct");
				return false;
			}else{
				return true;
			}
		}

	}
	
	
	/**
	 * 用户注册
	 */
	@Override
	public boolean regist(User user) {
		if(!"123".equals(user.getInvitaCode())){
			_log.warn("the invitecode is not correct!");
			return false;
		}
		
		if(null != userDao.findUserByUsername(user.getUsername())){
			_log.warn("the username:"+user.getUsername()+" is existed!");
			return false;
		}
		
		userDao.addUser(user);
		return true;
	}
	
	/**
	 * 获取全体用户列表
	 */
	@Override
	public List<User> listAllUsers() {
		
		return userDao.findAllUsers();
		 
	}
	
	/**
	 * 通过userid获得user的bean
	 */
	public User getUserById(Integer id){
		return userDao.findUserById(id);
	}
	
	/**
	 * 更新用户
	 */
	public void updateUser(User user){
		userDao.update(user);
	}
	
	/**
	 * 根据用户id删除
	 */
	public void delUser(Integer id){
		User user = getUserById(id);
		userDao.delUser(user);
	}
	
	/**
	 * 根据每页条目数量获取总页数
	 */
	public int getPageSum(int pageCount){
		return (userDao.getUserCount()-1)/pageCount +1;
	}
	
	/**
	 * 根据页码和每页条目数量获得用户
	 */
	public List<User> listUserLimit(int pageGoto,int pageCount){
		return userDao.findUsersLimit((pageGoto-1)*pageCount, pageCount);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}







}
