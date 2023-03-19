package maximumElement;

public class MaximumElement {
	public static int FindMaximunElementArray( int[] array, int begin, int end) {
		
		if(begin == end ) {
			return array[begin];
		}
		
		int current = array[begin];
		int result = FindMaximunElementArray(array, begin+1, end);
		return current > result ? current : result;
	}

}
