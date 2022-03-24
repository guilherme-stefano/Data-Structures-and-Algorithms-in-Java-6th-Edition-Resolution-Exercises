package R19;

import java.util.Scanner;

public class RemovePontuationClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);   
		System.out.print("Enter string to remove pontuation : ");
		String words = input.next();
		String wordsWithoutPontuation = RemovePontuation(words);
		System.out.print("Word without pontuation: " + wordsWithoutPontuation);
		input.close();
	}
	
	public static String RemovePontuation(String words) {
		String res = "";
		for (char c : words.toCharArray()) 
		{
			if(Character.isLetterOrDigit(c) || Character.isSpaceChar(c))
				res += c;
		}
		
		return res;
	}
}
