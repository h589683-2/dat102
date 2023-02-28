package hobbyProsjekt;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
		private String navn; 
		private MengdeADT<Hobby> hobbyer; 
		private int statusIndeks;
		
		public Medlem(Stirng navn, MengdeADT<Hobby> hobbyer, int statusIndeks) {
			this.navn = navn;
			this.hobbyer = hobbyer;
			this.statusIndeks = statusIndeks;
		}

//… Andre metoder
}
