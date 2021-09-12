package com.avltree;

public class Node {
	int value, height;
	Node right;
	Node left;
	
	Node(int value){
		this.value = value;
		height = 1;
	}
}
