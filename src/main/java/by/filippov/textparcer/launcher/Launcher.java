package by.filippov.textparcer.launcher;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.filippov.textparcer.composite.TextComposite;
import by.filippov.textparcer.exceptions.TechnicalException;
import by.filippov.textparcer.parcing.TextParcer;

public class Launcher {

	private static final Logger LOG = Logger.getLogger(Launcher.class);

	static {
		PropertyConfigurator.configure(Launcher.class
				.getResourceAsStream("/logconfig.properties"));
	}

	public static void main(String[] args) {

		StringBuilder text = new StringBuilder();
		try (Scanner scanner = new Scanner(
				Launcher.class.getResourceAsStream("/testfile.txt"));) {
			while (scanner.hasNextLine()) {
				text.append(scanner.nextLine());
				text.append("\n");
			}
		}
		TextParcer textParcer;
		try {
			textParcer = TextParcer.getInstance();
			TextComposite composite = textParcer.parce(text.toString());
			LOG.info(composite);
		} catch (TechnicalException e) {
			LOG.error(e);
		}
	}
}
