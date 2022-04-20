package com.top.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.top.pojo.Comment;
import com.top.utlis.PageResult;


public interface CommentService extends IService<Comment> {
	
	PageResult<Comment> findPage(Integer currentPage, Integer rows);
}
