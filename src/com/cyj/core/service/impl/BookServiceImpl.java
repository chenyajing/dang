package com.cyj.core.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.core.dao.BookDao;
import com.cyj.core.po.Book;
import com.cyj.core.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;
	@Override
	public List<Book> findByCatId(int cid, int begin, int size) {
		
		return bookDao.findByCatId(cid, begin, size);
	}

	@Override
	public Book findById(int id) {
		return bookDao.findById(id);
	}

	@Override
	public List<Book> findByHot(int num) {
		return bookDao.findByHot(num);
	}

	@Override
	public List<Book> findByNew(int num) {
		return bookDao.findByNew(num);
	}

	@Override
	public List<Book> findByNewHot(long time) {
		return bookDao.findByNewHot(time);
	}

	
	
}
