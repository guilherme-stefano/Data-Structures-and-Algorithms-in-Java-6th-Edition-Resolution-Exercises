package C116;

import java.util.Scanner;

public class CheckFormula {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number for a : ");
		int a = input.nextInt();
		System.out.print("Enter a number for b : ");
		int b = input.nextInt();
		System.out.print("Enter a number for c : ");
		int c = input.nextInt();
		boolean check = Check(a,b,c);
		System.out.print("This number " + (check ? "can": "can't") + " be used as aritmetic formula." );
		input.close();
	}
	
	public static boolean Check(int a, int b, int c) {
		if((a + b==c) || (a == b - c) || (a * b==c)) {
			return true;
		} else {
			return false;
		}
	}

}
