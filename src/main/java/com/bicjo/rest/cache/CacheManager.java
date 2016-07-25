package com.bicjo.rest.cache;

import java.util.List;

import com.bicjo.rest.cache.specification.Specification;

public interface CacheManager<T, ID> {

	void add(T model);

	T get(ID id);

	List<T> query(Specification<T> spec);

	T update(T model);

	T delete(T model);

	List<T> all();

	int size();

	void clear();

}
