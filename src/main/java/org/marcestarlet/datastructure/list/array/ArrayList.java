package org.marcestarlet.datastructure.list.array;

import org.marcestarlet.datastructure.list.List;

import java.util.Arrays;

/**
 * ArrayList implementation
 * A simple dynamic array implementation with the four
 * basic operations: add, remove, get and size.
 * This dynamic array doubles its size when needed.
 * Its initial size is 10
 * @author MarceStarlet
 * @param <T>
 */
public class ArrayList<T> implements List<T> {

    // the array initial size
    private static int INIT_SIZE = 10;
    private T[] array;
    // to handle the current size
    private int current_size;
    // to handle the current elements in the array.size()
    private int last_index = 0;

    public ArrayList(){
        // create the array with the default initial size
        array = (T[]) new Object[INIT_SIZE];
        current_size = INIT_SIZE;
    }

    @Override
    public boolean add(T value){
        try {
            // do we need to increase the size of the array?
            if (isResizeNeeded()) {
                // increment array by doubling the size
                resizeArray();
            }
            // add the value
            array[last_index] = value;
            last_index = last_index + 1;
        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public boolean remove(int index) throws IndexOutOfBoundsException {
        // index is not valid?
        if( index < 0 || index > size() ) {
            throw new IndexOutOfBoundsException();
        }

        try {
            if (index <= last_index) { // only remove if index is in range
                for (int i = index; i < last_index; i++) {
                    array[i] = array[i + 1]; // move positions
                }

                last_index = last_index - 1;
            }
        }catch(Exception e){
            return false;
        }

        return true;
    }

    @Override
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

    private boolean isResizeNeeded(){
        boolean incrementNeeded = false;
        // check if an increment is needed
        if(last_index == (current_size - 1)){
            incrementNeeded = true;
        }
        return incrementNeeded;
    }

    private void resizeArray(){
        current_size = current_size * 2; // double the size
        T[] newArray = (T[]) new Object[current_size]; // create new array and set new size

        // copy elements from old array to new array
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }

        array = newArray; // re-assign
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("");
        str.append("ArrayList={");
        for (int i = 0; i < size(); i++){
            str.append(array[i]).append(",");
        }
        str.replace(str.length()-1, str.length(), "}");

        return str.toString();
    }
}
