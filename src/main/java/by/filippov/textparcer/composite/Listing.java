package by.filippov.textparcer.composite;

public class Listing extends TextLeaf {
	private String listing;

	public Listing(String listing) {
		this.listing = listing;
	}

	@Override
	public String toString() {
		return "\n" + listing + "\n";
	}

}
