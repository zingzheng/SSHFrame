package bupt.zssdhl.SSHFrame.ServiceImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bupt.zssdhl.SSHFrame.Bean.User;
import bupt.zssdhl.SSHFrame.Dao.UserDao;
import bupt.zssdhl.SSHFrame.Service.UserService;

/**
 * �û���ز���service��impl
 * @author zss
 *
 */

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private static Log _log = LogFactory.getLog(UserServiceImpl.class);

	/**
	 * ��½ʱ����û��������Ƿ���ȷ
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
	 * �û�ע��
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
	 * ��ȡȫ���û��б�
	 */
	@Override
	public List<User> listAllUsers() {
		
		return userDao.findAllUsers();
		 
	}
	
	/**
	 * ͨ��userid���user��bean
	 */
	public User getUserById(Integer id){
		return userDao.findUserById(id);
	}
	
	/**
	 * �����û�
	 */
	public void updateUser(User user){
		userDao.update(user);
	}
	
	/**
	 * �����û�idɾ��
	 */
	public void delUser(Integer id){
		User user = getUserById(id);
		userDao.delUser(user);
	}
	
	/**
	 * ����ÿҳ��Ŀ������ȡ��ҳ��
	 */
	public int getPageSum(int pageCount){
		return (userDao.getUserCount()-1)/pageCount +1;
	}
	
	/**
	 * ����ҳ���ÿҳ��Ŀ��������û�
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
