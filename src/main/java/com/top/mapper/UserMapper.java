package com.top.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.top.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper extends BaseMapper<User> {
	
	void updImg(@Param("id") Integer id, @Param("filename") String filename);
}
