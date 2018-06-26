package com.cyj.core.dao;
import java.util.List;

import com.cyj.core.po.Category;
public interface CategoryDao {
	public List<Category> findAll();
	public List<Category> findByParentId(int pid);
}
