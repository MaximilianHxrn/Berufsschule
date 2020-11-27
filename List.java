/**
 * This class was created by Maximilian Horn and mirrors the functions of
 * {@List} from {@code java.util} and works with the sub class {@code Entry<T>}
 */

public class List<T> {

    Entry<T> head;
    Entry<T> tail;
    int length;

    void add(T element) {
        push(element);
    }

    void push(T element) {
        if (head == null) {
            head = new Entry<T>(element, null);
            tail = head;
        } else {
            Entry<T> new_node = new Entry<T>(element, null);
            head.setNext(new_node);
            head = new_node;
        }
        length++;
    }

    T pop() {
        T temp = null;
        Entry<T> node = tail;
        for (int i = 0; i < length - 2; i++) {
            node = node.getNext();
        }
        Entry<T> previous = node;
        node = node.getNext();
        previous.setNext(null);
        temp = node.element;
        node = null;
        length--;
        head = previous;
        return temp;
    }

    Entry<T> get(int index) {
        if (index == 0) {
            return tail;
        }
        Entry<T> node = tail;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    T pop(int index) throws Exception {
        T temp;
        Entry<T> node = tail;
        if (index == 0) {
            temp = tail.element;
            tail = tail.getNext();
            return temp;
        }
        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
        }
        Entry<T> previous = node;
        node = node.getNext();
        previous.setNext(node.getNext());
        temp = node.element;
        node = null;
        length--;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry<T> currNode = this.tail;
        while (currNode != null) {
            sb.append(currNode.element + " -> ");
            currNode = currNode.getNext();
        }
        if (sb.length() < 10) {
            return sb.toString();
        }
        return sb.toString().substring(0, sb.length() - 4);
    }

    void push_front(T element) {
        Entry<T> temp = new Entry<>(element, tail);
        tail = temp;
    }

    List<T> reverseList() throws Exception {
        List<T> temp = new List<>();
        for (int i = this.length - 1; i >= 0; i--) {
            temp.push(this.get(i).element);
        }
        return temp;
    }

    T last() {
        return head.element;
    }

    void concat(List<T> list) {
        for (int i = 0; i < list.length; i++) {
            push(list.get(i).element);
        }
    }

    @Override
    protected List<T> clone() {
        List<T> temp = new List<>();
        for (int i = 0; i < this.length; i++) {
            temp.push(this.get(i).element);
        }
        return temp;
    }

    List<T> concatClone(List<T> list) {
        this.concat(list);
        return this.clone();
    }

    void removeDuplicates() throws Exception {
        for (int i = 0; i < this.length; i++) {
            for (int j = i + 1; j < this.length; j++) {
                if (this.get(i).element.equals(this.get(j).element)) {
                    this.pop(j);
                }
            }
        }
    }

    int sizeDyn() {
        int size = 0;
        if (this.head != null) {
            Entry<T> entry = this.tail;
            while (entry != null) {
                size++;
                entry = entry.getNext();
            }
        }
        return size;
    }
}