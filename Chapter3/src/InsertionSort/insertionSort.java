package InsertionSort;

public class insertionSort {

	public static void main(String[] args) {
		char[] data = {'b','c','d','a', 'e', 'h', 'g', 'f'};
		insertionSort(data);

	}
	
	public static void insertionSort(char[] data) {
		  int n = data.length;
		  System.out.println("Iteration: 0");
		  for (int k2 = 0; k2 < n; k2++) { 
		    System.out.print("| " + data[k2] + " |");
		  }
		  System.out.println("");
		  
		  for (int k = 1; k < n; k++) { // begin with second character
		    System.out.println("Iteration:" + k);
		    char cur = data[k]; // time to insert cur=data[k]
		    int j = k; // find correct index j for cur
		    while (j > 0 && data[j - 1] > cur) { // thus, data[j-1] must go after cur
		      data[j] = data[j - 1]; // slide data[j-1] rightward
		      j--; // and consider previous j for cur
		    }
		    data[j] = cur; // this is the proper place for cur

		    for (int k2 = 0; k2 < n; k2++) {
		      System.out.print("| " + data[k2] + " |");
		    }
		    System.out.println("");
		  }
		}

}
