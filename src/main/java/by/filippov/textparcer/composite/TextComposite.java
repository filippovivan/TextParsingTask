package by.filippov.textparcer.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TextComposite implements TextComponent {

	private ArrayList<TextComponent> components;

	public TextComposite() {
		components = new ArrayList<TextComponent>();
	}

	@Override
	public boolean add(TextComponent part) {
		return components.add(part);
	}

	@Override
	public boolean remove(TextComponent part) {
		return components.remove(part);
	}

	@Override
	public List<TextComponent> getChilds() {
		return Collections.unmodifiableList(components);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (TextComponent component : components) {
			builder.append(component);
		}
		return new String(builder);
	}

	@Override
	public Iterator<TextComponent> iterator() {
		return components.iterator();
	}

}
