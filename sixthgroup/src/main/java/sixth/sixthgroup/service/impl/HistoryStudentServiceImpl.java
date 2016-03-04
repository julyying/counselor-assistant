package sixth.sixthgroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.dao.HistoryStudentMapper;
import sixth.sixthgroup.model.HistoryStudent;
import sixth.sixthgroup.service.HistoryStudentService;
@Service("historyStudentService")
public class HistoryStudentServiceImpl implements HistoryStudentService {
	private HistoryStudentMapper historyStudentMapper;
	
	public HistoryStudentMapper getHistoryStudentMapper() {
		return historyStudentMapper;
	}
	@Autowired
	public void setHistoryStudentMapper(HistoryStudentMapper historyStudentMapper) {
		this.historyStudentMapper = historyStudentMapper;
	}

	public List<HistoryStudent> selectPeopleToHold() {
		// TODO Auto-generated method stub
		List<HistoryStudent> list=this.historyStudentMapper.selectPeopleToHold();
		return list;
	}
	public int insertOne(HistoryStudent student) {
		// TODO Auto-generated method stub
		int key = 0;
		key=this.historyStudentMapper.insert(student);
		return key;
	}
	public List<HistoryStudent> selectAll() {
		// TODO Auto-generated method stub
		List<HistoryStudent> list= this.historyStudentMapper.selectAll();
		return list;
	}
}
