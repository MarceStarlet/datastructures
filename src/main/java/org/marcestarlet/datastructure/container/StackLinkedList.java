package org.marcestarlet.datastructure.container;

import java.util.EmptyStackException;

public class StackLinkedList<T> implements Stack<T> {

    private Node<T> top;

    public StackLinkedList(){
    }

    @Override
    public boolean isEmpty() {
        return null == top;
    }

    @Override
    public boolean push(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }

        try{
            Node<T> node = new Node<>(element);
            node.setNext(top);
            top = node;
        }catch(Exception ex){
            return false;
        }

        return true;
    }

    @Override
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T element = top.getData();
        top = top.getNext();
        return element;
    }

    @Override
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.getData();
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
