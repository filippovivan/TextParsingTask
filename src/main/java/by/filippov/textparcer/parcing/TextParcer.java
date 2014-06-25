package by.filippov.textparcer.parcing;

import java.util.regex.Pattern;

import by.filippov.textparcer.composite.TextComposite;

public class TextParcer {
	public static TextComposite parce(String text) {
		TextComposite result = new TextComposite();
		Pattern paragraphRegexp = Pattern.compile("\\t.*?[\\t\\f]");
		//Pattern sentenceRegexp = Pattern.compile("[]");
		String[] paragraphs = paragraphRegexp.split(text);
		for (String paragraph : paragraphs) {
			
		}
		return null;
	}
}
