package hobbyProsjekt;

public class Datakontakt {
	
	private static Medlem [] medlemTab;
	private int antall;
	
	public Datakontakt(int lengde) {
		medlemTab = new Medlem[lengde];
		antall = 0;
	}
	
	public Medlem[] getTab() {
		return medlemTab;
	}
	
	public void utvid(){
		Medlem[] ny = new Medlem[antall*2];
		ny = medlemTab;
		medlemTab = ny;
	}
	
	public void leggTilMedlem(Medlem person){
		if(medlemTab.length > antall) {
			medlemTab[antall] = person;
			antall++;
		} else {
			utvid();
			medlemTab[antall] = person;
			antall++;
		}
		
		
	}
	
	public int finnMedlemIndeks(String navn) {
		for(int i = 0; i < medlemTab.length; i++) {
			if(navn == medlemTab[i].getNavn()) {
				return i;
			}
		}
		
		return -1;
		
		
	}
	
	public int finnPartnerFor(String navn) {
		int indeks = finnMedlemIndeks(navn);
		for(int i = 0; i < medlemTab.length; i++) {
			if((Medlem.passerTil(medlemTab[i], medlemTab[indeks])) && (medlemTab[i].getStatusIndeks() == -1) && (i != indeks)) {
				medlemTab[i].setStatusIndeks(indeks);
				System.out.print("indeks for i satt: " + indeks);
				medlemTab[indeks].setStatusIndeks(i);
				System.out.print("i for indeks satt: " + i);
				return i;
			}
		}
		return -1;
	}
	
	public void tilbakestillStatusIndeks(String navn) {
		int indeks = finnMedlemIndeks(navn);
		
		if(indeks > -1) {
			medlemTab[indeks].setStatusIndeks(-1);
		}
	
	}
	
	public void sokPartner() {
		for(int i = 0; i < medlemTab.length; i++) {
			finnPartnerFor(medlemTab[i].getNavn());
		}
	}
}
