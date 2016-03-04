package test.sixthgroup.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sixth.sixthgroup.controller.OperationLogController;
import sixth.sixthgroup.model.OperationLog;
import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.OperationLogService;
import sixth.sixthgroup.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class OperationLogControllerTest {
	
	private MockHttpServletRequest request;  

    private MockHttpServletResponse response; 
	  
    private OperationLogController operationLogController = new OperationLogController();
    
    private OperationLogService operationLogService;
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public OperationLogService getOperationLogService() {
		return operationLogService;
	}
	@Autowired
	public void setOperationLogService(OperationLogService operationLogService) {
		this.operationLogService = operationLogService;
	}
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    }   
	@Test
	public void selectAll1() {
		//fail("Not yet implemented");
		operationLogController.selectAll(1,1,1,request, response);
		assertEquals("false",operationLogController.getBmp()); 
	}
	
	@Test
	public void selectAll2() throws Exception {
		//fail("Not yet implemented");
		User user=new User();
		user.setUserId(1);
		user.setUserPower(1);
		
		List<OperationLog> list = new ArrayList();
		OperationLog operationLog = new OperationLog();
		list.add(operationLog);
		//list.add(operationLog);
		
		userService = mock(UserService.class);
		operationLogController.setUserService(userService);
		when(userService.findUserById(1)).thenReturn(user);
		
		operationLogService = mock(OperationLogService.class);
		operationLogController.setOperationLogService(operationLogService);
		when(operationLogService.selectByPeopleId(user.getUserId())).thenReturn(list);
		
		operationLogController.selectAll(1,1,1,request, response);
		assertEquals("false",operationLogController.getBmp()); 
	}

	@Test
	public void selectAll3() throws Exception {
		//fail("Not yet implemented");
		User user=new User();
		user.setUserId(1);
		user.setUserPower(2);
		
		List<OperationLog> list = new ArrayList();
		OperationLog operationLog = new OperationLog();
		list.add(operationLog);
		list.add(operationLog);
		
		userService = mock(UserService.class);
		operationLogController.setUserService(userService);
		when(userService.findUserById(1)).thenReturn(user);
		
		operationLogService = mock(OperationLogService.class);
		operationLogController.setOperationLogService(operationLogService);
		when(operationLogService.selectAll()).thenReturn(list);
		
		operationLogController.selectAll(1,1,1,request, response);
		assertEquals("false",operationLogController.getBmp()); 
	}
}
