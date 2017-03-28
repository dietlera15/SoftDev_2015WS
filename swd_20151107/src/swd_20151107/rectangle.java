package swd_20151107;

public class rectangle
	{
	public int width;
	public int height;
	public int perimeter;
	public int area;
	
	public rectangle(int rectWidth, int rectHeight)
		{
		width = rectWidth;
		height = rectHeight;
		perimeter = rectWidth * 2 + rectHeight * 2;
		area = rectWidth * rectHeight;
		}
	}