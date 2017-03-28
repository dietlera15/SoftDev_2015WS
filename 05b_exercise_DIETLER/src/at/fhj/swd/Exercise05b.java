package at.fhj.swd;

import javax.swing.JOptionPane;

public class Exercise05b
{

	public static void main(String[] args)
	{		
		int ArrayCount = 5; // Die Anzahl der zu berechnenden Kreise
		int [] radius = new int [ArrayCount]; // definieren der Radien
		Circle [] circle = new Circle [ArrayCount];  // definieren der Kreise
		
		for (int i = 0; i <= (ArrayCount - 1); i++)
		{
			String radius_string = JOptionPane.showInputDialog("Geben Sie den Radius für Kreis " + (i + 1) + " ein:");
			try
			{
				radius[i] = Integer.parseInt(radius_string);

				circle[i] = new Circle(radius[i]);
				System.out.println("Der Radius des Kreises " + (i + 1) + " ist: " + circle[i].scale);
				System.out.println("Die Fläche des Kreises " + (i + 1) + " ist: " + circle[i].area);
				System.out.println("Der Umfang des Kreises " + (i + 1) + " ist: " + circle[i].perimeter);
				
/*				// Überprüfen der berechneten Kreise
				if (i == (ArrayCount - 1))
				{
					for (int j = 0; j <= (ArrayCount - 1); j++)
					{
						System.out.print("  ---  sc " + j + ": " + circle[j].scale);
						System.out.print("  ---  ar " + j + ": " + circle[j].area);
						System.out.println("  ---  pe " + j + ": " + circle[j].perimeter);
					}
				}
*/			}
			catch(NumberFormatException ex)
			{
				System.out.println("Der eingegebene Radius für Kreis " + (i + 1) + " ist falsch.");
				i--;
			}
		}
	}
}
