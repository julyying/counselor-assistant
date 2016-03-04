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

import sixth.sixthgroup.model.Academy;
import sixth.sixthgroup.service.AcademyService;

@Controller
@RequestMapping("/academyController")
public class AcademyController {
	private AcademyService academyService;

	public AcademyService getAcademyService() {
		return academyService;
	}
	@Autowired
	public void setAcademyService(AcademyService academyService) {
		this.academyService = academyService;
	}
	
	private String tmp;
	
	public String getTmp() {
		return tmp;
	}
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	/**
	 * 获取学院列表
	 * @return {"result":true,"AcademyList":[{"acadId":1,"acadName":"计算机科学与技术学院"},{"acadId":2,"acadName":"理学院"}]}
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectAll")
	public ModelAndView selectAll(HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		//String tmp = null;
		try {
			
			List<Academy> list = this.academyService.getAll();
			map.put("result", Boolean.TRUE);
			map.put("AcademyList", list);
			tmp = "true";
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			tmp = "false";
			e.printStackTrace();
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
			//mav.setViewName(tmp);
			return mav;
		}
	}
}
