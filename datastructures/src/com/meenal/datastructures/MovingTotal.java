package com.meenal.datastructures;

import java.util.ArrayList;
import java.util.List;

public class MovingTotal {

	ArrayList<Integer> numbers;
	List<Integer> sums;
	int index;

	public MovingTotal() {
		numbers = new ArrayList<>();
		sums = new ArrayList<>();
	}

	/**
	 * Adds/appends list of integers at the end of internal list.
	 */
	public void append(int[] list) {
		int tempSum;
		for (int i = 0; i < list.length; i++) {
			numbers.add(list[i]);
			if (numbers.size() - index == 3) {
				tempSum = numbers.get(index) + numbers.get(index + 1) + numbers.get(index + 2);
				sums.add(tempSum);
				index++;
			}
		}

	}

	/**
	 * Returns boolean representing if any three consecutive integers in the
	 * internal list have given total.
	 */
	public boolean contains(int total) {
		if (sums.contains(total)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		MovingTotal movingTotal = new MovingTotal();

		movingTotal.append(new int[] { 1, 2, 3 });

		System.out.println(movingTotal.contains(6));
		System.out.println(movingTotal.contains(9));

		movingTotal.append(new int[] { 4 });

		System.out.println(movingTotal.contains(9));
	}
}
