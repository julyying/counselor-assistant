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

import sixth.sixthgroup.controller.UserController;
import sixth.sixthgroup.model.ClassAccount;
import sixth.sixthgroup.model.Grade;
import sixth.sixthgroup.model.Student;
import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.GradeService;
import sixth.sixthgroup.service.StudentService;
import sixth.sixthgroup.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class UserControllerTest {
	private MockHttpServletRequest request;  

    private MockHttpServletResponse response;
    
    private UserController UserController = new UserController();
    
    private UserService userService;
	
	private GradeService gradeService;
	
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public GradeService getGradeService() {
		return gradeService;
	}
	
	@Autowired
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    @Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    }   
    
	@Test
	public void selectUserById1() throws Exception {
		//fail("Not yet implemented");
		User user =new User();
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.findUserById(1)).thenReturn(user);
		
		UserController.selectUserById(1, request, response);
		assertEquals("true",UserController.getBmp()); 
	}

	@Test
	public void selectUserById2() throws Exception {
		//fail("Not yet implemented");
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.findUserById(1)).thenReturn(null);
		
		UserController.selectUserById(1, request, response);
		assertEquals("true",UserController.getBmp()); 
	}

	@Test
	public void selectUserById3() throws Exception {
		//fail("Not yet implemented");
		
		UserController.selectUserById(1, request, response);
		assertEquals("false",UserController.getBmp()); 
	}
	
	@Test
	public void selectUserByNameAndPassword1() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		
		User user =new User();
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.findUserByNameAndPassword(loginname, password)).thenReturn(user);
		
		UserController.selectUserByNameAndPassword(loginname, password, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void selectUserByNameAndPassword2() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.findUserByNameAndPassword(loginname, password)).thenReturn(null);
		
		UserController.selectUserByNameAndPassword(loginname, password, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void selectUserByNameAndPassword3() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		
		UserController.selectUserByNameAndPassword(loginname, password, request, response);
		assertEquals("false",UserController.getBmp()); 
	}
	
	@Test
	public void insertUser1() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		int userpower = 1;
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.insertUser(loginname, password, userpower)).thenReturn(1);
		
		UserController.insertUser(loginname, password, userpower, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void insertUser2() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		int userpower = 1;
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.insertUser(loginname, password, userpower)).thenReturn(0);
		
		UserController.insertUser(loginname, password, userpower, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void insertUser3() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		int userpower = 1;
		
		UserController.insertUser(loginname, password, userpower, request, response);
		assertEquals("false",UserController.getBmp()); 
	}
	
	@Test
	public void insertClassAccount1() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		int userpower = 1;
		int classId = 1;
		int studentId =1;
		
		UserController.insertClassAccount(loginname, password, userpower, classId, studentId, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void insertClassAccount2() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		int userpower = 2;
		int classId = 1;
		int studentId =1;
		Grade grade=new Grade();
		Student student=new Student();
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.insertUser(loginname, password, userpower)).thenReturn(0);
		
		gradeService = mock(GradeService.class);
		UserController.setGradeService(gradeService);
		when(gradeService.selectByClassId(classId)).thenReturn(grade);
		
		studentService = mock(StudentService.class);
		UserController.setStudentService(studentService);
		when(studentService.getOneStudentById(studentId)).thenReturn(student);
		
		UserController.insertClassAccount(loginname, password, userpower, classId, studentId, request, response);
		assertEquals("false",UserController.getBmp()); 
	}
	
	@Test
	public void insertClassAccount3() throws Exception {
		//fail("Not yet implemented");
		String loginname = "swl";
		String password = "123";
		int userpower = 2;
		int classId = 1;
		int studentId =1;
		
		UserController.insertClassAccount(loginname, password, userpower, classId, studentId, request, response);
		assertEquals("false",UserController.getBmp()); 
	}
	
	@Test
	public void selectUserByClassId1() throws Exception {
		//fail("Not yet implemented");
		int classId = 1;
		
		Grade grade=new Grade();
		Student student=new Student();
		User user=new User();
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.findUserById(grade.getGradMonitor())).thenReturn(user);
		
		gradeService = mock(GradeService.class);
		UserController.setGradeService(gradeService);
		when(studentService.getOneStudentById(user.getUserBelong())).thenReturn(student);
		
		UserController.selectUserByClassId(classId, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void selectUserByClassId2() throws Exception {
		//fail("Not yet implemented");
		int classId = 1;
		UserController.selectUserByClassId(classId, request, response);
		assertEquals("false",UserController.getBmp()); 
	}
	
	@Test
	public void selectAll1() throws Exception {
		//fail("Not yet implemented");
		
		List<ClassAccount> list = new ArrayList();
		ClassAccount classAccount = new ClassAccount();
		list.add(classAccount);
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.selectAll()).thenReturn(list);
		
		UserController.selectAll(request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void selectAll2() throws Exception {
		//fail("Not yet implemented");
		
		List<ClassAccount> list = new ArrayList();
		ClassAccount classAccount = new ClassAccount();
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.selectAll()).thenReturn(list);
		
		UserController.selectAll(request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void selectAll3() throws Exception {
		//fail("Not yet implemented");
		
		UserController.selectAll(request, response);
		assertEquals("false",UserController.getBmp()); 
	}
	
	@Test
	public void deleteOne1() throws Exception {
		//fail("Not yet implemented");
		int gradId = 1;
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.deleteOne(gradId)).thenReturn(1);
		
		UserController.deleteOne(gradId, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void deleteOne2() throws Exception {
		//fail("Not yet implemented");
		int gradId = 1;
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(userService.deleteOne(gradId)).thenReturn(0);
		
		UserController.deleteOne(gradId, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void deleteOne3() throws Exception {
		//fail("Not yet implemented");
		int gradId = 1;
		
		UserController.deleteOne(gradId, request, response);
		assertEquals("false",UserController.getBmp()); 
	}
	
	@Test
	public void updateOne1() throws Exception {
		//fail("Not yet implemented");
		int gradId = 1;
		String studNum ="10010002";
		String userName ="swl";
		String userPassword = "123";
		Grade grade = new Grade();
		Student student = new Student();
		
		userService = mock(UserService.class);
		UserController.setUserService(userService);
		when(gradeService.selectByClassId(gradId)).thenReturn(grade);
		
		studentService = mock(StudentService.class);
		UserController.setStudentService(studentService);
		when(studentService.getOneStudent(studNum)).thenReturn(student);
		
		UserController.updateOne(gradId, studNum, userName, userPassword, request, response);
		assertEquals("true",UserController.getBmp()); 
	}
	
	@Test
	public void updateOne2() throws Exception {
		//fail("Not yet implemented");
		int gradId = 1;
		String studNum ="10010002";
		String userName ="swl";
		String userPassword = "123";
		
		UserController.updateOne(gradId, studNum, userName, userPassword, request, response);
		assertEquals("false",UserController.getBmp()); 
	}
}
