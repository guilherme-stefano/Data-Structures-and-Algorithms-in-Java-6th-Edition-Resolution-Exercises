package R64;

public class main {

	public static void main(String[] args) {

		LinkedStack<Integer> S = new LinkedStack<Integer> ();
		LinkedStack<Integer> T = new LinkedStack<Integer> ();
		
		S.push(1);
		S.push(2);
		S.push(3);
		
		T.push(1);
		T.push(2);
		T.push(3);
		
		
		LinkedStack<Integer> result = T.transfer(S, T);
		
		
		  while(!result.isEmpty())
		  {
			  System.out.println(result.pop());
		  }
		  
	
	}

}
