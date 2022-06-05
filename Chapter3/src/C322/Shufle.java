package C322;

import java.util.Random;

public class Shufle<E> {
	
	public E[] elements; 
	public Shufle(E[] elements) {
		this.elements = elements;
	}
	public static void main(String[] args) {
		Integer[] elements = {1,2,3,4,5,6,7};
		Shufle<Integer> shufle = new Shufle<Integer>(elements);
		shufle.print();
		shufle.shufle();
		shufle.print();
	}
	
	void shufle(){
		int lenght = elements.length;
		for(int i=0; i<lenght; i++) {
			Random r = new Random();
			int shufled = r.nextInt(lenght);
			E aux = elements[i];
			elements[i] = elements[shufled];
			elements[shufled] = aux;
		}
	}
	
	void print() {
		System.out.print(" | ");
		for(E element : elements){
			System.out.print(element +" | ");
		}
		System.out.println("");
	}
	
	

}
