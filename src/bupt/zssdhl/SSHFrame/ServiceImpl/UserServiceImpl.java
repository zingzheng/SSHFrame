package bupt.zssdhl.SSHFrame.ServiceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bupt.zssdhl.SSHFrame.Bean.User;
import bupt.zssdhl.SSHFrame.Dao.UserDao;
import bupt.zssdhl.SSHFrame.Service.UserService;


public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private static Log _log = LogFactory.getLog(UserServiceImpl.class);

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
	
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
