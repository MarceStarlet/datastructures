package org.marcestarlet.datastructure.array;

/**
 * DynamicArray (ArrayList)
 * A simple dynamic array definition with the three
 * basic operations: add, remove and get.
 * @author MarceStarlet
 * @param <T>
 */
public interface DynamicArray<T> {

    /**
     * Adds a value to the array list
     * @param value
     * @return true if succeed
     */
    boolean add( T value );

    /**
     * Removes the value in the position <code>index</code>
     * @param index
     * @throws IndexOutOfBoundsException whether (index < 0 or index > size())
     */
    void remove( int index ) throws IndexOutOfBoundsException;

    /**
     * Gets the value in the position <code>index</code>
     * @param index
     * @return value type T
     * @throws IndexOutOfBoundsException whether (index < 0 or index > size())
     */
    T get( int index ) throws IndexOutOfBoundsException;

    /**
     * @return the number of elements in the array list
     */
    int size();
}
