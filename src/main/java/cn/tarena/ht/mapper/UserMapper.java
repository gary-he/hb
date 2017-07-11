package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.User;

public interface UserMapper {

	
	
	public User findOne(String userId);

	public Object update(User user);

}
