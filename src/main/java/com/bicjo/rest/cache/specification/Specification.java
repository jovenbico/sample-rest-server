package com.bicjo.rest.cache.specification;

public interface Specification<T> {

	boolean match(T model);

}
