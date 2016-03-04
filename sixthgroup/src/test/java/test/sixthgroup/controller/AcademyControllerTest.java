package test.sixthgroup.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sixth.sixthgroup.controller.AcademyController;
import sixth.sixthgroup.service.AcademyService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class AcademyControllerTest {

	// 模拟request,response  
	
    private MockHttpServletRequest request;  

    private MockHttpServletResponse response; 

    private AcademyController academyController = new AcademyController();
	
    private AcademyService academyService;
    
	public AcademyService getAcademyService() {
		return academyService;
	}
	@Autowired
	public void setAcademyService(AcademyService academyService) {
		this.academyService = academyService;
	}
	// 执行测试方法之前初始化模拟request,response  
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    }    
	@Test
	public void selectAll1() {
		//fail("Not yet implemented");
		academyService = mock(AcademyService.class);
		academyController.setAcademyService(academyService);
		academyController.selectAll(request, response);
		assertEquals("true",academyController.getTmp()); 
	}
	@Test
	public void selectAll2() {
		//fail("Not yet implemented");
		academyController.selectAll(request, response);
		assertEquals("false",academyController.getTmp()); 
	}

}
