package copyshi;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gray.user.entity.User;
import com.gray.user.service.impl.UserDao;

public class test {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new  ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-mybatis.xml","spring-shi.xml");
		UserDao bean = ctx.getBean("userDao", UserDao.class);
		System.out.println("bean : "+bean);
		User user = new User("zhangsan", "zs123", null, null, null);
		User u = bean.login(user);
		System.out.println("u-\n"+u);
		ctx.close();
	}
	 
	
}
