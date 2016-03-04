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

import sixth.sixthgroup.controller.SpecialInfoClassController;
import sixth.sixthgroup.model.SpecialInfoClass;
import sixth.sixthgroup.service.SpecialInfoClassService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class SpecialInfoLogClassControllerTest {
	
	private MockHttpServletRequest request;  

    private MockHttpServletResponse response;
    
    private SpecialInfoClassController specialInfoClassController =new SpecialInfoClassController();
    
    private SpecialInfoClassService specialInfoClassService;
    
    public SpecialInfoClassService getSpecialInfoClassService() {
		return specialInfoClassService;
	}
    
	@Autowired
	public void setSpecialInfoClassService(
			SpecialInfoClassService specialInfoClassService) {
		this.specialInfoClassService = specialInfoClassService;
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
		List<SpecialInfoClass> list = new ArrayList();
		SpecialInfoClass specialInfoClass = new SpecialInfoClass();
		list.add(specialInfoClass);
		
		specialInfoClassService = mock(SpecialInfoClassService.class);
		specialInfoClassController.setSpecialInfoClassService(specialInfoClassService);
		when(specialInfoClassService.selectAll()).thenReturn(list);
		specialInfoClassController.selectAll(request, response);
		assertEquals("true",specialInfoClassController.getBmp()); 
	}
	
	@Test
	public void selectAll2() {
		//fail("Not yet implemented");
		List<SpecialInfoClass> list = new ArrayList();
		SpecialInfoClass specialInfoClass = new SpecialInfoClass();
		//list.add(specialInfoClass);
		
		specialInfoClassService = mock(SpecialInfoClassService.class);
		specialInfoClassController.setSpecialInfoClassService(specialInfoClassService);
		when(specialInfoClassService.selectAll()).thenReturn(list);
		specialInfoClassController.selectAll(request, response);
		assertEquals("true",specialInfoClassController.getBmp()); 
	}

	@Test
	public void selectAll3() {
		specialInfoClassController.selectAll(request, response);
		assertEquals("false",specialInfoClassController.getBmp()); 
	}
}
