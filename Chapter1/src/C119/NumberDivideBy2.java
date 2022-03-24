package C119;

import java.util.Scanner;

public class NumberDivideBy2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);   
		System.out.print("Enter string to calculate: ");
		int number = input.nextInt();
		int calc = Calculate(number);
		System.out.print("Result: " + calc);
		input.close();
	}
	
	public static int Calculate(int number) {
		int divisor = 0;
		
		while(number > 2) {
			number = number/2;
			divisor++;
		}
		
		return divisor;
	}

}

