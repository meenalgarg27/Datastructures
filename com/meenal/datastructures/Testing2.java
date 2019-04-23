package com.meenal.datastructures;

public class Testing2 {
    public static int countNumbers(int[] sortedArray, int lessThan) {
    		int counter = 0;
    		if(sortedArray.length > 0 &&lessThan < sortedArray[0]) {
    			return 0;
    		} else if( sortedArray.length > 0 && lessThan > sortedArray[sortedArray.length -1]) {
    			return sortedArray.length;
    		} else {
    			for(int i = 0; i< sortedArray.length; i++) {
        			if(sortedArray[i] < lessThan) {
        				counter++;
        			} else if(sortedArray[i] == lessThan) {
        				break;
        			} else {
        				break;
        			}
        		}
        		return counter;
    		}
    		
    		
    }
    
    public static void main(String[] args) {
        System.out.println(Testing2.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}
