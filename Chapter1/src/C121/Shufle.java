package C121;

import java.util.ArrayList;
import java.util.Random;

public class Shufle {
	public static void main(String[] args) {

	

		
		int[] sufled = Shufle();
		
		for(int number : sufled) {
			System.out.print(number + ",");
		}

	}
	
	public static int[] Shufle() {
		
		ArrayList<Integer> numbersToShufle = new ArrayList<Integer>();
		int[] numbersShufled = new int[52];

		for(int i = 0 ; i <= 51; i++) {
			numbersToShufle.add(i + 1);
		}
		
	
		for(int i = 0 ; i <= 51; i++) {
			Random rand = new Random();
			int numbersToShufleLenght = numbersToShufle.size();
			int randomInex = rand.nextInt(numbersToShufleLenght);
			int popRandom = numbersToShufle.remove(randomInex);
			numbersShufled[i] = popRandom;
		}
		
		return numbersShufled;
		
		
	}
	
	
}
