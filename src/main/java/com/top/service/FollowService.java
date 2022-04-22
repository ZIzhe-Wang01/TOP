package com.top.service;

import com.baomidou.mybatisplus.extension.service.IService;


import com.top.pojo.Follow;

import com.top.dao.entity.Follow;

import com.top.pojo.Follow;


public interface FollowService extends IService<Follow> {
	
	void addFollow(Integer userId, Integer followId);
}
