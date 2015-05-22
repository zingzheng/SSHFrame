package bupt.zssdhl.SSHFrame.DaoImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Dao.UserDao;


@Transactional
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	private static Log _log = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	public void addUser(UserInfo userInfo) {
		
		sessionFactory.getCurrentSession().save(userInfo);
	}

	@Override
	public void delUser(UserInfo userInfo) {
		
		sessionFactory.getCurrentSession().delete(userInfo);
	}

	@Override
	public void update(UserInfo userInfo) {

		sessionFactory.getCurrentSession().update(userInfo);
	}

	@Override
	public UserInfo findUserById(Integer id) {

		return (UserInfo)sessionFactory.getCurrentSession().get(UserInfo.class, id);
	}


	@Override
	public UserInfo findUserByUsername(String username) {
		
		_log.info("finding user from db where username="+username);
		UserInfo userInfo = null;
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from UserInfo where username =:username");
		query.setParameter("username", username);
		
		List<UserInfo> userList = query.list();

		if(0 != userList.size()){
			userInfo = userList.get(0);
			_log.info("find user by username");
			
		}else{
			_log.info("there is no such username");
		}
		return userInfo;
	}
	
	@Override
	public List<UserInfo> findAllUsers() {
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from UserInfo order by id");
		return (List<UserInfo>)query.list();
	}
	
	@Override
	public List<UserInfo> findUsersLimit(int firstResult,int maxResult){
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from UserInfo order by id");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return (List<UserInfo>)query.list();
	}
	
	@Override
	public int getUserCount(){
		Query query = sessionFactory.getCurrentSession()
				.createQuery("select count(*) from UserInfo");
		return Integer.valueOf(((Long)query.uniqueResult()).toString());
		  
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
