package exercise03b;

public class exercise03b {

	public static void main(String[] args)
	{
		int c;
		
		for (int a = 2; a <=9; a++)
		{
			System.out.print(a + ":   ");

			for (int b = 2; b <=10; b++)
			{
				c = a * b;
				System.out.print( a + " * " + b + " = " + c + "   ");
			}
			
			System.out.println();
		}
	}

}
