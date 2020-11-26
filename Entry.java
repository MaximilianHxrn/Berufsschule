public class Entry<T> {
    T element;
    private Entry<T> next;
    int index;

    Entry(T element, Entry<T> next) {
        this.element = element;
        this.next = next;
    }

    Entry<T> getNext() {
        return next;
    }

    Entry<T> getEntry() {
        return this;
    }

    void setNext(Entry<T> next) {
        this.next = next;
    }
}
