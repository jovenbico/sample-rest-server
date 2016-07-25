package com.bicjo.rest.model;

import org.springframework.core.style.ToStringCreator;

public class Order extends SimpleModel {

	private String name;

	public Order() {
		this(null);
	}

	public Order(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this).append(getId()).append(this.name).toString();
	}

}
