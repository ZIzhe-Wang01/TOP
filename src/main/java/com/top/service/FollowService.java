package com.top.service;

import com.baomidou.mybatisplus.extension.service.IService;
<<<<<<< HEAD
<<<<<<< HEAD
import com.top.pojo.Follow;
=======
import com.top.dao.entity.Follow;
>>>>>>> 7c4da5c (new update)
=======
import com.top.pojo.Follow;
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039



public interface FollowService extends IService<Follow> {
	
	void addFollow(Integer userId, Integer followId);
}
