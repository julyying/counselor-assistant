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

import sixth.sixthgroup.model.OperationLog;
import sixth.sixthgroup.model.User;
import sixth.sixthgroup.service.OperationLogService;
import sixth.sixthgroup.service.UserService;

@Controller
@RequestMapping("/operationLogController")
public class OperationLogController {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private OperationLogService operationLogService;
	
	private UserService userService;
	
	private String bmp;
	
	public String getBmp() {
		return bmp;
	}

	public void setBmp(String bmp) {
		this.bmp = bmp;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public OperationLogService getOperationLogService() {
		return operationLogService;
	}
	@Autowired
	public void setOperationLogService(OperationLogService operationLogService) {
		this.operationLogService = operationLogService;
	}
	
	/**
	 * 查找对应权限的所有的操作记录
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/selectAll")
	public ModelAndView selectAll(int userId,int pageNum,int pageSize, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		//String bmp =null;
		Map map = new HashMap();
		try {
			User user=new User();
			user=this.userService.findUserById(userId);
			List<OperationLog> list = new ArrayList();
			if(user.getUserPower()==1){
				/* 1 为学生权限 */
				list=this.operationLogService.selectByPeopleId(user.getUserId());
			}else{
				/* 2为辅导员权限 ,目前只有一个辅导员，所以查询所有记录*/
				list=this.operationLogService.selectAll();
			}
			
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
			
			List<OperationLog> operationList = new ArrayList();
			for(int i=beginNum;i<endNum;i++){
				OperationLog test = new OperationLog();
				test = list.get(i);
				test.setTime(DATE_FORMAT.format(test.getOploTime()));
				operationList.add(test);
			}
			if(operationList.size()>0){
				map.put("result", Boolean.TRUE);
				map.put("maxPage", maxPage);
				map.put("operationList", operationList);
			}else{
				map.put("result", Boolean.FALSE);
				map.put("maxPage", maxPage);
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
	 * 添加一条操作日志
	 * @param userId 操作者的id
	 * @param content 操作内容
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	@RequestMapping("/insertOne")
	public ModelAndView insertOne(int userId,String content, HttpServletRequest request,HttpServletResponse response) {
	    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		@SuppressWarnings("rawtypes")
		//String bmp = null;
		Map map = new HashMap();
		try {
			Date date=new Date();
			
			OperationLog obj = new OperationLog();
			obj.setOploPeopleid(userId);
			obj.setOploContent(content);
			obj.setOploTime(date);
			
			int key=0;
			key=this.operationLogService.insertOne(obj);
			if(key!=0){
				map.put("result", Boolean.TRUE);
			}else{
				map.put("result", Boolean.FALSE);
			}
			bmp = "true";
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			e.printStackTrace();
			bmp = "fasle";
		}finally{
			view.setAttributesMap(map);
			mav.setView(view);
		//	mav.setViewName(bmp);
			return mav;
		}
	}
}
