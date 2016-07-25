package com.bicjo.rest.cache;

import com.bicjo.rest.model.Order;

public class OrderCacheManager extends SimpleCacheManager<Order, String> {

	public static OrderCacheManager INSTANCE = new OrderCacheManager();

	private OrderCacheManager() {
	}
}
