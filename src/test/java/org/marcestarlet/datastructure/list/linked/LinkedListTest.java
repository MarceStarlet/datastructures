package org.marcestarlet.datastructure.list.linked;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void add() {
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            assertEquals( true, myLinkedList.add(i) );
        }

        assertEquals(10, myLinkedList.size());
        assertEquals(5, myLinkedList.get(5));

        System.out.println( myLinkedList.toString() );
    }

    @Test
    public void removeFirstAndLastElementByIndex() {
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            assertEquals( true, myLinkedList.add(i) );
        }

        assertEquals(true, myLinkedList.remove(0 ) );
        assertEquals(9, myLinkedList.size());

        assertEquals(1, myLinkedList.get(0));


        assertEquals(true, myLinkedList.remove( 8) );
        assertEquals(8, myLinkedList.size());

        assertEquals(8, myLinkedList.get(8));
    }

    @Test
    public void removeMiddleElementByIndex() {
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            assertEquals( true, myLinkedList.add(i) );
        }

        assertEquals(true, myLinkedList.remove(7 ) );
        assertEquals(9, myLinkedList.size());

        assertEquals(8, myLinkedList.get(7));
    }

    @Test
    public void removeWrongIndex() {
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.remove(9000000));
    }

    @Test
    public void removeFirstAndLastElementByValue() {
        LinkedList<String> myLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            assertEquals( true, myLinkedList.add("" + i) );
        }

        assertEquals(true, myLinkedList.remove( "0") );
        assertEquals(9, myLinkedList.size());

        assertEquals("1", myLinkedList.get(0));

        assertEquals(true, myLinkedList.remove( "9") );
        assertEquals(8, myLinkedList.size());

        assertEquals("8", myLinkedList.get(8));

        System.out.println( myLinkedList.toString() );
    }

    @Test
    public void removeMiddleElementByValue() {
        LinkedList<String> myLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            assertEquals( true, myLinkedList.add("" + i) );
        }

        assertEquals(true, myLinkedList.remove( "7") );
        assertEquals(9, myLinkedList.size());

        assertEquals("8", myLinkedList.get(7));
    }

    @Test
    public void getFirstMiddleAndLastElement() {
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            assertEquals( true, myLinkedList.add(i) );
        }

        assertEquals(10, myLinkedList.size());

        assertEquals(0, myLinkedList.get(0));
        assertEquals(6, myLinkedList.get(6));
        assertEquals(9, myLinkedList.get(9));
    }

    @Test
    public void getWrongIndex() {
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(9000000));
    }

    @Test
    public void addAndHugeSize() {
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            assertEquals( true, myLinkedList.add(i) );
        }

        assertEquals(10000, myLinkedList.size());
    }
}