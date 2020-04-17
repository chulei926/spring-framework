package com.leichu.spring.learn.bean;

import com.leichu.spring.learn.common.dao.BookDao;
import com.leichu.spring.learn.common.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配
 *
 * <pre>
 *  <code>@Autowired</code> 首先按照 byType 去查找，如果结果有多个，再按照 byName 查找。如果没找到，那么会抛出异常。解决方法时，使用required=false。
 *  <code>@Resource</code> 默认通过 byName 查找，找不到再按 byType 去查找。
 *
 *  <code>@Autowired</code> 和 <code>@Resource</code> 两个注解的区别：
 *  1. @Autowired 默认按照 byType 方式进行bean匹配，@Resource 默认按照 byName 方式进行bean匹配
 *  2. @Autowired 是Spring的注解，@Resource 是J2EE的注解，根据导入注解的包名就可以知道。
 *  3. Spring属于第三方的，J2EE是Java自己的东西。因此，建议使用 @Resource 注解，以减少代码和Spring之间的耦合。
 *
 *  </pre>
 */
public class BeanTest4Autowired {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowiredConfig.class);
		System.out.println("容器创建完成");

		BookService bookService = ctx.getBean(BookService.class);
		System.out.println(bookService);
	}
}

@Configuration
@ComponentScan({"com.leichu.spring.learn.common.service", "com.leichu.spring.learn.common.dao"})
class AutowiredConfig {

	@Bean("bookDao2")
	public BookDao bookDao() {
		BookDao bookDao = new BookDao();
		bookDao.setLabel("2");
		return bookDao;
	}
}
