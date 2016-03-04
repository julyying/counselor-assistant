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

import sixth.sixthgroup.model.HistoryStudent;
import sixth.sixthgroup.service.HistoryStudentService;

@Controller
@RequestMapping("/historyStudentController")
public class HistoryStudentController {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");

	private HistoryStudentService historyStudentService;
	
	private String bmp;
	
	public String getBmp() {
		return bmp;
	}
	
	public void setBmp(String bmp) {
		this.bmp = bmp;
	}
	public HistoryStudentService getHistoryStudentService() {
		return historyStudentService;
	}
	@Autowired
	public void setHistoryStudentService(HistoryStudentService historyStudentService) {
		this.historyStudentService = historyStudentService;
	}
	
	/**
	 * 选取一定数量的人员举办班会
	 * @param num 开班会的人数
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectPeopleToHold")
	public ModelAndView selectPeopleToHold(int num, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
	//	String bmp = null;
		Map map = new HashMap();
		try {
			List<HistoryStudent> list=this.historyStudentService.selectPeopleToHold();
			int len=list.size();
			if(len<num){
				System.out.println(len);
				map.put("result", Boolean.FALSE);
				map.put("message", "人员数不足");
			}else{
				List<HistoryStudent> studList = new ArrayList();
				for(int i=0;i<num;i++){
					studList.add(list.get(i));
					
					HistoryStudent stud = new HistoryStudent();
					Date date=new Date();
					stud.setHistStudentid(list.get(i).getStudId());
					stud.setHistTime(date);
					this.historyStudentService.insertOne(stud);
				}
				map.put("result", Boolean.TRUE);	
				map.put("studList", studList);	
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
	 * 查看往届人员
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectHistoryStudent")
	public ModelAndView selectHistoryStudent(int pageSize, int pageNum, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
	//	String bmp = null;
		Map map = new HashMap();
		try {
			List<HistoryStudent> list = this.historyStudentService.selectAll();
			
			int maxNum = list.size();
			int maxPage = maxNum/pageSize;
			if(maxNum%pageSize !=0){
				maxPage+=1;
			}
			int beginNum = (pageNum-1) * pageSize;
			int endNum=beginNum+pageSize;
			if(endNum>maxNum){
				endNum=maxNum;
			}
			
			List<HistoryStudent> studList = new ArrayList();
			for(int i=beginNum;i<endNum;i++){
				HistoryStudent test = new HistoryStudent();
				test= list.get(i);
				test.setTime(DATE_FORMAT.format(test.getHistTime()));
				studList.add(test);
			}
			if(studList.size()>0){
				map.put("result", Boolean.TRUE);
				map.put("studList", studList);
				map.put("maxPage", maxPage);
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
