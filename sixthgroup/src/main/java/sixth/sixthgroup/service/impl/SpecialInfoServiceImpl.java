package sixth.sixthgroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.dao.SpecialInfoMapper;
import sixth.sixthgroup.model.SpecialInfo;
import sixth.sixthgroup.service.SpecialInfoService;
@Service("specialInfoService")
public class SpecialInfoServiceImpl implements SpecialInfoService {
	private SpecialInfoMapper specialInfoMapper;
	
	public SpecialInfoMapper getSpecialInfoMapper() {
		return specialInfoMapper;
	}
	
	@Autowired
	public void setSpecialInfoMapper(SpecialInfoMapper specialInfoMapper) {
		this.specialInfoMapper = specialInfoMapper;
	}
	
	public List<SpecialInfo> selectByInfoType(Integer spinClassno) {
		// TODO Auto-generated method stub
		List<SpecialInfo> list=this.specialInfoMapper.selectByInfoType(spinClassno);
		return list;
	}

	public int insertOneInfo(SpecialInfo record) {
		// TODO Auto-generated method stub
		int key=0;
		key=this.specialInfoMapper.insert(record);
		return key;
	}

	public int updateByPrimaryKey(SpecialInfo record) {
		// TODO Auto-generated method stub
		int key=0;
		key=this.specialInfoMapper.updateByPrimaryKey(record);
		return key;
	}

	public int deleteOne(int spinId) {
		// TODO Auto-generated method stub
		int key = 0;
		key = this.specialInfoMapper.deleteByPrimaryKey(spinId);
		return key;
	}

}
