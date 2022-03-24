package R18;

import java.util.Scanner;

public class CountsVowelClass {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);   
		System.out.print("Enter string to count vowels: ");
		String nextVowel = input.next();
		int count = CountsVowel(nextVowel);
		System.out.print("The count is: " + count);
		input.close();
	}
	
	public static int CountsVowel(String word) {
		int vowels = 0;
		
		for(char c : word.toCharArray()) {
			if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u' ) {
				vowels++;
			}
		}
		
		return vowels;
	}
	
}
