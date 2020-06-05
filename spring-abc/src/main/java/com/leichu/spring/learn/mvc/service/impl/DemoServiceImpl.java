package com.leichu.spring.learn.mvc.service.impl;

import com.leichu.spring.learn.common.model.Student;
import com.leichu.spring.learn.mvc.dao.DemoDao;
import com.leichu.spring.learn.mvc.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Resource
	private DemoDao demoDao;

	@Override
	public Student get(int id) {
		return demoDao.find(id);
	}
}
