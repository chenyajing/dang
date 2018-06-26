package com.cyj.core.po;

public class Item {
	private int id;// id int(12) NOT NULL auto_increment,
	private int order_id;// order_id int(10) NOT NULL, --订单
	private int product_id;// product_id int(10) NOT NULL, --产品
	private String product_name;// product_name varchar(100) NOT NULL, --产品名字
	private double dang_price;// dang_price double NOT NULL, --当当价格
	private int product_num;// product_num int(10) NOT NULL, --购买产品数量
	private double amount;// amount double NOT NULL, --小计
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getDang_price() {
		return dang_price;
	}
	public void setDang_price(double dang_price) {
		this.dang_price = dang_price;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
