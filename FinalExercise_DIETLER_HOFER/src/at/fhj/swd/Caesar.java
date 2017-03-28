package at.fhj.swd;

import java.util.TreeMap;

public class Caesar {
	
	public static char encode(char letter, int key) {
		if (letter >= 'A' && letter <= 'Z') {
			letter = (char) ((((letter + key) - 'A' ) % 26) + 'A');
		} else if (letter >= 'a' && letter <= 'z') {
			letter = (char) ((((letter + key) - 'a' ) % 26) + 'a');
		} else {}
		return letter;
	}
	
	public static int findKey (TreeMap<Character, Integer> letter) {
		int key = 0;
		char keyChar = 'a';
		int keyInt = 0;
		
		for(Character curChar : letter.keySet()) {
			if((curChar >= 'a' && curChar <= 'z') && letter.get(curChar) > keyInt) {
				keyChar = curChar;
				keyInt = letter.get(curChar);
			}
		}
		
		key = (char) (('e' - keyChar + 26) % 26);
		return key;
	}
}