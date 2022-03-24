package R127;

public class Subtraction extends Operation{
	
	
	public Subtraction(double number1, double number2) {
		super(number1, number2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double Calculate() {
		return Number1 - Number2;
	}

}
