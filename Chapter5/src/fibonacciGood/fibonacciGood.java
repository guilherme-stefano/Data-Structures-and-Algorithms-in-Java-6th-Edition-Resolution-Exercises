package fibonacciGood;

public class fibonacciGood {
	 public static long[] fibonacciGood(int n) {
		   if (n <= 1) {
		     long[] answer = {
		       n,
		       0
		     };
		     return answer;
		   } else {
		     long[] temp = fibonacciGood(n-1); 
		     long[] answer = {
		       temp[0] + temp[1],
		       temp[0]
		     }; 
		     return answer;
		   }
		 }
}
