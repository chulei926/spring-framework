package com.leichu.spring.learn.common.service;

import com.leichu.spring.learn.common.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService {

	@Autowired
	BookDao bookDao;

	@Override
	public String toString() {
		return "BookService{" +
				"bookDao=" + bookDao +
				'}';
	}
}
