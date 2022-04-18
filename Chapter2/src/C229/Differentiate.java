package C229;

import java.util.LinkedList;
import java.util.List;

public class Differentiate {
	
	private String PolynomialString;
	private LinkedList<PolynomialTerm> Polynomial;
	
	Differentiate(String polynomial){
		this.PolynomialString = polynomial.replaceAll(" ", "");
		this.Polynomial = new  LinkedList<PolynomialTerm>();
		buildPolynomialTermList();
	}
	
	private void buildPolynomialTermList() {
		PolynomialRegex regex = new PolynomialRegex(this.PolynomialString);
		LinkedList<String> polynomialStringList = regex.getStrings();
		PolynomialTermFactory polynomialTermFactory = new PolynomialTermFactory(polynomialStringList);
		this.Polynomial = polynomialTermFactory.buildPolynomialTermList();
	}
	
	public String Calculate() {
		String calculatedDifferentiate = "";
		for(PolynomialTerm term : this.Polynomial) {
			calculatedDifferentiate = calculatedDifferentiate + term.calculateDifferentiate();
		}		
		return calculatedDifferentiate;
	}
	
	
}
