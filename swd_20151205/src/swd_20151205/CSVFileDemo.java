package swd_20151205;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileDemo {

	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/home/student/countries.csv"));
			String line = null;
			
			reader.readLine();
			
			while ((line = reader.readLine()) != null) {
				String[] splited = line.split(";");
				
				String name = splited[0];
				int area = Integer.parseInt(splited[1]);
				int population = Integer.parseInt(splited[2]);
				
				System.out.println(name + " Fläche: " + area + " Einwohner: " + population);
			}
		}

		catch (IOException error) {
			System.out.println("Fehler beim Lesen der Datei.");
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
