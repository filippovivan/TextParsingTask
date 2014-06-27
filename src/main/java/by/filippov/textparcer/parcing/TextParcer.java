package by.filippov.textparcer.parcing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import by.filippov.textparcer.composite.Listing;
import by.filippov.textparcer.composite.TextComposite;

public final class TextParcer {
	private static final Logger LOG = Logger.getLogger(TextParcer.class);

	public static TextComposite parce(String text) {
		TextComposite result = new TextComposite();
		Pattern paragraphRegexp = Pattern
				.compile("(\\t.+?[\\t\\f\\n\\r]|((?m)#---[.\\.\\n]+---#))");
		Pattern sentenceRegexp = Pattern
				.compile("([А-ЯA-Z0-9]((т.п.|т.д.|пр.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!])");
		Pattern lexemRegexp = Pattern.compile("\\D+?[(\\s-)([:punct:]+?)]");
		Matcher matcher = paragraphRegexp.matcher(text);
		while (matcher.find()) {
			String paragraph = matcher.group();
			paragraph = paragraph.trim();
			if (!(paragraph.startsWith("#---") && paragraph.endsWith("---#"))) {
				TextComposite paragraphNode = new TextComposite();
				Matcher sentenceMatcher = sentenceRegexp.matcher(paragraph);
				while (sentenceMatcher.find()) {
					String sentence = sentenceMatcher.group();
					sentence = sentence.trim();
					TextComposite sentenceNode = new TextComposite();
					Matcher lexemMatcher = lexemRegexp.matcher(sentence);
					while (lexemMatcher.find()) {
						String complexLexem = lexemMatcher.group();
						complexLexem = complexLexem.trim();
					}
					paragraphNode.add(sentenceNode);
				}
				result.add(paragraphNode);
			}
			else {
				addListingNode(result, paragraph);
			}
		}
		return null;
	}

	private static void addListingNode(TextComposite result, String paragraph) {
		paragraph = paragraph.trim();
		result.add(new Listing(paragraph));
	}
}
