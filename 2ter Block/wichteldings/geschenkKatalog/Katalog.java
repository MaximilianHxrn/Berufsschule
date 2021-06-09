package geschenkKatalog;

import java.util.List;



import geschenk.IGeschenk;

public class Katalog implements IKatalog{
	

	@Override
	public int add(KatalogEntry entry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public KatalogEntry search(IGeschenk geschenk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public String toStringReverse() {
		// TODO Auto-generated method stub
		return null;
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
