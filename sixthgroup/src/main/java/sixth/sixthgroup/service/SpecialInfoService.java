package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.SpecialInfo;

public interface SpecialInfoService {
	/**
	 * 通过特殊信息类型获取对应特殊信息列表
	 * @param spinClassno 特殊信息类型id
	 * @return
	 */
	 public List<SpecialInfo> selectByInfoType(Integer spinClassno);
	 /**
	  * 添加一条记录
	  * @param record
	  * @return
	  */
	 public int insertOneInfo(SpecialInfo record);
	 /**
	  * 通过主键更新一条特殊信息
	  * @param record
	  * @return
	  */
	 public int updateByPrimaryKey(SpecialInfo record);
	 /**
	  * 通过id删除一条特殊信息记录
	  * @param spinId
	  * @return
	  */
	 public int deleteOne(int spinId);
}
