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

import sixth.sixthgroup.controller.GradeController;
import sixth.sixthgroup.model.Grade;
import sixth.sixthgroup.service.GradeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class GradeControllerTest {

	 private MockHttpServletRequest request;  

	 private MockHttpServletResponse response; 
	 
	 private GradeController gradeController = new GradeController();
	 @Autowired
	 private GradeService gradeService;
	 
	public GradeService getGradeService() {
		return gradeService;
	}
	@Autowired
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	 @Before    
	public void setUp(){    
		 request = new MockHttpServletRequest();      
	     request.setCharacterEncoding("UTF-8");      
	     response = new MockHttpServletResponse();      
	 } 
	 
	 
	@Test
	public void addOneClass1() {
		//fail("Not yet implemented");
		gradeController.addOneClass("测试班级",1,request, response);
		assertEquals("false",gradeController.getBmp()); 
	}

	@Test
	public void addOneClass2() {
		//fail("Not yet implemented");
		gradeService = mock(GradeService.class);
		gradeController.setGradeService(gradeService);
		Grade grade= new Grade();
		grade.setGradName("测试班级");
		grade.setGradCounselor(1);
		when(gradeController.getGradeService().addOneClass(grade)).thenReturn(0);
		gradeController.addOneClass("测试班级",1,request, response);
		assertEquals("true",gradeController.getBmp()); 
	}
	
	@Test
	public void addOneClass3() {
		//fail("Not yet implemented");
		gradeService = mock(GradeService.class);
		gradeController.setGradeService(gradeService);
		Grade grade= new Grade();
		grade.setGradName("测试班级");
		grade.setGradCounselor(1);
		when(gradeController.getGradeService().addOneClass(grade)).thenReturn(1);
		gradeController.addOneClass("测试班级",1,request, response);
		assertEquals("true",gradeController.getBmp()); 
	}
	
	@Test
	public void selectByClassName1() {
		//fail("Not yet implemented");
		gradeController.selectByClassName("测试班级",request, response);
		assertEquals("false",gradeController.getBmp()); 
	}
	
	@Test
	public void selectByClassName2() {
		//fail("Not yet implemented");
		gradeService = mock(GradeService.class);
		gradeController.setGradeService(gradeService);
		when(gradeController.getGradeService().selectByClassName("班级")).thenReturn(null);
		gradeController.selectByClassName("班级",request, response);
		assertEquals("true",gradeController.getBmp()); 
	}
	
	@Test
	public void selectByClassName3() {
		//fail("Not yet implemented");
		Grade grade= new Grade();
		gradeService = mock(GradeService.class);
		gradeController.setGradeService(gradeService);
		when(gradeController.getGradeService().selectByClassName("班级")).thenReturn(grade);
		gradeController.selectByClassName("班级",request, response);
		assertEquals("true",gradeController.getBmp()); 
	}
	
	@Test
	public void selectAll1() {
		//fail("Not yet implemented");
		gradeController.selectAll(request, response);
		assertEquals("false",gradeController.getBmp()); 
	}
	
	@Test
	public void selectAll2() {
		//fail("Not yet implemented");
		List<Grade> list = new ArrayList();
		Grade grade = new Grade();
		list.add(grade);
		gradeService = mock(GradeService.class);
		gradeController.setGradeService(gradeService);
		when(gradeService.selectAll()).thenReturn(list);
		gradeController.selectAll(request, response);
		assertEquals("true",gradeController.getBmp()); 
	}
}
