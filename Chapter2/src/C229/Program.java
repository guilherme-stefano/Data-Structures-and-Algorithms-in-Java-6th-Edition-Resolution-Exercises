package C229;

public class Program {

	public static void main(String[] args) {
		Differentiate differentiate = new Differentiate("-5x^3 +2x^2 -2x +1");
		System.out.println(differentiate.Calculate());
	}

}
