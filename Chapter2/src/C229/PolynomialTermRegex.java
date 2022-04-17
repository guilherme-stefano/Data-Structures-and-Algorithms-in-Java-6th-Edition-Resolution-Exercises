package C229;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialTermRegex {
	
	private String Term;
	
	public PolynomialTermRegex(String term) {
		this.Term = term;
	}
	
	public boolean hasNumberInBeginTerm() {
	   char charArray[] = this.Term.toCharArray();
	   boolean hasNumber = Character.isDigit(charArray[0]);
	   hasNumber = hasNumber || Character.isDigit(charArray[1]);   
	   return hasNumber; 
	}
	
	public boolean hasSignal() {
	   char charArray[] = this.Term.toCharArray();
	   boolean hasSignal = charArray[0] == '-' || charArray[0] == '+'; 
	   return hasSignal; 
	}

}
