package at.fhj.swd;

import javax.swing.JOptionPane;

public class primzahlen {

	private static void printPrimes(int limit){
		int count = 0;
		for (int i = 1; i <= limit; i++) {
			if (MathUtil.isPrime(i)){
				count++;
				System.out.print(i + "; ");
			}
		}
		System.out.printf("%nIm Bereicht von 2 bis %d gibt es %d Primzahlen.%n", limit, count);
	}

	private static int readInteger(){
		String input = JOptionPane.showInputDialog(null, "Please enter a interval in which all prime numbers should be listed." );
		int limit = Integer.parseInt(input);
		return limit;
	}
	
	public static void main(String[] args) {
		
		try{
			int limit = readInteger();
			printPrimes(limit);
		}
		
		catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Invalid number");
		}
		
		//1. User Input
		
		//2. Methode die bestimmt ob eine Zahl eine Primzahl ist
		
		//3. Verwendung dieser Methode zum Auflisten aller Primzahlen

	}

}
