/**
 * This class was created by Maximilian Horn and mirrors the functions of
 * {@List} from {@code java.util} and works with the sub class {@code Entry<T>}
 */

public class List<T> {

    Entry<T> head;
    Entry<T> tail;
    int length;
    String name;

    List() {
        name = null;
    }

    List(String name) {
        this.name = name;
    }

    void add(T element) {
        push(element);
    }

    void push(T element) {
        if (head == null) {
            this.head = new Entry<T>(element, null);
            this.head.setPrevious(null);
            this.tail = this.head;
        } else {
            Entry<T> new_node = new Entry<T>(element, null);
            this.head.setNext(new_node);
            this.head = new_node;
        }
        this.length++;
    }

    T pop() {
        T temp = null;
        if (head == tail) {
            temp = this.head.getElement();
            this.head = null;
            this.tail = null;
            length--;
            return temp;
        }
        Entry<T> node = this.head;
        Entry<T> previous = this.head.getPrevious();
        previous.setNext(null);
        temp = node.getElement();
        node = null;
        this.length--;
        this.head = previous;
        return temp;
    }

    Entry<T> get(int index) {
        if (index >= length) {
            System.out.println("Index > Listenlänge");
            return null;
        }
        if (index == 0) {
            return this.tail;
        }
        Entry<T> node = this.tail;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    T pop(int index) throws Exception {
        if (index >= length) {
            System.out.println("Index > Listenlänge");
            return null;
        }
        T temp;
        Entry<T> node = this.tail;
        if (index == 0) {
            temp = this.tail.getElement();
            this.tail = this.tail.getNext();
            this.length--;
            return temp;
        }
        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
        }
        Entry<T> previous = node;
        node = node.getNext();
        previous.setNext(node.getNext());
        temp = node.getElement();
        node = null;
        this.length--;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.name != null) {
            sb.append(this.name + " ");
        }
        if (this.tail == null) {
            return "";
        }
        Entry<T> currNode = this.tail;
        while (currNode != null) {
            sb.append(currNode.getElement() + " -> ");
            currNode = currNode.getNext();
        }
        if (sb.length() < 10) {
            return sb.toString();
        }
        return sb.toString().substring(0, sb.length() - 4);
    }

    void push_front(T element) {
        Entry<T> temp = new Entry<>(element, this.tail);
        this.tail = temp;
        if (this.head == null) {
            this.head = this.tail;
        }
        this.length++;
    }

    List<T> reverseList() throws Exception {
        List<T> temp = new List<>();
        for (int i = this.length - 1; i >= 0; i--) {
            temp.push(this.get(i).getElement());
        }
        return temp;
    }

    T last() {
        return this.head == null ? null : this.head.getElement();
    }

    void concat(List<T> list) {
        for (int i = 0; i < list.length; i++) {
            this.push(list.get(i).getElement());
        }
    }

    @Override
    protected List<T> clone() {
        List<T> temp = new List<>();
        for (int i = 0; i < this.length; i++) {
            temp.push(this.get(i).getElement());
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
                if (this.get(i).getElement().equals(this.get(j).getElement())) {
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

    void push(T element, int index) {
        if (index == 0) {
            push_front(element);
        }
        Entry<T> node = this.tail;
        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
        }
        Entry<T> previous = node;
        node = node.getNext();
        previous.setNext(new Entry<T>(element, node));
        this.length++;
    }

    void clear() throws Exception {
        while (this.head != null) {
            this.pop();
        }
    }

    boolean contains(T element) {
        for (int i = 0; i < this.length; i++) {
            if (this.get(i).getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    void removeIf(boolean bool) {
        if (bool) {
            this.pop();
        }
    }

    void removeIf(boolean bool, int index) throws Exception {
        if (bool) {
            this.pop(index);
        }
    }

    void pushIf(boolean bool, T element) {
        if (bool) {
            push(element);
        }
    }

    void pushFrontIf(boolean bool, T element) {
        if (bool) {
            push_front(element);
        }
    }

    void pushAtIf(boolean bool, T element, int index) {
        if (bool) {
            push(element, index);
        }
    }

    List<T> subList(int start, int end) {
        List<T> temp = new List<T>();
        for (int i = start; i < end; i++) {
            temp.push(this.get(i).getElement());
        }
        return temp;
    }

    List<T> subList(int start) {
        List<T> temp = new List<T>();
        for (int i = start; i < this.length; i++) {
            temp.push(this.get(i).getElement());
        }
        return temp;
    }

    T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            temp[i] = this.get(i).getElement();
        }
        return temp;
    }

    @SuppressWarnings("unchecked")
    void push(T... elements) {
        for (T temp : elements) {
            this.push(temp);
        }
    }
}