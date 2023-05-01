package R66;

public class main {

	public static void main(String[] args) {
		CheckMathematicExpression checkMath = new CheckMathematicExpression();
		
		boolean result = checkMath.checkExpression("(1+2)/2");
		
		System.out.println(result);

	}

}
