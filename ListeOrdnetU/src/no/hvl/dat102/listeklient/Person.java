package no.hvl.dat102.listeklient;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	// Konstrukt�rer

	public Person() {
		this("", "", 0);

	}

	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselsaar;

	}

	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	int getFoedselsaar() {
		return foedselsaar;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String toString() {
		return (foedselsaar + "\t" + etternavn + ", " + fornavn);
	}

	public int compareTo(Person denAndrePersonen) {
		int resultat = 0;
		// sammenligner fodselsaar
		if (foedselsaar < denAndrePersonen.getFoedselsaar()) {
			resultat = -1;
		} else if (foedselsaar == denAndrePersonen.getFoedselsaar()) {
			// hvis fodselsaar er likt saa sammenligner den etternavn
			int etellerannet = etternavn.compareTo(denAndrePersonen.getEtternavn());
			if (etellerannet == 0) {
				etellerannet = fornavn.compareTo(denAndrePersonen.getFornavn());
				resultat = etellerannet;
			} else {
				resultat = etellerannet;
			}

		} else {
			resultat = 1;
		}
		return resultat;
	}//

}// class