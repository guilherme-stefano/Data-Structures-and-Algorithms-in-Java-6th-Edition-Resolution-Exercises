package R58;

public class ToInt {
	public static int ToInt(String number) {
		return ToInt(number.toCharArray(), number.length() - 1); 
	}
	private static int ToInt(char[] number, int size) {
		  if (size == 0) {
		    return Character.getNumericValue(number[size]); 
		  }
		  	int resultRecursive = ToInt(number, size-1);
		  	int resultCurrent = (int) (Character.getNumericValue(number[size])* Math.pow(10, size));
		  	return resultRecursive + resultCurrent;
		  }
		}
   

