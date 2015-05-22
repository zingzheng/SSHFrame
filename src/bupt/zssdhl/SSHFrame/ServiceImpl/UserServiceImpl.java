package bupt.zssdhl.SSHFrame.ServiceImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;
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
	public boolean loginCheck(UserInfo userInfo) {
		
		UserInfo userCheck = userDao.findUserByUsername(userInfo.getUsername());
		if(null == userCheck){
			_log.warn("this username is not regist" + userInfo.getUsername() );
			return false;
		}else{
			if(!userCheck.getPwd().equals(userInfo.getPwd())){
				_log.warn("pwd is not correct");
				return false;
			}else{
				userInfo.setId(userCheck.getId());
				userInfo.setGrade(userCheck.getGrade());
				return true;
			}
		}

	}
	
	
	/**
	 * �û�ע��
	 */
	@Override
	public boolean regist(UserInfo userInfo) {
		
		if(userInfo.getGrade() == 1){
			if(!"123".equals(userInfo.getInvitaCode())){
				_log.warn("the invitecode is not correct!");
				return false;
			}
		}
		
		if(userInfo.getGrade() == 0){
			if(!"000".equals(userInfo.getInvitaCode())){
				_log.warn("the root invitecode is not correct!");
				return false;
			}
		}
		
		if(null != userDao.findUserByUsername(userInfo.getUsername())){
			_log.warn("the username:"+userInfo.getUsername()+" is existed!");
			return false;
		}
		
		userDao.addUser(userInfo);
		return true;
	}
	
	/**
	 * ��ȡȫ���û��б�
	 */
	@Override
	public List<UserInfo> listAllUsers() {
		
		return userDao.findAllUsers();
		 
	}
	
	/**
	 * ͨ��userid���user��bean
	 */
	public UserInfo getUserById(Integer id){
		return userDao.findUserById(id);
	}
	
	/**
	 * �����û�
	 */
	public void updateUser(UserInfo userInfo){
		userDao.update(userInfo);
	}
	
	/**
	 * �����û�idɾ��
	 */
	public void delUser(Integer id){
		UserInfo user = getUserById(id);
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
	public List<UserInfo> listUserLimit(int pageGoto,int pageCount){
		return userDao.findUsersLimit((pageGoto-1)*pageCount, pageCount);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}







}
