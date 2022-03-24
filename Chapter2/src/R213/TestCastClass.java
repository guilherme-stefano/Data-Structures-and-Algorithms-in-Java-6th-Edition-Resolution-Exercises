package R213;

public class TestCastClass {

	
	
	public static void main(String[] args) {
		
		Equitrarian eq = new Equitrarian();
		Horse horse = (Horse)eq;
		horse.eat();
		
		Horse h = new Runner();
		Equitrarian e = (Equitrarian)h;
		h.eat();
		e.trote();
		

	}
	

	
	

}

class Horse {
	public int height;
	
	public void eat() {
		System.out.println("i ate");
	}
}

class Equitrarian extends Horse{
	public int weight;
	public void trote() {
		System.out.println("i troted");
	}
	
}

class Runner extends Horse{
	public int color;
	public void run() {
		System.out.println("i runed");
	}

}
