public class Entry<T> {
    private T element;
    private Entry<T> previous;
    private Entry<T> next;

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
        if (next != null) {
            next.setPrevious(this);
        }
    }

    public String toString() {
        return element.toString();
    }

    T getElement() {
        return this.element;
    }

    void setElement(T element) {
        this.element = element;
    }

    Entry<T> getPrevious() {
        return this.previous;
    }

    void setPrevious(Entry<T> previous) {
        this.previous = previous;
    }
}
