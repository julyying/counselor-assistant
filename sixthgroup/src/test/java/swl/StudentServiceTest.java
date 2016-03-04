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

import sixth.sixthgroup.model.Student;
import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.StudentService;

import com.alibaba.fastjson.JSON;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class StudentServiceTest {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger
			.getLogger(UserControllerTest.class);
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void getAll() {
		List<Student> list = this.studentService.getAll();
		LOGGER.info(JSON.toJSON(list));
	}

	@Test
	public void getOneStudent() throws Exception {
		//fail("Not yet implemented");	
		Student act = new Student();
		act = this.studentService.getOneStudent("20130001");
		Student exp = new Student();
		exp =  this.studentService.getOneStudent("20130001");
		//LOGGER.info(JSON.toJSON(act));
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void addOneStudent() throws Exception {
		//fail("Not yet implemented");	
		Student act = new Student();
		act.setGradName("testName");
		act.setBothTime("2012-12-12");
		act.setStudAddress("红星街");
		act.setStudAge("22");
		act.setStudBanknum("12345678901");
		act.setStudDorimitory("东九");
		act.setStudGradeid(1);
		act.setStudIdcard("2537585525375858");
		act.setStudName("testName");
		act.setStudNation("汉族");
		act.setStudNum("21213120");
		
		int key1 = this.studentService.addOneStudent(act);
		int key2 = 1;
		//LOGGER.info(JSON.toJSON(act));
		assertEquals(JSON.toJSON(key1),JSON.toJSON(key2));
	}
	
	@Test
	public void getByGradeid() throws Exception {
		//fail("Not yet implemented");	
		List<Student> list = this.studentService.getByGradeid(1);
		
		LOGGER.info(JSON.toJSON(list));
		//assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void deleteOne() throws Exception {
		//fail("Not yet implemented");	
		int act = 0;
		act = this.studentService.deleteOne("20130001");
		int exp = 2;
		//LOGGER.info(JSON.toJSON(list));
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void updateOne() throws Exception {
		//fail("Not yet implemented");	
		
		Student act = new Student();
		act.setStudId(1);
		act.setGradName("testName");
		act.setBothTime("2012-12-12");
		act.setStudAddress("红星街");
		act.setStudAge("22");
		act.setStudBanknum("12345678901");
		act.setStudDorimitory("东九");
		act.setStudGradeid(1);
		act.setStudIdcard("2537585525375858");
		act.setStudName("testName");
		act.setStudNation("汉族");
		act.setStudNum("20130001");
		
		int key1 = this.studentService.updateOne(act);
		int key2 = 2;
		//LOGGER.info(JSON.toJSON(list));
		assertEquals(JSON.toJSON(key1),JSON.toJSON(key2));
	}
}
