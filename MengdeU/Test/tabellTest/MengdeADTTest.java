package tabellTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.mengde.adt.*;

public abstract class MengdeADTTest {
	
	private MengdeADT <Integer> m1;
	private MengdeADT <Integer> m2;

	private Integer t0 = 1;
	private Integer t1 = 2;
	private Integer t2 = 3;
	private Integer t3 = 4;
	private Integer t4 = 5;
	private Integer t5 = 6;
	
	protected abstract MengdeADT<Integer> reset();
	
	/**
	 * Henter ein ny Mengde for hver test.
	 */
	@BeforeEach
	public void setup() {
		m1 = reset();
		m2 = reset();
	}
	
	@Test
	public void testUnion() {
		m1.leggTil(t3);
		m1.leggTil(t4);
		m2.leggTil(t0);
		m2.leggTil(t3);
		
		MengdeADT<Integer> uni = m2.union(m1);
		boolean test = uni.inneholder(t3) && uni.inneholder(t0) && uni.inneholder(t4);
		
		assertTrue(test);
	}
	
	@Test
	public void testSnitt() {
		m1.leggTil(t3);
		m1.leggTil(t4);
		m2.leggTil(t0);
		m2.leggTil(t3);
		
		MengdeADT<Integer> snitt = m2.snitt(m1);
		boolean test = snitt.inneholder(t3) && !snitt.inneholder(t4) && !snitt.inneholder(t0);
		
		assertTrue(test);
		
	}
	
	@Test
	public void testDifferens() {}

	@Test
	public void testUndermengde() {}
	
	
}
