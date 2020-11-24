public class Person {
    protected int einkommen;
    private int freibetrag;
    public static double steuersatz;
    public static boolean kriseExistiert;
    private String name;

    Person(int einkommen, int freibetrag, String name) {
        this.einkommen = einkommen;
        this.freibetrag = freibetrag;
        this.name = name;
    }

    int zuVersteuerndesEinkommen() {
        return einkommen;
    }

    double steuer() {
        return steuersatz;
    }

    int getFreiBetrag() {
        return freibetrag;
    }

    public static void setSteuersatz(double steuersatz) {
        Person.steuersatz = steuersatz;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name).append(" Bruttoeinkommen: " + einkommen);
        sb.append(" Zu versteuernde Eink.: " + zuVersteuerndesEinkommen());
        sb.append(" Zu zahlende Steuer: " + (zuVersteuerndesEinkommen() * steuersatz));
        sb.append(" Verbleibende Netto: " + (einkommen - zuVersteuerndesEinkommen() * steuersatz));
        return sb.toString();
    }

    public String getName() {
        return name;
    }
}