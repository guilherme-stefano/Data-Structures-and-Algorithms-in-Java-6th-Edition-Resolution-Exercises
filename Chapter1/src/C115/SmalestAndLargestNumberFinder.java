package C115;

public class SmalestAndLargestNumberFinder {
	
	public static void main(String[] args) {
		int[] integers = new int[] {2,3,1,5,4};
		int smalest = Smalest(integers);
		int largest = Largest(integers);
		System.out.println("For numbers : ");
		for(int number : integers) {
			System.out.print(number + ",");
		}
		System.out.println("");
		System.out.println("The smalest is: " + smalest);
		System.out.println("The largest is: " + largest);
	}
	
	public static int Smalest(int[] integers) {
		int smalest = integers[0];
		for(int number : integers) {
			if(number < smalest) {
				smalest = number;
			}
		}
		
		return smalest;
		
	}
	
	public static int Largest(int[] integers) {
		int largest = integers[0];
		for(int number : integers) {
			if(number > largest) {
				largest = number;
			}
		}
		
		return largest;
	}
	
}
