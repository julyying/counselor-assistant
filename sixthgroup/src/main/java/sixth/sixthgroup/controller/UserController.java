package sixth.sixthgroup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import sixth.sixthgroup.model.ClassAccount;
import sixth.sixthgroup.model.Grade;
import sixth.sixthgroup.model.Student;
import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.GradeService;
import sixth.sixthgroup.service.StudentService;
import sixth.sixthgroup.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {
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
	
	private String bmp;
	
	public String getBmp() {
		return bmp;
	}
	
	public void setBmp(String bmp) {
		this.bmp = bmp;
	}
	/**
	 * 通过id查找用户
	 * @param id 用户的id
	 * @return {"result":true,"user":{"userId":1,"userName":"swl","userPassword":"123","userPower":1}}
	 */
    @SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectUserById")
    public ModelAndView selectUserById(int id, HttpServletRequest request,HttpServletResponse response) {
    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			User user=new User();
			user=userService.findUserById(id);
			if(null==user){
    			map.put("result", Boolean.FALSE);
    		}else{
    			map.put("result", Boolean.TRUE);
    			map.put("user", user);
    		}
			bmp = "true";
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
			bmp = "false";
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
    
    /**
     * 通过用户名和密码 查找用户
     * @param loginname 用户名
     * @param password 密码
     * @return {"result":true,"user":{"userId":1,"userName":"swl","userPassword":"123","userPower":1}}
     */
    @SuppressWarnings({ "unchecked", "finally" })
	@RequestMapping("/selectUserByNameAndPassword")
    public ModelAndView selectUserByNameAndPassword(String loginname,String password, HttpServletRequest request,HttpServletResponse response) {
        	ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		User user= new User();
    		user=this.userService.findUserByNameAndPassword(loginname, password);
    		if(null==user){
    			map.put("result", Boolean.FALSE);
    		}else{
    			map.put("result", Boolean.TRUE);
    			map.put("user", user);
    		}
    		bmp = "true";
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    		bmp = "false";
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
    /**
     * 添加一个用户名
     * @param loginname 用户名
     * @param password 密码
     * @param userpower 用户权限
     * @return {"result":false}
     */
    @SuppressWarnings({ "finally", "unchecked" })
    @RequestMapping("/insertUser")
    public ModelAndView insertUser(String loginname, String password, int userpower, HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		int key=0;
    		key=this.userService.insertUser(loginname, password, userpower);
    		if(key==1){
    			map.put("result", Boolean.TRUE);
    		}else{
    			map.put("result", Boolean.FALSE);
    		}
    		bmp = "true";
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    		bmp = "false";
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
    /**
     * 添加一个班级账号
     * @param loginname 账号
     * @param password 密码
     * @param userpower 当前用户的权限； 1为学生，2为辅导员
     * @param classId 班级id
     * @param studentId 持有账号学生的id
     * @return
     */
    @SuppressWarnings({ "finally", "unchecked" })
    @RequestMapping("/insertClassAccount")
    public ModelAndView insertClassAccount(String loginname, String password, 
    		int userpower, int classId,int studentId,HttpServletRequest request,
    		HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		if(userpower == 1){
    			map.put("result", Boolean.FALSE);
    			map.put("message", "没有权限注册账号");
    		}else{
    			int key1=0,key2=0;
        		Grade grade=new Grade();
        		grade=this.gradeService.selectByClassId(classId);
        		Student student=new Student();
    			student=this.studentService.getOneStudentById(studentId);
        		if(grade != null && student != null){ 
        			User addUser=new User();
        			addUser.setUserName(loginname);
        			addUser.setUserPassword(password);
        			addUser.setUserPower(1);
        			addUser.setUserBelong(studentId);
        			key1=this.userService.insertUser(addUser);
        			
        			User user=new User();
    				user=this.userService.findUserByNameAndPassword(loginname, password);
        			grade.setGradMonitor(user.getUserId());
    				key2=this.gradeService.updateByPrimaryKey(grade);					
        			if(key1==1 && key2==1){
        				map.put("user", user);
        				map.put("result", Boolean.TRUE);
        			}else{
        				map.put("result", Boolean.FALSE);
        			}   			
        		}else{
        			map.put("result", Boolean.FALSE);
        		}
    		}		
    		bmp = "true";
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    		bmp = "false";
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
    
    /**
     * 查找某个班级账号的所有信息（账号持有人、账号、密码）
     * @param classId
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "finally", "unchecked" })
    @RequestMapping("/selectUserByClassId")
    public ModelAndView selectUserByClassId(int classId, HttpServletRequest request,HttpServletResponse response) {
        	ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		Grade grade =new Grade();
    		User user=new User();
    		Student student =new Student();
    		grade= this.gradeService.selectByClassId(classId);
    		user=this.userService.findUserById(grade.getGradMonitor());
    		student = this.studentService.getOneStudentById(user.getUserBelong());
    	
    		System.out.println(classId);
    		System.out.println(grade.getGradMonitor());
    		System.out.println(user.getUserBelong());
    		
    		map.put("result", Boolean.TRUE);
        	map.put("accountNumber",user.getUserName());
        	map.put("password",user.getUserPassword());
        	map.put("userName",student.getStudName());
    	bmp = "true";
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    		bmp = "false";
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
    
    /**
     * 查找所有的班级账号信息（即权限为学生的账号信息，默认学生为1）
     * @return
     */
    @SuppressWarnings({ "finally", "unchecked" })
    @RequestMapping("/selectAll")
    public ModelAndView selectAll(HttpServletRequest request,HttpServletResponse response) {
        	ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		List<ClassAccount> list=this.userService.selectAll();
    		if(list.size()>0){
    			map.put("result", Boolean.TRUE);
    			map.put("ClassAccountList", list);
    		}else{
    			map.put("result", Boolean.FALSE);
    			map.put("message", "不存在班级账号");
    		}
    		bmp = "true";
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    		bmp = "false";
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
    
    /**
     * 通过班级id删除班级账号
     * @param gradId 班级id
     * @return
     */
    @SuppressWarnings({ "finally", "unchecked" })
    @RequestMapping("/deleteOne")
    public ModelAndView deleteOne(int gradId, HttpServletRequest request,HttpServletResponse response) {
        	ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		int key = 0;
    		key = this.userService.deleteOne(gradId);
    		if(key != 0){
    			map.put("result", Boolean.TRUE);
    		}else{
    			map.put("result", Boolean.TRUE);
    			map.put("message","班级账号不存在" );
    		}
    		bmp = "true";
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    		bmp = "false";
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
    
    @SuppressWarnings({ "finally", "unchecked" })
    @RequestMapping("/updateOne")
    public ModelAndView updateOne(int gradId, String studNum, String userName,
			String userPassword, HttpServletRequest request,HttpServletResponse response) {
        	ModelAndView mav = new ModelAndView();
    	MappingJacksonJsonView view = new MappingJacksonJsonView();
    	@SuppressWarnings("rawtypes")
    	Map map = new HashMap();
    	try {
    		Grade grade = new Grade();
    		grade = this.gradeService.selectByClassId(gradId);
    		
    		Student student = new Student();
    		student = this.studentService.getOneStudent(studNum);
    		
    		if(grade == null){
    			map.put("result", Boolean.FALSE);
        		map.put("message", "该班级不存在");
    		}else if(grade.getGradMonitor() == null){
    			map.put("result", Boolean.FALSE);
        		map.put("message", "该班级不存在班级账号");
    		}else if(student == null){
    			map.put("result", Boolean.FALSE);
        		map.put("message", "该学生不存在");
    		}else{
    			int key = 0;
    			key = this.userService.updateOne(gradId, studNum, userName, userPassword);
    			if(key != 0){
    				map.put("result", Boolean.TRUE);
    			}else{
    				map.put("result", Boolean.FALSE);
    				map.put("message","更新操作发生异常");
    			}
    		}
    		bmp = "true";
    	} catch (Exception e) {
    		map.put("result", Boolean.FALSE);
    		e.printStackTrace();
    		bmp = "false";
    	}finally{
    		view.setAttributesMap(map);
    		mav.setView(view);
    		return mav;
    	}
    }
}
