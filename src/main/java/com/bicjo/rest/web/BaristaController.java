package com.bicjo.rest.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bicjo.rest.cache.OrderCacheManager;
import com.bicjo.rest.model.Order;

@RestController
@RequestMapping(value = "/barista", produces = "application/json; charset=UTF-8")
public class BaristaController {

	private OrderCacheManager orderCacheManager = OrderCacheManager.INSTANCE;

	@RequestMapping(method = RequestMethod.GET, value = "/orders")
	public @ResponseBody List<Order> orderList() {
		return orderCacheManager.all();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/orders")
	public List<Order> deleteOrder(@RequestBody List<Order> orders) {

		List<Order> deletedOrders = new ArrayList<>();
		for (Order order : orders) {
			Order deletedOrder = orderCacheManager.delete(order);
			if (deletedOrder != null)
				deletedOrders.add(deletedOrder);
		}

		return deletedOrders;
	}

}
