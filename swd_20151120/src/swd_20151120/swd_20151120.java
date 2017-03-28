package swd_20151120;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class swd_20151120
{
	public static void main(String[] args)
	{
		
		BufferedReader reader = null;
		
		try
		{
/*			FileInputStream stream = new FileInputStream("/tmp/hallo.txt");
			InputStreamReader streamReader = new InputStreamReader(stream);
			BufferedReader bufferReader = new BufferedReader(streamReader);
*/			
//			reader = new BufferedReader(new FileInputStream("/tmp/hallo.txt"));
			
			String line = null;
			int lineNum = 1;
//			while((line = bufferReader.readLine()) != null)
			while((line = reader.readLine()) != null)
			{
				System.out.printf("Zeile %d: %s %n", lineNum, line);
				lineNum++;
			}
/*			System.out.println(line);
			bufferReader.close();
			
*/		}
		catch(FileNotFoundException e)
		{
			System.out.println("Datei konnte nicht gefunden werden.");
		}
		catch(IOException e)
		{
			System.out.println("Fehler beim Lesen der Datei!");
		}
		
		finally{
			if(reader != null)
			{
				try
				{
					reader.close();
				}
				catch(IOException e)
				{
				}
			}
		}
		
		
/*		int age = 33;
		String name = "John";
		
		System.out.println("Ihr Name ist " + name + " und Sie sind " + age + " Jahre alt");

		String output = String.format("Ihr Name ist %s und Sie sind %d Jahre alt", name, age);
		System.out.print(output);
		System.out.printf(output);
		System.out.println(output);
*/	
	}
}
