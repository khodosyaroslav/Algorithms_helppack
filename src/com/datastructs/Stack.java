package com.datastructs;

public interface Stack<T> {
	public void push(T item);
	T pop();
	
	boolean isEmpty();
}
