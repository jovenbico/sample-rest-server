package com.bicjo.rest.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bicjo.rest.cache.OrderCacheManager;
import com.bicjo.rest.model.Order;

@RestController
@RequestMapping(value = "/customers", produces = "application/json; charset=UTF-8")
public class CustomerController {

	private OrderCacheManager orderCacheManager = OrderCacheManager.INSTANCE;

	@RequestMapping(method = RequestMethod.POST, value = "/order")
	public @ResponseBody Order createOrder(@RequestBody Order order) {

		orderCacheManager.add(order);

		return order;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/order")
	public @ResponseBody Order changeOrder(@RequestBody Order order) {

		return orderCacheManager.update(order);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/order/{id}")
	public @ResponseBody Order getOrder(@PathVariable String id) {
		return orderCacheManager.get(id);
	}

}
