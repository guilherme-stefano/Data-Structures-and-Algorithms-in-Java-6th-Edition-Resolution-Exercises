package R127;

public abstract class Operation {
	protected double Number1;
	protected double Number2;
	
	
	public Operation(double number1, double number2)
	{
		this.Number1(number1);
		this.Number2(number2);
	}
	
	public void Number1(double number1) 
	{
		this.Number1 = number1;
	}
	
	public double Number1() 
	{
		return this.Number1;
	}
	
	public void Number2(double number2) 
	{
		this.Number2 = number2;
	}
	
	public double Number2() 
	{
		return this.Number2;
	}
	
	public abstract double Calculate();
}
