package cn.tarena.ht.service;

import java.util.UUID;

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
	public User findOne(String user_id) {
		
		return userMapper.findOne(user_id);
	}

	@Override
	public User findUserByUserName(String userName) {
		return userMapper.findUserByUserName(userName);
	}

	@Override
	public void saveUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		userMapper.saveUser(user);
	}

}
