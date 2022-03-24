package R13;

import java.util.Scanner;

public class IsMultiple {

	public static void main(String args[]) {
		long n = ReadLong();
		long m = ReadLong(); 
		boolean result = IsmultipleCheck(n, m);

		System.out.print("n is a multiple of m: " + result);
	}

	private static long ReadLong() {
		Scanner input = new Scanner(System.in);
		long result;
		System.out.print("Enter a long value: ");
		result = input.nextLong();
		input.close();
		return result;
	}

	private static boolean IsmultipleCheck(long n, long m) {

		if (m == 0) {
			return false;
		}

		float result = n % m;

		if (result != 0) {
			return false;
		}

		return true;

	}
}
