package R59;

public class Power {

	public static int PowerMethod(int x, int y) {
		int value = 1; 	
		for(int i = 0; i<(y/2); i++) {
				value = value * x;
			}
		
		value = value * value;
		
		if(y%2 ==1) {
			value = value * x;
		}
		
		return value;
	}
}
   

