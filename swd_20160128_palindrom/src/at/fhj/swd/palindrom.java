package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class palindrom {

	public static boolean isPalindrome(String word){
		int length = word.length();
		int middle = word.length()/2;
		for(int i = 0; i < middle; i++){
			char leftLetter = Character.toLowerCase(word.charAt(i));
			char rightLetter = Character.toLowerCase(word.charAt(length - i -1));
			//System.out.printf("Index: %d Buchstabe: %s %n", i, leftLetter);
			//System.out.printf("Index: %d Buchstabe: %s %n", length - i -1, rightLetter);
			if(leftLetter != rightLetter){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String word = JOptionPane.showInputDialog(null, "Geben Sie ein Wort ein:", "Eingabe");
		
		String path = "/home/student/de_neu.dic";
		
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(path));
			
			String line = null;
			while( (line = reader.readLine()) != null){
				//if(line.charAt(0) == '%')
				if(line.startsWith("%")){
					continue;
				}
				if(isPalindrome(line)){
					System.out.println("Palindrome: " + line);
				}
			}
		}
		catch(IOException ex){
			System.out.println("Datei konnte nicht gelesen werden.");
		}
		finally {
			if (reader != null);
		}
		
		
				
		if(word != null){
			boolean palindrome = isPalindrome(word);
			
			if(palindrome == true){
				JOptionPane.showMessageDialog(null, String.format("%s ist ein Palindrom.", word));
			}
			else{
				JOptionPane.showMessageDialog(null, String.format("%s ist kein Palindrom.", word));
			}

		}
	}
}
