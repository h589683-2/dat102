package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;

public abstract class KoeADTTest {
	
	// Referanse til Koe
	private KoeADT<Integer> koe;
	
	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	protected abstract KoeADT<Integer> reset();
	
	/**
	 * Henter ein ny koe for hver test.
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}
	
	
	/**
	 * test pao at ein ny koe er tom.
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}
	/**
	 * test på inn og ut
	 */
	@Test
	public void innOgUt() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}
	/**
	 * Test pao inn og ut med dublikate verdier
	 */
	@Test
	public void innOgUtMedDuplikater() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}
	
	/**
	 * Testing pao foerste
	 */
	@Test
	public void innUtInnInnUtFoerste() {
		try {
			koe.innKoe(e2);
			koe.utKoe();
			koe.innKoe(e3);
			koe.innKoe(e4);
			koe.utKoe();
			assertEquals(e4, koe.foerste());
		} catch (EmptyCollectionException e) {
			fail("ut eller inn feilet uventet " + e.getMessage());
		}
	}
	
	/**
	 * Test pao at ein koe med elementer ikke er tom
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}
	
	
	/**
	 * Tester at ein koe med null elementer er tom.
	 */
	@Test
	public void innUtErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("push eller pop feilet uventet " + e.getMessage());
		}
	}
	
	/**
	 * Forsoek ut av ein tom stabel skal gi "underflow exception"
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void utFromEmptyIsUnderFlowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { stabel.pop(); } });
		 */
		
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
	
	
	
	
 

}
