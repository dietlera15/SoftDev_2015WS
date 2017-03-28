package at.fhj.swd;

public class MathUtil {

	public static boolean isPrime(int n){
		if(n < 2) return false;
		for (int i = 2; i < n; i++){
			boolean isDivisible = (n % i == 0);
			if(isDivisible) return false;
			}
		return true;
	}	
	
}
