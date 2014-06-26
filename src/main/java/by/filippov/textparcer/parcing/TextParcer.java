package by.filippov.textparcer.parcing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import by.filippov.textparcer.composite.TextComposite;

public class TextParcer {
	private static final Logger LOG = Logger.getLogger(TextParcer.class);

	public static TextComposite parce(String text) {
		TextComposite result = new TextComposite();
		Pattern paragraphRegexp = Pattern
				.compile("(\\t.+?[\\t\\f\\n\\r]|//#-+?.+?//-+?#)");
		Pattern sentenceRegexp = Pattern
				.compile("([А-ЯA-Z0-9]((т.п.|т.д.|пр.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!])");
		Pattern lexemRegexp = Pattern.compile("\\D+?[(\\s-)([:punct:]+?)]");
		Matcher matcher = paragraphRegexp.matcher(text);
		while (matcher.find()) {
			String paragraph = matcher.group();
			paragraph = paragraph.trim();
			TextComposite paragraphNode = new TextComposite();
			result.add(paragraphNode);
			if (!(paragraph.startsWith("#---") && paragraph.endsWith("---#"))) {
				Matcher sentenceMatcher = sentenceRegexp.matcher(paragraph);
				while (sentenceMatcher.find()) {
					String sentence = sentenceMatcher.group();
					sentence = sentence.trim();
					Matcher lexemMatcher = lexemRegexp.matcher(sentence);
					while (lexemMatcher.find()) {
						String lexem = lexemMatcher.group();
						lexem = lexem.trim();
					}
				}
			}
			else {
				String listing = matcher.group();
				listing = listing.trim();
				result.add(new Listing(listing));
			}
		}
		return null;
	}
}
