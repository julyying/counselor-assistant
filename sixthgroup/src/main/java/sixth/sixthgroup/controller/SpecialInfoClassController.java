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

import sixth.sixthgroup.model.SpecialInfoClass;
import sixth.sixthgroup.service.SpecialInfoClassService;

@Controller
@RequestMapping("/specialInfoClassController")
public class SpecialInfoClassController {
	private SpecialInfoClassService specialInfoClassService;

	private String bmp;
	
	public String getBmp() {
		return bmp;
	}
	
	public void setBmp(String bmp) {
		this.bmp = bmp;
	}
	public SpecialInfoClassService getSpecialInfoClassService() {
		return specialInfoClassService;
	}
	@Autowired
	public void setSpecialInfoClassService(
			SpecialInfoClassService specialInfoClassService) {
		this.specialInfoClassService = specialInfoClassService;
	}
	
	/**
	 * 获取所有特殊信息类型
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectAll")
	public ModelAndView selectAll( HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		try {
			List<SpecialInfoClass> list=this.specialInfoClassService.selectAll();
			if(list.size()>0){
				map.put("result", Boolean.TRUE);
				map.put("list",list );
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
}
