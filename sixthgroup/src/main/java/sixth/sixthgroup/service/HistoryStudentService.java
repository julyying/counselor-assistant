package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.HistoryStudent;

public interface HistoryStudentService {
	/**
	 * 查找未参与过班会的人员
	 * @return
	 */
	public List<HistoryStudent> selectPeopleToHold();
	/**
	 * 添加一个历史记录
	 * @param student
	 * @return
	 */
	public int insertOne(HistoryStudent student);
	/**
     * 获取所有人员
     * @return
     */
	public List<HistoryStudent> selectAll();
}
