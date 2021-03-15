public class Königin extends Person {

    Königin(int einkommen, String name) {
        super(einkommen, 0, name);
        this.einkommen = einkommen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + getName());
        sb.append(" Bruttoeinkommen: " + einkommen);
        sb.append(" Zu versteuernde Eink.: " + zuVersteuerndesEinkommen());
        sb.append(" Zu zahlende Steuer: 0");
        sb.append(" Verbleibende Netto: " + zuVersteuerndesEinkommen());
        return sb.toString();
    }
}
