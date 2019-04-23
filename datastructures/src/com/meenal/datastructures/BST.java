package com.meenal.datastructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	Node root;

	public void add(int value) {
		this.recurrsiveInsertion(root, value);
	}

	public void deleteNode(Node n) {

	}

	public boolean containsNode(int value) {
		return recurrsiveSearch(root, value);
	}

	private Node recurrsiveInsertion(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}
		if (value < current.value) {
			recurrsiveInsertion(current.left, value);
		} else if (value > current.value) {
			recurrsiveInsertion(current.right, value);
		} else {
			return current;
		}
		return current;
	}

	private boolean recurrsiveSearch(Node current, int value) {
		if (current == null) {
			return false;
		}

		if (current.value == value) {
			return true;
		}
		return (value < current.value) ? recurrsiveSearch(current.left, value) : recurrsiveSearch(current.right, value);
	}
}

public class BST {

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);

		assertTrue(bt.containsNode(6));
		assertTrue(bt.containsNode(4));

		assertFalse(bt.containsNode(1));
	}
}
