package at.fhj.swd;

import javax.swing.JOptionPane;

public class Exercise04
{

	// Überprüft ob der eingegebene Wert innerhalb der Grenzen liegt
	public static boolean InputValid(int IVmin, int IVval, int IVmax)
	{
		boolean iv = false; // iv ... Input Value

		if ((IVmin <= IVval) && (IVval <= IVmax))
		{
			iv = true;
		}
		else
		{
			iv = false;
		}
		
		return iv;
	}

	// Überprüft ob es sich beim angegebenen Jahr um ein Schaltjahr handelt
	public static boolean IsLeapYear(int year)
	{
		boolean LeapYear = false;

		if (((year % 4) == 0) & !(((year % 100) == 0) ^ ((year % 400) == 0)))
		{
			LeapYear = true;
		}
		else
		{
			LeapYear = false;
		}
		
		return LeapYear;
	}

	// Werteeingabe über JOptionPane mit Umwandlung auf Integer
	public static int InputValue(String Type)
	{
		String input = JOptionPane.showInputDialog("Geben Sie " + Type + "  ein:");
		int iv;
		try
		{
			iv = Integer.parseInt(input);
		}
		catch (NumberFormatException ex)
		{
			iv = 0;
		}
		
		return iv;
	}

	// Gibt die Anzahl der Tage des Monats aus (Monat 1 - 12; 13 ist Februar im Schaltjahr)
	public static int DaysOfMonth(int month, boolean LeapYear)
	{
		int[] Days = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29 };
		int i = 0;

		if ((month == 2) && LeapYear)
		{
			i = 13;
		}
		else
		{
			i = month;
		}
		
		return Days[i];
	}

	// zählt die Schaltjahre zwischen den angegebenen Jahren
	public static int LeapYearCounter(int year_start, int year_end)
	{
		boolean LYC_IsLeapYear = false;
		int LYC_Count = 0;

		for (int i = year_start; i < year_end; i++)
		{
			LYC_IsLeapYear = IsLeapYear(i);

			if (LYC_IsLeapYear == true)
			{
				LYC_Count++;
			}
		}
		
		return LYC_Count;
	}

	public static void main(String[] args) {
		// Initialisierung der Werte Werte
		boolean end_program = false; // Programm abbrechen (Code überspringen)

		// Initialisierung der Jahreswerte
		int s_yy = 1900; // Startjahr
		int e_yy = 0; // Endjahr
		boolean Valid_e_yy = false; // Eingabejahr ist OK

		// Initialisierung der Monatswerte
		int s_mm = 1; // Startmonat
		int e_mm = 0; // Endmonat
		boolean Valid_e_mm = false; // Eingabemonat ist OK

		// Initialisierung der Tageswerte
		int s_dd = 1; // Starttag
		int e_dd = 0; // Endtag
		boolean Valid_e_dd = false; // Eingabetag ist OK

		// Eingabe des Jahres
		if (end_program == false)
		{
			e_yy = InputValue("das Jahr");
			Valid_e_yy = InputValid(s_yy, e_yy, 5867441);
			end_program = !Valid_e_yy;
		}
		
		// Eingabe des Monats
		if (end_program == false)
		{
			e_mm = InputValue("den Monat");
			Valid_e_mm = InputValid(1, e_mm, 12);
			end_program = !Valid_e_mm;
		}

		// Eingabe des Tages
		if (end_program == false)
		{
			e_dd = InputValue("den Tag");
			boolean LeapYear = IsLeapYear(e_yy); // Schaltjahr?
			int days = DaysOfMonth(e_mm, LeapYear); // Anzahl der Monatstage
			Valid_e_dd = InputValid(1, e_dd, days);
			end_program = !Valid_e_dd;
		}

/*		// hier auskommentiert ist der alte programmcode. der zwar
 		// funktioniert, allerdings das abfangen mit einer falschen
 		// eingabe "kompliziert" wurde. bei der fehlerausgabe war
 		// es möglich das ein jahr vor 1900 eintreten konnte, sowie
 		// ein falsches datum (55.55.1899). dann war mir die
 		// fehlerauswertung zu doof, und ich hab die eingabe von
 		// tag-monat-jahr auf jahr-monat-tag umgebaut. das machte
 		// vieles einfacher.

 		if (end_program == false)
 		{
			String end_dd = JOptionPane.showInputDialog("Geben Sie den Tag ein:");
			String end_mm = JOptionPane.showInputDialog("Geben Sie den Monat ein:");
			String end_yy = JOptionPane.showInputDialog("Geben Sie das Jahr ein:");
			try
			{
				e_dd = Integer.parseInt(end_dd);
				e_mm = Integer.parseInt(end_mm);
				e_yy = Integer.parseInt(end_yy);
			}
			catch (NumberFormatException ex)
			{
				end_program = true;
			}
		}

		if (end_program == false)
		{
			Valid_e_yy = InputValid(s_yy, e_yy, 5867441);
			Valid_e_mm = InputValid(1, e_mm, 12);

			// Der Tag soll bei einem invaliden Jahr oder Monat nicht berechnet
			// werden Falsches Jahr: Die LeapYear Methode würde ein falsches
			// Ergebnis liefern Falsches Monat: Der Index für das Array wäre
			// falsch und es war hier einfacher abzufangen :-)

			if ((Valid_e_yy == true) && (Valid_e_mm == true))
			{
				boolean LeapYear = IsLeapYear(e_yy);
				int days = DaysOfMonth(e_mm, LeapYear);
				Valid_e_dd = InputValid(1, e_dd, days);
			}

			end_program = !(Valid_e_yy && Valid_e_mm && Valid_e_dd);
		}
*/
		if (end_program == false)
		{
			int calc_yy = e_yy - s_yy;
			int dd_years = 365 * calc_yy;
			int dd_Lyears = LeapYearCounter(s_yy, (e_yy - 1));
			int dd_month = 0;
			boolean calc_LeapYear = IsLeapYear(e_yy);

			for (int i = 1; i < e_mm; i++)
			{
				dd_month = dd_month + DaysOfMonth(i, calc_LeapYear);
			}

			int dd_days = (e_dd - 1);

			int dd_count = dd_years + dd_Lyears + dd_month + dd_days;

			System.out.print("Anzahl der Tage zwischen ");
			System.out.print(s_dd + "." + s_mm + "." + s_yy);
			System.out.print(" und ");
			System.out.print(e_dd + "." + e_mm + "." + e_yy);
			System.out.println(": " + dd_count);
			System.out.println("--------------------------------------------------");
			System.out.println("Die Summe der Tage von 1990 - " + (e_yy - 1) + ": " + dd_years);
			System.out.println("zusätzliche Tage durch Schaltjahre von 1990 - " + (e_yy - 1) + ": " + dd_Lyears);
			System.out.println("Die Summe der Tage aller vergangenn Monate " + e_yy + ": " + dd_month);
			System.out.println("Tage des " + e_mm + ". Monats: " + dd_days);
		}

		else
		{
			if (e_yy < 1900)
			{
				System.out.println("Fehler: Das Datum darf nicht vor dem 01.01.1900 liegen.");
			}
			else
			{
				System.out.println("Fehler: Die eingegebenen Werte entsprechen keinem gültigen Datum");
			}

			System.out.println("--------------------------------------------------");
			System.out.println(e_dd + "." + e_mm + "." + e_yy);
			System.out.println("Tag: " + Valid_e_dd + " - Monat: " + Valid_e_mm + " - Jahr: " + Valid_e_yy);
		}

	}

}