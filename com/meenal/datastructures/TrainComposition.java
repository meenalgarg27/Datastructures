package com.meenal.datastructures;

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

public class TrainComposition {
	Node root;

	public void attachWagonFromLeft(int wagonId) {
		Node leftNode = new Node(wagonId);

		if (this.root == null) {
			root = leftNode;
		} else {
			Node temp = this.root;
			while (temp.left != null) {
				temp = temp.left;
			}
			temp.left = leftNode;
			leftNode.right = temp;

		}

	}

	public void attachWagonFromRight(int wagonId) {
		Node rightNode = new Node(wagonId);

		if (this.root == null) {
			root = rightNode;
		} else {
			Node temp = this.root;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = rightNode;
			rightNode.left = temp;
			this.root = rightNode;

		}
	}

	public int detachWagonFromLeft() {
		int result;
		Node temp = this.root;
		if (temp != null) {
			while (temp.left != null) {
				temp = temp.left;
			}

			result = temp.value;
			if (temp.right != null && temp.right.left != null) {
				temp.right.left = null;
			} else {
				this.root = null;
			}

			temp = null;
		} else {
			result = 0;
		}
		return result;

	}

	public int detachWagonFromRight() {
		int result;
		Node temp = this.root;
		if (temp != null) {
			result = temp.value;
			if (temp.left != null && temp.left.right != null) {
				temp.left.right = null;
				this.root = temp.left;
			} else {
				this.root = null;
			}
			temp = null;
		} else {
			result = 0;
		}

		return result;
	}

	public static void main(String[] args) {
		TrainComposition tree = new TrainComposition();
		tree.attachWagonFromLeft(1);
		tree.attachWagonFromLeft(2);
		tree.attachWagonFromLeft(3);
		tree.attachWagonFromLeft(4);
		tree.attachWagonFromLeft(5);

		System.out.println(tree.detachWagonFromRight()); // 7
		System.out.println(tree.detachWagonFromLeft()); // 13
		System.out.println(tree.detachWagonFromLeft());

		tree.attachWagonFromRight(13);
		tree.attachWagonFromRight(6);
		tree.attachWagonFromRight(11);
		System.out.println(tree.detachWagonFromLeft());
		System.out.println(tree.detachWagonFromLeft());
		System.out.println(tree.detachWagonFromLeft());
		System.out.println(tree.detachWagonFromLeft());
		System.out.println(tree.detachWagonFromLeft());
		System.out.println(tree.detachWagonFromLeft());

	}

}
