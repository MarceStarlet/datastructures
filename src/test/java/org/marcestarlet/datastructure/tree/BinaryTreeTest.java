package org.marcestarlet.datastructure.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

    @Test
    public void insert() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(8, 8, false);
        tree.insert(8,4,true);
        tree.insert(8,10,false);
        tree.insert(4,2,true);
        tree.insert(4,6,false);
        tree.insert(6,6,false);
        tree.insert(10,20,false);

        tree.traverse(3);
    }

    @Test
    public void deleteLeaf() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(8, 8, false);
        tree.insert(8,4,true);
        tree.insert(8,10,false);
        tree.insert(4,2,true);
        tree.insert(4,6,false);
        tree.insert(10,20,false);

        tree.traverse(3);
        tree.delete(2);
        tree.traverse(3);
    }

    @Test
    public void deleteNode() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(8, 8, false);
        tree.insert(8,4,true);
        tree.insert(8,10,false);
        tree.insert(4,2,true);
        tree.insert(4,6,false);
        tree.insert(10,20,false);

        tree.traverse(3);
        tree.delete(8);
        tree.traverse(3);
    }

    @Test
    public void traverse_inorder() {
    }

    @Test
    public void traverse_preorder() {
    }

    @Test
    public void traverse_postorder() {
    }

    @Test
    public void isBinarySearchTree_inorder() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(8, 8, false);
        tree.insert(8,4,true);
        tree.insert(8,10,false);
        tree.insert(4,2,true);
        tree.insert(4,6,false);
        //tree.insert(6,15,false);
        tree.insert(10,20,false);

        tree.traverse(3);
        //assertFalse( tree.isBinarySearchTree_inorder( new BinaryTree.Node<>(Integer.MIN_VALUE)) );
        assertTrue( tree.isBinarySearchTree_inorder(new BinaryTree.Node<>(Integer.MIN_VALUE)) );
    }

    @Test
    public void isBinarySearchTree_bounded() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(8, 8, false);
        tree.insert(8,4,true);
        tree.insert(8,10,false);
        tree.insert(4,2,true);
        tree.insert(4,6,false);
        tree.insert(6,15,false);
        tree.insert(10,20,false);

        tree.traverse(3);
        assertFalse( tree.isBinarySearchTree_bounded( Integer.MIN_VALUE, Integer.MAX_VALUE ) );
        //assertTrue( tree.isBinarySearchTree_bounded( Integer.MIN_VALUE, Integer.MAX_VALUE ) );
    }
}