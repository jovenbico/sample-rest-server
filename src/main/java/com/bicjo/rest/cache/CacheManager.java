package com.bicjo.rest.cache;

import java.util.List;

import com.bicjo.rest.cache.specification.Specification;

public interface CacheManager<T> {

	void add(T model);

	List<T> query(Specification<T> spec);

	void update(T model);

	void delete(T model);

	int size();

	void clear();

}
