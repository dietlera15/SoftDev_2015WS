package hello_world;

public class hello_world
{

	public static void main(String[] args)
	{
		System.out.println("Hello World!");
		int value = 30;
		System.out.println(value);
		value = 40;
		boolean DietlerBOOL = true;
		int DietlerINT = 30;
		float DietlerFLOAT = 2.22f;
		// String DietlerSTRING = "Servus";
		
		System.out.println("BOOL: " + DietlerBOOL + " INTEGER: " + DietlerINT + " FLOAT: " + DietlerFLOAT);
		// System.out.println(DietlerINT);
		// System.out.println(DietlerFLOAT);
		// System.out.println(DietlerSTRING);

		int a = 20;
		int b = 10;
		int sum = a + b;
		int diff = a - b;
		int prod = a * b;
		int quot = a / b;
		int rest = a % b;
		
		System.out.println(sum);
		System.out.println(diff);
		System.out.println(prod);
		System.out.println(quot);
		System.out.println(rest);
		
		int c = 0;
		int d = 2;
		int e = 46;
		
		for(int i = 0; i < 10; i++)
		{
		
			if (c < e)
			{
				System.out.println(c + " ist kleiner als " + e);
				c = c + d;
			}
			
			else 
			{
				System.out.println("Ende");
			}
		
		}
	
	}

}