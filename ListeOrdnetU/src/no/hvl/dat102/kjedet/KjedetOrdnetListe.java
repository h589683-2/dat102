package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager ein ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom()) {throw new EmptyCollectionException("ordnet liste");}

		T resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom()) {throw new EmptyCollectionException("ordnet liste");}

		T resultat = siste.getElement();
		fjern(resultat);
		return resultat;
	}
	

	@Override
	public T foerste() {
		if (erTom()) {throw new EmptyCollectionException("ordnet liste");}

		return foerste.getElement();
	}

	@Override
	public T siste() {
		if (erTom()) {throw new EmptyCollectionException("ordnet liste");}

		return siste.getElement();
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
	public void leggTil(T element) {
		LinearNode<T> nyNode = new LinearNode<>(element);
		// sjekker om siste element er større enn andre i listen
		if (siste != null && element.compareTo(siste.getElement()) > 0) {
			siste.setNeste(nyNode);
			siste = nyNode;
			antall++;
			return;
		}
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (forrige != null && denne != null) {
			forrige.setNeste(nyNode);
			nyNode.setNeste(denne);
		} else if (forrige != null) {
			forrige.setNeste(nyNode);
			siste = nyNode;
		} else if (denne != null) {
			nyNode.setNeste(foerste);
			foerste = nyNode;
		} else { // hvis forrige e null
			foerste = nyNode;
			siste = nyNode;
		}
		antall++;
	}

	@Override
	public T fjern(T element) {
		if (erTom()) {throw new EmptyCollectionException("ordnet liste");}
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // In i lista eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikkje funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikkje funn
		return resultat;
	}

}// class