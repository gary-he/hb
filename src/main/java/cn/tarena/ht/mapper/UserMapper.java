package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.User;

public interface UserMapper {

	public void updateUser(User user);

	
	public User findOne(String user_id);
	/**
	 * 根据userName查找对应用户
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName);
	/**
	 * 注册用户
	 * @param user
	 */
	public void saveUser(User user);
}
