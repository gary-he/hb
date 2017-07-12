package cn.tarena.ht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
		
	@Override
	public void updateUser(User user) {
		
		userMapper.updateUser(user);

	}

	@Override
	public User findOne(Integer user_id) {
		
		return userMapper.findOne(user_id);
	}

}
