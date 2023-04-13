package ReverseUsingStack;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

			
			  Integer[] a = {
			    4,
			    8,
			    15,
			    16,
			    23,
			    42
			  };
			  String[] s = {
			    "Jack",
			    "Kate",
			    "Hurley",
			    "Jin",
			    "Michael"
			  };
			  System.out.println("a = " + Arrays.toString(a));
			  System.out.println("s = " + Arrays.toString(s));
			  System.out.println("Reversing...");
			  Reverse.reverse(a);
			  Reverse.reverse(s);
			  System.out.println("a = " + Arrays.toString(a));
			  System.out.println("s = " + Arrays.toString(s));
			
	}

}
