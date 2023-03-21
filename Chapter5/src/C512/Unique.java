package C512;

public class Unique {

	public static boolean CheckUnique(int[] elements, int size, int i, int j) {
		
		if(i > size) {
			return true; 
		}
		
		if(j > size) {
			return true;
		}
		
		
		boolean currentCompare = false;
		if(i != j) {
			 currentCompare = elements[i] == elements[j] ;
			
			if(currentCompare) {
				return false;
			}
		}
		
		boolean comparei =  !currentCompare && CheckUnique(elements, size, i+1, j);
		
		if(!comparei) {
			return false;
		}
		
	    boolean comparey = comparei && CheckUnique(elements, size, i, j+1);
	    
	    return comparey;
	    
	
	}
}
   

