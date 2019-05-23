package org.marcestarlet.datastructure.list.array;

import org.junit.Test;
import org.marcestarlet.datastructure.list.List;
import static org.junit.Assert.assertEquals;

public class ArrayListTest {

    @Test
    public void addOneTest() {
        List<Integer> myArrayList = new ArrayList<>();

        myArrayList.add(8);

        assertEquals(1, myArrayList.size());
    }

    @Test
    public void addElevenTest() {
        List<Integer> myArrayList = new ArrayList<>();

        for(int i = 0; i < 11; i++){
            myArrayList.add(i);
        }

        System.out.println(myArrayList.toString());
        assertEquals(11, myArrayList.size());
    }

    @Test
    public void removeOneNumOfElementsTest() {
        List<Integer> myArrayList = new ArrayList<>();

        for(int i = 1; i <= 5; i++){
            myArrayList.add(i);
        }

        assertEquals(5, myArrayList.size());

        myArrayList.remove(2);

        assertEquals(4, myArrayList.size());
    }

    @Test
    public void removeOneElementsTest() {
        List<Integer> myArrayList = new ArrayList<>();

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
        List<Integer> myArrayList = new ArrayList<>();

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
        List<Integer> myArrayList = new ArrayList<>();

        myArrayList.remove(400000);
    }

    @Test
    public void getElevenTest() {
        List<Integer> myArrayList = new ArrayList<>();

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
        List<Integer> myArrayList = new ArrayList<>();

        myArrayList.get(400000);
    }
}