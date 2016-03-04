package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.SpecialInfoClass;

public interface SpecialInfoClassService {
	/**
	 * 获取所有特殊信息类型
	 * @return
	 */
	public List<SpecialInfoClass> selectAll();
}
