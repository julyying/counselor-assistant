package test.sixthgroup.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import sixth.sixthgroup.model.HistoryStudent;
import sixth.sixthgroup.service.HistoryStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class HistoryStudentServiceTest {
	private static final Logger LOGGER = Logger
			.getLogger(HistoryStudentServiceTest.class);
	@Autowired
	HistoryStudentService testObj;




	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private List<HistoryStudent> CreatePeopleExpList()
	{
		List<HistoryStudent> expList = new ArrayList<HistoryStudent> ();
		String gradeName[] = {"卓计1301","软件1302","医影1301","医影1301","信息安全1301"};
		int stuId[] = {2,3,4,5,20};
		String stuName[] = {"赵1","谁让他不回复","123","赵九","赵九"};
		String stuNum[] = {"20130005","20130002","20130006","20130003","20130004"};
		String stuTel[] = {"13344449999","123","123","13344449999","13344449999"};
		for(int i = 0; i < 5; ++i)
		{
			HistoryStudent h_student = new HistoryStudent();
			h_student.setGradName(gradeName[i]);
			h_student.setStudId(stuId[i]);
			h_student.setStudName(stuName[i]);
			h_student.setStudNum(stuNum[i]);
			h_student.setStudTel(stuTel[i]);
			expList.add(h_student);
			
		}
		return expList;
	}
	@Test
	public void testselectPeopleToHold() {
		//fail("Not yet implemented");
		List<HistoryStudent> expList = CreatePeopleExpList();
		List<HistoryStudent> actList = testObj.selectPeopleToHold();
		assertEquals(JSON.toJSON(expList),JSON.toJSON(actList));
	}
	@Test
	@Transactional
	@Rollback(true)
	public void testinsertOne() throws ParseException {
		//fail("Not yet implemented");
		HistoryStudent h_student = new HistoryStudent();
		h_student.setGradName("信息安全1301");
		h_student.setHistId(10000);
		h_student.setHistStudentid(20);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 //String类型转换成Date类型
		Date ddate= sdf.parse("2016-01-09");
		h_student.setHistTime(ddate);
		h_student.setStudId(20);
		h_student.setStudName("赵九");
		h_student.setStudNum("20130004");
		h_student.setStudTel("13344449999");
		int exp = 1;
		int act = testObj.insertOne(h_student);
		assertEquals(exp,act);
	}
	@Test
	public void testselectAll() throws ParseException {
		//fail("Not yet implemented");
		List<HistoryStudent> expList = new ArrayList<HistoryStudent> ();
		HistoryStudent h_student = new HistoryStudent();
		h_student.setGradName("软件1301");
		h_student.setHistId(null);
		h_student.setHistStudentid(null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 //String类型转换成Date类型
		Date ddate= sdf.parse("2016-01-11");
		h_student.setHistTime(ddate);
		h_student.setStudId(1);
		h_student.setStudName("色板");
		h_student.setStudNum("20130001");
		h_student.setStudTel("123");
		h_student.setTime(null);
		expList.add(h_student);
		List<HistoryStudent> actList = testObj.selectAll();
		
		assertEquals(JSON.toJSON(expList),JSON.toJSON(actList));
	}
}
