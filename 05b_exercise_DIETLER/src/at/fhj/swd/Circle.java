package at.fhj.swd;

public class Circle {
	
	// Definieren der öffentlichen Variablen
	public double area;
	public double perimeter;
	public double scale;
	
	// Skaliert den Radius um den gegebenen Faktor
	public static double r_scale (int radius, double factor)
	{
		double radius_s = factor * radius;
		return radius_s;
	}
	
	// Berechnet den Umfang des Kreises
	public static double CircPerimeter (double radius)
	{
		double CircPerimeter = 2 * radius * Math.PI;
		return CircPerimeter;
	}
	
	// Berechnet die Fläche des Kreises
	public static double Area51 (double radius)
	{
		double CircArea = Math.pow(radius, 2) * Math.PI;
		return CircArea;
	}
	
	
	public Circle(int r)
	{
		double f = 2; // Faktor ist fix gesetzt
		scale = r_scale(r, f); // Radius wird skaliert
		perimeter = CircPerimeter(scale); // Umfang mit skaliertem Radius
		area = Area51(scale); // Fläche mit skaliertem Radius
	}
	
}
