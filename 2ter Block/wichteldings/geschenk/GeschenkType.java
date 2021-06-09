package geschenk;

public enum GeschenkType {
	
	GESCHENK("Geschenk"),
	ESSBARES("Essbares"),
	SPIELZEUG("Spielzeug"),
	KLEIDUNG("Kleidung");
	
	private final String type;
	
	private GeschenkType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
