package com.meenal.datastructures;

import java.util.ArrayList;
import java.util.Collection;

public class Folders {
	public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
		ArrayList<String> result;
		String[] words = xml.split("<folder name=\"");// splits
			result = new ArrayList<>();
			for(int i=1; i<words.length; i++) {
				if(words[i].startsWith(Character.toString(startingLetter))) {
					result.add(words[i].substring(0, words[i].indexOf("\"")));
				}
			}
			return result;

	}

	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<folder name=\"c\">"
				+ "<folder name=\"program files\">" + "<folder name=\"uninstall information\" />" + "</folder>"
				+ "<folder name=\"users\" />" + "</folder>";

		Collection<String> names = folderNames(xml, 'u');
		for (String name : names)
			System.out.println(name);
	}
}
