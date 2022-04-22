package com.top.service;

import com.baomidou.mybatisplus.extension.service.IService;
<<<<<<< HEAD
<<<<<<< HEAD
import com.top.pojo.Post;
import com.top.utlis.PageResult;
=======
import com.top.dao.entity.Post;
import com.top.utils.PageResult;
>>>>>>> 7c4da5c (new update)
=======
import com.top.pojo.Post;
import com.top.utlis.PageResult;
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039


public interface PostService extends IService<Post> {
	
	PageResult<Post> findPage(Integer currentPage, Integer rows);
	
}
