package by.filippov.textparcer.launcher;

import java.util.Scanner;

public class TextCreator {

	public static String loadTextFromFile(String path) {
		StringBuilder builder = new StringBuilder();
		try (Scanner scanner = new Scanner(
				Launcher.class.getResourceAsStream(path));) {
			while (scanner.hasNextLine()) {
				builder.append(scanner.nextLine());
				builder.append("\n");
			}
		}
		return builder.toString();
	}
}
