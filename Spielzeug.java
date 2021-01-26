public class Spielzeug extends Geschenk{
	private double spannung;
	
	@SuppressWarnings("static-access")
	public Spielzeug() {
		super();
		Zufall z = new Zufall();
		name = z.spielzeug();
		schwierigkeit = z.schwierigkeit(10);
		spannung = schwierigkeit * name.length() / 10;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(spannung);
		return sb.toString();
	}
	
	
}
