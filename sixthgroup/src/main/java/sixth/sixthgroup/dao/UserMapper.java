package sixth.sixthgroup.dao;

import java.util.List;
import java.util.Map;

import sixth.sixthgroup.model.ClassAccount;
import sixth.sixthgroup.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
	
	 /*
     * 自己添加的方法
     */
    User slectUserByNameAndPasword(User user);
    /**
     * 获取所有的班级账号
     * @return
     */
    List<ClassAccount> selectAll();
    /**
     * 通过班级id删除一个班级
     * @param gardId
     * @return
     */
    int deleteOne(Integer gardId);
    /**
     * 修改一个班级账号信息
     * @param gradId
     * @param studNum
     * @param userName
     * @param userPassword
     * @return
     */
    
  //  int updateOne(Integer gradId,String studNum,String userName,String userPassword);
    
    int updateOne(Map<String, Object> params);
}