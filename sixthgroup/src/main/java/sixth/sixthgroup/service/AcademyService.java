package sixth.sixthgroup.service;


import java.util.List;

import sixth.sixthgroup.model.Academy;

public interface AcademyService {
	/**
	 * 获取所有学院
	 * @return
	 */
	public  List<Academy> getAll();
	/**
	 * 通过学院名称获取学院id
	 * @param name 学院名称
	 * @return
	 */
	int getIdByName(String name);
}
