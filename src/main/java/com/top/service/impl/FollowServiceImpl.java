package com.top.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
<<<<<<< HEAD
<<<<<<< HEAD
import com.top.mapper.FollowMapper;
import com.top.pojo.Follow;
=======
import com.top.dao.entity.Follow;
import com.top.dao.mapper.FollowMapper;
>>>>>>> 7c4da5c (new update)
=======
import com.top.mapper.FollowMapper;
import com.top.pojo.Follow;
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039
import com.top.service.FollowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {
	
	@Autowired
	private FollowMapper followMapper;
	
	@Override
	public void addFollow(Integer userId, Integer followId) {
		followMapper.addFollow(userId,followId);
	}
}
