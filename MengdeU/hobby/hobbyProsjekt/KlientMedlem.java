package hobbyProsjekt;

import hobbyProsjekt.Tekstgrensesnitt;
import hobbyProsjekt.Datakontakt;

public class KlientMedlem {

	public static void main(String [] args) {
		Datakontakt dk = new Datakontakt(3);
		int i = 0;
		while(i < 3) {
		dk.leggTilMedlem(Tekstgrensesnitt.lesMedlem());
		i++;
		}
		dk.sokPartner();
		
		Tekstgrensesnitt.skrivMedlemsdata(dk);
		
		
		
	}

	
}
