package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			this.leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}//

	@Override
	public T fjern(T element) { //Denne skal vi se p� litt senere

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (start.getElement().equals(element)) {// Sletter foran
			resultat = start.getElement();
			start = start.getNeste();
			antall--;
		} else {// Gjennomg�r den kjedete strukturen
			forgjenger = start;
			aktuell = start.getNeste();
			for (int sok = 2; sok <= antall && !funnet; sok++) {
				if (aktuell.getElement().equals(element))
					funnet = true;
				else {
					forgjenger = aktuell;
					aktuell = aktuell.getNeste();
				}
			}
			if (funnet) {
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste()); // Slette midt inni/bak
				antall--;
			}
		}
		return resultat;

	}//

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}
	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hashcode-metoden da en del biblioteker bruker hascode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hashcode senere i faget.
	 */

	@Override
	public int hashCode() {
		return Objects.hash(antall, start);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KjedetMengde other = (KjedetMengde) obj;
		return antall == other.antall && Objects.equals(start, other.start);
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}


	@Override
	public MengdeADT<T> union (MengdeADT<T> m2) { //Fulgt go gjort likt som i løsningen til kladdoppgave3 
		KjedetMengde<T> begge = new KjedetMengde<T>();
	    LinearNode<T> aktuell = start;
	   
	    while (aktuell != null) {    
	          begge.settInn(aktuell.getElement());
	          aktuell = aktuell.getNeste();   //this-mengden
	    }//while
	   
	    Iterator<T> teller = m2.iterator();
	    while (teller.hasNext()){
	          T element = teller.next();
	         
	          if(!inneholder(element)) {
	        	  begge.settInn(element);
	          }
	     }   
	    return begge; 
	}//ff

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) { //Hva ønsker de på denne?
		// TODO
		MengdeADT<T> snittM = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		
		while(aktuell != null) {
			if(m2.inneholder(aktuell.getElement())) {
				snittM.leggTil(aktuell.getElement());
				aktuell = aktuell.getNeste();
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return snittM;

	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		// TODO
		MengdeADT<T> differensM = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		
		while(aktuell != null) {
			if(m2.inneholder(aktuell.getElement()) == false) {
				differensM.leggTil(aktuell.getElement());
				aktuell = aktuell.getNeste();
			}else {
				aktuell = aktuell.getNeste();
			}
			
			Iterator<T> it = m2.iterator();
			while(it.hasNext()) {
				T element = it.next();
				if(differensM.inneholder(element) == false) {
					differensM.leggTil(element);
				}
			}
			
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		LinearNode<T> aktuell = start;
		
		while(aktuell != null) {
			if(m2.inneholder(aktuell.getElement()) == false) {
				return false;
			} 
			aktuell = aktuell.getNeste();
			}
		
		
		return erUnderMengde;
	}

	@Override
	public Iterator<T> iterator() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) { //Hjelpemetode
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

}// class
