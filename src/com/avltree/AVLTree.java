package com.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
	static Node root;
	
	private int height(Node current) {
		return current == null ? 0 : current.height;
	}
	
	private void updateHeight(Node current) {
		current.height = 1 + Math.max(height(current.left), height(current.right));
	}
	
	private int getBalance(Node current) {
		return (current == null) ? 0 : (height(current.right) - height(current.left));
	}
	
	private Node rightRotation(Node y) {
		Node x = y.left;
		Node z = x.right;
		x.right = y;
		y.left = z;
		updateHeight(y);
		updateHeight(x);		
		return x;
	}
	
	private Node leftRotation(Node y) {
		Node x = y.right;
		Node z = x.left;
		x.left = y;
		y.right = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}
	
	private Node rebalance(Node z) {
		updateHeight(z);
		int balance = getBalance(z);
		if(balance > 1) {
			if(height(z.right.right) > height(z.right.left)) {
				z = leftRotation(z);
			} else {
				z.right = rightRotation(z.right);
				z = leftRotation(z);
			}
		} else if(balance < -1) {
			if(height(z.left.left) > height(z.left.right)) {
				z = rightRotation(z);
			} else {
				z.left = leftRotation(z.left);
				z = rightRotation(z);
			}
		}
		
		return z;
	}
	
	// each value is unique
	private Node insertRecursive(Node current, int value) {
		if(current == null)
			return new Node(value);
		if(value < current.value)
			current.left = insertRecursive(current.left, value);
		else if(value > current.value)
			current.right = insertRecursive(current.right, value);
		else
			throw new RuntimeException("duplicate key");
		
		return rebalance(current);
	}	
	public void insert(int value) {
		root = insertRecursive(root, value);
	}
	
	private int findSmallestValue(Node current) {
		return current.left == null ? current.value : findSmallestValue(current.left);
	}
	private Node deleteRecursive(Node current, int value) {
		if(current == null) return current;
		
		if(current.value == value) {
			//if(current.left == null && current.right == null) return null;
			if(current.left == null) return current.right;
			if(current.right == null) return current.left;
			
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
		}
		
		if(value < current.value) current.left = deleteRecursive(current.left, value);
		if(value > current.value) current.right = deleteRecursive(current.right, value);
		
		if(current != null) current = rebalance(current);
		
		return current;
	}
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	public static void traverseLevelOrder() {
		if(root == null) {
			return;			
		}
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);		
		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			System.out.print(node.value + " ");
			
			if(node.left != null) {
				nodes.add(node.left);
			}
			if(node.right != null) {
				nodes.add(node.right);
			}
		}
		
	}
	
	public static void main(String[] args) {
		AVLTree avlt = new AVLTree();
		
		avlt.insert(1);
		avlt.insert(2);
		avlt.insert(3);
		avlt.insert(4);
		avlt.insert(5);
		avlt.insert(6);
		
		avlt.delete(3);
		
		traverseLevelOrder();
	}

}
