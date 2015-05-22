package bupt.zssdhl.SSHFrame.Action.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Dao.UserDao;
import bupt.zssdhl.SSHFrame.Service.UserService;


public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) ac.getBean("userService");
		UserInfo user = new UserInfo();
		user.setUsername("admin");
		user.setPwd("123");
		if(userService.loginCheck(user)){
			System.out.println("ok");
		}else{
			System.out.println("not ok");
		}
		
	}

}
