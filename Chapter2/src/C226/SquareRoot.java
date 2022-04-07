package C226;

public class SquareRoot extends Progression {
	 public SquareRoot(double start) {
		 super(start);
	 }
	 
	 public SquareRoot() {
		 super(65536);
	 }
	 
	 protected void advance() {
		 current = Math.sqrt((double) current);
	 }
}
