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
			if((i != indeks) && (medlemTab[i].getStatusIndeks() == -1)) {
					medlemTab[i].setStatusIndeks(indeks);
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
		int status = -1;
		for(int i = 0; i < medlemTab.length; i++) {
			if(medlemTab[i].getStatusIndeks() == -1){
			status = finnPartnerFor(medlemTab[i].getNavn());
			medlemTab[i].setStatusIndeks(status);
			}
			
		}
	}

		
	}

