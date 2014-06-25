package by.filippov.textparcer.composite;

import java.util.List;

import by.filippov.textparcer.exceptions.LogicalException;

public abstract class TextLeaf implements TextComponent {

	public boolean add(TextComponent part) throws LogicalException {
		throw new LogicalException("Cant add child to leaf.");
	}

	public boolean remove(TextComponent part) throws LogicalException {
		throw new LogicalException("Can't remove child from leaf.");
	}

	public List<TextComponent> getChilds() throws LogicalException {
		throw new LogicalException("Getting childs of leaf unaviable.");
	}

	@Override
	public abstract String toString();

}
