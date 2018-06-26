package com.cyj.core.service;

import java.util.List;

import com.cyj.core.po.Book;
public interface BookService {
	public List<Book> findByCatId(int cid,int begin,int size);
	public Book findById(int id);

	/**
	 * @param num 取出前num个数据（降序）
	 * @return 热卖商品
	 */
	public List<Book> findByHot(int num);
	
	/**
	 * @param num 取出前num个数据（降序）
	 * @return 最新商品（按上架时间）
	 */
	public List<Book> findByNew(int num);
	public List<Book> findByNewHot(long time);
}
