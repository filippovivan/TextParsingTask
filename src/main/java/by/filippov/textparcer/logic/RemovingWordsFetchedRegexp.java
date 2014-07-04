package by.filippov.textparcer.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.filippov.textparcer.composite.TextComponent;
import by.filippov.textparcer.composite.TextComposite;
import by.filippov.textparcer.composite.Word;

public class RemovingWordsFetchedRegexp implements TextModifier {

	private final Pattern pattern;

	public RemovingWordsFetchedRegexp(Pattern pattern) {
		this.pattern = pattern;
	}

	@Override
	public final void modify(TextComposite text) {
		for (TextComponent textPart : text.getChilds()) {
			if (textPart instanceof TextComposite) {
				TextComposite paragraph = (TextComposite) textPart;
				for (TextComponent paragrphPart : (paragraph.getChilds())) {
					modifyConcreteSentence(paragrphPart);
				}
			}
		}
	}

	private void modifyConcreteSentence(TextComponent paragrphPart) {
		TextComposite sentence = (TextComposite) paragrphPart;
		for (TextComponent lexem : sentence.getChilds()) {
			if (lexem instanceof Word) {
				Matcher matcher = pattern.matcher(lexem.toString().trim());
				if (matcher.find()) {
					sentence.remove(lexem);
				}
			}
		}
	}

	public Pattern getPattern() {
		return pattern;
	}

}
