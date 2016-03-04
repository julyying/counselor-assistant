package sixth.sixthgroup.dao;

import java.util.List;

import sixth.sixthgroup.model.SpecialInfoClass;

public interface SpecialInfoClassMapper {
    int deleteByPrimaryKey(Integer spclId);

    int insert(SpecialInfoClass record);

    int insertSelective(SpecialInfoClass record);

    SpecialInfoClass selectByPrimaryKey(Integer spclId);

    int updateByPrimaryKeySelective(SpecialInfoClass record);

    int updateByPrimaryKey(SpecialInfoClass record);
    
    /**
     * 获取所有类型
     */
    List<SpecialInfoClass> selectAll();
}