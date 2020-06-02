package com.leichu.spring.learn.mybatis.mapper;

import com.leichu.spring.learn.mybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

	@Select("select * from tb_user")
	List<User> findList();

	@Insert("INSERT INTO tb_user (name, pwd) VALUES (#{name}, #{pwd})")
	void insert(User user);

	// 错误 SQL，用于测试 事务回滚
	@Insert("INSERT INTO tb_user (id, name, pwd) VALUES (#{id}, #{name}, #{pwd}) 123")
	void insert2(User user);


}
