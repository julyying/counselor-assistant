package sixth.sixthgroup.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import sixth.sixthgroup.model.Student;
import sixth.sixthgroup.service.StudentService;

@Controller
@RequestMapping("/studentController")
public class StudentController {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	private String bmp;
	
	public String getBmp() {
		return bmp;
	}
	
	public void setBmp(String bmp) {
		this.bmp = bmp;
	}
	/**
	 * 获取所有学生
	 * @return studentList
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectAll")
	public ModelAndView selectAll(HttpServletRequest request,HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			List<Student> list=this.studentService.getAll();
			List<Student> studList = new ArrayList();
			int len=list.size();
			for(int i=0;i<len;i++){
				Student test = new Student();
				test=list.get(i);
				if(test.getStudBron()!=null){
					test.setBothTime(DATE_FORMAT.format(test.getStudBron()));
				}
				studList.add(test);
			}
			if(len>0){
				map.put("result", Boolean.TRUE);
				map.put("studList", studList);
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
	 * 通过班级id获取学生
	 * @param gradeId 班级id
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectByGradeid")
	public ModelAndView selectByGradeid(int gradeId,HttpServletRequest request,HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			System.out.println("**************");
			List<Student> list=this.studentService.getByGradeid(gradeId);
			List<Student> studList = new ArrayList();
			int len=list.size();
			for(int i=0;i<len;i++){
				Student test = new Student();
				test=list.get(i);
				if(test.getStudBron()!=null){
					test.setBothTime(DATE_FORMAT.format(test.getStudBron()));
				}
				studList.add(test);
			}
			if(len>0){
				map.put("result", Boolean.TRUE);
				map.put("studList", studList);
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
	 * 根据学号获取一个学生
	 * @param studNum 学号
	 * @return student
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectStudByStudNum")
	public ModelAndView selectStudByStudNum(String studNum, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			Student student=new Student();
			student=this.studentService.getOneStudent(studNum);
			if(student!=null){
				student.setBothTime(DATE_FORMAT.format(student.getStudBron()));
				map.put("result", Boolean.TRUE);
				map.put("student",student );
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
	 * 添加一个学生
	 * @param studGradeid 班级id
	 * @param studName 姓名
	 * @param studSex 性别
	 * @param studAge 年龄
	 * @param studTel 电话
	 * @param studQq QQ
	 * @param studAddress 住址
	 * @param studIdcard 省份证号
	 * @param studNum 学号
	 * @param studBron 出生日期
	 * @param studBanknum 银行卡号
	 * @param studNation 民族
	 * @param studDorimitory 宿舍
	 * @param studParentname 家长姓名
	 * @param studParenttel 家长电话
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/insertOneStudent")
	public ModelAndView insertOneStudent(int studGradeid,String studName,String studSex,
			String studAge,String studTel,String studQq,
			String studAddress,String studIdcard,String studNum,
			String studBron,String studBanknum,String studNation,
			String studDorimitory,String studParentname,String studParenttel,
			HttpServletRequest request,HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
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
			
			int key=0;
			key=this.studentService.addOneStudent(student);
			if(key!=0){
				map.put("result", Boolean.TRUE);
				map.put("student", student);
			}else{
				map.put("result", Boolean.FALSE);
				map.put("message", "此学号已经存在");
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
	 * 通过学号删除一个学生
	 * @param studNum
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/deleteOne")
	public ModelAndView deleteOne(String studNum, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			int key = this.studentService.deleteOne(studNum);
			if(key != 0){
				map.put("result", Boolean.TRUE);
			}else{
				map.put("result", Boolean.FALSE);
				map.put("message","学号不存在或发生异常" );
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
	 * 修改一个学生的信息
	 * @param studGradeid
	 * @param studName
	 * @param studSex
	 * @param studAge
	 * @param studTel
	 * @param studQq
	 * @param studAddress
	 * @param studIdcard
	 * @param studNum
	 * @param studBron
	 * @param studBanknum
	 * @param studNation
	 * @param studDorimitory
	 * @param studParentname
	 * @param studParenttel
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/updateOne")
	public ModelAndView updateOne(int studGradeid,String studName,String studSex,
			String studAge,String studTel,String studQq,
			String studAddress,String studIdcard,String studNum,
			String studBron,String studBanknum,String studNation,
			String studDorimitory,String studParentname,String studParenttel,
			HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			Student student = new Student();
			
				java.util.Date date=DATE_FORMAT.parse(studBron);  
			
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
				
				int key = 0 ;
				key = this.studentService.updateOne(student);
				if(key != 0){
					map.put("result", Boolean.TRUE);
				}else{
					map.put("result", Boolean.FALSE);
					//可能是外键studGradeid引起的
					map.put("message","更新操作发生异常" );
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
