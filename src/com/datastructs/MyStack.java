package com.datastructs;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> implements Stack<T> {
	public List<T> list = new ArrayList<T>();
	
	@Override
	public void push(T item) {
		list.add(0, item);
	}

	@Override
	public T pop() {
		return list.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
