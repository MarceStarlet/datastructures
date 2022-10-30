package org.marcestarlet.datastructure.container;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void isEmpty() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void enqueue() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.enqueue("Marcela"));
        assertTrue(queue.enqueue("Juan"));
        assertTrue(queue.enqueue("Pedro"));
        assertTrue(queue.enqueue("Luis"));
    }

    @Test
    public void dequeue() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.enqueue("Marcela"));
        assertTrue(queue.enqueue("Juan"));
        assertTrue(queue.enqueue("Pedro"));
        assertTrue(queue.enqueue("Luis"));

        assertEquals("Marcela", queue.dequeue());
        assertEquals("Juan", queue.peek());

        assertTrue(queue.enqueue("Julio"));

        assertEquals("Juan", queue.dequeue());
        assertEquals("Pedro", queue.peek());
    }

    @Test
    public void peek() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.enqueue("Marcela"));
        assertTrue(queue.enqueue("Juan"));
        assertTrue(queue.enqueue("Pedro"));
        assertTrue(queue.enqueue("Luis"));

        assertEquals("Marcela", queue.peek());
        assertEquals("Marcela", queue.dequeue());
    }
}