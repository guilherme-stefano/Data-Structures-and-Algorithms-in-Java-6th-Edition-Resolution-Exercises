package R14;

import java.util.Scanner;

public class IsEven {

	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer value to check if is even: ");
		int numberToCheck = input.nextInt();
		boolean isEven = IsEvenCheck(numberToCheck);
		System.out.print("The number " + (isEven ? "is" : "is not") + " even");
		input.close();
	}
	
	public static boolean IsEvenCheck (int number) {
		int numberCheck = number > 0 ? number : number * -1 ;
		while(numberCheck >= 0) {
			
			if(numberCheck == 0) {
				return true;
			}
			
			if(number < 0) {
				return false;
			}
			
			numberCheck = numberCheck - 2;
		}
		
		return false;
	}

}
