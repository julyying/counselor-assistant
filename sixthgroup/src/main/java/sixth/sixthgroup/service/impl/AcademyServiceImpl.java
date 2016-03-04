package sixth.sixthgroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.dao.AcademyMapper;
import sixth.sixthgroup.model.Academy;
import sixth.sixthgroup.service.AcademyService;

@Service("academyService")
public class AcademyServiceImpl implements AcademyService {
	private AcademyMapper academyMapper;
	
	public AcademyMapper getAcademyMapper() {
		return academyMapper;
	}
	@Autowired
	public void setAcademyMapper(AcademyMapper academyMapper) {
		this.academyMapper = academyMapper;
	}
	
	public List<Academy> getAll() {
		// TODO Auto-generated method stub
		List<Academy> list = this.academyMapper.selectAll();
		return list;
	}
	
	public int getIdByName(String name) {
		// TODO Auto-generated method stub
		int key=0;
		Academy academy=new Academy();
		academy=this.academyMapper.selectByName(name);
		if(academy !=null){
			key=academy.getAcadId();
		}
		return key;
	}

}
