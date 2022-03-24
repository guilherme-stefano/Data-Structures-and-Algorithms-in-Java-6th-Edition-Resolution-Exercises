package R127;

public class Division  extends Operation{


	public Division(double number1, double number2) {
		super(number1, number2);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void Number2(double number2)
	{
		this.Number2 = number2;
	}
	

	@Override
	public double Calculate() {
		return Number1 / Number2;
	}


}
