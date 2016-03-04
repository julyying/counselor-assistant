package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.ClassAccount;
import sixth.sixthgroup.model.User;

public interface UserService {
	/**
	 * 通过id查找用户
	 */
	public User findUserById(int id) throws Exception;
	/**
	 * 通过账号、密码删查找用户
	 */
	public User findUserByNameAndPassword(String loginnaem,String password) throws Exception;
	/**
	 * 添加一个用户
	 */
	public int insertUser(String loginname,String password,int userpower) throws Exception;
	/**
	 * 添加一个用户
	 * @param user 被添加用户的信息
	 * @return
	 */
	public int insertUser(User user)throws Exception;
	/**
	 * 查找所有班级账号
	 * @return
	 */
	public List<ClassAccount> selectAll();
	/**
	 * 通过班级id删除班级账号，这个班级还是存在的
	 * @param gradId
	 */
	public int deleteOne(int gradId);
	
	/**
	 * 修改一个班级账号信息
	 * @param gradId
	 * @param studNum
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public int updateOne(int gradId,String studNum,String userName,String userPassword);
}
