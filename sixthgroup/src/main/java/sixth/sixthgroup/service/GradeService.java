package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.Grade;

public interface GradeService {
	/**
	 * 添加一个班级
	 * @param grade 被添加的班级信息
	 * @return
	 */
	public int addOneClass(Grade grade);
	
	/**
	 * 通过班级名称查找班级
	 * @param gradName 班级名称
	 * @return
	 */
	public Grade selectByClassName(String gradName);
	/**
	 * 获取所有班级
	 * @return
	 */
	public List<Grade> selectAll();
	/**
	 * 通过班级id修改班级的班长id
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(Grade record);
	/**
	 * 通过班级id查找班级
	 */
	public Grade selectByClassId(int classId);
}
