package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}