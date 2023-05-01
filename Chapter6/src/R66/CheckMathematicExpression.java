package R66;

public class CheckMathematicExpression {
	private LinkedStack<String> StackExpression = new  LinkedStack<String>();
	private String OpenExpression = "(";
	private String CloseExpression = ")";
	private String NumberSignal = "+-";
	private String Operations = "*/";
	
	public boolean checkExpression(String expression) {
		
		String firstElement = expression.charAt(0) + "";
		
		if(OpenExpression.contains(firstElement)  || NumberSignal.contains(firstElement) || Operations.contains(firstElement)) {
			StackExpression.push(firstElement);
		}
		
		if(CloseExpression.contains(firstElement)) {
			
			if(StackExpression.isEmpty()) {
				return false;
			}
			
			String pop = StackExpression.pop();
			
			if(!OpenExpression.contains(pop)) {
				return false;
			}
			
			StackExpression.push("0");
			
		}

		
		if(isNumeric(firstElement)) {
			String nextElement =  firstElement;
			String nextExpression =  expression.substring(1);
			while(nextExpression.length() != 0 && isNumeric(nextElement)) {
				nextElement = nextExpression.charAt(0) + "";
				
				if(isNumeric(nextElement)) {
					expression = expression.substring(1);
					firstElement = firstElement + nextElement;
					nextExpression = expression;
				}
			}
			
			if(StackExpression.isEmpty()) {
				return false;
			}
			
			String top = StackExpression.top();
			
			if(NumberSignal.contains(top)) {
				StackExpression.pop();
				top = StackExpression.top();
				if(isNumeric(top)) {
					StackExpression.pop();
				}
			}else if(Operations.contains(top)) {
				StackExpression.pop();
				top = StackExpression.top();
				if(isNumeric(top)) {
					StackExpression.pop();
				} else {
					return false;
				}
			}else {
				StackExpression.push(firstElement);
			}
			
		}
		
		if(expression.length() == 1) {
			return (StackExpression.isEmpty());
		}

		return checkExpression(expression.substring(1));

	}
	
	
	private static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
