package cn.tarena.ht.service;

import cn.tarena.ht.pojo.User;

public interface UserService {

	public  User findOne(String userId) ;

	public  void update(User user) ;

	

}
