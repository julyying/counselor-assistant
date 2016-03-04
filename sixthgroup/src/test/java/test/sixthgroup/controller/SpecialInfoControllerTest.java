package test.sixthgroup.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import sixth.sixthgroup.controller.SpecialInfoController;
import sixth.sixthgroup.model.SpecialInfo;
import sixth.sixthgroup.service.SpecialInfoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class SpecialInfoControllerTest {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private MockHttpServletRequest request;  

    private MockHttpServletResponse response;
    
    private SpecialInfoController specialInfoController =new SpecialInfoController();
    
    private SpecialInfoService specialInfoService;

	public SpecialInfoService getSpecialInfoService() {
		return specialInfoService;
	}
	@Autowired
	public void setSpecialInfoService(SpecialInfoService specialInfoService) {
		this.specialInfoService = specialInfoService;
	}
	
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    }   
    
	@Test
	public void selectByTypeId1() {
		//fail("Not yet implemented");
		List<SpecialInfo> list =new ArrayList();
		SpecialInfo specialInfo = new SpecialInfo();
		list.add(specialInfo);
		
		specialInfoService = mock(SpecialInfoService.class);
		specialInfoController.setSpecialInfoService(specialInfoService);
		when(specialInfoService.selectByInfoType(1)).thenReturn(list);
		
		specialInfoController.selectByTypeId(1,1,2,request, response);
		assertEquals("false",specialInfoController.getBmp()); 
	}

	@Test
	public void getTheCount1() {
		//fail("Not yet implemented");
		List<SpecialInfo> list =new ArrayList();
		SpecialInfo specialInfo = new SpecialInfo();
		list.add(specialInfo);
		
		specialInfoService = mock(SpecialInfoService.class);
		specialInfoController.setSpecialInfoService(specialInfoService);
		when(specialInfoService.selectByInfoType(1)).thenReturn(list);
		
		specialInfoController.getTheCount(1, request, response);
		assertEquals("false",specialInfoController.getBmp()); 
	}
	
	@Test
	public void insertOneInfo1() throws ParseException {
		//fail("Not yet implemented");
		java.util.Date date=DATE_FORMAT.parse("2013-12-12");  
		
		SpecialInfo specialInfo=new SpecialInfo();
		specialInfo.setSpinStudentid(1);
		specialInfo.setSpinClassno(1);
		specialInfo.setSpinTime(date);
		
		specialInfoService = mock(SpecialInfoService.class);
		specialInfoController.setSpecialInfoService(specialInfoService);
		when(specialInfoService.insertOneInfo(specialInfo)).thenReturn(1);
		
		specialInfoController.insertOneInfo(1, 1, "2013-12-12", request, response);
		assertEquals("true",specialInfoController.getBmp()); 
	}
	
	@Test
	public void insertOneInfo2() {
		//fail("Not yet implemented");
		
		specialInfoController.insertOneInfo(1, 1, "2013-12-12", request, response);
		assertEquals("false",specialInfoController.getBmp()); 
	}
	
	@Test
	public void deleteOne1() {
		//fail("Not yet implemented");
		
		specialInfoService = mock(SpecialInfoService.class);
		specialInfoController.setSpecialInfoService(specialInfoService);
		when(specialInfoService.deleteOne(1)).thenReturn(1);
		
		specialInfoController.deleteOne(1, request, response);
		assertEquals("true",specialInfoController.getBmp()); 
	}
	
	@Test
	public void deleteOne2() {
		//fail("Not yet implemented");
		
		specialInfoService = mock(SpecialInfoService.class);
		specialInfoController.setSpecialInfoService(specialInfoService);
		when(specialInfoService.deleteOne(1)).thenReturn(0);
		
		specialInfoController.deleteOne(1, request, response);
		assertEquals("true",specialInfoController.getBmp()); 
	}
	
	@Test
	public void deleteOne3() {
		//fail("Not yet implemented");
		specialInfoController.deleteOne(1, request, response);
		assertEquals("false",specialInfoController.getBmp()); 
	}
}
