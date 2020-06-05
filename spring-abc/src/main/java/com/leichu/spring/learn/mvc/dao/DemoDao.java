package com.leichu.spring.learn.mvc.dao;

import com.leichu.spring.learn.common.model.Student;
import org.springframework.stereotype.Repository;

@Repository("demoDao")
public class DemoDao {

	public Student find(int id){
		Student student = new Student();
		student.setId(id);
		student.setName("kitty");
		return student;
	}

}
