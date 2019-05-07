package readers;

import baseReader.BaseReader;
import token.Token;

public class EndOfLineCommentReader extends BaseReader{
	public String type;
	
	public EndOfLineCommentReader() {
		super();
		this.type = "eolc";
	}
	
	protected boolean checkTokenEnd(String string, int index) {
		if (index == string.length() || string.charAt(index) == '\n')
			this.state = this.states[0];
		return (index == string.length() || string.charAt(index) == '\n');
	}

	protected boolean canStart(String string, int index) {
		boolean cond = (string.charAt(index) == '/' && index + 1 < string.length() && string.charAt(index+1) == '/');
		if (cond)
			this.state = this.states[1];			
		return cond;
	}

	protected Token correctType(String string) {
		return new Token(this.type, string, string);
	}

	
}
