package by.filippov.textparcer.launcher;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.filippov.textparcer.composite.TextComposite;
import by.filippov.textparcer.exceptions.TechnicalException;
import by.filippov.textparcer.parcing.TextParcer;

public class Launcher {

	private static final Logger LOG = Logger.getLogger(Launcher.class);
	private static final String TEST_FILE_PATH = "/text/testfile.txt";

	static {
		PropertyConfigurator.configure(Launcher.class
				.getResourceAsStream("/logconfig.properties"));
	}

	public static void main(String[] args) {
		String text = TextCreator.loadTextFromFile(TEST_FILE_PATH);
		try {
			TextParcer textParcer = TextParcer.getInstance();
			TextComposite composite = textParcer.parce(text);
			LOG.info(composite);
		} catch (TechnicalException e) {
			LOG.error(e);
		}
	}
}
