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

import sixth.sixthgroup.model.Diary;
import sixth.sixthgroup.service.DiaryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class DiaryServiceTest {

	private static final Logger LOGGER = Logger
			.getLogger(DiaryServiceTest.class);
	@Autowired
	DiaryService testObj;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	@Transactional
	@Rollback(true)
	public void testInsertOne() throws ParseException {
	//	fail("Not yet implemented");
	     int exp = 1;
	     Diary diary = new Diary();
	     diary.setTime("");
	     diary.setDiarContent("test");
	     Integer diarId = 100;
	     diary.setDiarId(diarId);
	     
	     //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 //String类型转换成Date类型
		//Date ddate= sdf.parse("2016-01-09");
	     
	     //diary.setDiarTime(ddate);
	     diary.setDiarUser(2);
	     int act = testObj.insertOne(diary);
	     assertEquals(exp,act);
	     
	}
	@Test
	@Transactional
	@Rollback(true)
	public void testdeleteByPrimaryKey() {
	//	fail("Not yet implemented");
	     int exp = 1;
	     Integer diarId = 1;
	     int act = testObj.deleteByPrimaryKey(diarId);
	     assertEquals(exp,act);
	}
	private List<Diary> CreateExpList() throws ParseException
	{
		String diar_count[] = {"交作业","答辩","开会","论文","论文润色","修改论文","论文","论文","论文","论文","论文","论文"};
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 //String类型转换成Date类型
		Date ddate= sdf.parse("2016-01-09");
		List<Diary> expList = new ArrayList<Diary>();
		for(int i = 0; i < 12; ++i)
		{
			Diary diary = new Diary();
			diary.setDiarContent(diar_count[i]);
			diary.setDiarId(i+1);
			diary.setDiarUser(1);
			diary.setDiarTime(ddate);
			expList.add(diary);
		}
		return expList;
		
	}
	@Test
	public void testselectAll() throws ParseException {
	//	fail("Not yet implemented");
		List<Diary> expList = new ArrayList<Diary>();
		expList = CreateExpList();
		List<Diary> actList = testObj.selectAll();
		for(int i = 0; i < actList.size(); ++i)
		{
			System.out.println(actList.get(i).getDiarId());
			System.out.println(actList.get(i).getDiarUser());
			System.out.println(actList.get(i).getDiarContent());
			System.out.println(actList.get(i).getDiarTime());
		}
		assertEquals(JSON.toJSON(expList),JSON.toJSON(actList));
	}

}
