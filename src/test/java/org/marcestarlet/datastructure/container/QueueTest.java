package org.marcestarlet.datastructure.container;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void isEmpty_whenNewQueue_thenQueueIsEmpty() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmpty_whenAddedAnElement_thenQueueIsNotEmpty() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("Marcela");

        assertFalse(queue.isEmpty());
    }

    @Test
    public void isEmpty_whenAddedAndRemovedAllElements_thenQueueIsEmpty() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("Marcela");
        queue.dequeue();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void size() {
        Queue<String> queue = new Queue<>();

        assertEquals(queue.size(), 0);
    }

    @Test
    public void size_whenAddedSomeElements_thenQueueSizeIsGreaterThanZero() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("Marcela");

        assertTrue(queue.size() > 0);
    }

    @Test
    public void size_whenAddedAndRemovedAllElements_thenQueueSizeIsZero() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("Marcela");
        queue.dequeue();

        assertEquals(queue.size(), 0);
    }

    @Test
    public void enqueue_whenQueueIsNew_thenQueueEnqueueIsTrue() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.enqueue("Marcela"));
        assertTrue(queue.enqueue("Juan"));
        assertTrue(queue.enqueue("Pedro"));
        assertTrue(queue.enqueue("Luis"));

        assertEquals(queue.size(), 4);
        assertEquals("[Marcela, Juan, Pedro, Luis]", queue.toString());
    }

    @Test
    public void enqueue_whenEnqueuqNullElement_thenNPE() {
        Queue<String> queue = new Queue<>();

        var exception = assertThrows(NullPointerException.class, () -> queue.enqueue(null));

        assertEquals("The element to enqueue is null, this queue does not allow null values", exception.getMessage());
    }

    @Test
    public void dequeue_whenQueueHasElements_thenQueueDequeueIsOK() {
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
        
        assertEquals(queue.size(), 3);
        assertEquals("[Pedro, Luis, Julio]", queue.toString());
    }

    @Test
    public void enqueue_whenDequeueAnEmptyQueue_thenNoSuchElementException() {
        Queue<String> queue = new Queue<>();

        var exception = assertThrows(NoSuchElementException.class, () -> queue.dequeue());

        assertEquals("The queue is empty, a dequeue is not possible", exception.getMessage());
    }


    @Test
    public void peek_whenQueueHasElements_thenQueuePeekIsOK() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.enqueue("Marcela"));
        assertTrue(queue.enqueue("Juan"));
        assertTrue(queue.enqueue("Pedro"));
        assertTrue(queue.enqueue("Luis"));

        assertEquals("Marcela", queue.peek());
        assertEquals("Marcela", queue.dequeue());
        assertEquals("Juan", queue.peek());

        assertEquals(queue.size(), 3);
        assertEquals("[Juan, Pedro, Luis]", queue.toString());
    }

    @Test
    public void enqueue_whenPeekAnEmptyQueue_thenNoSuchElementException() {
        Queue<String> queue = new Queue<>();

        var exception = assertThrows(NoSuchElementException.class, () -> queue.peek());

        assertEquals("The queue is empty, a peek is not possible", exception.getMessage());
    }
}