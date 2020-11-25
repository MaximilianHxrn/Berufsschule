import java.security.SecureRandom;

public class MainClass {

    // private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        GenericStack<String> g = new GenericStack<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        SecureRandom r = new SecureRandom();
        for (int i = 0; i < 25; i++) {
            g.push(Character.toString(alphabet.charAt(r.nextInt(alphabet.length()))));
        }
        for (int i = 0; i < 100; i++) {
            if (r.nextBoolean()) {
                g.push(Character.toString(alphabet.charAt(r.nextInt(alphabet.length()))));
            } else {
                g.pop();
            }
            System.out.println(g.toString());
        }
    }
    /*
     * 
     * @SuppressWarnings("unused") private static void time() { long appendTimeAvg =
     * 0L; long deleteTimeAvg = 0L; long substringTimeAvg = 0L; for (int k = 0; k <
     * 1000; k++) { long startTime = System.nanoTime(); SB.append("Max");
     * appendTimeAvg = (System.nanoTime() - startTime); startTime =
     * System.nanoTime(); SB.deleteCharAt(k).toString(); deleteTimeAvg =
     * (System.nanoTime() - startTime); startTime = System.nanoTime();
     * SB.substring(0, k); substringTimeAvg = (System.nanoTime() - startTime); }
     * System.out.println( "Append: " + appendTimeAvg + "\nDelete: " + deleteTimeAvg
     * + "\nSubString: " + substringTimeAvg); }
     * 
     * @SuppressWarnings("unused") private static void Schueler() { Schueler hans =
     * new Schueler("Hans", "Im Feld 52"); hans.addKursNote("Mathe", 1);
     * hans.addKursNote("Kunst", 3); hans.addKursNote("Mathe", 2);
     * hans.druckeNoten(); System.out.println(hans.getAdresse());
     * System.out.println(hans.getName()); hans.setAdresse("Knöpflerstr. 11");
     * System.out.println(hans.getAdresse()); hans.toString();
     * System.out.println(hans); Schueler georg = new Schueler("Georg",
     * "eioghireo"); System.out.println("Anzahl: " + hans.gebAnzahl());
     * System.out.println(hans.getDurchschnitstsnote()); }
     * 
     * @SuppressWarnings("unused") private static void ArrayHelferTest() { int[]
     * array = { 1, 4, 2, 4, 40, 74, 85 }; ArrayHelfer.arrayGet(array, 3);
     * System.out.println("Max: " + ArrayHelfer.max(array));
     * System.out.println("Mean: " + ArrayHelfer.mean(array));
     * System.out.println("Median: " + ArrayHelfer.median(array));
     * System.out.println("Show: " + ArrayHelfer.show(array));
     * System.out.println("Sum: " + ArrayHelfer.sum(array));
     * System.out.println("Resize: " + ArrayHelfer.show(ArrayHelfer.resize(array,
     * 10))); ArrayHelfer.sort(array); System.out.println("Sort: " +
     * ArrayHelfer.show(array)); ArrayHelfer.square(array);
     * System.out.println("Square: " + ArrayHelfer.show(array));
     * ArrayHelfer.swap(array, 0, 1); System.out.println("Swap: " +
     * ArrayHelfer.show(array)); }
     */
}
