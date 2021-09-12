package com.datastructs;

public class Main {
	public static void workIntQueue() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		System.out.println("Write in queue:");
		for(int i = 1; i <= 10; i++) {
			queue.add(i);
			System.out.print(i + " ");
		}
		
		System.out.println("\nQueue: ");
		
		while(!queue.isEmpty()) {
			System.out.println(queue.remove() + " ");
		}
		System.out.println();
	}
	
	public static void workIntStack() {
		MyStack<Integer> stack = new MyStack<Integer>();
		System.out.println("Write in stack: ");
		for(int i = 1; i <= 10; i++) {
			stack.push(i);
			System.out.print(i + " ");
		}
		
		System.out.println("\nStack: ");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		workIntQueue();
		workIntStack();
	}

}
