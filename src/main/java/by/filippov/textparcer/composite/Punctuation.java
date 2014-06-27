package by.filippov.textparcer.composite;

public class Punctuation extends TextLeaf {
	private char value;

	public Punctuation(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		switch (value) {
		case '"':
			return String.valueOf(value);
		default:
			return value + " ";
		}

	}

}
