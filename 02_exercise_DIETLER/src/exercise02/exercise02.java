package exercise02;

public class exercise02 {

	public static void main(String[] args) {
	
	for(int year = 1900; year <= 2015; year++)
	{
		if (((year % 4) == 0) & !(((year % 100) == 0) ^ ((year % 400) == 0)))
		{
			System.out.println(year + " ist ein Schaltjahr.");
		}
		
		else
		{
			System.out.println(year + " ist kein Schaltjahr.");
		}
		
	}

	}
}
