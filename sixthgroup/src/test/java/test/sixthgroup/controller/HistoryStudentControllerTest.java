package test.sixthgroup.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sixth.sixthgroup.controller.HistoryStudentController;
import sixth.sixthgroup.model.HistoryStudent;
import sixth.sixthgroup.service.HistoryStudentService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class HistoryStudentControllerTest {
	
	private MockHttpServletRequest request;  

	private MockHttpServletResponse response; 
	
	private HistoryStudentController historyStudentController = new HistoryStudentController();
	
	private HistoryStudentService historyStudentService;

	public HistoryStudentService getHistoryStudentService() {
		return historyStudentService;
	}
	@Autowired
	public void setHistoryStudentService(HistoryStudentService historyStudentService) {
		this.historyStudentService = historyStudentService;
	}
	 @Before    
	public void setUp(){    
		 request = new MockHttpServletRequest();      
	     request.setCharacterEncoding("UTF-8");      
	     response = new MockHttpServletResponse();      
	 } 
	@Test
	public void selectPeopleToHold1() {
		//fail("Not yet implemented");
		historyStudentController.selectPeopleToHold(10,request, response);
		assertEquals("false",historyStudentController.getBmp()); 
	}

	@Test
	public void selectPeopleToHold2() {
		//fail("Not yet implemented");
		historyStudentService = mock(HistoryStudentService.class);
		historyStudentController.setHistoryStudentService(historyStudentService);
		historyStudentController.selectPeopleToHold(10,request, response);
		assertEquals("true",historyStudentController.getBmp()); 
	}
	
	@Test
	public void selectPeopleToHold3() {
		//fail("Not yet implemented");
		List<HistoryStudent> list=this.historyStudentService.selectPeopleToHold();
		HistoryStudent historyStudent = new HistoryStudent();
		
		list.add(historyStudent);
		list.add(historyStudent);
		
		System.out.println(list.size()+"###########################");
		historyStudentService = mock(HistoryStudentService.class);
		historyStudentController.setHistoryStudentService(historyStudentService);
		when(historyStudentService.selectPeopleToHold()).thenReturn(list);
		historyStudentController.selectPeopleToHold(1,request, response);
		assertEquals("true",historyStudentController.getBmp()); 
	}
	
	@Test
	public void selectHistoryStudent1() {
		//fail("Not yet implemented");
		historyStudentController.selectHistoryStudent(1,1,request, response);
		assertEquals("false",historyStudentController.getBmp()); 
	}
	
	@Test
	public void selectHistoryStudent2() {
		//fail("Not yet implemented");
		List<HistoryStudent> list=this.historyStudentService.selectPeopleToHold();
		HistoryStudent historyStudent = new HistoryStudent();
		
		//list.add(historyStudent);
		list.add(historyStudent);
		
		
		System.out.println(list.size()+"###########################");
		historyStudentService = mock(HistoryStudentService.class);
		historyStudentController.setHistoryStudentService(historyStudentService);
		when(historyStudentService.selectAll()).thenReturn(list);
		historyStudentController.selectHistoryStudent(1,2,request, response);
		assertEquals("true",historyStudentController.getBmp()); 
	}
}
