package R52;

public class BinarySearch {
	public static int binarySearch(int[] data, int target, int low, int high) {
		  if (low > high)
		    return -1; // interval empty; no match
		  else {
		    int mid = (low + high) / 2;
		    if (target == data[mid])
		      return mid; // found a match
		    else if (target < data[mid])
		      return binarySearch(data, target, low, mid - 1); // recur left of the middle
		    else
		      return binarySearch(data, target, mid + 1, high); // recur right of the middle
		  }
		}
}
