package org.marcestarlet.datastructure.container;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackLinkedListTest {

    @Test
    public void isEmpty() {
        Stack<String> stack = new StackLinkedList<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void push() {
        Stack<String> stack = new StackLinkedList<>();

        assertTrue(stack.push("Marcela"));
        assertTrue(stack.push("Juan"));
        assertFalse(stack.isEmpty());
    }

    @Test
    public void pop() {
        Stack<String> stack = new StackLinkedList<>();

        stack.push("Marcela");
        stack.push("Juan");

        assertEquals("Juan", stack.pop());
        assertEquals("Marcela", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void peek() {
        Stack<String> stack = new StackLinkedList<>();

        stack.push("Juan");

        assertEquals("Juan", stack.peek());
        assertFalse(stack.isEmpty());
    }
}