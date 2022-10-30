package org.marcestarlet.datastructure.container;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StackArrayTest {

    @Test
    public void isEmpty() {
        Stack<String> stack = new StackArray<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void push() {
        Stack<String> stack = new StackArray<>();

        assertTrue(stack.push("Marcela"));
        assertTrue(stack.push("Juan"));
        assertFalse(stack.isEmpty());
    }

    @Test
    public void pop() {
        Stack<String> stack = new StackArray<>();

        stack.push("Marcela");
        stack.push("Juan");

        System.out.println(stack.toString());

        assertEquals("Juan", stack.pop());
        assertEquals("Marcela", stack.pop());
        assertTrue(stack.isEmpty());

        System.out.println(stack.toString());
    }

    @Test
    public void peek() {
        Stack<String> stack = new StackArray<>();

        stack.push("Juan");

        assertEquals("Juan", stack.peek());
        assertFalse(stack.isEmpty());

        System.out.println(stack.toString());
    }
}