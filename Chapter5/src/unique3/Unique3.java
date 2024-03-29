package unique3;

public class Unique3 {
	public static boolean unique3(int[] data, int low, int high) {
		  if (low >= high) return true;
		  else if (!unique3(data, low, high- 1)) return false;
		  else if (!unique3(data, low + 1, high)) return false;
		  else return (data[low] != data[high]);
		}
}
