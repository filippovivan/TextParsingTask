package by.filippov.textparcer.composite;

public class Punctuation extends TextLeaf {
	private char punctuation;

	@Override
	public String toString() {
		return punctuation + " ";
	}

}
