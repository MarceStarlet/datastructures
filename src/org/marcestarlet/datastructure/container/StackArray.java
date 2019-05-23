package org.marcestarlet.datastructure.container;

import java.util.EmptyStackException;

public class StackArray<T> implements Stack<T>{

    private static final int INIT_SIZE = 16;
    private int last_index;
    private int current_size;
    private T[] stack;

    public StackArray() {
        stack = (T[]) new Object[INIT_SIZE];
        current_size = INIT_SIZE;
        last_index = -1;
    }

    @Override
    public boolean isEmpty(){
        return last_index > -1 ? false : true;
    }

    @Override
    public boolean push( T element ) throws NullPointerException  {
        if (element == null) {
            throw new NullPointerException();
        }

        try {
            if (isResizeNeeded()) {
                resize();
            }
            last_index++;
            stack[last_index] = element;
        }catch( ArrayIndexOutOfBoundsException ex ){
            return false;
        }

        return true;
    }

    @Override
    public T pop() throws EmptyStackException {
        if ( isEmpty() ){
            throw new EmptyStackException();
        }

        T element = stack[last_index];
        stack[last_index] = null;
        last_index--;

        return element;
    }

    @Override
    public T peek(){
        if ( isEmpty() ){
            throw new EmptyStackException();
        }

        return stack[last_index];
    }

    private boolean isResizeNeeded(){
        boolean resizeNeeded = false;
        // check if an resize is needed
        if(last_index == (current_size - 1)){
            resizeNeeded = true;
        }
        return resizeNeeded;
    }

    private void resize(){
        current_size = current_size * 2; // double the size
        T[] newArray = (T[]) new Object[current_size]; // create new array and set new size

        // copy elements from old array to new array
        for(int i = 0; i < stack.length; i++){
            newArray[i] = stack[i];
        }

        stack = newArray; // re-assign
    }

    @Override
    public String toString(){
        if (isEmpty()) {
            return "StackArray={}";
        }
        StringBuilder str = new StringBuilder("");
        str.append("StackArray={");
        for (int i = 0; i <= last_index; i++){
            str.append(stack[i]).append(",");
        }
        str.replace(str.length()-1, str.length(), "}");

        return str.toString();
    }
}
