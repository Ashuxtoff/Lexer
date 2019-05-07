package readers;

import baseReader.BaseReader;
import token.Token;


public class WhiteSpaceReader extends BaseReader{
	public String type;
	
	public WhiteSpaceReader() {
		super();
		this.type = "ws";
	}	
	
	public boolean canStart(String string, int index) {
		if (index < string.length() && Character.isWhitespace(string.charAt(index)))
			this.state = this.states[1];
		return (index < string.length() && Character.isWhitespace(string.charAt(index)));
	}

	public boolean checkTokenEnd(String string, int index) {
		if (!this.canStart(string, index))
			this.state = this.states[0];
		return (!this.canStart(string, index));
	}
	
	public Token Read(String string, int index) {
		return super.readToken(string, index);
	}

	protected Token correctType(String string) {
		return new Token(this.type, string, string);
	}
	
}
	
