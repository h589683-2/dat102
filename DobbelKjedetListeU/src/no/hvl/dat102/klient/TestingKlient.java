package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.DobbelKjedetOrdnetListe;

public class TestingKlient {
    public static void main(String[] args) {
        DobbelKjedetOrdnetListe<Integer> list = new DobbelKjedetOrdnetListe<>(69, 420);

        for (int i = 55; i < 200; i++) {
            list.leggTil(i);
        }

        
        

    }
}