package com.cyj.core.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cyj.core.po.CartItem;

public interface CartService {
	public void buy(int id,HttpSession session);
	public void update(int id,int num,HttpSession session);
	public void delete(int id,HttpSession session);
	public void recovery(int id,HttpSession session);
	public void clearCart(HttpSession session);
	/**
	 * @param flag true 统计fixed_price 
	 * flag false 统计dang_price
	 * @return
	 */
	public double total(boolean flag,HttpSession session);
	public List<CartItem> getItems(boolean delete,HttpSession session);//返回产品集合
}
