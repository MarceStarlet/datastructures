package org.marcestarlet.datastructure.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DynamicArrayImpTest {

    @Test
    public void addOneTest() {
        DynamicArray<Integer> myArrayList = new DynamicArrayImp<>();

        myArrayList.add(8);

        assertEquals(1, myArrayList.size());
    }

    @Test
    public void addElevenTest() {
        DynamicArray<Integer> myArrayList = new DynamicArrayImp<>();

        for(int i = 0; i < 11; i++){
            myArrayList.add(i);
        }

        assertEquals(11, myArrayList.size());
    }

    @Test
    public void removeOneNumOfElementsTest() {
        DynamicArray<Integer> myArrayList = new DynamicArrayImp<>();

        for(int i = 1; i <= 5; i++){
            myArrayList.add(i);
        }

        assertEquals(5, myArrayList.size());

        myArrayList.remove(2);

        assertEquals(4, myArrayList.size());
    }

    @Test
    public void removeOneElementsTest() {
        DynamicArray<Integer> myArrayList = new DynamicArrayImp<>();

        for(int i = 1; i <= 5; i++){
            myArrayList.add(i);
        }

        myArrayList.remove(2);

        assertEquals(1, myArrayList.get(0));
        assertEquals(2, myArrayList.get(1));
        assertEquals(4, myArrayList.get(2));
        assertEquals(5, myArrayList.get(3));
        assertEquals(null, myArrayList.get(4));
    }

    @Test
    public void removeLastElementTest() {
        DynamicArray<Integer> myArrayList = new DynamicArrayImp<>();

        for(int i = 1; i <= 5; i++){
            myArrayList.add(i);
        }

        myArrayList.remove(4);

        assertEquals(1, myArrayList.get(0));
        assertEquals(2, myArrayList.get(1));
        assertEquals(3, myArrayList.get(2));
        assertEquals(4, myArrayList.get(3));
        assertEquals(null, myArrayList.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWrongIndexTest(){
        DynamicArray<Integer> myArrayList = new DynamicArrayImp<>();

        myArrayList.remove(400000);
    }

    @Test
    public void getElevenTest() {
        DynamicArray<Integer> myArrayList = new DynamicArrayImp<>();

        for(int i = 0; i < 11; i++){
            myArrayList.add(i);
        }

        for(int i = 0; i < 11; i++){
            assertEquals(i,myArrayList.get(i));
        }

        assertEquals(11, myArrayList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getWrongIndexTest(){
        DynamicArray<Integer> myArrayList = new DynamicArrayImp<>();

        myArrayList.get(400000);
    }
}