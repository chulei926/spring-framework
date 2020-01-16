package com.leichu.spring.learn.mybatis.mapper;

import com.leichu.spring.learn.mybatis.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

	@Select("select * from tb_student")
	List<Student> findList();
}
