package test.sixthgroup.model;

import static org.junit.Assert.*;
import jxl.common.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import sixth.sixthgroup.model.Academy;
import swl.UserControllerTest;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class AcademyTest {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger
			.getLogger(UserControllerTest.class);
	
	@Autowired
	private Academy testObj;

	@Before
	public void setUp() throws Exception {
	//	testObj = new Academy();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAcadId() {
	//	fail("Not yet implemented");
		Integer exp = 10;
		testObj.setAcadId(exp);
		Integer act = testObj.getAcadId();
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	   // assertEquals(0,0);
	}
}
