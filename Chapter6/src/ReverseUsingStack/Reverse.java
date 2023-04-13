package ReverseUsingStack;

public class Reverse {
	
	public static < E > void reverse(E[] a) {
		  Stack < E > buffer = (Stack<E>) new ArrayStack <E> (a.length);
		  for (int i = 0; i < a.length; i++)
		    buffer.push(a[i]);
		  for (int i = 0; i < a.length; i++)
		    a[i] = buffer.pop();
		}
}
