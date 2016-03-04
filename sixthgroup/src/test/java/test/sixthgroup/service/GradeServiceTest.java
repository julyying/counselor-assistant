package test.sixthgroup.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

import org.junit.After;
import org.junit.Before;

import sixth.sixthgroup.model.Grade;
import sixth.sixthgroup.service.GradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class GradeServiceTest {

	private static final Logger LOGGER = Logger
			.getLogger(GradeServiceTest.class);
	@Autowired
	GradeService testObj;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testaddOneClass() {
	//	fail("Not yet implemented");
		Grade grade = new Grade();
		grade.setGradAcademy(1);
		grade.setGradCounselor(1);
		grade.setGradId(10000);
		grade.setGradMonitor(1);
		grade.setGradName("test");
		int exp = 1;
	    int act = testObj.addOneClass(grade);
	    assertEquals(exp,act);

	}
	@Test
	public void testselectByClassName() {
	//	fail("Not yet implemented");
		Grade expgrade = new Grade();
		expgrade.setGradAcademy(1);
		expgrade.setGradCounselor(1);
		expgrade.setGradId(1);
		expgrade.setGradMonitor(1);
		expgrade.setGradName("软件1301");
		Grade actgrade = testObj.selectByClassName("软件1301");
		assertEquals(JSON.toJSON(expgrade),JSON.toJSON(actgrade));
	}
    private List<Grade> GreateExpList()
    {
    	int array_id[] = {1,2,4,5,9};
    	String array_name[] = {"软件1301","软件1302","卓计1301","医影1301","信息安全1301"};
    	int array_academy[] =  {1,1,1,1,0};
    	int array_consoler[] = {1,1,1,1,1};
    	int array_monitor[] = {1,2,5,6,0};
    	List<Grade> expList = new ArrayList<Grade>();
    	for(int i = 0; i < 5; ++i)
    	{
    		Grade expgrade = new Grade();
    		if(array_academy[i]!=0)
    		    expgrade.setGradAcademy(array_academy[i]);
    		else expgrade.setGradAcademy(null);
    		if(array_monitor[i] != 0)
    		     expgrade.setGradMonitor(array_monitor[i]);
    		else expgrade.setGradMonitor(null);
    		
    		expgrade.setGradName(array_name[i]);
    		expgrade.setGradCounselor(array_consoler[i]);
    		expgrade.setGradId(array_id[i]);
    		expList.add(expgrade);
    	}
    	return expList;
    }
	@Test
	public void testselectAll() {
	//	fail("Not yet implemented");
		List<Grade> expList = GreateExpList();
		List<Grade> actList = testObj.selectAll();
		for(int i = 0; i < actList.size(); ++i)
		{
			System.out.println(actList.get(i).getGradAcademy());
			System.out.println(actList.get(i).getGradCounselor());
			System.out.println(actList.get(i).getGradId());
			System.out.println(actList.get(i).getGradName());
			System.out.println(actList.get(i).getGradMonitor());
		}
		assertEquals(JSON.toJSON(expList),JSON.toJSON(actList));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testupdateByPrimaryKey() {
	//	fail("Not yet implemented");
		Grade grade = new Grade();
		grade.setGradAcademy(1);
		grade.setGradCounselor(1);
		grade.setGradId(1);
		grade.setGradMonitor(1);
		grade.setGradName("机械制造");
		int exp = 1;
		int act = testObj.updateByPrimaryKey(grade);
		assertEquals(exp,act);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testselectByClassId() {
	//	fail("Not yet implemented");
		Grade expgrade = new Grade();
		expgrade.setGradAcademy(1);
		expgrade.setGradCounselor(1);
		expgrade.setGradId(1);
		expgrade.setGradMonitor(1);
		expgrade.setGradName("软件1301");
		Grade actgrade = testObj.selectByClassId(1);
		assertEquals(JSON.toJSON(expgrade),JSON.toJSON(actgrade));
	}

}
