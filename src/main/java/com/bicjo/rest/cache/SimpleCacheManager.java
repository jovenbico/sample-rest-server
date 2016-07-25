package com.bicjo.rest.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bicjo.rest.cache.specification.Specification;
import com.bicjo.rest.model.SimpleModel;

public abstract class SimpleCacheManager<T extends SimpleModel> implements CacheManager<T> {

	private List<T> storage = Collections.synchronizedList(new ArrayList<>());

	@Override
	public void add(T model) {
		storage.add(model);
	}

	@Override
	public List<T> query(Specification<T> spec) {
		List<T> results = new ArrayList<>();

		for (T model : storage) {
			if (spec.match(model)) {
				results.add(model);
			}
		}

		return results;
	}

	@Override
	public void update(T model) {
		@SuppressWarnings("unchecked")
		Specification<T> modelSpec = (Specification<T>) model.simpleSpecification();
		for (T m : storage) {
			if (modelSpec.match(m)) {
				storage.remove(m);
				storage.add(model);
				break;
			}
		}
	}

	@Override
	public void delete(T model) {
		@SuppressWarnings("unchecked")
		Specification<T> modelSpec = (Specification<T>) model.simpleSpecification();
		for (T m : storage) {
			if (modelSpec.match(m)) {
				storage.remove(m);
				break;
			}
		}
	}

	@Override
	public int size() {
		return storage.size();
	}

	@Override
	public void clear() {
		storage.clear();
	}

}
