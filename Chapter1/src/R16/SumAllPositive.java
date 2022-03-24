package R16;

import java.util.Scanner;

public class SumAllPositive {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);   
		System.out.print("Enter an integer value to Sum all integers: ");
		int numberToSum = input.nextInt();
		int sum = SumAllPositiveFunc(numberToSum);
		System.out.print("The sum is: " + sum);
		input.close();
	}
	
	public static int SumAllPositiveFunc(int n) {
		int result = 0;
		if(n <= 0) {
			return 0;
		}
		for(int i = 1; i<=n; i++) {
			if((i % 2) != 0) {
				result = result + i; 
			}
		}
		
		return result ;
	}
}
