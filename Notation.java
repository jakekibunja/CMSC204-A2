package assignment2;

public class Notation {
	
	public static String convertInfixToPostfix(String eq) throws QueueOverflowException, StackUnderflowException, StackOverflowException{
		String output = "";
		NotationQueue postQ = new NotationQueue<String>();
		NotationStack opStack = new NotationStack<String>();

		for (int nextChar = 0; nextChar < eq.length(); nextChar++) {
			switch(eq.charAt(nextChar)) {
			case ' ': 
				break;
			case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8': case '9':
				postQ.enqueue(eq.charAt(nextChar));
				break;
			case '(':
				opStack.push(eq.charAt(nextChar));
				break;
			case '*': case '/':case '+': case '-':
				if ((opStack.top().equals('*')) || (opStack.top().equals('/'))) {
					postQ.enqueue(opStack.pop());
					opStack.push(eq.charAt(nextChar));
					break;
				}
			case ')':
				while(!opStack.top().equals('(')) {
					postQ.enqueue(opStack.pop());
				}
				opStack.pop();
				break;
			}
		}
		
		while(!opStack.isEmpty()) {
			postQ.enqueue(opStack.pop());
		}
		output = postQ.toString();
		return output;
	}
	
	public static String convertPostfixToInfix(String eq) throws StackOverflowException, StackUnderflowException {
		String output = "";
		NotationStack opStack = new NotationStack<String>();
		String temp;
		String infix = "";
		
		for (int nextChar = 0; nextChar < eq.length(); nextChar++) {
			switch(eq.charAt(nextChar)) {
			case ' ': 
				break;
			case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8': case '9':
				opStack.push(eq.charAt(nextChar));
				break;
			case '*': case '/':case '+': case '-':
				try {
					if (opStack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
				}
				catch (InvalidNotationFormatException exception) {
					exception.printStackTrace();
				}
				
				temp = (String)opStack.pop();
				
				output = "(" + (String)opStack.pop() + eq.charAt(nextChar) + temp + ")";
				opStack.push(output);
				
				break;
				}
				
		}
		try {
			if (opStack.size() > 1) {
				throw new InvalidNotationFormatException();
			}
		}
		catch (InvalidNotationFormatException exception) {
			exception.printStackTrace();
		}
		
		return output;
	}

	public static double evaluatePostfixExpression(String postfixExpr) throws StackOverflowException, StackUnderflowException  {
		String output = "";
		NotationStack opStack = new NotationStack<String>();
		int eval = 0;

		for (int nextChar = 0; nextChar < postfixExpr.length(); nextChar++) {
			switch(postfixExpr.charAt(nextChar)) {
			case ' ': 
				break;
			case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8': case '9': case '(':
				opStack.push(postfixExpr.charAt(nextChar));
				break;
			case '*': case '/':case '+': case '-':
				try {
					if (opStack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
				}
				catch (InvalidNotationFormatException exception) {
					exception.printStackTrace();
				}
				
				int secVal = (int)opStack.pop();
				int firVal = (int)opStack.pop();
				
				switch (postfixExpr.charAt(nextChar)) {
				case '*':
					eval = firVal * secVal;
					break;
				case '/':
					eval = firVal / secVal;
					break;
				case '+':
					eval = firVal + secVal;
					break;
				case '-':
					eval = firVal - secVal;
					break;
				}
				
				opStack.push(eval);
				break;
			}
		}
		
		try {
			if (opStack.size() > 1) {
				throw new InvalidNotationFormatException();
			}
		}
		catch (InvalidNotationFormatException exception) {
			exception.printStackTrace();
		}
		
		
		
		return (double)opStack.pop();
	}


}
