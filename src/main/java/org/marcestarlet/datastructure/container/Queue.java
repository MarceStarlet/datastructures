package org.marcestarlet.datastructure.container;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of a Queue by using a simple inked list of Node<E>
 * 
 * First In - First Out
 * This Queue maintains the references to the first and last elements so that way can
 * enqueue and dequeue in O(1) time.
 * 
 * This Queue does not allow null values, when a null values is attempted 
 * a NullPointerException will be thrown
 */
public class Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public Queue() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.size;
    }

    public boolean enqueue(T element) throws NullPointerException {
        Objects.requireNonNull(element, "The element to enqueue is null, this queue does not allow null values");

        try {
            var node = new Node<>(element);
            if ( this.last != null ) {
                this.last.setNext(node);
            }
            this.last = node;
            if (this.first == null) {
                this.first = this.last;
            }
        } catch (IndexOutOfBoundsException ex) { // In case we reach memory limit
            System.out.println("An error occurred while enqueueing a new element: " + ex.getMessage());
            return false;
        }

        this.size++;

        return true;
    }

    public T dequeue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The queue is empty, a dequeue is not possible");
        }

        var element = first.getData();
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }

        this.size--;

        return element;
    }

    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty, a peek is not possible");
        }

        return this.first.getData();
    }

    @Override
    public String toString() {
        return Stream.iterate(this.first, Node::getNext)
        .limit(this.size)
        .map(Node::getData)
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
    }

    private class Node<E> {

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
