package R127;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.print("Insira o primeiro Numero: ");
		double number1 = input.nextDouble();
		System.out.print("Insira o segundo Numero: ");
		double number2 = input.nextDouble();
		System.out.print("Insira o operador: ");
		String operator = input.next();
		Calculator calculator = new Calculator();
		double resultado = calculator.Calculate(number1, number2, operator);
		System.out.print("Resultado : " + resultado);

	}
	
	public double Calculate(double number1, double number2, String operator) 
	{
		switch(operator) 
		{
			case "/":
				Division division = new Division(number1, number2);
				return division.Calculate();
			case "*":
				Multiplication multiplication = new Multiplication(number1, number2);
				return multiplication.Calculate();
			case "+":
				Sum sum = new Sum(number1, number2);
				return sum.Calculate();
			case "-":
				Subtraction subtraction = new Subtraction(number1, number2);
				return subtraction.Calculate();
			default :
				return 0;
							
		}
	}
	

	

}
