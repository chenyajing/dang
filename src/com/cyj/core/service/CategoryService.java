package com.cyj.core.service;
import java.util.List;

import com.cyj.core.po.Category;
public interface CategoryService {
	public List<Category> findAll();
	public List<Category> findByParentId(int pid);
}
