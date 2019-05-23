package org.marcestarlet.datastructure.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree<>();

        tree.insert( 10);
        tree.insert( 5);
        tree.insert( 15);
        tree.insert( 4);
        tree.insert( 11);
        tree.insert( 7);
        tree.insert( 20);
    }

    @Test
    public void traversal() {
       tree.traversal();
    }

    @Test
    public void traversal_IN_ORDER() {
        tree.traversal( BinarySearchTree.TraversalTree.IN_ORDER);
    }

    @Test
    public void traversal_PRE_ORDER() {
        tree.traversal( BinarySearchTree.TraversalTree.PRE_ORDER);
    }

    @Test
    public void traversal_POST_ORDER() {
        tree.traversal( BinarySearchTree.TraversalTree.POST_ORDER);
    }

    @Test
    public void search() {
        assertNotNull(tree.search(11));
        assertNull(tree.search( 30));
    }

    @Test
    public void treeString() {

        BinarySearchTree<String> tree = new BinarySearchTree<>();

        tree.insert( "e");
        tree.insert( "c");
        tree.insert( "k");
        tree.insert( "a");
        tree.insert( "h");
        tree.insert( "d");
        tree.insert( "m");

        tree.traversal();

        assertNotNull(tree.search("h"));
        assertNull(tree.search( "o"));
    }
}