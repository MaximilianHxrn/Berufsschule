public class Essbares extends Geschenk {
	private boolean gesund;

	@SuppressWarnings("static-access")
	public Essbares() {
		super();
		Zufall z = new Zufall();
		name = z.essbares();
		schwierigkeit = z.schwierigkeit(15);
		if(schwierigkeit%2==0) {
			gesund = true;
		}else {
			gesund = true;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(gesund);
		return sb.toString();
	}

}
