package R214;

import java.util.Scanner;

public class OutOfBoundsTryCatch {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);   
		System.out.print("Enter the size of Array: ");
		int sizeArray = input.nextInt();
		int[] arrayInts = new int[sizeArray];
		
		try {
			System.out.print("Select a array position to put 198 value:");
			int index = input.nextInt();
			arrayInts[index] = 198;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("Don’t try buffer overflow attacks in Java!");
		}
	

	}
	
	
	
}
