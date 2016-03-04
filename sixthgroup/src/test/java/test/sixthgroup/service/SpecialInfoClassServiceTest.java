package test.sixthgroup.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jxl.common.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import org.junit.After;
import org.junit.Before;
import sixth.sixthgroup.model.SpecialInfoClass;
import sixth.sixthgroup.service.SpecialInfoClassService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class SpecialInfoClassServiceTest {

	private static final Logger LOGGER = Logger
			.getLogger(SpecialInfoClassService.class);
	@Autowired
	SpecialInfoClassService testObj;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testselectAll() {
		//fail("Not yet implemented");
		 int specil_Id[] = {1,2,3,4};
		 String spcl_name[] = {"晚归","旷课","请假","2+4活动"};
		 List<SpecialInfoClass> expList = new ArrayList<SpecialInfoClass>();
		 for(int i = 0; i < 4; ++i)
		 {
			 SpecialInfoClass infoClass = new SpecialInfoClass();
			 infoClass.setSpclId(specil_Id[i]);
			 infoClass.setSpclName(spcl_name[i]);
             expList.add(infoClass);			 
		 }
		 List<SpecialInfoClass> actList = testObj.selectAll();
		 assertEquals(JSON.toJSON(expList),JSON.toJSON(actList));
	}

}
