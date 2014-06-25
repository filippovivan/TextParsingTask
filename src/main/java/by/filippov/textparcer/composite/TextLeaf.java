package by.filippov.textparcer.composite;

import java.util.List;

import org.apache.log4j.Logger;

import by.filippov.textparcer.exceptions.LogicalException;

public abstract class TextLeaf implements TextComponent {

	private static final Logger LOG = Logger.getLogger(TextComponent.class);

	public boolean add(TextComponent part) throws LogicalException {
		LogicalException e = new LogicalException("Cant add child to leaf.");
		LOG.error(e);
		throw e;
	}

	public boolean remove(TextComponent part) throws LogicalException {
		LogicalException e = new LogicalException(
				"Can't remove child from leaf.");
		LOG.error(e);
		throw e;
	}

	public List<TextComponent> childIterator() throws LogicalException {
		LogicalException e = new LogicalException(
				"Getting childs of leaf unaviable.");
		LOG.error(e);
		throw e;
	}

	@Override
	public abstract String toString();

}
