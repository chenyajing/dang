package com.cyj.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyj.core.po.Book;
public interface BookDao {
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
	
	/**
	 * @param num 取出前num个数据（降序）
	 * @param time 多少时间内算新书
	 * @return 最新热卖商品
	 */
	public List<Book> findByNewHot(@Param("time")long time);
}
