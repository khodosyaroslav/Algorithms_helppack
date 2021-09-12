package com.sorts;

public class BubbleSort {

	public static void bubSort(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =  tmp;
				}
			}
		}
	}
	public static void bubSort(String arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j].compareTo(arr[j+1]) > 0) {
					String tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static void show(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void show(String arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int a[] = {64, 34, 25, 12, 22, 11, 90};
		String astr[] = {"Rick", "Steve", "Ajeet", "Becky", "Mohan"};
		
		System.out.println("array of ints: ");
		show(a);
		System.out.println("sorted array of ints: ");
		bubSort(a);
		show(a);
		
		System.out.println("----------------------");
		
		System.out.println("array of strings: ");
		show(astr);
		System.out.println("sorted array of strings: ");
		bubSort(astr);
		show(astr);
		
	}

}
