package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.User;

public interface UserMapper {

	public void updateUser(User user);

	public User findOne(String user_id);
}
