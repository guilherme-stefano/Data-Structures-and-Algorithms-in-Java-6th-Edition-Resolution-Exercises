package R32;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class RemoveRandom {
	
	Integer[] Elements = {1,2,3,4,5,6};
	
	public static void main(String[] args) {
		RemoveRandom remove = new RemoveRandom();
		
		remove.RemoveRandomWhileElements();

	}
	
	public void RemoveRandomWhileElements() {
		for(int i = 0; i < Elements.length ; i++) {
			Random random = new Random();
			Integer index = null;
			do {
				index = random.nextInt(Elements.length);
			}while(Elements[index] == null);
			System.out.println("Removed: " + Elements[index]);
			Elements[index] = null;
			
		
			 
		}
	}

}
