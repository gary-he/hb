package cn.tarena.ht.service;

import cn.tarena.ht.pojo.User;

public interface UserService {

	public void updateUser(User user);

	public User findOne(String user_id);

}
