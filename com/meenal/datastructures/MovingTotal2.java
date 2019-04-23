package com.meenal.datastructures;

import java.util.ArrayList;
import java.util.List;


public class MovingTotal2 {

	ArrayList<Integer> numbers;
	List<Integer> sums;

	/**
	 * Adds/appends list of integers at the end of internal list.
	 */
	public void append(int[] list) {
		int sum = 0;
		if (numbers == null) {
			numbers = new ArrayList<>();
			sums = new ArrayList<>();
			for (int i = 1; i <= list.length; i++) {
				if (i % 3 == 0) {
					numbers.add(list[i - 1]);
					sum = sum + list[i - 1];
					sums.add(sum);
					sum = 0;

				} else {
					numbers.add(list[i - 1]);
					sum = sum + list[i - 1];
				}
			}
		} else {
			if (numbers.size() % 3 != 0) {
				for (int index = numbers.size() - numbers.size() % 3 + 1; index < numbers.size(); index++) {
					sum = sum + numbers.get(index);
				}
			}

			for (int i = 1; i <= list.length; i++) {
				if (i % 3 == 0) {
					numbers.add(list[i - 1]);
					sum = sum + list[i - 1];
					sums.add(sum);
					sum = 0;

				} else {
					numbers.add(list[i - 1]);
					sum = sum + list[i - 1];
				}
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
