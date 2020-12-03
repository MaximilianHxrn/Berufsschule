public class MainClass {

    public static void main(String[] args) throws Exception {
        List<String> list = new List<>();
        double startTime;
        double endTime;
        int iterations = 15000000;

        list = init();

        System.out.println("List: " + list.toString() + "\n");
        list.removeDuplicates();
        System.out.println("List: " + list.toString() + "\n");
        System.exit(0);
        // ------------------------------------------------
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.push("new");
        }
        endTime = System.nanoTime();
        System.out.println("Push Time needed: " + ((endTime - startTime) / iterations) + "\n");
        // -------------------------------------------------

        // -------------------------------------------------
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.pop();
        }
        endTime = System.nanoTime();
        System.out.println("Pop Time needed: " + ((endTime - startTime) / iterations) + "\n");
        // -------------------------------------------------

        // -------------------------------------------------
        for (int i = 0; i < iterations; i++) {
            list.push("new");
        }
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.pop(0);
        }
        endTime = System.nanoTime();
        System.out.println("Pop at index 0 Time needed: " + ((endTime - startTime) / iterations) + "\n");
        // -------------------------------------------------

        // -------------------------------------------------
        list = init();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.push_front("front element");
        }
        endTime = System.nanoTime();
        System.out.println("Push before tail Time needed " + ((endTime - startTime) / iterations) + "\n");
        // -------------------------------------------------

        // -------------------------------------------------
        list = init();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list = list.reverseList();
        }
        endTime = System.nanoTime();
        System.out.println("Reversed list Time needed: " + ((endTime - startTime) / iterations) + "\n");
        // -------------------------------------------------

        // -------------------------------------------------
        list = init();
        System.out.println("Last Entry (head): " + list.last() + "\n");
        // -------------------------------------------------

        // -------------------------------------------------
        List<String> temp = new List<String>();
        temp.push("123");
        temp.push("1234");
        list = init();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.concat(temp);
        }
        endTime = System.nanoTime();
        System.out.println("Concated list Time needed " + ((endTime - startTime) / iterations) + "\n");
        // -------------------------------------------------

        // -------------------------------------------------
        list = init();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            temp = list.clone();
        }
        endTime = System.nanoTime();
        // System.out.println("Cloned list: " + temp.toString().equals(list.toString())
        // + "\n");
        System.out.println("Cloned list Time needed " + ((endTime - startTime) / iterations) + "\n");
        // -------------------------------------------------

        // -------------------------------------------------

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list = init();
            list.removeDuplicates();
        }
        endTime = System.nanoTime();
        System.out.println("Cleaned Duplicates: " + ((endTime - startTime) / iterations) + "\n");
        // -------------------------------------------------

        System.out.println("Size dyncamically equals value: " + Boolean.toString(list.length == list.sizeDyn()) + "\n");
    }

    static List<String> init() {
        List<String> list = new List<>();
        for (int i = 1; i < 5; i++) {
            list.push("Max " + i);
        }
        list.push(list.tail.getElement());
        list.push(list.tail.getElement());
        list.push("123");
        return list;
    }
}
