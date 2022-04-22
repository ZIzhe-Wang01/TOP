package com.top.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
<<<<<<< HEAD
<<<<<<< HEAD
import com.top.mapper.UserMapper;
import com.top.pojo.User;
=======
import com.top.dao.entity.User;
import com.top.dao.mapper.UserMapper;
>>>>>>> 7c4da5c (new update)
=======
import com.top.mapper.UserMapper;
import com.top.pojo.User;
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039
import com.top.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public void updImg(Integer id, String filename) {
		userMapper.updImg(id,filename);
	}
}
