package R65;

public class main {

	public static void main(String[] args) {

		LinkedStack<Integer> S = new LinkedStack<Integer> ();
		
		S.push(1);
		S.push(2);
		S.push(3);
		
		System.out.println(S.size());
		
		S.clear();
		
		System.out.println(S.size());
		  
	
	}

}
