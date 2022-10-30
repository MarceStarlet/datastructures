package org.marcestarlet.datastructure.container;

public interface Stack<T> {

    /**
     * Returns true if the Stack contains not elements
     * @return true if the Stack contains no elements
     */
    boolean isEmpty();

    /**
     * Inserts the element specified at the top of the Stack
     * @param element
     * @return true if the element specified was inserted successfully
     * @throws NullPointerException
     */
    boolean push( T element ) throws NullPointerException;

    /**
     * Returns and removes the element at the top of the Stack
     * @return the element at the top of the Stack
     */
    T pop();

    /**
     * Returns the element at the top of the Stack
     * @return the element at the top of the Stack
     */
    T peek();
}
