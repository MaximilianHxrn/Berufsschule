public class MainClass {

    public static void main(String[] args) throws Exception {
        List<String> list = new List<>();

        for (int i = 1; i < 5; i++) {
            list.push("Max " + i);
        }

        System.out.println("List: " + list.toString() + "\n");

        list.push("new");
        System.out.println("Push: " + list.toString() + "\n");

        list.pop();
        System.out.println("Pop: " + list.toString() + "\n");

        list.pop(0);
        System.out.println("Pop at index 0: " + list.toString() + "\n");

        list.push_front("front element");
        System.out.println("Push before tail: " + list.toString() + "\n");

        list = list.reverseList();
        System.out.println("Reversed list: " + list.toString() + "\n");

        System.out.println("Last Entry (head): " + list.last() + "\n");

        List<String> temp = new List<String>();
        temp.push("123");
        temp.push("1234");
        list.concat(temp);
        System.out.println("Concated list: " + list.toString() + "\n");

        temp = list.clone();
        System.out.println("Cloned list: " + temp.toString().equals(list.toString()) + "\n");

        list.push(list.last());
        System.out.println("Added Duplicate last: " + list.toString() + "\n");
        list.removeDuplicates();
        System.out.println("Cleaned Duplicates: " + list.toString() + "\n");

        System.out.println("Size dyncamically equals value: " + Boolean.toString(list.length == list.sizeDyn()) + "\n");
    }
}
