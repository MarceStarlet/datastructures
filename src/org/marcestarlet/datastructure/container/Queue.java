package org.marcestarlet.datastructure.container;

import java.util.Hashtable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;

public class Queue<T> {

    Map<String,String> a = new Hashtable<>();


    private Node<T> first;
    private Node<T> last;

    public Queue(){
    }

    public boolean isEmpty(){
        return first == null;
    }

    public boolean enqueue( T element ) throws NullPointerException{
        if (element == null) {
            throw new NullPointerException();
        }

        try{
            Node<T> node = new Node<>(element);
            if ( last != null ) {
                last.setNext(node);
            }
            last = node;
            if (first == null){
                first = last;
            }
        }catch (IndexOutOfBoundsException ex ){
            return false;
        }

        return true;
    }

    public T dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        T element = first.getData();
        first = first.next;
        if (first == null) {
            last = null;
        }

        return element;
    }

    public T peek(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return first.getData();
    }

    class Node<E>{

        private E data;
        private Node<E> next;

        public Node( E data ) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
