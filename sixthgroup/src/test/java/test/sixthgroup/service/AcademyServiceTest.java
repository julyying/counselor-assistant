package test.sixthgroup.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
import sixth.sixthgroup.service.AcademyService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class AcademyServiceTest {

	private static final Logger LOGGER = Logger
			.getLogger(AcademyServiceTest.class);
	@Autowired
	AcademyService testObj;
	


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAll() {
		//fail("Not yet implemented");
		List<Academy> expList = new ArrayList<Academy>();
		Academy e = new Academy();
		e.setAcadId(1);
		e.setAcadName("计算机科学与技术学院");
		expList.add(e);
		List<Academy> actList = testObj.getAll();
		assertEquals(JSON.toJSON(expList),JSON.toJSON(actList));
	}
	@Test
	public void testGetIdByName() {
		//fail("Not yet implemented");
		int expId = 1;
		int actId = testObj.getIdByName("计算机科学与技术学院");
		assertEquals(expId,actId);
	}



}
