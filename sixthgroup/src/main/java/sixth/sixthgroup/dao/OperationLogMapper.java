package sixth.sixthgroup.dao;

import java.util.List;

import sixth.sixthgroup.model.OperationLog;

public interface OperationLogMapper {
    int deleteByPrimaryKey(Integer oploId);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer oploId);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKey(OperationLog record);
	
	 /**
     * 查找所有的操作日志
     * @return
     */
    List<OperationLog> selectAll();
    /**
     * 通过用户id查找操作记录
     */
    List<OperationLog> selectByPeopleId(Integer oploPeopleid);
}