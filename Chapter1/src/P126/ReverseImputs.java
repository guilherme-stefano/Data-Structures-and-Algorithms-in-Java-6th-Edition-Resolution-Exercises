package P126;

import java.util.Scanner;

public class ReverseImputs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the of lines : ");
		int numberLines = input.nextInt();
		ReverseImputs reverseImputs = new ReverseImputs();
		reverseImputs.Reverse(numberLines);
	}
	
	private void Reverse(int numberLines) {
		String[] inputs = new String[numberLines];
		
		for(int i=0; i<numberLines; i++) 
		{
			Scanner input = new Scanner(System.in);
			System.out.print("Enter a value to the Line: ");
			inputs[i] = input.next();
		} 
		System.out.println("");
		for(int i = numberLines-1; i >= 0 ; i--) {
			System.out.println(inputs[i]);
		}
	}
		
		
}
	

