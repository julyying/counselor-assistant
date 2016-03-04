package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.Diary;

public interface DiaryService {
	/**
	 * 添加一条工作记录
	 * @param record
	 * @return
	 */
	public int insertOne(Diary record);
	
	/**
	 * 通过主键删除一条记录
	 */
	public int deleteByPrimaryKey(Integer diarId);
	 /**
	  * 查找所有工作日记
	  * @return
	  */
	public List<Diary> selectAll();
}
