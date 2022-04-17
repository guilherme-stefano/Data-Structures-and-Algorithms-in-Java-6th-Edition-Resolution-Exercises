package C229;

public abstract class PolynomialTerm {
	public String Term;
	
	public PolynomialTerm(String Term){
		this.Term = Term;
	}
	
	public abstract String calculateDifferentiate();
	
	
}
