package sixth.sixthgroup.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import sixth.sixthgroup.model.Diary;
import sixth.sixthgroup.service.DiaryService;

@Controller
@RequestMapping("/DiaryController")
public class DiaryController {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	private DiaryService diaryService;

	private String tmp;
	
	public String getTmp() {
		return tmp;
	}
	
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	public DiaryService getDiaryService() {
		return diaryService;
	}
	@Autowired
	public void setDiaryService(DiaryService diaryService) {
		this.diaryService = diaryService;
	}
	/**
	 * 添加一条日记
	 * @param content 内容
	 * @param time 截止时间
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/insertOne")
	public ModelAndView insertOne(String content,String time, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		//String tmp = null;
		try {
			java.util.Date date=DATE_FORMAT.parse(time);
			
			Diary diary=new Diary();
			diary.setDiarContent(content);
			diary.setDiarTime(date);
			diary.setDiarUser(2);
			
			int key=0;
			key=this.diaryService.insertOne(diary);
			if(key==1){
				map.put("result", Boolean.TRUE);
			}else{
				map.put("result", Boolean.FALSE);
			}
			tmp="true";
			
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
			tmp="false";
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
			//mav.setViewName(tmp);
			return mav;
		}
	}
	
	/**
	 * 删除一条日记
	 * @param id 日记的id
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/deleteById")
	public ModelAndView deleteById(int id, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		//String bmp = null;
		try {
			int key = 0;
			key=this.diaryService.deleteByPrimaryKey(id);
			if(key==1){
				map.put("result", Boolean.TRUE);
			}else{
				map.put("result", Boolean.FALSE);
			}
			tmp = "true";
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
			tmp = "false";
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
		//	mav.setViewName(bmp);
			return mav;
		}
	}
	
	/**
	 * 获取所有的日记
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
		//String bmp = null;
		try {
			List<Diary> list=this.diaryService.selectAll();
			List<Diary> diaryList = new ArrayList();
			int len=list.size();
			for(int i=0;i<len;i++){
				Diary test= new Diary();
				test=list.get(i);
				test.setTime(DATE_FORMAT.format(test.getDiarTime()));
				
				diaryList.add(test);
			}
			
			if(len>0){
				map.put("result", Boolean.TRUE);
				map.put("diaryList",diaryList );
			}else{
				map.put("result", Boolean.FALSE);
			}
			tmp = "true";
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
			tmp = "false";
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
			//mav.setViewName(bmp);
			return mav;
		}
	}
}
