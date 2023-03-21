package R57;

public class HarmonicNumber {
	public static float GetHarmonicNumber(int n) {
		  if (n == 1)
		    return 1; 
		  else {
			 float recursiveValue = GetHarmonicNumber(n - 1) + 1/n;
			 float currentValue = (float)1/n;
			 return recursiveValue + currentValue ;
		  }
		}
}
