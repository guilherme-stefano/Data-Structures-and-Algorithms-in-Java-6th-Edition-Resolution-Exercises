package C226;

public abstract class Progression<T> {

	// instance variable
	protected T current;

	/** Constructs a progression with given start value. */
	public Progression(T start) { current = start; }
	/** Returns the next value of the progression. */
	public T nextValue() {
		T answer = current;
		advance(); // this protected call is responsible for advancing the current value
		return answer;
	}
	
	/** Advances the current value to the next value of the progression. */
	protected abstract void advance();
	
	/** Prints the next n values of the progression, separated by spaces. */
	public void printProgression(int n) {
	System.out.print(nextValue()); // print first value without leading space
	 for (int j=1; j < n; j++)
	 System.out.print(" " + nextValue().toString()); // print leading space before others
	 System.out.println(); // end the line

	 }
}