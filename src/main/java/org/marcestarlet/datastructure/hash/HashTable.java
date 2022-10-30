package org.marcestarlet.datastructure.hash;

/**
 * HashTable 
 * Separate chaining with linked list to prevent collisions
 * HashTable for an HashEntry<int,T>
 * @author MarceStarlet
 * Feb 29, 2016
 * @param <T>
 */
public interface HashTable<T> {

	/**
	 * get value from the key given
	 * @param key
	 * @return
	 */
	T get(int key);
	
	/**
	 * put the value for the key given
	 * @param key
	 * @param value
	 */
	void put(int key, T value);
}
