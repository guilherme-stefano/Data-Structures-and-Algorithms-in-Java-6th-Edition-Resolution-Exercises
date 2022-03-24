package C120;

public class CheckDistinct {

	public static void main(String[] args) {
		double[] doubles = new double[] {2.9,4.2,1,4.1,4};
		boolean isUnique = CheckIfIsUnique(doubles);
		System.out.print("The array " + (isUnique ? "has" : "hasn't") + " all elements distincts " );
	}
	
	public static boolean CheckIfIsUnique(double[] doubles) {
		for(int i = 0 ; i < doubles.length ; i++  ) {
			double n = doubles[i];
			for(int j = 0 ; j < doubles.length ; j++  ) {
				if(i != j) {
					double m = doubles[j];
					if(m == n) {
						return false;
					}
				 }
			}
		}
		return true;
	}
}
