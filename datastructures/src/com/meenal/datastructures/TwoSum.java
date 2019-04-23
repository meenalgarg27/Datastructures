package com.meenal.datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
	public static int[] findTwoSum(int[] list, int sum) {
//		List<Integer> arraylist = new ArrayList<>(list);
		List<Integer> arraylist = Arrays.stream(list).boxed().collect(Collectors.toList());

		int [] result = null;
		for(int i =0 ; i< list.length; i++) {
			int temp = sum -list[i];
			if(arraylist.contains(temp)) {
				result = new int[2];
				result[0] = i;
				result[1] = arraylist.indexOf(temp);
				break;
			}
		}
		
		return result;

	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] { 13, 1, 5, -3, 5, 9 }, 10);
		if (indices != null) {
			System.out.println(indices[0] + " " + indices[1]);
		}
	}
}