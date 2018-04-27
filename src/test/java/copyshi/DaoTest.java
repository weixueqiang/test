package copyshi;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gray.user.dao.UserDao;
import com.gray.user.entity.User;

public class DaoTest {

	
	ClassPathXmlApplicationContext ctx;
	
	UserDao userDao;
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("classpath:spring-dao.xml","classpath:spring-mybatis.xml");
		userDao=ctx.getBean("userDao", UserDao.class);
	}
	
	@Test
	public void test1() {
		User user = new User();
		user.setUsername("admin");
		User u1=userDao.login(user);
		System.out.println(u1);
		User u2=userDao.withRoleUser(user);
		System.out.println(u2);
	}
	
	@Test
	public void oneCacheTest() {
		User user = new User();
		user.setUsername("admin");
		User u1=userDao.login(user);
		System.out.println(u1);
		User u2=userDao.login(user);
		System.out.println(u2);
	}
	
	@Test
	public void twoCacheTest() {
		User user = new User();
		user.setUsername("admin");
		User u1=userDao.login(user);
		System.out.println(u1);
		User u2=userDao.login(user);
		System.out.println(u2);
	}
	
	@Test
	public void test2() {
		User user = new User();
		user.setUsername("admin");
		User u1=userDao.login(user);
		System.out.println(u1);
		User u2=userDao.withRoleAndMenu("admin");
		System.out.println(u2);
	}
	
	@Test
	public void sessionTest() throws Exception {
		SqlSessionFactory factory=ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		SqlSession session=factory.openSession();
		UserDao mapper = session.getMapper(UserDao.class);
		
		User user = new User();
		user.setUsername("admin");
		User u1=mapper.login(user);
		System.out.println(u1);
		User u2=mapper.login(user);
		System.out.println(u2);
		session.close();
	}
	
	
	
	
	
	@After
	public void destory() {
		ctx.close();
	}
}
