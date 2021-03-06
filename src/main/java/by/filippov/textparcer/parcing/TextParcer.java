package by.filippov.textparcer.parcing;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.filippov.textparcer.composite.Word;
import by.filippov.textparcer.composite.Listing;
import by.filippov.textparcer.composite.Punctuation;
import by.filippov.textparcer.composite.TextComposite;
import by.filippov.textparcer.exceptions.TechnicalException;

public final class TextParcer {
	private static final String PROPERTIES_PATH = "/regexp.properties";
	private static final String KEY_LISTING_PREFIX = "listingprefix";
	private static final String KEY_LISTING_SUFFIX = "listingsuffix";
	private static final String KEY_PARAGRAPH = "paragraph";
	private static final String KEY_SENTENCE = "sentence";
	private static final String KEY_LEXEM = "lexem";
	private static final String KEY_PUNCTUATION = "punctuation";
	private static TextParcer instance;

	private final Properties properties = new Properties();

	private String listingSuffix;
	private String listingPrefix;
	private Pattern paragraphRegexp;
	private Pattern sentenceRegexp;
	private Pattern lexemRegexp;
	private Pattern punctuationRegexp;

	private TextParcer() throws TechnicalException {
		try {
			InputStream is = TextParcer.class
					.getResourceAsStream(PROPERTIES_PATH);
			properties.load(is);
			punctuationRegexp = Pattern.compile(properties
					.getProperty(KEY_PUNCTUATION));
			lexemRegexp = Pattern.compile(properties.getProperty(KEY_LEXEM));
			sentenceRegexp = Pattern.compile(properties
					.getProperty(KEY_SENTENCE));
			paragraphRegexp = Pattern.compile(properties
					.getProperty(KEY_PARAGRAPH));
			listingSuffix = properties.getProperty(KEY_LISTING_SUFFIX);
			listingPrefix = properties.getProperty(KEY_LISTING_PREFIX);
		} catch (IOException e) {
			throw new TechnicalException("Properties file unaviable.", e);
		}
	}

	public static TextParcer getInstance() throws TechnicalException {
		if (instance != null) {
			return instance;
		} else {
			return instance = new TextParcer();
		}
	}

	public TextComposite parce(String text) {
		TextComposite result = new TextComposite();

		Matcher matcher = paragraphRegexp.matcher(text);
		while (matcher.find()) {
			String paragraph = matcher.group();
			paragraph = paragraph.trim();
			if (!(paragraph.startsWith(listingPrefix) && paragraph
					.endsWith(listingSuffix))) {
				TextComposite paragraphNode = new TextComposite();
				fillParagraphNode(paragraph, paragraphNode);
				result.add(paragraphNode);
			} else {
				addListingNode(result, paragraph);
			}
		}
		return result;
	}

	private void fillParagraphNode(String paragraph, TextComposite paragraphNode) {
		Matcher sentenceMatcher = sentenceRegexp.matcher(paragraph);
		while (sentenceMatcher.find()) {
			String sentence = sentenceMatcher.group();
			sentence = sentence.trim();
			TextComposite sentenceNode = new TextComposite();
			fillSentenceNode(sentence, sentenceNode);
			paragraphNode.add(sentenceNode);
		}
	}

	private void fillSentenceNode(String sentence, TextComposite sentenceNode) {
		Matcher lexemMatcher = lexemRegexp.matcher(sentence);
		while (lexemMatcher.find()) {
			String complexLexem = lexemMatcher.group();
			complexLexem = complexLexem.trim();
			Matcher punctuationMatcher = punctuationRegexp
					.matcher(complexLexem);
			if (!punctuationMatcher.find()) {
				Word wordNode = new Word(complexLexem);
				sentenceNode.add(wordNode);
			} else {
				Punctuation punctuationNode = new Punctuation(
						complexLexem.charAt(0));
				sentenceNode.add(punctuationNode);
			}
		}
	}

	private void addListingNode(TextComposite result, String listing) {
		result.add(new Listing(listing));
	}
}
