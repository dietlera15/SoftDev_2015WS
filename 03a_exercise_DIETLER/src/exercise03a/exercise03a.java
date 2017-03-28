package exercise03a;

public class exercise03a {

	public static void main(String[] args)
	{
		int value = 170;
		int bitlength = 8;
		int index = (bitlength - 1);
		
		boolean[] bit_b = new boolean[bitlength];
		int[] bit_i = new int[bitlength];
		
		System.out.println("Dezimalzahl: " + value);
		
		if ((value < (Math.pow(2, bitlength))) && (value >= 0))
		{
			for(int i = index; i >= 0; i--)
			{
				if (value % 2 == 1)
				{
					bit_b[i] = true;
					bit_i[i] = 1;
				}
				else
				{
					bit_b[i] = false;
					bit_i[i] = 0;
				}
				//System.out.print("Value: " + value);
				
				//value = value / 2;
				value = (value - (value % 2)) / 2;
				
				//System.out.println("/2 = " + value + " " + bit_i[i] + " Rest");
			}
						
			System.out.print("Binärzahl: ");
			
			for(int i = 0; i <= index; i++)
			{
				System.out.print(bit_i[i]);
			}
			
			System.out.println();
			
			for(int i = 0; i <= index; i++)
			{
				System.out.print("B" + i + " " + bit_b[i] + "; ");
			}
		}
		
		else
		{
			System.out.print("'" + value + "' is not a valid number");
		}
	}
}