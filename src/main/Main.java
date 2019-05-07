package main;

import lexer.Lexer;
import token.Token;
import baseReader.BaseReader;
import readers.WordReader;
import readers.IntReader;
import readers.FloatReader;
import readers.WhiteSpaceReader;
import readers.EndOfLineCommentReader;
import readers.TraditionalCommentReader;



public class Main {

	public static void main(String[] args) {
		Lexer lexer = new Lexer();
		String input = ".7e+23f\r\n" + 
				" //ddd 12 123.D \n   /*wsd*/";
		lexer.register(new FloatReader());
		lexer.register(new WordReader());
		lexer.register(new IntReader());
		lexer.register(new WhiteSpaceReader());
		lexer.register(new EndOfLineCommentReader());
		lexer.register(new TraditionalCommentReader());
		Token[] tokens = lexer.tokenize(input);
		tokens.toString();

	}

}
