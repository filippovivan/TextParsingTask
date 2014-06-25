package by.filippov.textparcer.launcher;

import java.io.File;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.filippov.textparcer.parcing.TextParcer;

public class Launcher {

	private static final Logger LOG = Logger.getLogger(Launcher.class);

	static {
		PropertyConfigurator.configure(Launcher.class
				.getResourceAsStream("/logconfig.properties"));
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(
				Launcher.class.getResourceAsStream("/testfile.txt"));
		StringBuilder text = new StringBuilder();
		while (scanner.hasNextLine()) {
			text.append(scanner.nextLine());
			text.append("\n");
		}
		TextParcer.parce(text.toString());
	}
}
