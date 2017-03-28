package swd_20151107;

public class swd_20151107
	{
	public static int calcPerimeter(int w, int h)
		{
		int u = (2 * w) + (2 * h);
		return u;		
		}
			
	public static void main(String[] args)
		{
		int a = 1;
		int b = 2;
		int x = calcPerimeter(a, b);
				
		System.out.println(x);
		
		rectangle rect = new rectangle(10,9);
		System.out.println(rect.width + " + " + rect.height + " = " + rect.perimeter);
	
		rectangle rect2 = new rectangle(6,7);
		System.out.println(rect2.width + " * " + rect2.height + " = " + rect2.area);
	
		}
	
	
	
	
	}