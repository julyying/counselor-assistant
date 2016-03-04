package sixth.sixthgroup.dao;

import java.util.List;

import sixth.sixthgroup.model.HistoryStudent;

public interface HistoryStudentMapper {
    int deleteByPrimaryKey(Integer histId);

    int insert(HistoryStudent record);

    int insertSelective(HistoryStudent record);

    HistoryStudent selectByPrimaryKey(Integer histId);

    int updateByPrimaryKeySelective(HistoryStudent record);

    int updateByPrimaryKey(HistoryStudent record);
    /**
     * 选取未参加班会人员
     * @return
     */
    List<HistoryStudent> selectPeopleToHold();
    /**
     * 获取所有人员
     * @return
     */
    List<HistoryStudent> selectAll();
}