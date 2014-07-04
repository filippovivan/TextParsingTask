package by.filippov.textparcer.composite;

public class Listing implements TextComponent {
	private String listing;

	public Listing(String listing) {
		this.listing = listing;
	}

	@Override
	public String toString() {
		return "\n\t" + listing + "\n";
	}

}
