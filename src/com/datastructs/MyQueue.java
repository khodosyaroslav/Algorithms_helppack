package com.datastructs;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> implements Queue<T> {
	private List<T> list = new ArrayList<T>();

	@Override
	public void add(T item) {
		list.add(item);
	}

	@Override
	public T remove() {
		return list.remove(0);
	}

	@Override
	public boolean isEmpty() {		
		return list.isEmpty();
	}
}