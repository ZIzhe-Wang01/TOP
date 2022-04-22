package com.top.service;

import com.baomidou.mybatisplus.extension.service.IService;
<<<<<<< HEAD
<<<<<<< HEAD
import com.top.pojo.User;
=======
import com.top.dao.entity.User;
>>>>>>> 7c4da5c (new update)
=======
import com.top.pojo.User;
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039


public interface UserService extends IService<User> {

	void updImg(Integer id, String filename);

}
