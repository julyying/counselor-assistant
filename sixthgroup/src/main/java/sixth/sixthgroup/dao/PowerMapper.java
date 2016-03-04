package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.Power;

public interface PowerMapper {
    int deleteByPrimaryKey(Integer poweId);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(Integer poweId);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);
}