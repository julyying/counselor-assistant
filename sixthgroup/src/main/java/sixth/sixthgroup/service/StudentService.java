package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.Student;

public interface StudentService {
	/**
	 * 获取所有学生
	 * @return studentList
	 */
	public  List<Student> getAll();
	/**
	 * 根据学号获取一个学生
	 * @param studNum 学号
	 * @return student
	 */
	public Student getOneStudent(String studNum);
	/**
	 * 添加一个学生
	 * @param student 被添加的学生的详细信息
	 * @return
	 */
	public int addOneStudent(Student student);
	/**
	 * 通过学号查找一个学生
	 * @param studId
	 * @return
	 */
	public Student getOneStudentById(int studId);
	/**
	 * 通过班级id获取学生
	 * @param gradeid
	 * @return
	 */
	public List<Student> getByGradeid(int gradeid);
	/**
	 * 通过学号删除一个学生
	 * @param studNum
	 * @return
	 */
	public int deleteOne(String studNum);
	/**
	 * 通过学生id修改学生信息
	 * @param record
	 * @return
	 */
	public int updateOne(Student record);
}
