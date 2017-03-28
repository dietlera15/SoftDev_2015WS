package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Exercise06 {

	// Array Liste für die Länder erstellen
	private static ArrayList<Country> countree = new ArrayList<Country>();
	// Prozentlimit für die Länder die im HTML-File eingefärbt werden sollen
	private static int low = 10;
	// Gibt den Pfad der Quelldatei an
	private static String Source = "/tmp/countries.csv";
	// Gibt den Pfad für die zu erstellende Datei an
	private static String Destination = "/tmp/SWD15_DIETLER_countrees.xhtml";
	// Nur die Länder mit weniger Internetnutzern als das Prozentlimit sollen ausgegeben werden
	private static boolean lowIU = false;
	// Gibt den Pfad für das Log-File aus
	private static String logFile = System.getProperty("user.dir") + "/log.txt";
	// Gibt den aktuellen Pfad an
	private static String actualPath = System.getProperty("user.dir");
	
	// Liest das CSV-File ein und weißt es der ArrayList zu
	private static void CSVReader(String Source){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(Source));
			String line = null;
			/* Kann die Zeilennummer aus dem File ausgelesen werden?
			 */
			// gibt die anzahl der gelesen Zeilennummern an
			int index = 1;
			// erste Zeile wird gelesen und an den HeaderCheck übergeben
			String[] header = reader.readLine().split(";");
			boolean CSVok = HeaderCheck(header);
			if (CSVok) {
				// Wenn der Header OK ist, so wird die spaltenposition ermittelt
				int i_nam = ColumnCheck(header, "name");
				int i_are = ColumnCheck(header, "total_area");
				int i_pop = ColumnCheck(header, "population");
				int i_int = ColumnCheck(header, "internet_users");
				index++;
				// es wird Zeile für Zeile eingelesen bis keine mehr vorhanden ist.
				while ((line = reader.readLine()) != null) {
					// gelesenen Zeile wird aufgeteilt mit dem Seperator ";"
					String[] splited = line.split(";");
					try {
						// Zuweisen und Umwandeln der seperierten Werte
						String name = splited[i_nam];
						float area = Float.parseFloat(splited[i_are]);
						int population = Integer.parseInt(splited[i_pop]);
						int internet = Integer.parseInt(splited[i_int]);
						// Erstellen eines neuen Countries und übergeben der gelesenen Werte
						countree.add(new Country(name, area, population, internet));
					} catch (Exception error) {
						System.out.println("Fehlerhafte Werte in Zeile " + index + ".");
						System.out.println("Details unter \"" + logFile + "\"");
						LogFileWriter(error);
					}
					index++;
				}
			} else {
				System.out.println("Es sind nicht alle Werte für die Konvertierung im CSV-File vorhanden.");
			}
			LogFileMessage("CSV-Reader: Es wurden " + index + " Zeilen gelesen.");
		} catch (IOException error) {
			System.out.println("Fehler beim Lesen der Datei. Bitte Pfadangabe prüfen");
			System.out.println("Details unter \"" + logFile + "\"");
			LogFileWriter(error);
		} finally {
			if (reader != null){
				try {
					reader.close();
					System.out.println("["+ actualDateTime() + "] - " + "Das Lesen des CSV-Files wurde beendet.");
				} catch (Exception e){}
			}
		}	
	}
	
	// Schreibt das HTML File
	private static void HTMLWriter(String Destination){
		// Gelesene Datensätze
		int dataRead = 1;
		// Datensätze die beim Schreiben übersprungen wurden
		int dataSkipped = 0;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(Destination));
			
			// Header wird eingefügt
			writer.println("<!DOCTYPE html>\n"
					+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">\n"
					+ "<head>\n"
						+ "\t<meta charset=\"UTF-8\"/>\n"
						+ "\t<meta name=\"viewport\" content=\"width=device-width\"/>\n"
						+ "\t<meta name=\"author\" content=\"Andreas Dietler\"/>\n"
						+ "\t<title>Software Development </title>\n"
						+ "\t<style>\n"
							+ ".low {color: red;}"
							+ "#table-header {font-weight: bold; color: blue;}"
							+ "#austria {font-weight: bold; color: green;}"
						+ "\t</style>\n"
					+ "</head>\n"
					+ "<body>\n"
						+ "\t<header>\n"
							+ "\t\t<h1>Uebung: Laenderstatistik</h1>\n"
						+ "\t</header>\n"
						+ "\t<main>\n"
							+ "\t\t<table>\n"
								+ "\t\t\t<thead>\n"
									+ "\t\t\t\t<tr id=\"table-header\"><td>Name</td><td>Total Area</td><td>Population</td><td>Internet User</td></tr>\n"
								+ "\t\t\t</thead>\n"
								+ "\t\t\t<tbody>\n");
			
			/* Content einfügen (Länderstatistik)
			 * Für jedes Land wird eine Table-Row eingefügt
			 */ 
			for(int i = 0; i < countree.size(); i++){
				/* fügt eine normale Table-Row ein wenn ein Land weniger als x% Internetnutzer besitzt.
				 * Nur gültig wenn Länder mit weniger als x% geschreiben werden sollen.
				 * Wenn alle Länder geschreiben werden sollen, werden die else if ausgeführt
				 */
				if (lowIU && (countree.get(i).get_p_internet_users() < low)){
					writer.println("\t\t\t\t<tr><td>" + countree.get(i).get_name() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_total_area() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_population() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_p_internet_users() + "</td></tr>\n");
				}
				/* fügt eine Table-Row mit der ID (für CSS) "austria" ein
				 * sollte anschließend grün gefärbt und FETT gedruckt sein
				 */
				else if (!lowIU && countree.get(i).get_name().equals("Austria")){
					writer.println("\t\t\t\t<tr id=\"austria\"><td>" + countree.get(i).get_name() + "</td>\n"
							+ "\t\t\t\t<td>" + countree.get(i).get_total_area() + "</td>\n"
							+ "\t\t\t\t<td>" + countree.get(i).get_population() + "</td>\n"
							+ "\t\t\t\t<td>" + countree.get(i).get_p_internet_users() + "</td></tr>\n");
				}
				/* fügt eine Table-Row mit der Class (für CSS) "low" ein
				 * sollte anschließend rot gefärbt sein
				 */
				else if (!lowIU && (countree.get(i).get_p_internet_users() < low)){
					writer.println("\t\t\t\t<tr class=\"low\"><td>" + countree.get(i).get_name() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_total_area() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_population() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_p_internet_users() + "</td></tr>\n");
				}
				/* fügt eine Table-Row mit der Class (für CSS) "low" ein
				 * sollte anschließend rot gefärbt sein
				 */
				else if (!lowIU){
					writer.println("\t\t\t\t<tr><td>" + countree.get(i).get_name() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_total_area() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_population() + "</td>\n"
									+ "\t\t\t\t<td>" + countree.get(i).get_p_internet_users() + "</td></tr>\n");
				} 
				/* Wenn ein Datensatz überprungen wird, so wird die Variable
				 * dataSkipped um 1 erhöht
				 */
				else {
					dataSkipped++;
				}
				// die Anzahl der gelesen Datensätze wird in der Variable dataRead gespeichert.
				dataRead = i + 1;
			}
			
			//Footer schreiben.
			writer.println("\t\t\t</tbody>\n"
							+ "\t\t</table>\n"
						+ "\t</main>\n"
						+ "\t<footer>\n"
							+ "\t\t<h6>Andreas Dietler<br></br>\n"
							+ "\t\tSoftware Development<br></br>\n"
							+ "\t\tSoftware Design WS2015<br></br>\n"
							+ "\t\tFH Joanneum Kapfenberg</h6>\n"
						+ "\t</footer>\n"
					+ "</body>\n"
					+ "</html>\n");
					
		} catch (IOException error) {
			System.out.println("Fehler beim Schreiben der Datei. Bitte Pfadangabe prüfen.");
			System.out.println("Details unter \"" + logFile + "\"");
			LogFileWriter(error);
		} finally {
			if (writer != null){
				try {
					writer.close();
					System.out.println("["+ actualDateTime() + "] - " + "Das Schreiben des HTML-Files wurde beendet.");
				} catch (Exception e){}
			}
		}
		// Einträge ins Log-File (inzwischen ist es ein Spam File)
		LogFileMessage("HTML-Writer: Es wurden " + dataRead + " Datensätze gelesen.");
		LogFileMessage("HTML-Writer: Es wurden " + (dataRead - dataSkipped) + " Datensätze geschreiben.");
		LogFileMessage("HTML-Writer: Es wurden " + dataSkipped + " Datensätze übersprungen.");
	}
	
	// Schreibt eine Fehlermeldung in das Log-File
	private static void LogFileWriter(Exception msg){
		PrintWriter writer = null;
		try {
			// neue Zeile ins Log-File hinzufügen
			writer = new PrintWriter(new FileOutputStream(logFile, true));
			// schreibe das aktuelle Datum, Zeit und die MESSAGE
			writer.println("["+ actualDateTime() + "] - " + msg);								
		} catch (IOException error) {
			/* wenn das Schreiben ins log file nicht funktioniert,
			 * wird in der Console eine Fehlermeldung ausgegeben
			 */
			System.out.println("Error during writing the Log-File to \"" + logFile + "\"");
			System.out.println("Error-Details: " + error);
		} finally {
			if (writer != null){
				try {
					writer.close();
				} catch (Exception e){}
			}
		}
	}
	
	// Schreibt eine Meldung in das Log-File
	private static void LogFileMessage(String msg){
		PrintWriter writer = null;
		try {
			// neue Zeile ins Log-File hinzufügen
			writer = new PrintWriter(new FileOutputStream(logFile, true));
			// schreibe das aktuelle Datum, Zeit und die MESSAGE
			writer.println("["+ actualDateTime() + "] - " + msg);								
		} catch (IOException error) {
			/* wenn das Schreiben ins log file nicht funktioniert,
			 * wird in der Console eine Fehlermeldung ausgegeben
			 */
			System.out.println("Error during writing the Log-File to \"" + logFile + "\"");
			System.out.println("Error-Details: " + error);
		} finally {
			if (writer != null){
				try {
					writer.close();
				} catch (Exception e){}
			}
		}
	}
 	
	// Hoffentlich richtiges Program
	public static void main(String[] args) {
		// Damit das LogFile nicht nur Fehlermeldungen enthält
		LogFileMessage("-------------------------");
		System.out.println("Ein Log File wurde erstellt / Neue Einträge wurden zum LogFile hinzugefügt: \"" + logFile + "\"");
		LogFileMessage("Programm started.");
		LogFileMessage("Actual Directory: " + actualPath);
		LogFileMessage("Length of Arguments: " + args.length);
		/* Enthält das Zuweisen der Argumente
		 * Wenn keine Argumente übergeben wurden wird mit den Initialwerten gearbeitet
		 * 
		 */
		if (args.length != 0){
			try {
				for(int i = 0; i < args.length; i++) {
					/* ein for wurde für jedes Argument eingefügt, für den Fall das weniger
					 * Argumente übergeben werden. werden z.b. die low Internet Usage Only
					 * nicht ausgeführt.
					 */
					// schreibt den neuen Quellpfad
					if (i == 0) Source = args[0];
					// schreibt din neuen Zeilpfad
					if (i == 1) Destination = args[1];
					// Ürüft ob nur die Länder mit weniger als x Prozent ausgegeben werden sollen
					if (i == 2) {
						if (args[2].equals("-lowInternetUsageOnly")) {
							lowIU = true;
						} else
							try {
								/* wenn -lowInternetUsageOnly nicht vorhanden ist, wird geprüft
								 * ob das Übergebenen Element geparsed werden kann und wird als
								 * Prozentlimit für die einzufärbenden Elemente übergeben.
								 */
								low = Integer.parseInt(args[2]);
							}
							// Wenn das Parsen nix gut läuft, wird eine Meldung ins Log-File geschreiben
							catch (NumberFormatException error){
								LogFileWriter(error);
							}
					}
					// ich hab keine Idee was ich schon wieder schreiben soll
					if (i == 3) { 
						try {
							// eingegebenes Argument in eine Integer umwandeln
							low = Integer.parseInt(args[3]);
						}
						// Wenn das Parsen nix gut läuft, wird eine Meldung ins Log-File geschreiben
						catch (NumberFormatException error){
							LogFileWriter(error);
						}
					}
					/* schreibt das aktuelle Argument ins Log-File
					 * da kann ma alles nachvollziehen :-O
					 */
					String Argument = "Argument " + i + ": " + args[i];
					LogFileMessage(Argument);
				}
			} catch (IndexOutOfBoundsException error) {
				LogFileWriter(error);
			}
		} else {
			// Wenn keine Argumente übergeben wurden.
			System.out.println("Es wurden keine Argumente Übergeben. Das Programm wird "
					+ "mit den Initialwerten ausgeführt. Files werden aus dem Ordner "
					+ "\"/tmp/\" gelesen und geschreiben. Bitte überprüfen sie ihre "
					+ "Eingabe! <Programm> <Eingabe Pfad & File> <Ausgabe Pfad & File> "
					+ "<-lowInternetUsageOnly> <Prozentsatz für lowInternetUsage>. "
					+ "Details finden sie in der Doku (Aufgabenstellung von Uebung 06 "
					+ "- Laenderstatistik) auf Moodle oder irgendwo auf ihrem Laptop.");
		}
		// Read CSV-File
		CSVReader(Source);
		try {
			LogFileMessage(countree.size() + " Datensätze vorhanden.");
		} catch (IndexOutOfBoundsException error) {
			LogFileWriter(error);
		}
		// Write HTML-File
		HTMLWriter(Destination);
		
		LogFileMessage("Programm stopped.");
	}
	
	// zum Überprüfen des CSV Headers
	private static boolean HeaderCheck(String[] columns){
		// Für jede Spalte wird eine boolsche variable erstellt
		boolean check = false;
		boolean ch_name = false;
		boolean ch_area = false;
		boolean ch_popu = false;
		boolean ch_iusr = false;
		/* beim schreiben der kommentare ist mir eine weitere möglichkeit eingefallen
		 * es wird eine Integer Variable erstellt, welche hochgezählt wird,
		 * wenn einer der Strings vorhanden ist. In unserem Fall müsste diese am Ende
		 * 4 sein. Wenn sie 4 ist, wird ein True (value == 4) zurückgegeben.
		 */
		for(int i = 0; i < columns.length; i++){
			/* Es müssen die Spalten name, total_area, population, internet_users im Header
			 * vorhanden sein. Wenn die Spalte gefunden wurde, wird die zugehörige Variable
			 * auf TRUE gesetzt
			 */
			// Prüft nachg dem Wert "name"
			if(columns[i].equals("name")) ch_name = true;
			// Prüft nachg dem Wert "total_area"
			if(columns[i].equals("total_area")) ch_area = true;
			// Prüft nachg dem Wert "population"
			if(columns[i].equals("population")) ch_popu = true;
			// Prüft nachg dem Wert "internet_users"
			if(columns[i].equals("internet_users")) ch_iusr = true;
		}
		// Wenn alle vier Spalten vorhanden sind, wird die check Variable auf TRUE gesetzt
		if (ch_name && ch_area && ch_popu && ch_iusr) check = true;
		return check;
	}
	
	
	// sucht im Header die Spaltennummer für den den übergebenen checkValue (Name, Area, Population ...)
	private static int ColumnCheck(String[] columns, String checkValue){
		int index = 0;
		for(int i = 0; i < columns.length; i++){
			// Überprüft ob der String gleich dem checkValue ist (der kas geht jo net mit ==)
			if(columns[i].equals(checkValue)) index = i;
		}
		// gibt den Index (Spaltenposition) zurück
		return index;
	}
	
	
	// Ausgabe des aktuellen Datums und der Zeit
	private static String actualDateTime() {
		/* Kopie aus dem Internet
		 * Ich habe es mir noch nicht im Detail angesehen
		 * Aber es funktioniert
		 */
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
}
