package C317;

public class FindRepeated {
	
	public static Integer find(int[] array) {
		for(int i=0;i<array.length;i++) {
			for(int j = i; j < array.length ; j++ ) {
				if(array[i] == array[j] && i!=j ) {
					return array[i];
				}
			}	
		}	
		
		return null;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,5};
		
		Integer finded = FindRepeated.find(numbers);
		
		System.out.println(finded);
	}
}
