package swl;

import static org.junit.Assert.*;

import java.util.List;

import jxl.common.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import sixth.sixthgroup.model.ClassAccount;
import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class UserServiceTest {
	private static final Logger LOGGER = Logger
			.getLogger(UserControllerTest.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	@Transactional
	@Rollback(true)
	public void insertUser() throws Exception {
		//fail("Not yet implemented");	
		User user = new User();
		user.setUserBelong(3);
		user.setUserName("swl");
		user.setUserPassword("123");
		user.setUserPower(2);
		
		int act = 0;
		act = this.userService.insertUser(user);
		
		int exp = 1;
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}
	
	@Test
	public void findUserByIdTest() throws Exception {
		//fail("Not yet implemented");
		User act = new User();
		act = this.userService.findUserById(1);
		
		User exp = new User();
		exp.setUserBelong(3);
		exp.setUserId(1);
		exp.setUserName("myName");
		exp.setUserPassword("mySQL");
		exp.setUserPower(2);
		
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}

	
	@Test
	public void findUserByNameAndPassword() throws Exception {
		//fail("Not yet implemented");
		User act = new User();
		act = this.userService.findUserByNameAndPassword("myName","mySQL");
		
		User exp = new User();
		exp.setUserBelong(3);
		exp.setUserId(1);
		exp.setUserName("myName");
		exp.setUserPassword("mySQL");
		exp.setUserPower(2);
		//LOGGER.info(JSON.toJSON(act));
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}
	
	@Test
	public void selectAll() throws Exception {
		//fail("Not yet implemented");
		List<ClassAccount> list = this.userService.selectAll();
		//System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
		LOGGER.info(JSON.toJSON(list));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void deleteOne() throws Exception {
		//fail("Not yet implemented");
		int exp =1;
		int act = this.userService.deleteOne(1);
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void updateOne() throws Exception {
		//fail("Not yet implemented");
		int exp =1;
		int act = this.userService.updateOne(1, "20130001", "myTestName", "myTestPassword");
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}
}
