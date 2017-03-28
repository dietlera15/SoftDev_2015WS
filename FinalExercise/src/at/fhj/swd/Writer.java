package at.fhj.swd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class Writer {

	private String path = "D:/01_education/03_fh/01_semester_swd/SoftDev/uebungen_DIETLER/Exercise 7";
	
	private String HTMLHeader() {
		String text = "<!DOCTYPE html>\n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">\n"
				+ "<head>\n"
					+ "\t<meta charset=\"UTF-8\"/>\n"
					+ "\t<meta name=\"viewport\" content=\"width=device-width\"/>\n"
					+ "\t<meta name=\"author\" content=\"Andreas Dietler und Christian Hofer\"/>\n"
					+ "\t<title>Software Development</title>\n"
					+ "\t<style>\n"
						+ ".low {color: red;}"
						+ "#table-header {font-weight: bold; color: blue;}"
						+ "#austria {font-weight: bold; color: green;}"
					+ "\t</style>\n"
				+ "</head>\n";
		return text;
	}
	
	private String HTMLFooter() {
		String text = "\t<footer>\n"
				+ "\t\t<h6>Andreas Dietler und Christian Hofer<br></br>\n"
				+ "\t\tSoftware Development<br></br>\n"
				+ "\t\tSoftware Design WS2015<br></br>\n"
				+ "\t\tFH Joanneum Kapfenberg</h6>\n"
			+ "\t</footer>\n"
		+ "</body>\n"
		+ "</html>\n";
		return text;
	}
	
	public Writer(String path) {
		this.path = path;
	}
	
	public void HTMLwriter(TreeMap<String, Integer> words, TreeMap<Character, Integer> letter, int wordCount, int letterCount) {
		PrintWriter writer = null;
		try {
			ArrayList<Statistics> Buchstaben = SortMyBuchstaben(letter, letterCount);
			ArrayList<Statistics> Woerter = SortMyTree(words, wordCount);	
			
			writer = new PrintWriter(new FileOutputStream(path));
	
//			Header wird eingefuegt
			writer.println(HTMLHeader());
			writer.println("<body>\n"
						+ "\t<header>\n"
							+ "\t\t<h1>Final Exercise</h1>\n"
						+ "\t</header>\n"
						+ "\t<main>\n"
							+ "\t\t<table>\n"
								+ "\t\t\t<thead>\n"
									+ "\t\t\t\t<tr id=\"table-header\"><td>Buchstabe</td><td>Anzahl</td><td>Prozent</td></tr>\n"
								+ "\t\t\t</thead>\n"
								+ "\t\t\t<tbody>\n");
			
			for(int i = 0; i < Buchstaben.size(); i++){
				writer.println("\t\t\t\t<tr><td>" + Buchstaben.get(i).getText() + "</td>\n"
								+ "\t\t\t\t<td>" + Buchstaben.get(i).getCount() + "</td>\n"
								+ "\t\t\t\t<td>" + Buchstaben.get(i).getPercentage() + "</td></tr>\n");
				}
			
			writer.println("\t\t\t</tbody>\n"
					+ "\t\t</table>\n");
			
			writer.println("\t\t<table>\n"
							+ "\t\t\t<thead>\n"
								+ "\t\t\t\t<tr id=\"table-header\"><td>Wort</td><td>Anzahl</td><td>Prozent</td></tr>\n"
							+ "\t\t\t</thead>\n"
							+ "\t\t\t<tbody>\n");
			
			for(int i = 0; i < 25; i++){
				writer.println("\t\t\t\t<tr><td>" + Woerter.get(i).getText() + "</td>\n"
								+ "\t\t\t\t<td>" + Woerter.get(i).getCount() + "</td>\n"
								+ "\t\t\t\t<td>" + Woerter.get(i).getPercentage() + "</td></tr>\n");
				}
			
			writer.println("\t\t\t</tbody>\n"
							+ "\t\t</table>\n"
						+ "\t</main>\n");

//			Footer schreiben.
			writer.println(HTMLFooter());
					
		} catch (IOException error) {
			System.out.println("Fehler beim Schreiben der Datei. Bitte Pfadangabe pruefen.");
		} finally {
			if (writer != null){
				try {
					writer.close();
				} catch (Exception e){}
			}
		}
	}
	
	public void Filewriter(ArrayList<String> content, int key) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(path));
			
			for(int i = 0; i < content.size(); i++){
				char[] letter = content.get(i).toCharArray();
				for (int j = 0; j < letter.length; j++) {
					letter[j] = Caesar.encode(letter[j], key);
				}
				String help = "";
				for(int j = 0; j < letter.length; j++) {
					help += letter[j];
				}
				content.set(i, help);
				writer.println(help);
			}	
		} catch (IOException error) {
			System.out.println("Fehler beim Schreiben der Datei. Bitte Pfadangabe pruefen.");
		} finally {
			if (writer != null){
				try {
					writer.close();
					System.out.println("Datei wurde geschrieben.");
				} catch (Exception e){}
			}
		}	
		
	}
	
	public static ArrayList<Statistics> SortMyTree(TreeMap<String, Integer> map, int total){
		ArrayList<Statistics> top = new ArrayList<Statistics>();
		
		for(String curWord : map.keySet()){
			int count = map.get(curWord);
			top.add(new Statistics(curWord, count, total));
			}
		for(int i = 1; i < top.size(); i++) {
			for(int j = 0; j < top.size() - i; j++) {
				if(top.get(j).getCount() < top.get(j+1).getCount()) {
					Statistics temp = top.get(j);
					top.set(j, top.get(j+1));
					top.set(j+1, temp);
				}
			}
		}
		return top;
	}
	
	public static ArrayList<Statistics> SortMyBuchstaben(TreeMap<Character, Integer> map, int total){
		ArrayList<Statistics> top = new ArrayList<Statistics>();
		
		for(Character curChar : map.keySet()){
			int count = map.get(curChar);
			top.add(new Statistics(curChar, count, total));
			}
		for(int i = 1; i < top.size(); i++) {
			for(int j = 0; j < top.size() - i; j++) {
				if(top.get(j).getCount() < top.get(j+1).getCount()) {
					Statistics temp = top.get(j);
					top.set(j, top.get(j+1));
					top.set(j+1, temp);
				}
			}
		}
		return top;
	}
}
