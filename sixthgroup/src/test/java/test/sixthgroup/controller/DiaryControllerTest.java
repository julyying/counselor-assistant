package test.sixthgroup.controller;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

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

import sixth.sixthgroup.controller.DiaryController;
import sixth.sixthgroup.model.Diary;
import sixth.sixthgroup.service.DiaryService;
import static org.mockito.Mockito.when;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class DiaryControllerTest {
// 模拟request,response  
	
    private MockHttpServletRequest request;  

    private MockHttpServletResponse response; 
    
    private DiaryController diaryController = new DiaryController();
    
    private DiaryService diaryService;
    
    public DiaryService getDiaryService() {
		return diaryService;
	}
    
    @Autowired
	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
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
		
		List<Diary> list = new ArrayList();
		Diary diary =new Diary();
		
		list.add(diary);
		
		diaryService = mock(DiaryService.class);
		//when(diaryService.selectAll()).thenReturn(list);
		diaryController.setDiaryService(diaryService);
		diaryController.selectAll(request, response);
		assertEquals("true",diaryController.getTmp()); 
	}
	
	@Test
	public void selectAll2() {
		//fail("Not yet implemented");
		diaryController.selectAll(request, response);
		assertEquals("false",diaryController.getTmp()); 
	}

	@Test
	public void insertOne1() {
		//fail("Not yet implemented");
		diaryController.insertOne("hello ","2012-12-12",request, response);
		assertEquals("false",diaryController.getTmp()); 
	}
	
	@Test
	public void insertOne2() {
		//fail("Not yet implemented");
		Diary diary = new Diary();
		
		diaryService = mock(DiaryService.class);
		diaryController.setDiaryService(diaryService);
		when(diaryService.insertOne(diary)).thenReturn(1);
		diaryController.insertOne("hello ","2012-12-12",request, response);
		assertEquals("true",diaryController.getTmp()); 
	}
	
	@Test
	public void deleteById1() {
		//fail("Not yet implemented");
		diaryController.deleteById(1,request, response);
		assertEquals("false",diaryController.getTmp()); 
	}
	
	@Test
	public void deleteById2() {
		//fail("Not yet implemented");
		diaryService = mock(DiaryService.class);
		diaryController.setDiaryService(diaryService);
		diaryController.deleteById(1,request, response);
		assertEquals("true",diaryController.getTmp()); 
	}
}
