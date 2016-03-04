package sixth.sixthgroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.dao.SpecialInfoClassMapper;
import sixth.sixthgroup.model.SpecialInfoClass;
import sixth.sixthgroup.service.SpecialInfoClassService;
@Service("specialInfoClassService")
public class SpecialInfoClassServiceImpl implements SpecialInfoClassService {
	private SpecialInfoClassMapper specialInfoClassMapper;
	
	public SpecialInfoClassMapper getSpecialInfoClassMapper() {
		return specialInfoClassMapper;
	}
	@Autowired
	public void setSpecialInfoClassMapper(
			SpecialInfoClassMapper specialInfoClassMapper) {
		this.specialInfoClassMapper = specialInfoClassMapper;
	}

	public List<SpecialInfoClass> selectAll() {
		// TODO Auto-generated method stub
		List<SpecialInfoClass> list=this.specialInfoClassMapper.selectAll();
		return list;
	}

}
