package copyshi;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gray.user.dao.PermissionDao;
import com.gray.user.dao.RoleDao;
import com.gray.user.dao.UserDao;
import com.gray.user.entity.Permission;
import com.gray.user.entity.Role;
import com.gray.user.entity.User;
import com.gray.user.service.impl.UserService;
import com.gray.user.service.impl.UserServiceImpl;

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
		System.out.println(user);
		userDao.save(user);
		System.out.println(user);
	}
	

	@org.junit.Test
	public void getUser() {
		UserDao userDao = ctx.getBean("userDao", UserDao.class);
		//save
		String salt = "salt";
		String password="1";
		Md5Hash md5 = new Md5Hash(password, salt, 1);
		password=md5.toString();
		String username = "admin";
		User user = new User(null, username, md5.toString(), salt);
		user=userDao.login(user);
		System.out.println(user);
	}
	
	@org.junit.Test
	public void testService() {
		UserService bean = ctx.getBean("userService", UserService.class);
		String salt = "salt";
		String password="1";
		Md5Hash md5 = new Md5Hash(password, salt, 1);
		password=md5.toString();
		String username = "zhangsan";
		User user = new User(null, username, md5.toString(), salt);
		bean.save(user);
	}
	
	@org.junit.Test
	public void testPermission() {
		PermissionDao bean = ctx.getBean("permissionDao", PermissionDao.class);
		Permission permission = new Permission();
		permission.setName("*");
		permission.setSort("0");
		bean.save(permission);
		System.out.println(permission);
	}
	
	
	
	
	@org.junit.Test
	public void testRole() {
		RoleDao bean = ctx.getBean("roleDao", RoleDao.class);
		Role role=new Role();
		role.setRolename("admin");
		System.out.println(role);
		bean.save(role);
		System.out.println(role);
	}
	
	
	
	
	
	
	@After
	public void destory() {
		ctx.close();
	}
	
}
