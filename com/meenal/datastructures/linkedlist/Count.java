package com.meenal.datastructures.linkedlist;

import java.util.*;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class Count {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Node head = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				if (head == null)
					head = new Node(a);
				else
					insert(head, a);
			}
			GfG g = new GfG();
			System.out.println(g.getCount(head));
		}
	}

	public static Node insert(Node head, int a) {
		if (head == null)
			return new Node(a);
		head.next = insert(head.next, a);
		return head;
	}
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

/* Complete the function below */
class GfG {
	// head is reference to head of linked list
	public int getCount(Node head) {
		if(head.next != null) {
			return getCount(head.next) + 1;
		} else {
			return 1;
		}
		
	}
}