package readers;

import baseReader.BaseReader;
import token.Token;

public class IntReader extends BaseReader{
	public String type;
	
	public IntReader() {
		super();
		this.type = "int";
	}	
	
	public boolean canStart(String string, int index) {
		int i = index;
		if (string.charAt(index) == '-')
			i++;
		while (i < string.length())
			if (!Character.isDigit(string.charAt(i))) 
				break;
			else i++;
			if (i - index > 0 && string.length() > i + 2 && string.charAt(i + 1) == '.' && Character.isDigit(string.charAt(i+2)))
				return false;
		if (i - index > 0)
			this.state = this.states[1];		
		return (i - index > 0);
	}

	public boolean checkTokenEnd(String string, int index) {
		if (index == string.length() || !Character.isDigit(string.charAt(index)))
			this.state = super.states[0];
		return (index == string.length() || !Character.isDigit(string.charAt(index)));
			
	}
	
	public Token Read(String string, int index) {
		return super.readToken(string, index);
	}
	
	public Token correctType(String string) {
		return new Token(this.type, string, Integer.parseInt(string));
	}
}