package lecture4;

public class lecture4 {

	public static boolean methleapyear(int year) {
		boolean leapyear = false;
		if (((year % 4) == 0) & !(((year % 100) == 0) ^ ((year % 400) == 0))) {
			leapyear = true;
		}
		else {
			leapyear = false;
		}
		return leapyear;
	}

	public static int area(int w, int h) {
		int rectarea = w * h;
		return rectarea;
		}

	
	public static void main(String[] args) {
		int currentyear = 2015;
		System.out.println(currentyear);
	}

}