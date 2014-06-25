package by.filippov.textparcer.composite;

public class Word extends TextLeaf {
	private String word;

	public Word(String word) {
		super();
		this.word = word;
	}

	@Override
	public String toString() {
		return word;
	}

}
