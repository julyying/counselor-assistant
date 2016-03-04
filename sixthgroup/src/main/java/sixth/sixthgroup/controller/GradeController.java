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

import sixth.sixthgroup.model.Grade;
import sixth.sixthgroup.service.GradeService;

@Controller
@RequestMapping("/gradeController")
public class GradeController {
	private GradeService gradeService;

	private String bmp;
	
	public String getBmp() {
		return bmp;
	}

	public void setBmp(String bmp) {
		this.bmp = bmp;
	}
	public GradeService getGradeService() {
		return gradeService;
	}
	@Autowired
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	
	/**
	 * 添加一个班级
	 * @param name 班级名称
	 * @param counselorId 辅导员id
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/addOneClass")
	public ModelAndView addOneClass(String name, int counselorId,HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		//String bmp = null;
		try {
			Grade grade= new Grade();
			grade.setGradName(name);
			grade.setGradCounselor(counselorId);
			
			int key=0;
			key=this.gradeService.addOneClass(grade);
			if(key != 0){
				map.put("result", Boolean.TRUE);
				map.put("grade",grade );
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
			//mav.setViewName(bmp);
			return mav;
		}
	}
	
	/**
	 * 通过班级名称查找班级
	 * @param gradName 班级名称
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectByClassName")
	public ModelAndView selectByClassName(String gradName, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
	//	String bmp = null;
		Map map = new HashMap();
		try {
			System.out.println(gradName);
			Grade grade= new Grade();
			grade=this.gradeService.selectByClassName(gradName);
			if(grade != null){
				map.put("result", Boolean.TRUE);
				map.put("grade",grade );
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
		//	mav.setViewName(bmp);
			return mav;
		}
	}
	/**
	 * 获取所有班级
	 * @return list
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectAll")
	public ModelAndView selectAll(HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
	//	String bmp = null;
		Map map = new HashMap();
		try {
			List<Grade> list=this.gradeService.selectAll();
			if(list.size()>0){
				map.put("result", Boolean.TRUE);
				map.put("gradeList", list);
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
		//	mav.setViewName(bmp);
			return mav;
		}
	}
}
