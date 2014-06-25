package by.filippov.textparcer.composite;

import org.apache.log4j.Logger;

public class Punctuation extends TextLeaf {
	private static final Logger LOG = Logger.getLogger(Punctuation.class);

	private String punctuation;

	@Override
	public String toString() {
		switch (punctuation) {
		case ",":
		case ".":
		case "!":
		case "?":
			return punctuation + " ";
		case "-":
			return " " + punctuation + " ";
		default: {
			LOG.warn(punctuation + " is not punctuation simbol");
			return "";
		}
		}
	}

}
