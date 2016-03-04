package sixth.sixthgroup.dao;

import java.util.List;

import sixth.sixthgroup.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
	
    /**
     * 获取所有学生的详细信息
     * @return
     */
    List<Student> selectAll();
    /**
     * 根据学号获取一个学生
     * @param studNum 学号
     * @return student
     */
    Student selectByStudNum(String studNum);
    /**
     * 添加一个学生
     * @param student
     * @return
     */
    Student insertOneStudent(Student student);
    /**
     * 通过班级id获取班级的学生
     * @param studGradeid
     * @return
     */
    List<Student> selectByGradeId(Integer studGradeid);
    /**
     * 通过学号删除一个学生
     * @param studNum  学号
     * @return 
     */
    int deleteByStudNum(String studNum);
}