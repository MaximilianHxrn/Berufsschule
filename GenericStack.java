public class GenericStack<T> {
    Entry<T> head;
    int length;

    void push(T element) {
        Entry<T> new_node = new Entry<T>(element, head);
        head = new_node;
        length++;
    }

    T pop() {
        if (head == null) {
            return null;
        }
        T temp = head.element;
        head = head.getNext();
        length--;
        return temp;
    }

    T pop(int index) throws Exception {
        T temp;
        if (index >= 0) {
            Entry<T> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            Entry<T> previous = node;
            node = node.getNext();
            previous.setNext(node.getNext());
            temp = node.element;
            node = null;
            length--;
        } else {
            throw new Exception("Empty Stack");
        }
        return temp;
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

    void reverseStack() throws Exception {
        for (int i = 0; i < length - 1; i++) {
            push(pop(i));
        }
    }
}