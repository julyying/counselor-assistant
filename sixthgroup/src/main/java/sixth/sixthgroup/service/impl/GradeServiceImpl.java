package sixth.sixthgroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.dao.GradeMapper;
import sixth.sixthgroup.model.Grade;
import sixth.sixthgroup.service.GradeService;

@Service("gradeService")
public class GradeServiceImpl implements GradeService {
	private GradeMapper gradeMapper;
	
	public GradeMapper getGradeMapper() {
		return gradeMapper;
	}
	
	@Autowired
	public void setGradeMapper(GradeMapper gradeMapper) {
		this.gradeMapper = gradeMapper;
	}
	
	public int addOneClass(Grade grade) {
		// TODO Auto-generated method stub
		int key=0;
		Grade reGrade=this.gradeMapper.selectByClassName(grade.getGradName());
		if(reGrade==null){
			key=this.gradeMapper.insert(grade);
		}
		return key;
	}

	public Grade selectByClassName(String gradName) {
		// TODO Auto-generated method stub
		Grade grade = new Grade();
		grade=this.gradeMapper.selectByClassName(gradName);
		return grade;
	}

	public List<Grade> selectAll() {
		// TODO Auto-generated method stub
		List<Grade> list=this.gradeMapper.selectAll();
		return list;
	}

	public int updateByPrimaryKey(Grade record) {
		// TODO Auto-generated method stub
		int key=0;
		Grade test= new Grade();
		test=this.gradeMapper.selectByPrimaryKey(record.getGradId());
		if(test != null){
			key=this.gradeMapper.updateByPrimaryKey(record);
		}
		return key;
	}

	public Grade selectByClassId(int classId) {
		// TODO Auto-generated method stub
		Grade grade = new Grade();
		grade=this.gradeMapper.selectByPrimaryKey(classId);
		return grade;
	}

}
