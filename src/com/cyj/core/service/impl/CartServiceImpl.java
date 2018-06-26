package com.cyj.core.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.core.dao.BookDao;
import com.cyj.core.po.CartItem;
import com.cyj.core.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	private Map<Integer, CartItem> store = new HashMap<Integer, CartItem>();
	@Autowired
	private BookDao bookDao;
	private void Store(HttpSession session) {
		CartServiceImpl cart = (CartServiceImpl) session.getAttribute("s_cart");
		if(cart != null){
			this.store = cart.store;
		}
	}
	public void buy(int id,HttpSession session) {
		Store(session);
		if(store.containsKey(id)){
			//如果购物车中已存在，产品数量+1
			CartItem ci = store.get(id);
			ci.setNum(ci.getNum()+1);
		}else{
			//如果不存在，则从数据库中找出相应商品，添加进购物车
			CartItem ci = new CartItem();
			ci.setBook(bookDao.findById(id));
			store.put(id, ci);
		}
		
	}

	public void delete(int id,HttpSession session) {
		Store(session);
		if(store.containsKey(id)){
			store.get(id).setDelete(true);
		}
	}

	/**
	 * delete=true返回已删除产品列表
	 * delete=false返回确认购买列表
	 * @param delete
	 * @return
	 */
	public List<CartItem> getItems(boolean delete,HttpSession session) {
		Store(session);
		List<CartItem> cis = new ArrayList<CartItem>();
		for(CartItem ci : store.values()){
			if(ci.isDelete()==delete){
				cis.add(ci);
			}
		}
		return cis;
	}

	/**
	 * 恢复
	 */
	public void recovery(int id,HttpSession session) {
		Store(session);
		if(store.containsKey(id)){
			store.get(id).setDelete(false);
		}
	}
	
	/**
	 * 清空购物车
	 */
	public void clearCart(HttpSession session){
		session.removeAttribute("s_cart");
	}

	/**
	 * 统计确认购买商品总金额
	 * flag true:统计fixed_price,false:统计dang_price
	 */
	public double total(boolean flag,HttpSession session) {
		double totalPrice = 0.0;
			if(flag){
				for(CartItem ci : getItems(false,session)){
					totalPrice += ci.getNum()*ci.getBook().getProduct().getFixed_price();
				}
			}else{
				for(CartItem ci : getItems(false,session)){
					totalPrice += ci.getNum()*ci.getBook().getProduct().getDang_price();
				}
			}
			totalPrice = Number2(totalPrice);
		return totalPrice;
	}

	/**
	 * 根据id更新产品数量
	 */
	public void update(int id, int num,HttpSession session) {
		if(store.containsKey(id)){
			store.get(id).setNum(num);
		}
	}

	public Map<Integer, CartItem> getStore() {
		return store;
	}

	/**
	 * 将double型数字保留两位小数
	 * @param pDouble
	 * @return
	 */
	private double Number2(double pDouble) {
		BigDecimal bd = new BigDecimal(pDouble);
		BigDecimal bd1 = bd.setScale(2, bd.ROUND_HALF_UP);
		pDouble = bd1.doubleValue();

		return pDouble;
	}
	
	
}
