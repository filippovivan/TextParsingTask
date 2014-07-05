package by.filippov.textparcer.composite;

public class Word implements TextComponent {

	private String lexem;

	public Word(String word) {
		super();
		this.lexem = word;
	}

	@Override
	public String toString() {
		return lexem + " ";
	}

}
