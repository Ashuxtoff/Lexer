package readers;

import baseReader.BaseReader;
import token.Token;


public class WordReader extends BaseReader{	
	public String type;
	
	public WordReader() {
		super();
		this.type = "word";
	}

	public boolean canStart(String string, int index) {
		if (index < string.length() && Character.isLetter(string.charAt(index)))
			this.state = this.states[1];
		return (index < string.length() && Character.isLetter(string.charAt(index)));
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
