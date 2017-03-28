package at.fhj.swd;

import javax.swing.JOptionPane;

public class Exercise05
{
	
	public static void main(String[] args)
	{
		int radius = 0; // initialisieren des Radius
		
		// Eingabe über JOptionPane
		String radius_string = JOptionPane.showInputDialog("Geben Sie den Radius ein:");
		try
		{
			// Umwandeln auf Integer
			radius = Integer.parseInt(radius_string);
		
			// Initialisieren des Kreisobjektes
			Circle circle = new Circle(radius);
			System.out.println("Der Radius des Kreises ist: " + circle.scale);
			System.out.println("Die Fläche des Kreises ist: " + circle.area);
			System.out.println("Der Umfang des Kreises ist: " + circle.perimeter);
		}
		catch(NumberFormatException ex)
		{
			System.out.println("Der eingegebene Radius ist falsch.");
		}
	}
}
