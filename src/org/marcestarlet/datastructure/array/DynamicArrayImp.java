package org.marcestarlet.datastructure.array;

/**
 * DynamicArray (ArrayList) Implementation
 * A simple dynamic array implementation with the three
 * basic operations: add, remove and get.
 * This dynamic array doubles is size when needed.
 * Its initial size is 10
 * @author MarceStarlet
 * @param <T>
 */
public class DynamicArrayImp<T> implements DynamicArray<T>{

    // the array initial size
    private static int INIT_SIZE = 10;
    private T[] array;
    // to handle the current size
    private int current_size;
    // to handle the current elements in the array.size()
    private int last_index = 0;

    public DynamicArrayImp(){
        // create the array with the default initial size
        array = (T[]) new Object[INIT_SIZE];
        current_size = INIT_SIZE;
    }

    public boolean add(T value){
        try {
            // do we need to increase the size of the array?
            if (isIncrementNeeded()) {
                // increment array by doubling the size
                increaseArray();
            }
            // add the value
            array[last_index] = value;
            last_index = last_index + 1;
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        // index is not valid?
        if( index < 0 || index > size() ) {
            throw new IndexOutOfBoundsException();
        }

        if( index <= last_index ) { // only remove if index is in range
            for (int i = index; i < last_index; i++) {
                array[i] = array[i + 1]; // move positions
            }

            last_index = last_index - 1;
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        // index is not valid?
        if( index < 0 || index > size() ) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    public int size() {
        return last_index;
    }

    private boolean isIncrementNeeded(){
        boolean incrementNeeded = false;
        // check if an increment is needed
        if(last_index == (current_size - 1)){
            incrementNeeded = true;
        }
        return incrementNeeded;
    }

    private void increaseArray(){
        current_size = current_size * 2; // double the size
        T[] newArray = (T[]) new Object[current_size]; // create new array and set new size

        // copy elements from old array to new array
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }

        array = newArray; // re-assign
    }
}
