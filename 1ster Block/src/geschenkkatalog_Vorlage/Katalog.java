package geschenkkatalog_Vorlage;

import java.util.List;

import geschenk.IGeschenk;

public class Katalog implements IKatalog{

	@Override
	public int add(KatalogEntry entry) {
		
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

}
