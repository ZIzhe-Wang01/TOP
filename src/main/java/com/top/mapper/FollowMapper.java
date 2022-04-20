package com.top.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.top.pojo.Follow;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowMapper extends BaseMapper<Follow> {
	
	void addFollow(@Param("userId") Integer userId, @Param("followId") Integer followId);
}
