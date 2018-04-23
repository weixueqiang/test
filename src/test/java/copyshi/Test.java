package copyshi;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gray.user.dao.UserDao;
import com.gray.user.entity.User;

public class Test {

	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("classpath:spring-mvc.xml","classpath:spring-shi.xml",
				"classpath:spring-dao.xml","classpath:spring-mybatis.xml");
	}
	
	@org.junit.Test
	public void testDao() {
		UserDao userDao = ctx.getBean("userDao", UserDao.class);
		//save
		String salt = "salt";
		String password="1";
		Md5Hash md5 = new Md5Hash(password, salt, 1);
		password=md5.toString();
		String username = "admin";
		User user = new User(null, username, md5.toString(), salt);
//		TestUser user = new TestUser(null, username, password, salt);
		System.out.println(user);
		userDao.save(user);
		System.out.println(user);
	}
	
	@After
	public void destory() {
		ctx.close();
	}
	
}
