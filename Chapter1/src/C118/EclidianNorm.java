package C118;

public class EclidianNorm {

	public static void main(String[] args) {
		int[] integers = new int[] {4,3};
		double euclianNorm = Calculate(integers, 2);
		System.out.print("The euclian value is " + euclianNorm);
	}
	
	public static double Calculate(int[] vector, int p) {
		double euclidianNorm = 0;
		int euclianSum = 0;
		for(int number : vector) {
			euclianSum = euclianSum + (int)Math.pow(number, p);
		}
		double e = (double)1/p;
		euclidianNorm = Math.pow(euclianSum, e);
		
		return euclidianNorm;
	}

}
