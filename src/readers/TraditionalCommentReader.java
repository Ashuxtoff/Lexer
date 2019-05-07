package readers;


import baseReader.BaseReader;
import token.Token;

public class TraditionalCommentReader extends BaseReader{
	private String type;
	
	public TraditionalCommentReader() {
		super();
		this.type = "tc";
	}

	protected boolean checkTokenEnd(String string, int index) {
		boolean cond = (string.charAt(index-1) == '/' &&  string.charAt(index-2) == '*');
		if (cond)
			this.state = this.states[0];
		return cond;
	}

	protected boolean canStart(String string, int index) {
		boolean cond = (string.charAt(index+1) == '*' && string.charAt(index) == '/');
		if (cond)
			this.state = this.states[1];
		return cond;
	}

	protected Token correctType(String string) {
		return new Token(this.type, string, string);
	}
	
	
}
