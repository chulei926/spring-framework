package com.leichu.spring.learn.mvc.controller;

import com.leichu.spring.learn.common.model.Student;
import com.leichu.spring.learn.mvc.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("demo")
public class DemoController {

	@Resource
	private DemoService demoService;

	@RequestMapping("index")
	public ModelAndView index(ModelAndView modelAndView, Integer id) {

		Student student = demoService.get(id);

		modelAndView.setViewName("demo");
		modelAndView.addObject("student", student.toString());
		return modelAndView;
	}

}
