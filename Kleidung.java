public class Kleidung extends Geschenk{
	private int eleganz;
	
	@SuppressWarnings("static-access")
	public Kleidung() {
		super();
		Zufall z = new Zufall();
		name=z.kleidung();
		schwierigkeit = z.schwierigkeit(5);
		eleganz = name.length();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(eleganz);
		return sb.toString();
	}
	
	
}
