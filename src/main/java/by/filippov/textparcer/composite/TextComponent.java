package by.filippov.textparcer.composite;

import java.util.List;

import by.filippov.textparcer.exceptions.LogicalException;

public interface TextComponent {
	default boolean add(TextComponent part) throws LogicalException {
		throw new LogicalException(
				"Operation add is not defined for this instance of TextComponent.");
	}

	default boolean remove(TextComponent part) throws LogicalException {
		throw new LogicalException(
				"Operation remove is not defined for this instance of TextComponent.");
	}

	default List<TextComponent> getChilds() throws LogicalException {
		throw new LogicalException(
				"Operation getChilds is not defined for this instance of TextComponent.");
	}

	String toString();
}
