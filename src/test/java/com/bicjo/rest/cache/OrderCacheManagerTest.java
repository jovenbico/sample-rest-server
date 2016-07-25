package com.bicjo.rest.cache;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.bicjo.rest.cache.specification.Specification;
import com.bicjo.rest.model.Order;

public class OrderCacheManagerTest extends Assert {

	private final Logger LOG = LogManager.getLogger(getClass());
	private OrderCacheManager cacheManager = OrderCacheManager.INSTANCE;

	@After
	public void cleanup() {
		cacheManager.clear();
	}

	@Test
	public void add_ok() {
		LOG.debug("add_ok");
		Order order = new Order("latte");
		cacheManager.add(order);

		assertTrue(cacheManager.size() > 0);
	}

	@Test
	public void query_ok() {
		Order order = new Order("latte");
		cacheManager.add(order);

		@SuppressWarnings("unchecked")
		List<Order> orders = cacheManager.query((Specification<Order>) order.simpleSpecification());

		assertFalse(orders.isEmpty());
	}

	@Test
	public void update_ok() {
		Order order = new Order("latte");
		cacheManager.add(order);

		Order orderUpdated = new Order("kape");
		orderUpdated.setId(order.getId());

		cacheManager.update(orderUpdated);

		@SuppressWarnings("unchecked")
		List<Order> orders = cacheManager.query((Specification<Order>) orderUpdated.simpleSpecification());

		assertEquals("kape", orders.get(0).getName());
	}

	@Test
	public void delete_ok() {
		Order order = new Order("latte");
		cacheManager.add(order);

		assertEquals(1, cacheManager.size());

		cacheManager.delete(order);

		assertEquals(0, cacheManager.size());

	}

}
