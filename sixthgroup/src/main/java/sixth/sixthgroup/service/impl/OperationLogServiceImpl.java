package sixth.sixthgroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.model.OperationLog;
import sixth.sixthgroup.service.OperationLogService;
import sixth.sixthgroup.dao.OperationLogMapper;
@Service("operationLogService")
public class OperationLogServiceImpl implements OperationLogService {
	private OperationLogMapper OperationLogMapper;
	
	public OperationLogMapper getOperationLogMapper() {
		return OperationLogMapper;
	}
	@Autowired
	public void setOperationLogMapper(OperationLogMapper operationLogMapper) {
		OperationLogMapper = operationLogMapper;
	}

	public List<OperationLog> selectAll() {
		// TODO Auto-generated method stub
		List<OperationLog> list=this.OperationLogMapper.selectAll();
		return list;
	}
	public List<OperationLog> selectByPeopleId(int oploPeopleid) {
		// TODO Auto-generated method stub
		List<OperationLog> list=this.OperationLogMapper.selectByPeopleId(oploPeopleid);
		return list;
	}
	public int insertOne(OperationLog record) {
		// TODO Auto-generated method stub
		int key=0;
		key=this.OperationLogMapper.insert(record);
		return key;
	}

}
