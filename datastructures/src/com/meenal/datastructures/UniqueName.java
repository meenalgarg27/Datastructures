package com.meenal.datastructures;

import java.util.HashMap;
import java.util.Map;

public class UniqueName {
	public static String firstUniqueName(String[] names) {
		/*Set<String> set = new HashSet<>(Arrays.asList(names));
		if(set.isEmpty()) {
			return null;
		} else {
			return set.toArray(new String[0])[0];
		}*/
		
		String result = null;
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i =0;i< names.length;i++) {
			if(map.containsKey(i)) {
				int value = map.get(i);
				map.put(i, value + 1);
			} else {
				map.put(i, 1);
			}
		}
		
		for (Map.Entry<Integer,Integer> entry : map.entrySet())  {
			if(entry.getValue() == 1) {
				result = names[entry.getKey()];
				break;
			} 
		}
        return result;    
				
	}

	public static void main(String[] args) {
		System.out.println(firstUniqueName(new String[] { "Abbi", "Adeline", "Abbi", "Adalia" }));
	}
}