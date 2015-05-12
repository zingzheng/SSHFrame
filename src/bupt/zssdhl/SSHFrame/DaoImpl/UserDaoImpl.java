package bupt.zssdhl.SSHFrame.DaoImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import bupt.zssdhl.SSHFrame.Bean.User;
import bupt.zssdhl.SSHFrame.Dao.UserDao;


@Transactional
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	private static Log _log = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	public void addUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void delUser(User user) {
		
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void update(User user) {

		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public User findUserById(Integer id) {

		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}


	@Override
	public User findUserByUsername(String username) {
		
		_log.info("finding user from db where username="+username);
		User user = null;
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from User where username =:username");
		query.setParameter("username", username);
		
		List<User> userList = query.list();

		if(0 != userList.size()){
			user = userList.get(0);
			_log.info("find user by username");
			
		}else{
			_log.warn("there is no such username");
		}
		return user;
	}
	
	@Override
	public List<User> findAllUsers() {
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from User order by id");
		return (List<User>)query.list();
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
