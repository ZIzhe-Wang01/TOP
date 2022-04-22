package com.top.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039
import com.top.mapper.PostMapper;
import com.top.mapper.UserMapper;
import com.top.pojo.Post;
import com.top.service.PostService;
import com.top.utlis.PageResult;
<<<<<<< HEAD
=======
import com.top.dao.entity.Post;
import com.top.dao.mapper.PostMapper;
import com.top.dao.mapper.UserMapper;
import com.top.service.PostService;
import com.top.utils.PageResult;
>>>>>>> 7c4da5c (new update)
=======
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
	
	@Autowired
	private PostMapper postMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public PageResult<Post> findPage(Integer currentPage, Integer rows) {
		Page<Post> result = postMapper.selectPage(new Page<>(currentPage, rows), null);
		PageResult<Post> page = new PageResult<>();
<<<<<<< HEAD
<<<<<<< HEAD
		result.getRecords().forEach(forum -> {
			forum.setTime(forum.getTime().substring(0, forum.getTime().length() - 2));
			forum.setUser(userMapper.selectById(forum.getUserId()));
=======
		result.getRecords().forEach(post -> {
			post.setTime(post.getTime().substring(0, post.getTime().length() - 2));
			post.setUser(userMapper.selectById(post.getUserId()));
>>>>>>> 7c4da5c (new update)
=======
		result.getRecords().forEach(forum -> {
			forum.setTime(forum.getTime().substring(0, forum.getTime().length() - 2));
			forum.setUser(userMapper.selectById(forum.getUserId()));
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039
		});
		page.setList(result.getRecords());
		page.setTotal(result.getTotal());
		page.setRows(rows);
		page.setCurrentPage(currentPage);
		page.setTotalPage((int) Math.ceil(result.getTotal() * 1. / rows));
		return page;
	}
	
	
}
