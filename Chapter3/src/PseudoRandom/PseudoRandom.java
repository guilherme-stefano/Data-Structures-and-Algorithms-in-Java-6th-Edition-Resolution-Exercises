package PseudoRandom;

public class PseudoRandom {
	private int a;
	private int b;
	private int n;
	private int current;
	
	PseudoRandom(int a, int b, int n, int seed){
		this.a = a;
		this.b = b;
		this.n = n;
		this.current = seed;
	}
	
	public int next() {
		int next = (a*current+b)%n;
		current = next;
		return next;
	}
}
