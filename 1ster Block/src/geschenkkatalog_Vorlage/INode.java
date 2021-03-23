package geschenkkatalog_Vorlage;

public interface INode<T> {
    public Node<T> getRightNode();
    public Node<T> getLeftNode();
    public T getElement();
}
