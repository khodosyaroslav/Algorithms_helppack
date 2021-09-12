package com.bintree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	static Node root;
	
	private Node addRecursive(Node current, int value) {
		if(current == null)
			return new Node(value);
		
		if(value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if(value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}
		
		return current;
	}	
	public void add(int value) {
		root = addRecursive(root, value);
	}
	
	private boolean containsNodeRecursive(Node current, int value) {
		if(current == null)
			return false;
		if(value == current.value)
			return true;		
		return value < current.value ? containsNodeRecursive(current.left, value) : containsNodeRecursive(current.right, value);
	}
	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}
	
	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}
	private Node deleteRecursive(Node current, int value) {
		if(current == null) return null;
		
		// Node to delete found 
		if(value == current.value) {
			if(current.left == null && current.right == null) return null;
			if(current.left == null) return current.right;
			if(current.right == null) return current.left;
			
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		
		if(value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	// search in depth
	public static void traversePreOrder(Node node) {
		if(node != null) {
			System.out.print(node.value + " ");
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	public static void traverseInOrder(Node node) {
		if(node != null) {
			traverseInOrder(node.left);
			System.out.print(node.value + " ");
			traverseInOrder(node.right);
		}
	}
	public static void traversePostOrder(Node node) {
		if(node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(node.value + " ");
		}
	}
	
	
	// search in width
	public static void traverseLevelOrder() {
		if(root == null) return;
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			System.out.print(node.value + " ");
			
			if(node.left != null)
				nodes.add(node.left);
			if(node.right != null)
				nodes.add(node.right);			
		}
		
	}
	
	static int sumNodes(Node current) {
		int s = 0;
		s += current.value;
		
		if(current.left != null) {
			s += sumNodes(current.left);
		}
		if(current.right != null) {
			s += sumNodes(current.right);
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		
		bt.add(1);
		bt.add(10);
		
		System.out.println("PreOrder: ");
		traversePreOrder(root);
		System.out.println();
		
		System.out.println("LevelOrder: ");
		traverseLevelOrder();
		System.out.println();
		
		int sum = sumNodes(root);
		System.out.println("Sum of nodes: " + sum);		
	}

}
