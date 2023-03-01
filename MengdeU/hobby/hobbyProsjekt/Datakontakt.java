package hobbyProsjekt;

public class Datakontakt {
	
	private Medlem [] medlemTab;
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
		
		medlemTab[antall] = person;
		antall++;
		System.out.println(antall);
	}
	
	public int finnMedlemIndeks(String navn) {
		
		return antall;
		
	}
	
	public void finnPartnerFor(String navn) {
		
	}
	
	public void tilbakestillStatusIndeks() {
		
	}
	
}
