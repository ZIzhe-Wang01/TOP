package com.top.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.top.pojo.Post;
import com.top.utlis.PageResult;

import com.top.dao.entity.Post;
import com.top.utils.PageResult;

import com.top.pojo.Post;
import com.top.utlis.PageResult;

public interface PostService extends IService<Post> {
	
	PageResult<Post> findPage(Integer currentPage, Integer rows);
	
}
