package com.bicjo.rest.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bicjo.rest.cache.specification.Specification;
import com.bicjo.rest.model.SimpleModel;

public abstract class SimpleCacheManager<T extends SimpleModel, ID extends Serializable>
		implements CacheManager<T, ID> {

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
	public T get(ID id) {
		T result = null;
		for (T model : storage) {
			if (model.getId().equals(id)) {
				result = model;
				break;
			}
		}
		return result;
	}

	@Override
	public T update(T model) {
		T result = null;

		@SuppressWarnings("unchecked")
		Specification<T> modelSpec = (Specification<T>) model.simpleSpecification();
		for (T m : storage) {
			if (modelSpec.match(m)) {
				storage.remove(m);
				storage.add(model);
				result = model;
				break;
			}
		}

		return result;
	}

	@Override
	public T delete(T model) {
		T result = null;
		@SuppressWarnings("unchecked")
		Specification<T> modelSpec = (Specification<T>) model.simpleSpecification();
		for (T m : storage) {
			if (modelSpec.match(m)) {
				storage.remove(m);
				result = m;
				break;
			}
		}
		return result;
	}

	@Override
	public List<T> all() {
		List<T> results = new ArrayList<>();
		results.addAll(storage);

		return results;
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
