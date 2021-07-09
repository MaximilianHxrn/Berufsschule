public class AVLBaum<T extends Comparable<T>> {

	private AVLNode root;

	public int getHoehe(AVLNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(node.hoeheLinkerTeilbaum, node.hoeheRechterTeilbaum);
	}

	public boolean add(T toAdd) {
		if (root == null) {
			root = new AVLNode(toAdd, null);
			return true;
		}
		boolean temp = add(toAdd, root);
		berechneHoehe(root);
		if (temp && getHoehe(root) >= 3) {
			balance(root);
		}
		return temp;
	}

	private boolean add(T toAdd, AVLNode node) {
		int compare = node.element.compareTo(toAdd);
		if (compare == 0) {
			return false;
		}
		if (compare < 0) { // Rechts weiter
			if (node.rightNode == null) {
				AVLNode newNode = new AVLNode(toAdd, node);
				node.rightNode = newNode;
				return true;
			}

			boolean temp = add(toAdd, node.rightNode);
			// node.hoeheRechterTeilbaum = getHoehe(node.rightNode);
			return temp;
		}
		// Links weiter
		if (node.leftNode == null) {
			AVLNode newNode = new AVLNode(toAdd, node);
			node.leftNode = newNode;
			return true;
		}
		boolean temp = add(toAdd, node.leftNode);
		// node.hoeheLinkerTeilbaum = getHoehe(node.leftNode);
		return temp;
	}

	void balance(AVLNode node) {
		boolean wasRotated = false;
		AVLNode second = null;
		if (node == null) {
			return;
		}
		if (node.getBalanceFaktor() == 2 || node.getBalanceFaktor() == -2) {
			if (node.hoeheLinkerTeilbaum > node.hoeheRechterTeilbaum) {
				second = node.leftNode;
			} else {
				second = node.rightNode;
			}
			if (node.getBalanceFaktor() > 0) {
				if (second.getBalanceFaktor() > 0) {
					rotateLeft(node, second);
				} else {
					rotateRightLeft(node);
				}
			} else if (node.getBalanceFaktor() < 0) {
				if (second.getBalanceFaktor() < 0) {
					rotateRight(node, second);
				} else {
					rotateLeftRight(node);
				}
			}
			wasRotated = true;
			berechneHoehe(root);
		}
		if (!wasRotated) {
			if (node.leftNode != null) {
				balance(node.leftNode);
			}
			if (node.rightNode != null) {
				balance(node.rightNode);
			}
		}
	}

	private int berechneHoehe(AVLNode node) {
		if (node == null) {
			return 0;
		}
		if (node.leftNode != null) {
			node.hoeheLinkerTeilbaum = berechneHoehe(node.leftNode);
		}
		else {
			node.hoeheLinkerTeilbaum = 0;
		}
		if (node.rightNode != null) {
			node.hoeheRechterTeilbaum = berechneHoehe(node.rightNode);
		}
		else {
			node.hoeheRechterTeilbaum = 0;
		}
		return 1 + Math.max(node.hoeheLinkerTeilbaum, node.hoeheRechterTeilbaum);
	}

	private void rotateLeftRight(AVLNode first) {
		rotateLeft(first.leftNode, first.leftNode.rightNode);
		rotateRight(first, first.leftNode);
	}

	private void rotateRight(AVLNode first, AVLNode second) {
		if (first.parentNode != null) {
			if (first.parentNode.leftNode != null) {
				if (first.parentNode.leftNode.element.equals(first.element)) {
					first.parentNode.leftNode = second;
				}
			}
			if (first.parentNode.rightNode != null) {
				if (first.parentNode.rightNode.element.equals(first.element)) {
					first.parentNode.rightNode = second;
				}
			}
		}
		if (second.rightNode != null) {
			first.leftNode = second.rightNode;
		} else {
			first.leftNode = null;
		}
		second.parentNode = first.parentNode;
		second.rightNode = first;
		first.parentNode = second;
		if (first.element.equals(root.element)) {
			root = second;
		}
	}

	private void rotateRightLeft(AVLNode first) {
		rotateRight(first.rightNode, first.rightNode.leftNode);
		rotateLeft(first, first.rightNode);
	}

	private void rotateLeft(AVLNode first, AVLNode second) {
		if (first.parentNode != null) {
			if (first.parentNode.leftNode != null) {
				if (first.parentNode.leftNode.element.equals(first.element)) {
					first.parentNode.leftNode = second;
				}
			}
			if (first.parentNode.rightNode != null) {
				if (first.parentNode.rightNode.element.equals(first.element)) {
					first.parentNode.rightNode = second;
				}
			}
		}
		if (second.leftNode != null) {
			first.rightNode = second.leftNode;
		} else {
			first.rightNode = null;
		}
		second.parentNode = first.parentNode;
		second.leftNode = first;
		first.parentNode = second;
		if (first.element.equals(root.element)) {
			root = second;
		}
	}

	public void printDotFile(String string) {
		try {
			Util.printDOTFile(string, root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class AVLNode implements INode<T> {
		T element;
		AVLNode rightNode;
		AVLNode leftNode;
		AVLNode parentNode;
		int hoeheRechterTeilbaum;
		int hoeheLinkerTeilbaum;

		AVLNode(T element, AVLNode parentNode) {
			this.element = element;
			this.parentNode = parentNode;
		}

		@Override
		public INode<T> getLeftNode() {
			return leftNode;
		}

		@Override
		public INode<T> getRightNode() {
			return rightNode;
		}

		@Override
		public T getElement() {
			return element;
		}

		public int getBalanceFaktor() {
			return hoeheRechterTeilbaum - hoeheLinkerTeilbaum;
		}
	}
}