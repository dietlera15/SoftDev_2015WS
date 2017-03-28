package swd_20151205;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {

	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/home/student/hello.txt"));
			String line = null;
			int lineNumber = 1;
			while ((line = reader.readLine()) != null) {
				System.out.println("Zeile " + lineNumber + " in Datei: " + line);
				lineNumber ++; 
			}
			System.out.println();
			System.out.println("Anzahl der Zeilen: " + (lineNumber - 1));
			reader.close();
		}

		catch (IOException error) {
			System.out.println("Fehler beim lesen der Datei.");
			System.out.println("Error-Details: " + error);
		}
		
		finally{
			if (reader != null){
				try {
					reader.close();
				}
				catch (Exception e){}
			}
		}


	}

}
