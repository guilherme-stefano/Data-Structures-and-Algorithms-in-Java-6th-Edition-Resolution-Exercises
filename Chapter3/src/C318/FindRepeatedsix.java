package C318;

public class FindRepeatedsix {
	
	public static Integer find(int[] array) {
		for(int i=0;i<array.length;i++) {
			int found = 0;
			for(int j = i; j < array.length ; j++ ) {

				if(array[i] == array[j] && i!=j ) {
					found++;
				}
				
				if(found == 4) {
					return array[i];
				}
			}	
		}	
		
		return null;
	}
	
	public static void main(String[] args) {
		int[] numbers = {5,1,1,5,5,5,1,1,5};
		
		Integer finded = FindRepeatedsix.find(numbers);
		
		System.out.println(finded);
	}
}
