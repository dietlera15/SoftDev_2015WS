package at.fhj.swd;

import java.io.IOException;

public class FinalExercise {

	public static void main(String[] args) throws IOException {
//		java at.fhj.swd.FinalExercise -key <Schlüssel> -caesar <Input Datei> <Output Datei> --> verschlüsseln
		if (args.length == 5 && (args[0].equalsIgnoreCase("-key")) &&
				(Integer.parseInt(args[1])) > 0 && (Integer.parseInt(args[1])) <=25) {
			String Source = args[3];
			String Destination = args[4];
			int key = 0;
			try {
				key = Integer.parseInt(args[1]);
				key = (((key % 26) + 26) % 26);
			} catch (NumberFormatException error){
				System.out.println(error);
			}
			Reader ReadMyFile = new Reader(Source);
			Writer WriteMyFile = new Writer (Destination);
			WriteMyFile.Filewriter(ReadMyFile.getText(), key);	
		}
//		java at.fhj.swd.FinalExercise -findKey <verschlüsselten Datei> --> Textanalyse und Schlüssel finden
		else if (args.length == 2 && args[0].equalsIgnoreCase("-findKey")) {
			String Source = args[1];
			Reader ReadMyFile = new Reader(Source);
			System.out.println("Der Schlüssel ist: " + Caesar.findKey(ReadMyFile.LetterCount()));
		}
//		java at.fhj.swd.FinalExercise -f <Input Datei> <Output Datei> --> decodieren
		else if(args.length == 3 && args[0].equalsIgnoreCase("-f")) {
			String Source = args[1];
			String Destination = args[2];
			Reader ReadMyFile = new Reader(Source);
			Writer WriteMyFile = new Writer (Destination);
			ReadMyFile.WordCount();
			ReadMyFile.LetterCount();
			System.out.println(ReadMyFile.getallwords() + " Woerter");
			System.out.println(ReadMyFile.getallletter() + " Buchstaben");
			WriteMyFile.HTMLwriter(ReadMyFile.WordCount(), ReadMyFile.LetterCount(), ReadMyFile.getallwords(), ReadMyFile.getallletter());
		}
//		Ungueltige Eingabe
		else {
			System.out.println("Bitte folgende Parameter eingeben um die Datei zu verschlüsseln: -key <key> -caesar <fileIn> <fileOut>");
			System.out.println("Der Key muss zwischen 0 und 25 liegen!");
			System.out.println("Bitte folgende Parameter eingeben um den Schlüssel zu finden: -findKey <fileIn>");
			System.out.println("Bitte folgende Parameter eingeben, um die Datei zu entschlüsseln: java at.fhj.swd.FinalExercise -f <Input Datei> <Output Datei>");
			System.exit(0);
		}
	}
}





