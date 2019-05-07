package lexer;

import java.util.ArrayList;
import baseReader.BaseReader;
import token.Token;
import readers.WordReader;

public class Lexer {
	private ArrayList<BaseReader> readersList;
	
	public Lexer() {
		this.readersList = new ArrayList<BaseReader>();
	}
	public Token[] tokenize(String input) {
		ArrayList<Token> resultList = new ArrayList<Token>();
		int index = 0;
		while (index < input.length()) {
			Token t = null;
		    for (int i = 0; i < readersList.size(); i++) {
		    	BaseReader temp = readersList.get(i);
		    	t = temp.readToken(input, index);
		    	if (t != null) {
		    		resultList.add(t);
		    		break;
		    	}		    		  	
		    }		    
		    if (t == null) return null;
		    else
		    	index += resultList.get(resultList.size() - 1).getText().length();
		}
		return resultList.toArray(new Token[resultList.size()]);
	}
	
	public void register(BaseReader reader) {
		this.readersList.add(reader);
	}	
}
