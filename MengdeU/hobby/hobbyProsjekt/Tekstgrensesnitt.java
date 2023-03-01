package hobbyProsjekt;

import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import hobbyProsjekt.Datakontakt;

public class Tekstgrensesnitt{
	
	
	public static Medlem lesMedlem(){
		Scanner s = new Scanner(System.in);
		System.out.println("Navn: ");
		String navn = s.nextLine();
		System.out.println("Hobbyer");
		String hobby = s.nextLine();
		Hobby h = new Hobby(hobby);
		KjedetMengde <Hobby> mh = new KjedetMengde<Hobby>();
		mh.leggTil(h);
		Medlem m = new Medlem(navn, mh);
		return m;
		
	}
	
	public static void skrivMedlemsdata(Datakontakt dk){
		Medlem[] m = dk.getTab();
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
			System.out.println("Status: " + m[i].getStatusIndeks() + "\nNavn: " + m[i].getNavn() + "\nHobbyer: " + m[i].getHobbyer()
					+ "\n--------------------------------------------");
			} else {
				break;
			}
				
		}
	}
	
	public static void skrivHobbyListe(Medlem medlem) { 
		System.out.println("Alle hobbyene "); 
		System.out.println(medlem.getHobbyer().toString()); 
	}
	
	public static void skrivParListe (Datakontakt arkiv){
	
	}
}