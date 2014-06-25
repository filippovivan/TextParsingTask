package by.filippov.textparcer.composite;

import java.util.List;

import by.filippov.textparcer.exceptions.LogicalException;

public interface TextComponent {
	boolean add(TextComponent part) throws LogicalException;

	boolean remove(TextComponent part) throws LogicalException;

	List<TextComponent> getChilds() throws LogicalException;

	String toString();
}
