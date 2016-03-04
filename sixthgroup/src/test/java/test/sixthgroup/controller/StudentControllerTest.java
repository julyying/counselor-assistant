package test.sixthgroup.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sixth.sixthgroup.controller.StudentController;
import sixth.sixthgroup.model.Student;
import sixth.sixthgroup.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class StudentControllerTest {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private MockHttpServletRequest request;  

    private MockHttpServletResponse response;
    
    private StudentController studentController =new StudentController();
    
    private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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
		List<Student> list = new ArrayList();
		Student student = new Student();
		Date date = new Date();
		student.setStudBron(date);
		list.add(student);
		
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.getAll()).thenReturn(list);
		
		studentController.selectAll(request, response);
		assertEquals("true",studentController.getBmp()); 
	}
	@Test
	public void selectAll2() {
		//fail("Not yet implemented");
		List<Student> list = new ArrayList();
		
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.getAll()).thenReturn(list);
		
		studentController.selectAll(request, response);
		assertEquals("true",studentController.getBmp()); 
	}
	@Test
	public void selectAll3() {
		studentController.selectAll(request, response);
		assertEquals("false",studentController.getBmp()); 
	}
	
	@Test
	public void selectByGradeid1() {
		//fail("Not yet implemented");
		List<Student> list = new ArrayList();
		Student student = new Student();
		Date date = new Date();
		student.setStudBron(date);
		list.add(student);
		
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.getByGradeid(1)).thenReturn(list);
		
		studentController.selectByGradeid(1, request, response);
		assertEquals("true",studentController.getBmp()); 
	}

	@Test
	public void selectByGradeid2() {
		//fail("Not yet implemented");
		List<Student> list = new ArrayList();
		
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.getByGradeid(1)).thenReturn(list);
		
		studentController.selectByGradeid(1, request, response);
		assertEquals("true",studentController.getBmp()); 
	}
	
	@Test
	public void selectByGradeid3() {
		//fail("Not yet implemented");
		studentController.selectByGradeid(1, request, response);
		assertEquals("false",studentController.getBmp()); 
	}
	
	@Test
	public void selectStudByStudNum1() {
		//fail("Not yet implemented");
		Date date = new Date();
		Student student = new Student();
		student.setStudBron(date);
	
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.getOneStudent("20110001")).thenReturn(student);
		
		studentController.selectStudByStudNum("20110001", request, response);
		assertEquals("true",studentController.getBmp()); 
	}
	
	@Test
	public void selectStudByStudNum2() {
		//fail("Not yet implemented");
	
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.getOneStudent("20110001")).thenReturn(null);
		
		studentController.selectStudByStudNum("20110001", request, response);
		assertEquals("true",studentController.getBmp()); 
	}
	
	@Test
	public void selectStudByStudNum3() {
		//fail("Not yet implemented");
	
		studentController.selectStudByStudNum("20110001", request, response);
		assertEquals("false",studentController.getBmp()); 
	}
	
	@Test
	public void insertOneStudent1() throws ParseException {
		//fail("Not yet implemented");
		int studGradeid=1;
		String studName="swl";
		String studSex="男";
		String studAge="22";
		String studTel="123";
		String studQq="345365";
		String studAddress="fag";
		String studIdcard="24675484";
		String studNum="25356";
		String studBron="2013-12-21";
		String studBanknum="2353654364";
		String studNation="china";
		String studDorimitory="fd6";
		String studParentname="fsd";
		String studParenttel="fsf";
		java.util.Date date=DATE_FORMAT.parse(studBron);  
		
		Student student=new Student();
		student.setStudAddress(studAddress);
		student.setStudAge(studAge);
		student.setStudBanknum(studBanknum);
		student.setStudBron(date);
		student.setStudDorimitory(studDorimitory);
		student.setStudGradeid(studGradeid);
		student.setStudIdcard(studIdcard);
		student.setStudName(studName);
		student.setStudNation(studNation);
		student.setStudNum(studNum);
		student.setStudQq(studQq);
		student.setStudSex(studSex);
		student.setStudTel(studTel);
		student.setStudParentname(studParentname);
		student.setStudParenttel(studParenttel);
		
	
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.addOneStudent(student)).thenReturn(1);
		
		studentController.insertOneStudent(studGradeid, studName, studSex, studAge, studTel, studQq, studAddress, studIdcard, studNum, studBron, studBanknum, studNation, studDorimitory, studParentname, studParenttel, request, response);		
		assertEquals("true",studentController.getBmp()); 
	}
	
	@Test
	public void insertOneStudent2() throws ParseException {
		//fail("Not yet implemented");
		int studGradeid=1;
		String studName="swl";
		String studSex="男";
		String studAge="22";
		String studTel="123";
		String studQq="345365";
		String studAddress="fag";
		String studIdcard="24675484";
		String studNum="25356";
		String studBron="2013-12-21";
		String studBanknum="2353654364";
		String studNation="china";
		String studDorimitory="fd6";
		String studParentname="fsd";
		String studParenttel="fsf";
		java.util.Date date=DATE_FORMAT.parse(studBron);  
		
		Student student=new Student();
		student.setStudAddress(studAddress);
		student.setStudAge(studAge);
		student.setStudBanknum(studBanknum);
		student.setStudBron(date);
		student.setStudDorimitory(studDorimitory);
		student.setStudGradeid(studGradeid);
		student.setStudIdcard(studIdcard);
		student.setStudName(studName);
		student.setStudNation(studNation);
		student.setStudNum(studNum);
		student.setStudQq(studQq);
		student.setStudSex(studSex);
		student.setStudTel(studTel);
		student.setStudParentname(studParentname);
		student.setStudParenttel(studParenttel);
		
	
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.addOneStudent(student)).thenReturn(0);
		
		studentController.insertOneStudent(studGradeid, studName, studSex, studAge, studTel, studQq, studAddress, studIdcard, studNum, studBron, studBanknum, studNation, studDorimitory, studParentname, studParenttel, request, response);		
		assertEquals("true",studentController.getBmp()); 
	}
	
	@Test
	public void insertOneStudent4() throws ParseException {
		//fail("Not yet implemented");
		int studGradeid=1;
		String studName="swl";
		String studSex="男";
		String studAge="22";
		String studTel="123";
		String studQq="345365";
		String studAddress="fag";
		String studIdcard="24675484";
		String studNum="25356";
		String studBron="2013-12-21";
		String studBanknum="2353654364";
		String studNation="china";
		String studDorimitory="fd6";
		String studParentname="fsd";
		String studParenttel="fsf";
		java.util.Date date=DATE_FORMAT.parse(studBron);  
		
		Student student=new Student();
		student.setStudAddress(studAddress);
		student.setStudAge(studAge);
		student.setStudBanknum(studBanknum);
		student.setStudBron(date);
		student.setStudDorimitory(studDorimitory);
		student.setStudGradeid(studGradeid);
		student.setStudIdcard(studIdcard);
		student.setStudName(studName);
		student.setStudNation(studNation);
		student.setStudNum(studNum);
		student.setStudQq(studQq);
		student.setStudSex(studSex);
		student.setStudTel(studTel);
		student.setStudParentname(studParentname);
		student.setStudParenttel(studParenttel);
		

		studentController.insertOneStudent(studGradeid, studName, studSex, studAge, studTel, studQq, studAddress, studIdcard, studNum, studBron, studBanknum, studNation, studDorimitory, studParentname, studParenttel, request, response);		
		assertEquals("false",studentController.getBmp()); 
	}
	
	@Test
	public void deleteOne1() {
		//fail("Not yet implemented");
	
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.deleteOne("20010001")).thenReturn(1);
		
		studentController.deleteOne("20010001", request, response);
		assertEquals("true",studentController.getBmp()); 
	}
	
	@Test
	public void deleteOne2() {
		//fail("Not yet implemented");
	
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.deleteOne("20010001")).thenReturn(0);
		
		studentController.deleteOne("20010001", request, response);
		assertEquals("true",studentController.getBmp()); 
	}
	
	@Test
	public void deleteOne3() {
		//fail("Not yet implemented");
		studentController.deleteOne("20010001", request, response);
		assertEquals("false",studentController.getBmp()); 
	}
	
	@Test
	public void updateOne1() throws ParseException {
		//fail("Not yet implemented");
		int studGradeid=1;
		String studName="swl";
		String studSex="男";
		String studAge="22";
		String studTel="123";
		String studQq="345365";
		String studAddress="fag";
		String studIdcard="24675484";
		String studNum="25356";
		String studBron="2013-12-21";
		String studBanknum="2353654364";
		String studNation="china";
		String studDorimitory="fd6";
		String studParentname="fsd";
		String studParenttel="fsf";
		java.util.Date date=DATE_FORMAT.parse(studBron);  
		
		Student student=new Student();
		student.setStudAddress(studAddress);
		student.setStudAge(studAge);
		student.setStudBanknum(studBanknum);
		student.setStudBron(date);
		student.setStudDorimitory(studDorimitory);
		student.setStudGradeid(studGradeid);
		student.setStudIdcard(studIdcard);
		student.setStudName(studName);
		student.setStudNation(studNation);
		student.setStudNum(studNum);
		student.setStudQq(studQq);
		student.setStudSex(studSex);
		student.setStudTel(studTel);
		student.setStudParentname(studParentname);
		student.setStudParenttel(studParenttel);
		
		studentService = mock(StudentService.class);
		studentController.setStudentService(studentService);
		when(studentService.updateOne(student)).thenReturn(1);
		
		studentController.updateOne(studGradeid, studName, studSex, studAge, studTel, studQq, studAddress, studIdcard, studNum, studBron, studBanknum, studNation, studDorimitory, studParentname, studParenttel, request, response);
		assertEquals("true",studentController.getBmp()); 
	}
	
	@Test
	public void updateOne2() throws ParseException {
		//fail("Not yet implemented");
		int studGradeid=1;
		String studName="swl";
		String studSex="男";
		String studAge="22";
		String studTel="123";
		String studQq="345365";
		String studAddress="fag";
		String studIdcard="24675484";
		String studNum="25356";
		String studBron="2013-12-21";
		String studBanknum="2353654364";
		String studNation="china";
		String studDorimitory="fd6";
		String studParentname="fsd";
		String studParenttel="fsf";
		java.util.Date date=DATE_FORMAT.parse(studBron);  
		
		studentController.updateOne(studGradeid, studName, studSex, studAge, studTel, studQq, studAddress, studIdcard, studNum, studBron, studBanknum, studNation, studDorimitory, studParentname, studParenttel, request, response);
		assertEquals("false",studentController.getBmp()); 
	}
}
