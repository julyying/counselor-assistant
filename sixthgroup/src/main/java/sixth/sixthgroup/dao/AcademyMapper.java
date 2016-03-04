package sixth.sixthgroup.dao;

import java.util.List;

import sixth.sixthgroup.model.Academy;

public interface AcademyMapper {
    int deleteByPrimaryKey(Integer acadId);

    int insert(Academy record);

    int insertSelective(Academy record);

    Academy selectByPrimaryKey(Integer acadId);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);
    /**
     * 获取所有学院
     * @return list
     */
    List<Academy> selectAll();
    /**
     * 通过学院名称查找学院的id
     */
    Academy selectByName(String acadName);
}