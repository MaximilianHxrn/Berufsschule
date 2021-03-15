public class Geschenk {
	protected String name;
	protected double schwierigkeit;
	
	@SuppressWarnings("static-access")
	public Geschenk() {
		Zufall z = new Zufall();
		name=z.geschenkartikel();
		schwierigkeit = z.schwierigkeit(25);
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getSchwierigkeit() {
		return this.schwierigkeit;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(":");
		sb.append(schwierigkeit);
		return sb.toString();
	}
}
