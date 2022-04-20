package com.top.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.top.pojo.User;


public interface UserService extends IService<User> {

	void updImg(Integer id, String filename);

}
