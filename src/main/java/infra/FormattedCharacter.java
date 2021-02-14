package infra;

public class FormattedCharacter {
	char character;
	boolean bold;
	boolean italic;
	boolean underline;
	
	FormattedCharacter(char character, boolean bold, boolean italic, boolean underline) {
		this.character = character;
		this.bold = bold;
		this.italic = italic;
		this.underline = underline;
	}
	
	FormattedCharacter(char character) {
		this(character, false, false, false);
	}

	public char getCharacter() {
		return character;
	}

	public boolean isBold() {
		return bold;
	}

	public boolean isItalic() {
		return italic;
	}

	public boolean isUnderline() {
		return underline;
	}
}