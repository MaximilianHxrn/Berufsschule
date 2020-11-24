public class Banker extends Person {

    Banker(int einkommen, String name) {
        super(einkommen, kriesencheck(), name);
        this.einkommen = einkommen;
    }

    private static int kriesencheck() {
        if (kriseExistiert) {
            return 1000;
        } else {
            return 0;
        }
    }
}
