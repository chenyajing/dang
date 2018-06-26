package com.cyj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.core.dao.CategoryDao;
import com.cyj.core.po.Category;
import com.cyj.core.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> findByParentId(int pid) {
		return categoryDao.findByParentId(pid);
	}

}
