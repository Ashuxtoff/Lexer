package token;

public class Token {
	private final Object value;
	private final String text;
	private final String type;

	public Token(String type, String text, Object value) {
		super();
		this.type = type;
		this.value = value;
		this.text = text;
	}

	public Token(String type, String text) {
		this(type, text, text);
	}

	public Object getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return type + "[" + text + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Token other = (Token) obj;
		return type.equals(other.type) && value.equals(other.value)
				&& text.equals(other.text);
	}
}