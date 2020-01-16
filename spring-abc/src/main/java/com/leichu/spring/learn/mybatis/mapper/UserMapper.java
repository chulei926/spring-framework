package com.leichu.spring.learn.mybatis.mapper;

import com.leichu.spring.learn.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

	@Select("select * from tb_user")
	List<User> findList();

}
