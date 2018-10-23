package org.marcestarlet.datastructure.hash;

import static org.junit.Assert.*;
import org.junit.Test;

public class HashTableImpTest {

	@Test
	public void simpleTest() {
		// Simple test
		HashTable<String> ht = new HashTableImp<>();
		
		ht.put(1, "Marce");
		ht.put(2, "Juan");
		ht.put(3, "Ana");
	
		assertEquals("Juan", ht.get(2));
	}
	
	@Test
	public void repeatedHashCodeTest(){
		// different keys same hash code
        HashTable<String> ht = new HashTableImp<>();
		
		ht.put(1, "Marce");
		ht.put(2, "Juan");
		ht.put(3, "Ana");
		ht.put(130, "Pedro");
		
		assertEquals("Pedro", ht.get(130));
		
	}
	
	@Test
	public void differentValuesTest(){
		// same keys different values
        HashTable<Float> ht = new HashTableImp<>();
		
		ht.put(1, 0.1f);
		ht.put(2, 0.2f);
		ht.put(3, 0.3f);
		ht.put(130, 0.130f);
		ht.put(2, 0.32f);
		
		assertEquals(new Float(0.32), ht.get(2));
		
	}
	
	@Test
	public void randomHashCodeTest(){
		// TO-DO
	}
	
	@Test
	public void toStringTest(){
		
		HashTable<String> ht = new HashTableImp<>();
		
		ht.put(1, "Marce");
		ht.put(2, "Juan");
		ht.put(3, "Ana");
		ht.put(130, "Pedro");
		
		assertEquals("HashTable=[<1,Marce>,<2,Juan>,<130,Pedro>,<3,Ana>]", ht.toString());
	}

}
