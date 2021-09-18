package com.datastructs.linkedlist;

public class LinkedList {
	ListItem head;
	
	public void add(int data) {
		ListItem newItem = new ListItem(data);
		newItem.next = null;
		
		if(head == null) {
			head = newItem;
		} else {
			ListItem last = head;
			while(last.next != null)
				last = last.next;
			
			last.next = newItem;
		}		
	}
	
	public static LinkedList delete(LinkedList list, int item) {
		ListItem current = list.head;
		ListItem prev = null;
		
		if(current != null && current.data == item) {
			list.head = current.next;
			return list;
		}
		
		while(current != null && current.data != item) {
			prev = current;
			current = current.next;
		}		
		if(current != null) {
			prev.next = current.next;
		}
		
		if(current == null)
			System.out.println(item + " not found");
		
		return list;
	}
	
	public void reverse() {
		if(head != null && head.next != null) {
			ListItem current = head.next;
			head.next = null;
			while(current != null) {
				ListItem next = current.next;
				current.next = head;
				head = current;
				current = next;
			}
		}
	}
	
	public void print() {
		ListItem current = head;
		
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	public static void main(String args[]) {
		LinkedList linkList = new LinkedList();
		
		linkList.add(30);
		linkList.add(40);
		linkList.add(50);
		linkList.add(60);
		linkList.add(70);
		linkList.add(80);
		linkList.add(90);
		linkList.add(91);

		linkList.print();
		System.out.println("\n------------------");
		
		linkList = delete(linkList, 60);		
		linkList.print();
		System.out.println("\n------------------");
		
		linkList.reverse();
		linkList.print();
	}
	
}
