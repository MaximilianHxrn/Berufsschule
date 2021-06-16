package geschenkKatalog;

import java.io.IOException;
import java.util.List;



import geschenk.IGeschenk;
import util.Util;

public class Katalog implements IKatalog{
	
	private KatalogNode root;
	

	@Override
	public int add(KatalogEntry entry) {
		if(root == null) {
			root = new KatalogNode(entry);
			return entry.getAnzahl();
		}
		return add(entry, root);
	}

	private int add(KatalogEntry entry, KatalogNode node) {
		int compare = node.element.compareTo(entry);
		if(compare == 0) {
			return node.element.erhoehe(entry.getAnzahl());
		}
		if(compare < 0) { //rechts weitergehen
			if(node.right == null) {
				node.right = new KatalogNode(entry);
				return node.right.element.getAnzahl();
			}
			return add(entry, node.right);
		}
		// links weiter
		if(node.left == null) {
			node.left = new KatalogNode(entry);
			return entry.getAnzahl();
		}
		return add(entry, node.left);
	}

	@Override
	public KatalogEntry search(IGeschenk geschenk) {
		KatalogEntry toSearch = new KatalogEntry(geschenk);
		return search(toSearch, root);
	}

	private KatalogEntry search(KatalogEntry toSearch, KatalogNode node) {
		if(node == null) {
			return null;
		}
		int compare = node.element.compareTo(toSearch);
		if(compare == 0) {
			return node.element;
		}
		if(compare > 0) { //links weitergehen
			return search(toSearch, node.left);
		}
		return search(toSearch, node.right); //rechts weitergehen
	}

	@Override
	public String toString() {
		return printPostorder(root);
	}

	String printPostorder(KatalogNode node)
    {
        if (node == null)
            return "";
			
        return new StringBuilder()
		           .append(printPostorder(node.left))
		           .append(node.element + "\n")
				   .append(printPostorder(node.right))
				   .toString();
    }
 
	@Override
	public String toStringReverse() {
		return printReverse(root);
	}
	
	private String printReverse(KatalogNode node) {
		if (node == null)
            return "";
			
        return new StringBuilder()
		           .append(printReverse(node.right))
		           .append(node.element + "\n")
				   .append(printReverse(node.left))
				   .toString();
	}

	@Override
	public int getGeschenkanzahl() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<KatalogEntry> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int remove(KatalogEntry entry) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public void printDotFile(String name) {
		try {
			Util.printDOTFile(name, root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class KatalogNode implements INode<KatalogEntry>{
		KatalogEntry element;
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
