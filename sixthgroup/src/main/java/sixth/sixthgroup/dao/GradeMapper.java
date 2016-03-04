package sixth.sixthgroup.dao;

import java.util.List;

import sixth.sixthgroup.model.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer gradId);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gradId);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
    
    /**
     * 通过班级名称查找班级
     */
    Grade selectByClassName(String gradName);
    /**
     * 查找所有班级
     * @return
     */
    List<Grade> selectAll();
}