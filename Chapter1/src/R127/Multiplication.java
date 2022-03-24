package R127;

public class Multiplication extends Operation{
	
	
	public Multiplication(double number1, double number2) {
		super(number1, number2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double Calculate() {
		return Number1 * Number2;
	}

}
