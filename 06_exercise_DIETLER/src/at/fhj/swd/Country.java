package at.fhj.swd;

public class Country {
	// Variablen der Country Class definieren - Variablen die übergeben werden
	private String name;
	private float total_area;
	private int population;
	private float p_young;
	private float p_adult;
	private float p_old;
	private int internet_users;
	// Variablen der Country Class definieren - Variablen die intern berechnet
	// werden
	private float p_internet_users;
	private float p_sum;

	// Ausgabe des Ländernamen
	public String get_name() {
		return name;
	}

	// Ausgabe der Landesfläche
	public float get_total_area() {
		return total_area;
	}

	// Ausgabe der Bevölkerung
	public int get_population() {
		return population;
	}

	// Ausgabe der Anzahl der Internetuser
	public int get_internet_users() {
		return internet_users;
	}

	// Ausgabe der Anzahl der Internetuser in Prozent
	public float get_p_internet_users() {
		return p_internet_users;
	}
	
	public boolean lowerThan(float percent) {
		boolean low = false;
		if (p_internet_users < percent) low = true;
		return low;
	}

	// Zuweisen der übergebenen Werte an die internen Variabeln
	public Country(String country, float area, int pop, int users) {
		name = country;
		total_area = area;
		population = pop;
		internet_users = users;

		// Anzahl der Internetuser in Prozent umrechnen.
		float p_internet_usa = (float) internet_users / (float) population * 100;
		float p_internet_user = Math.round(p_internet_usa * 1000);
		p_internet_users = p_internet_user / 1000;
		/* 
		 * Warum konnte diese Berechnung nicht in einer Zeile ausgeführt werden.
		 * Die Berechnung musste auf mehrere Zeilen aufgeteilt werden, da anonsten
		 * die Umwandlung in die Nachkommerstellen nicht funktionierte.
		 * Gibt es einen einfacheren Weg die Kommastellen bei Float/Double Variablen
		 * zu begrenzen? Im Internet wurde meistens dieser Weg vorgeschlagen.
		 */
	}
	
	public Country (String country, float area, int pop, float young, float adult, float old, int users){
		name = country;
		total_area = area;
		population = pop;
		p_young = young;
		p_adult = adult;
		p_old = old;
		internet_users = users;
		
		// Anzahl der Internetuser in Prozent umrechnen
		p_internet_users = (float) internet_users / (float) population * 100;
		
		// Summe der Bevölkerung in Prozent berechnen
		p_sum = p_young + p_adult + p_old;
		// Damit die gelbe Warnung nicht mehr angezeigt wird
		if(p_sum == 100);
	}

}
