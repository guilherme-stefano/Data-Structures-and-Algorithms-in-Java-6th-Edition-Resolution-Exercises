package PseudoRandom;
import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
  public static void main(String[] args) {
    int data[] = new int[5];
    PseudoRandom rand = new PseudoRandom(12, 5, 100, 92);
   
    for (int i = 0; i < data.length; i++)
    data[i] = rand.next(); // the next pseudo-random number
    int[] orig = Arrays.copyOf(data, data.length); // make a copy of the data array
    System.out.println("arrays equal before sort: " + Arrays.equals(data, orig));
    Arrays.sort(data); // sorting the data array (orig is unchanged)
    System.out.println("arrays equal after sort: " + Arrays.equals(data, orig));
    System.out.println("orig = " + Arrays.toString(orig));
    System.out.println("data = " + Arrays.toString(data));
  }
  
  
}