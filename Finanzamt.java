import java.util.ArrayList;

public class Finanzamt {
    public static void main(String[] args) {
        Person.setSteuersatz(0.25);
        Person.kriseExistiert = true;
        ArrayList<Person> list = new ArrayList<Person>() {
            private static final long serialVersionUID = 1L;
            {
                Person joe = new Person(6400, 0, "Joe");
                add(joe);
                Person hans = new Arbeiter(36000, "Hans");
                add(hans);
                Banker fred = new Banker(4000000, "Fred");
                add(fred);
                Königin julia = new Königin(1000000, "Julia");
                add(julia);
            }
        };
        System.out.println("Jährliche Steuer beträgt: " + berechneSteuer(list));
    }

    static int berechneSteuer(ArrayList<Person> list) {
        int sum = 0;
        for (Person temp : list) {
            double temp_sum = temp.zuVersteuerndesEinkommen() - temp.getFreiBetrag();
            temp_sum = (temp_sum * temp.steuer());
            if (!(temp_sum > temp.zuVersteuerndesEinkommen() || temp_sum <= 0)) {
                sum += temp_sum;
            }
            System.out.println(temp.toString());
        }
        return sum;
    }
}
