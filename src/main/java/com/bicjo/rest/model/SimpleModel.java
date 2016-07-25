package com.bicjo.rest.model;

import java.util.UUID;

import com.bicjo.rest.cache.specification.Specification;

public abstract class SimpleModel {

	private String id;

	public SimpleModel() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Specification<? extends SimpleModel> simpleSpecification() {
		return new Specification<SimpleModel>() {
			@Override
			public boolean match(SimpleModel model) {
				return model.getId().equals(id);
			}
		};
	}

}
