package com.dynamic;

public class Fibonacci {

	public static int straightMethod(int n) {
		int fibo[] = new int[n];
		fibo[0] = 1;
		fibo[1] = 1;
		for(int i = 2; i < n; i++) {
			fibo[i] = fibo[i-2] + fibo[i-1];
		}		
		return fibo[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println("5 element: " + straightMethod(5));
	}

}
