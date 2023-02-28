package hobbyProsjekt;

import no.hvl.dat102.mengde.adt.MengdeADT;
import hobbyProsjekt.Hobby;

public class Medlem {
		private String navn; 
		private MengdeADT<Hobby> hobbyer; 
		private int statusIndeks;
		
		public Medlem(String navn, MengdeADT<Hobby> hobbyer, int statusIndeks) {
			this.navn = navn;
			this.hobbyer = hobbyer;
			this.statusIndeks = statusIndeks;
		}
		
		private void setNavn(String navn) {
			this.navn = navn;
		}
		private String getNavn() {
			return navn;
		}
		private void setHobbyer(MengdeADT<Hobby> hobbyer) {
			this.hobbyer = hobbyer;
		}
		private MengdeADT<Hobby> getHobbyer(){
			return hobbyer;
		}
		private void setStatusIndeks(int statusIndeks) {
			this.statusIndeks = statusIndeks;
		}
		private int getStatusIndeks(){
		return statusIndeks;
		}

		public String toString() {
			String s = "";
			s = getNavn() + getHobbyer().toString() + Integer.toString(getStatusIndeks());
			return s;
		}
		
		public boolean passerTil(Medlem m1, Medlem m2) {
			if(m1.getHobbyer() == m2.getHobbyer()) {
				return true;
			}
			return false;
		}
		

}
