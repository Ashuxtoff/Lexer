package readers;

import java.util.Arrays;

import baseReader.BaseReader;
import token.Token;

public class FloatReader extends BaseReader{
	public String type;
	private boolean isPointFirst = true;
	private char[] specSymbols = new char[4];
	private char[] signs = new char[2];
	
	public FloatReader() {
		super();
		this.signs[0] = '-';
		this.signs[1] = '+';
		this.specSymbols[0] = 'f';
		this.specSymbols[1] = 'F';
		this.specSymbols[2] = 'd';
		this.specSymbols[3] = 'D';
		this.type = "float";
	}

	private boolean isSpecSymbol(char character) {
		for (char item: this.specSymbols)
			if (character == item)
				return true;
		return false;
	}
	
	private boolean isSign(char character) {
		for (char item: this.signs)
			if (character == item)
				return true;
		return false;
	}
	
	public boolean canStart(String string, int index) {
		int i = index;
		if (string.charAt(index) == '-')
			i++;
		int pointsCounter = 0;
		while (i < string.length() - 1 && pointsCounter < 2 &&
			   Character.isDigit(string.charAt(i)) || string.charAt(i) == '.')
			i++;
		if (i - index > 0 && string.substring(index, i).contains("."))
			this.state = this.states[1];
		return (i - index > 0 && string.substring(index, i).contains("."));	
			
					
	}

	protected boolean checkTokenEnd(String string, int index) {
		boolean stringEnd = index == string.length();
		boolean wrongLastSymbol = !(isSpecSymbol(string.charAt(index)) ||
								    Character.isDigit(string.charAt(index)) ||
								    string.charAt(index) == '.');
		boolean eMode1 = (index + 2 < string.length() && string.charAt(index) == 'e' &&
						 isSign(string.charAt(index + 1)) &&
						 Character.isDigit(string.charAt(index + 2)));
		boolean eMode2 = (index + 1 < string.length() && string.charAt(index) == 'e' && 
						 Character.isDigit(string.charAt(index+1)));
		boolean eSign = (string.charAt(index-1) == 'e' &&
						 isSign(string.charAt(index)) &&
						 Character.isDigit(string.charAt(index+1)));
		boolean cond = stringEnd || (wrongLastSymbol && !eMode1 && !eMode2 && !eSign); 
		if (cond)
			this.state = this.states[0];
		return cond;
	}	
	
	protected Token correctType(String string) {
		return new Token(this.type, string, Float.parseFloat(string));
	}
}

