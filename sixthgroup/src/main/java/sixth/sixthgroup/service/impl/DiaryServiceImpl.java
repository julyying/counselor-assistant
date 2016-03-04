package sixth.sixthgroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixth.sixthgroup.dao.DiaryMapper;
import sixth.sixthgroup.model.Diary;
import sixth.sixthgroup.service.DiaryService;
@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {
	private DiaryMapper diaryMapper;
	
	public DiaryMapper getDiaryMapper() {
		return diaryMapper;
	}
	@Autowired
	public void setDiaryMapper(DiaryMapper diaryMapper) {
		this.diaryMapper = diaryMapper;
	}

	public int insertOne(Diary record) {
		// TODO Auto-generated method stub
		int key=0;
		key=this.diaryMapper.insert(record);
		return key;
	}
	public int deleteByPrimaryKey(Integer diarId) {
		// TODO Auto-generated method stub
		int key=0;
		key=this.diaryMapper.deleteByPrimaryKey(diarId);
		return key;
	}
	public List<Diary> selectAll() {
		// TODO Auto-generated method stub
		List<Diary> list=this.diaryMapper.selectAll();
		return list;
	}

}
