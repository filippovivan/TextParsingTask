package by.filippov.textparcer.composite;

public class Punctuation extends TextLeaf {
	private String punctuation;

	@Override
	public String toString() {
		return punctuation + " ";
	}

}
