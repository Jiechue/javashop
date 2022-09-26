package com.javashop.pojo;

public class OrderDetail {
	private Integer id;
	private Order orders;
	private Goods goods;
	private Double number;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Order getOrders() {
		return orders;
	}
	public void setOrders(Order orders) {
		this.orders = orders;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Double getNumber() {
		return number;
	}
	public void setNumber(Double number) {
		this.number = number;
	}
}
