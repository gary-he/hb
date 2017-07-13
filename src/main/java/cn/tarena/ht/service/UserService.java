package cn.tarena.ht.service;

import cn.tarena.ht.pojo.User;

public interface UserService {
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 查询一个用户
	 * @param user_id
	 * @return
	 */
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
