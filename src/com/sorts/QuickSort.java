package com.sorts;

import java.util.Arrays;

public class QuickSort {
	
	public static void qsort(int arr[], int low, int high) {
		if(arr.length == 0) return;
		if(low >= high) return;
		
		int mid = low + (high - low) / 2;
		int pivot = arr[mid];
		
		int i = low, j = high;
		while(i <= j) {
			while(arr[i] < pivot) 
				i++;
			while(arr[j] > pivot) 
				j--;
			
			if(i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}			
		}
		
		if(low < j) 
			qsort(arr, low, j);
		if(high > i)
			qsort(arr, i, high);
	}
	
	public static void main(String[] args) {
		int a[] = {8, 0, 4, 7, 3, 7, 10, 12, -3}; //change
		
		System.out.println("array of ints: ");
		System.out.println(Arrays.toString(a));
		
		System.out.println("sorted array of ints: ");
		qsort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}

}
