package baseReader;

import token.Token;

public abstract class BaseReader {
	protected String state;
	protected String[] states = {"not active", "active"};
	protected String type;
	
	protected BaseReader() {
		state = states[0];
	}
		
	protected abstract boolean checkTokenEnd(String initialText, int index);
	protected abstract boolean canStart(String initialText, int index);	
	protected abstract Token correctType(String string);
	
	public Token readToken(String input, int index) {
		if (this.canStart(input, index)) {
			int i = index;
			while (this.state == "active") {
				i++;
				this.checkTokenEnd(input, i);
			}
			String result = input.substring(index, i);
			return this.correctType(result);
		}
		return null;
	}
}

