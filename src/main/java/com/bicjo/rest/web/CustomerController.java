package com.bicjo.rest.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bicjo.rest.model.Order;

@RestController
@RequestMapping(value = "/customers", produces = "application/json; charset=UTF-8")
public class CustomerController {

	@RequestMapping
	public Order createOrder() {
		return new Order("abc");
	}

}
