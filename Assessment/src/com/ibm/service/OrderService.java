package com.ibm.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.ibm.bean.Order;

public class OrderService {

	private Map<Integer, Order> orders;
	static Random rand;
	
	public OrderService() {
		orders = new HashMap<Integer, Order>();
		if(rand == null) {
			rand = new Random(); 
		}
	}

	public int placeOrder(Order order) {
		int orderNo = rand.nextInt();
		order.setOrderNo(orderNo);
		orders.put(orderNo, order);
		return orderNo;
	}

	public Order getOrder(int orderNo) {
		return orders.get(orderNo);
	}

}
