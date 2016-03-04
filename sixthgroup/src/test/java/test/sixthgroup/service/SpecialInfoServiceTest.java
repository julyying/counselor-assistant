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

import sixth.sixthgroup.model.SpecialInfo;
import sixth.sixthgroup.service.SpecialInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class SpecialInfoServiceTest {

	@Autowired
	private SpecialInfoService testObj;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testselectByInfoType() throws ParseException {
		//fail("Not yet implemented");
		List<SpecialInfo> expList = new ArrayList<SpecialInfo>();
		SpecialInfo info = new SpecialInfo();
		info.setGradName("软件1301");
		info.setSpinClassno(null);
		info.setSpinId(3);
		info.setSpinIsread(0);
		info.setSpinStudentid(null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 //String类型转换成Date类型
		Date ddate= sdf.parse("2016-01-05");
		info.setSpinTime(ddate);
		info.setStudDorimitory("是责任");
		info.setStudName("色板");
		info.setStudNum("20130001");
		info.setStudTel("123");
		expList.add(info);
		List<SpecialInfo> actList = testObj.selectByInfoType(3);
		assertEquals(JSON.toJSON(expList),JSON.toJSON(actList));
		
	}
	@Test
	@Transactional
	@Rollback(true)
	public void testinsertOneInfo() {
		//fail("Not yet implemented");
		SpecialInfo info = new SpecialInfo();
		info.setGradName("软件1301");
		info.setSpinClassno(1);
		info.setSpinId(10000);
		info.setSpinIsread(0);
		info.setSpinStudentid(1);
		info.setStudDorimitory("是责任");
		info.setStudName("色板");
		info.setStudNum("2013001");
		info.setStudTel("123");
		int exp = 1;
		int act = testObj.insertOneInfo(info);
		assertEquals(exp,act);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testupdateByPrimaryKey() {
		//fail("Not yet implemented");
		SpecialInfo info = new SpecialInfo();
		info.setGradName("软件1301");
		info.setSpinClassno(1);
		info.setSpinId(1);
		info.setSpinIsread(1);
		info.setSpinStudentid(1);	
		info.setStudDorimitory("是责任");
		info.setStudName("色板");
		info.setStudNum("20130001");
		info.setStudTel("123");
		int exp = 1;
		int act = testObj.updateByPrimaryKey(info);
		assertEquals(exp,act);
	}

}
