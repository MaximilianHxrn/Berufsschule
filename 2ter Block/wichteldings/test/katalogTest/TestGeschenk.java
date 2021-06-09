package katalogTest;

import geschenk.Geschenk;
import geschenk.GeschenkType;

	public class TestGeschenk extends Geschenk{
		
		private GeschenkType type;
		
		public TestGeschenk(String name, GeschenkType type) {
			this.name = name;
			this.type = type;
		}
		
		@Override
		public GeschenkType geschenkType() {
			return type;
		}

	}


