package com.search;

public class BinarySearch {

	// !_Works only in sorted array
	static int bsearch(int arr[], int val) {
		int low = 0;
		int high= arr.length - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2; // low + (high - low) / 2
			
			if(arr[mid] == val)
				return mid;
			
			if(arr[mid] < val) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 4, 10, 40};
		
		int res = bsearch(arr, 10);
		if(res == -1) {
			System.out.println("no such element");
		} else {
			System.out.println("element found, index: " + res);
		}
	}

}
