package C229;

public class NDegreeTerm extends PolynomialTerm{

	private String Signal;
	private int Number;
	private int Exp;
	
	public NDegreeTerm(String Term) {
		super(Term);
		this.Signal = "";
		this.Number = 0;
	}

	@Override
	public String calculateDifferentiate() {
		PolynomialTermRegex regex = new PolynomialTermRegex(this.Term);
		this.Signal = regex.hasSignal() ? this.Term.charAt(0) + "" : "";
		this.Number = regex.hasNumberInBeginTerm() ? 
				(this.Signal == "" ? Integer.parseInt(this.Term.charAt(0)+ "") : Integer.parseInt(this.Term.charAt(1)+"") ) : 0;
		this.Exp = Integer.parseInt(this.Term.charAt(this.Term.length() - 1) + "");
		
		int newExp = this.Exp - 1;
		int newNumber = this.Number * this.Exp;
		String newString = (newNumber > 0 ? "+" :"-") + (newNumber == 0 ? "" : newNumber + "") + (newExp !=1 ? "x^" + newExp : "x");
		return newString;
	}
	
}
