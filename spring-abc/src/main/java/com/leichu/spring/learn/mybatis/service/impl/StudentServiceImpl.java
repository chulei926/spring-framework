package com.leichu.spring.learn.mybatis.service.impl;

import com.leichu.spring.learn.mybatis.domain.Student;
import com.leichu.spring.learn.mybatis.mapper.StudentMapper;
import com.leichu.spring.learn.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public List<Student> getList() {
		studentMapper.findList();
		return null;
	}
}
