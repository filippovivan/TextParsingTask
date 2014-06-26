package by.filippov.textparcer.composite;

public class Lexem extends TextLeaf {
	private String lexem;

	public Lexem(String word) {
		super();
		this.lexem = word;
	}

	@Override
	public String toString() {
		return lexem;
	}

}
