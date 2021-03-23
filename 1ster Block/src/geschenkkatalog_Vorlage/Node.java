package geschenkkatalog_Vorlage;

public class Node<T> implements INode<T> {
    T element;
    Node<T> left;
    Node<T> right;

    Node(T element) {
        this.element = element;
        left = null;
        right = null;
    }

    void setRight(Node<T> right) {
        this.right = right;
    }

    void setLeft(Node<T> left) {
        this.left = left;
    }

    @Override
    public Node<T> getRightNode() {
        return right;
    }

    @Override
    public Node<T> getLeftNode() {
        return left;
    }

    @Override
    public T getElement() {
        return element;
    }

}
