package com.datastructs.hashtable;

// TODO: delete method and find method

public class HashTable {
	private Item table[];
	private int size;
	
	public HashTable(int size) {
		this.size = size;
		table = new Item[size];
	}
	
	private int hash(String key) {
		int hash = 0;
		for(int i = 0; i < key.length(); i++)
			hash = (31 * hash + key.charAt(i)) % size;
		return hash;
	}
	
	public void insert(String key) {
		Item item = new Item(key);
		int hash = hash(key);
		while(table[hash] != null) {
			hash++;
			hash %= size;
		}
		table[hash] = item;
	}
	
	public void print() {
		for(int i = 0; i < size; i++) {
			if(table[i] != null)
				System.out.println(i + " " + table[i].getKey());
		}
	}
	
	public static void main(String[] args) {
		HashTable hashTable = new HashTable(97);
//		HashTable hashTable = new HashTable(50);
		
		hashTable.insert("rhino");
		hashTable.insert("man");
		hashTable.insert("computer");
		hashTable.insert("home");
		hashTable.insert("basket");
		
		hashTable.print();
		
	}

}
