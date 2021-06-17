package geschenkKatalog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import geschenk.IGeschenk;
import util.Util;

public class Katalog implements IKatalog {

	private KatalogNode root;

	@Override
	public int add(KatalogEntry entry) {
		if (root == null) {
			root = new KatalogNode(entry);
			return entry.getAnzahl();
		}
		return add(entry, root, null);
	}

	private int add(KatalogEntry entry, KatalogNode node, KatalogNode previous) {
		int compare = node.element.compareTo(entry);
		if (compare == 0) {
			return node.element.erhoehe(entry.getAnzahl());
		}
		if (compare < 0) { // rechts weitergehen
			if (node.right == null) {
				node.right = new KatalogNode(entry);
				node.right.parent = node;
				return node.right.element.getAnzahl();
			}
			return add(entry, node.right, node);
		}
		// links weiter
		if (node.left == null) {
			node.left = new KatalogNode(entry);
			node.left.parent = node;
			return entry.getAnzahl();
		}
		return add(entry, node.left, node);
	}

	public List<KatalogEntry> search(String name) {
		return searchHelper(name, root, new ArrayList<KatalogEntry>());
	}

	ArrayList<KatalogEntry> searchHelper(String name, KatalogNode node, ArrayList<KatalogEntry> list) {
		if (node == null) {
			return list;
		}
		int compare = node.element.getName().compareTo(name);
		if (compare == 0) {
			list.add(node.element);
		}
		list = searchHelper(name, node.left, list);
		return searchHelper(name, node.right, list);
	}

	@Override
	public KatalogEntry search(IGeschenk geschenk) {
		KatalogEntry toSearch = new KatalogEntry(geschenk);
		return search(toSearch, root);
	}

	private KatalogEntry search(KatalogEntry toSearch, KatalogNode node) {
		if (node == null) {
			return null;
		}
		int compare = node.element.compareTo(toSearch);
		if (compare == 0) {
			return node.element;
		}
		if (compare > 0) { // links weitergehen
			return search(toSearch, node.left);
		}
		return search(toSearch, node.right); // rechts weitergehen
	}

	@Override
	public String toString() {
		return printPostorder(root);
	}

	String printPostorder(KatalogNode node) {
		if (node == null)
			return "";

		return new StringBuilder().append(printPostorder(node.left)).append(node.element + "\n")
				.append(printPostorder(node.right)).toString();
	}

	@Override
	public String toStringReverse() {
		return printReverse(root);
	}

	private String printReverse(KatalogNode node) {
		if (node == null)
			return "";

		return new StringBuilder().append(printReverse(node.right)).append(node.element + "\n")
				.append(printReverse(node.left)).toString();
	}

	@Override
	public int getGeschenkanzahl() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(KatalogEntry entry) {
		removeHelper(entry, root);
		sort();
		return 0;
	}

	public void removeHelper(KatalogEntry toRemove, KatalogNode node) {
		if (node == null) {
			return;
		}
		int compare = node.element.compareTo(toRemove);
		if (compare == 0) {
			if (node.element.getAnzahl() - toRemove.getAnzahl() > 0) {
				node.element.verringern(toRemove.getAnzahl());
				return;
			} else {
				KatalogEntry temp = null;
				if (node.left != null) {
					temp = getMax(node.left);
				} else if (node.right != null) {
					temp = getMin(node.right);
				}
				node.element = temp;
				if (temp == null) {
					if (isRightLeft(node)) {
						node.parent.right = null;
					} else {
						node.parent.left = null;
					}
				}
			}
		} else {
			if (compare > 0) { // links weitergehen
				removeHelper(toRemove, node.left);
			}
			removeHelper(toRemove, node.right); // rechts weitergehen
		}
	}

	private boolean isRightLeft(KatalogNode node) {
		if (node.parent.left.equals(node)) { // left = false
			return false;
		} else { // right = true
			return true;
		}
	}

	KatalogEntry getMax(KatalogNode node) {
		if (node.right != null) {
			return getMax(node.right);
		}
		if (isRightLeft(node)) {
			node.parent.right = null;
		} else {
			node.parent.left = null;
		}
		return node.element;
	}

	KatalogEntry getMin(KatalogNode node) {
		if (node.left != null) {
			return getMax(node.left);
		}
		if (isRightLeft(node)) {
			node.parent.right = null;
		} else {
			node.parent.left = null;
		}
		return node.element;
	}

	public void sort() {
		ArrayList<KatalogEntry> list = sortHelper(root, new ArrayList<KatalogEntry>());
		Katalog temp = new Katalog();
		for (KatalogEntry e : list) {
			temp.add(e);
		}
		root = temp.root;
	}

	ArrayList<KatalogEntry> sortHelper(KatalogNode node, ArrayList<KatalogEntry> list) {
		if (node != null) {
			sortHelper(node.left, list);
			list.add(node.element);
			sortHelper(node.right, list);
		}
		return list;
	}

	public void printDotFile(String name) {
		try {
			Util.printDOTFile(name, root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class KatalogNode implements INode<KatalogEntry> {
		KatalogEntry element;
		KatalogNode parent;
		KatalogNode left;
		KatalogNode right;

		public KatalogNode(KatalogEntry element) {
			this.element = element;
		}

		@Override
		public INode<KatalogEntry> getLeftNode() {
			return left;
		}

		@Override
		public INode<KatalogEntry> getRightNode() {
			return right;
		}

		@Override
		public KatalogEntry getElement() {
			return element;
		}
	}

}
