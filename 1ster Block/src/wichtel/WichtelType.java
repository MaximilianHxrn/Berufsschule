package wichtel;

public enum WichtelType {
	
	ROTER_WICHTEL("Roter Wichtel"),
	BLAUER_WICHTEL("Blauer Wichtel"),
	GELBER_WICHTEL("Gelber Wichtel");
	
	private final String type;
	
	private WichtelType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}

}
