package copyshi;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gray.user.dao.UserDao;

public class Test {

	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("classpath:spring-mvc.xml");
	}
	
	@org.junit.Test
	public void testDao() {
		UserDao userDao = ctx.getBean("userDao", UserDao.class);
		System.out.println(userDao);
	}
	
	@After
	public void destory() {
		ctx.close();
	}
	
}
