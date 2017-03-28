package at.fh.swd;

import java.util.ArrayList;
import java.util.HashMap;

public class swd_20160123 {

	public static void main(String[] args) {
		HashMap<Integer, String> numberName =
					new HashMap<Integer, String>();
		
		numberName.put(1, "2");
		numberName.put(2, "3");
		
		String name = numberName.get(1);
		System.out.println(name);
		
		String otherName = numberName.get(99);
		
		boolean containsThree = numberName.containsKey(3);
		
		if(otherName == null){
			System.out.println("Schlüssel existiert nicht.");
			
		for (Integer curKey : numberName.keySet())
		{
			System.out.println("Schlüssel: " + curKey);
		}
		
		ArrayList<String> allValues =
				new ArrayList<String>(numberName.values());
		
		
		
		}

	}

}
