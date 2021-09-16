package com.datastructs.linkedlist;

// TODO: delete method and reverse method

public class LinkedList {
	static ListItem head;
	
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
	
	public void print() {
		ListItem current = head;
		
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	public static void main(String args[]) {
		LinkedList linkList = new LinkedList();
		
		linkList.add(3);
		linkList.add(4);
		linkList.add(5);
		linkList.add(6);
		linkList.add(7);
		linkList.add(8);
		linkList.add(9);
		linkList.add(9);

		linkList.print();
	}
	
}
