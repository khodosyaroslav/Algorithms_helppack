package com.datastructs;

public interface Queue<T> {
	public void add(T item);
	T remove();
	
	boolean isEmpty();
}
