package swl;

import static org.junit.Assert.*;

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

import sixth.sixthgroup.model.OperationLog;
import sixth.sixthgroup.service.OperationLogService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
public class OperationLogServiceTest {
	private static final Logger LOGGER = Logger
			.getLogger(UserControllerTest.class);
	
	@Autowired
	private OperationLogService operationLogService;
	
	@Test
	public void selectAll() {
		List<OperationLog> list = this.operationLogService.selectAll();
		LOGGER.info(JSON.toJSON(list));
	}

	@Test
	public void selectByPeopleId() {
		List<OperationLog> list = this.operationLogService.selectByPeopleId(1);
		LOGGER.info(JSON.toJSON(list));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void insertOne() {
		Date date = new Date();
		OperationLog operationLog = new OperationLog();
		operationLog.setOploPeopleid(1);
		operationLog.setOploContent("我在做测试");
		operationLog.setOploTime(date);
		
		int act = 0;
		act = this.operationLogService.insertOne(operationLog);
		int exp = 1;
		assertEquals(JSON.toJSON(act),JSON.toJSON(exp));
	}
}
