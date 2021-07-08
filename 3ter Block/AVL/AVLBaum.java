package avl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import geschenkkatalog.INode;

public class AVLBaum<T extends Comparable<T>> {

	private AVLNode root;

	private int getHoehe(AVLNode node) {
		if (node == null) {
			return 0;
		}
		if (node.leftNode == null && node.rightNode == null) {
			return 1;
		}
		return 1 + Math.max(getHoehe(node.left), 
							getHoehe(node.right));
	}

	public static void printDOTFile(String name, INode<?> root) throws IOException {
		File folder = new File("DotFiles");
		if (!folder.exists()) {
			folder.mkdir();
		}
		File f = new File("DotFiles" + File.separatorChar + name + ".dot");
		if (!f.exists()) {
			f.createNewFile();
		}
		FileWriter writer = new FileWriter(f);
		BufferedWriter bwriter = new BufferedWriter(writer);

		bwriter.write("digraph BST {\n");
		bwriter.write("    node [fontname=\"Arial\"];\n");

		if (root == null) {
			bwriter.write("\n");
		} else {
			nullcounter = 0;
			printTree(root, bwriter);
		}

		bwriter.write("}\n");
		bwriter.close();
	}

	public boolean add(T toAdd) {
		if (root == null) {
			root = new AVLNode(toAdd, null);
			return true;
		}
		return add(toAdd, root);
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
			return add(toAdd, node.rightNode);
		}
		// Links weiter
		if (node.leftNode == null) {
			AVLNode newNode = new AVLNode(toAdd, node);
			node.leftNode = newNode;
			return true;
		}
		return add(toAdd, node.leftNode);
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
		INode<T> getLeftNode() {
			return leftNode;
		}

		@Override
		INode<T> getRightNode() {
			return rightNode;
		}

		@Override
		T getElement() {
			return element;
		}

		int getBalanceFaktor() {
			return 0;
		}
	}

}
