package hobbyProsjekt;

import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt{
	
	public static Medlem lesMedlem(){
		Scanner s = new Scanner(System.in);
		System.out.println("Navn: ");
		String navn = s.nextLine();
		System.out.println("Hobbyer");
		String hobby = s.nextLine();
		Hobby h = new Hobby(hobby);
		MengdeADT<Hobby> mh = new MengdeADT<Hobby>();
		mh.leggTil(h);
		Medlem m = new Medlem(navn, mh);
		return m;
		
	}
	
	public static void skrivHobbyListe(Medlem medlem) { 
		System.out.println("Alle hobbyene "); 
		System.out.println(medlem.getHobbyer().toString()); 
	}
	
	public static void skrivParListe (Datakontakt arkiv){
	
	}
}