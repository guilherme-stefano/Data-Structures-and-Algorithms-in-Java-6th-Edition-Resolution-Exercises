package C511;

public class Log {

	public static int LogMethod(int n) {
		
		if(n == 2) {
			return 1;
		}
		
		int logn = 1 + LogMethod(n/2);
		
		return logn;
	}
}
   

