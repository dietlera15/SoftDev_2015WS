package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Reader {

//	private String TextString;
	private int counter;
	private int counterL;
	private ArrayList<String> text = new ArrayList<String>();

/*	public String getTextString() {
		return TextString;
	}
*/
	public Integer getallwords() {
		return counter;
	}

	public Integer getallletter() {
		return counterL;
	}
	
	public ArrayList<String> getText() {
		return text;
	}

	public TreeMap<String, Integer> WordCount() {

		HashMap<String, Integer> TenWords = new HashMap<String, Integer>();
		TreeMap<String, Integer> WordCount = new TreeMap<String, Integer>();
		ArrayList<String> lowerText = new ArrayList<String>();
		int i = 0;
		int counter = 0;
//		System.out.println("Wörter werden gezählt");

		try {
			for (String st : text) {
				st = st.replaceAll("\n", " ");
				st = st.replaceAll("\r", " ");
				st = st.replaceAll("\\,", " ");
				st = st.replaceAll("\\.", " ");
				st = st.replaceAll("\\;", " ");
				st = st.replaceAll("\\-", " ");
				String str = st.toLowerCase();
				lowerText.add(str);
//				this.TextString += str;
				String[] splited = str.split(" ");
				counter += splited.length;
               	for (i = 0; i < splited.length; i++){
					if (splited[i].length() > 3) {
						if (!TenWords.containsKey(splited[i])) {
							TenWords.put(splited[i], 1);
						} else {
							TenWords.put(splited[i], TenWords.get(splited[i]) + 1);
						}
					} else {
//						i++;
					}
					
				}
			}
				
//			System.out.println(TenWords);	
			WordCount = new TreeMap<String, Integer>(TenWords);
			System.out.println("Wörter wurden gezählt");

		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Wörter konnten nicht gezählt werden");
		}
//		System.out.println(WordCount);
		this.counter = counter;
		return WordCount;
	}

	public TreeMap<Character, Integer> LetterCount() {

		HashMap<Character, Integer> Letters = new HashMap<Character, Integer>();
		TreeMap<Character, Integer> LetterCount = new TreeMap<Character, Integer>();

		try {
//			char[] letter = TextString.toCharArray();
			for (int i = 0; i < text.size(); i++) {
				String nichtAllesInEinemString = text.get(i).toLowerCase();
				try {
					char[] letter = nichtAllesInEinemString.toCharArray();
					for (int j = 0; j < letter.length; j++) {
						if (letter[j] >= 'a' && letter[j] <= 'z') {
							if (!Letters.containsKey(letter[j])) {
								Letters.put(letter[j], 1);
							} else {
								Letters.put(letter[j], Letters.get(letter[j]) + 1);
							}
						} else {}
					}
				} catch (Exception error) {
					System.out.println(error);
				}
			}
			LetterCount = new TreeMap<Character, Integer>(Letters);
			System.out.println("Buchstaben wurden gezählt");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Buchstaben konnten nicht gezählt werden");
		}
		counterL = 0;
		for(Character curLett : LetterCount.keySet()) {
			int count = LetterCount.get(curLett);
			counterL = counterL + count;
		}
		return LetterCount;
	}

	public Reader(String path) {
		String line = "";
		ArrayList<String> text = new ArrayList<String>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(path));
//			br.readLine();
			while ((line = br.readLine()) != null) {
				text.add(line);
			}
			br.close();

		} catch (IOException ex) {
			System.out.println("Fehler beim Lesen der Datei.");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					System.out.println("Reader ist bereits geschlossen.");
				}
			}
		}
		this.text = text;
		System.out.println("Datei wurde gelesen.");
	}
}

