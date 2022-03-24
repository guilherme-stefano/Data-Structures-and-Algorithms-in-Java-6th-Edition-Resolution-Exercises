package C114;

public class ReverseIntegers {

	public static void main(String[] args) {
		int[] arrayToReverse = new int[]{1,2,3,4,5,6};
		int[] reverse = ReverseArray(arrayToReverse);
		for(int number : reverse) {
			System.out.print(number + ",");
		}
	}
	
	public static int[] ReverseArray(int[] arrayToReverse) {
		int[] reverse = new int[arrayToReverse.length];
		int j = 0;
		for(int i = arrayToReverse.length - 1; i >= 0; i-- ) {
			reverse[j] = arrayToReverse[i];
			j++;
		}
		
		return reverse;
	}
	
	

}
