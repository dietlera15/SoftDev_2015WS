package swd_20151205;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream("/home/student/hello2.txt", true));
			for(int i = 0; i < 10; i++){
				writer.println(i + "Hallo Welt");
			}
		}

		catch (IOException error) {
			System.out.println("Fehler beim lesen der Datei.");
			System.out.println("Error-Details: " + error);
		}
		
		finally{
			if (writer != null){
				try {
					writer.close();
				}
				catch (Exception e){}
			}
		}

	}

}
