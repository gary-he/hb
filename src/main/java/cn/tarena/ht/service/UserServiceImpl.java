package cn.tarena.ht.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public User findOne(String userId) {
		
				
		return userMapper.findOne(userId);
	}

	@Override
	public void update(User user) {
		
		//Date data=new Date();
		
		userMapper.update(user);
		
		
	}

}
