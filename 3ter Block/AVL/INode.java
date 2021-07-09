public interface INode<T extends Comparable<T>> {
	
	INode<T> getLeftNode();
	INode<T> getRightNode();
	T getElement();

}
