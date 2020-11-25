public class GenericStack<T> {
    Entry<T> head;

    void push(T element) {
        Entry<T> new_node = new Entry<T>(element, head);
        head = new_node;
    }

    void pop() {
        if (head == null) {
            return;
        }
        head = head.getNext();
    }

    @Override
    public String toString() {
        String out = "";
        Entry<T> currNode = this.head;
        System.out.print("List: ");
        while (currNode != null) {
            out += currNode.element + " -> ";
            currNode = currNode.getNext();
        }
        if (out.length() < 4) {
            return out;
        }
        return out.substring(0, out.length() - 4);
    }

    String getHead() {
        return head.element.toString();
    }
}
