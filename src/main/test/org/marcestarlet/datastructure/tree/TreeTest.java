package org.marcestarlet.datastructure.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void insert() {
        Node<String> dinosaur = new Node<>("Dinosaur");

        // first branch
        assertNotNull( dinosaur.insert(new Node<>("Antonio")) );
        assertNotNull( dinosaur.insert(new Node<>("Lucia") ));
    }

    @Test
    public void traversal() {
        Node<String> dinosaur = new Node<>("Dinosaur");

        // first branch
        Node<String> antonio = dinosaur.insert(new Node<>("Antonio"));
        Node<String> lucia = dinosaur.insert(new Node<>("Lucia"));

        // second branch
        Node<String> ja = lucia.insert(new Node<>("Jose Antonio"));
        Node<String> lu = lucia.insert(new Node<>("Lucy"));
        Node<String> ma = lucia.insert(new Node<>("Mario"));
        Node<String> ka = lucia.insert(new Node<>("Kary"));
        Node<String> mo = lucia.insert(new Node<>("Mony"));
        Node<String> ju = lucia.insert(new Node<>("Juan"));

        // third branch
        Node<String> lil = ja.insert(new Node<>("Liliana"));
        Node<String> mar = ja.insert(new Node<>("Marcela"));
        Node<String> ton = ja.insert(new Node<>("Tony"));

        Node<String> ale = lu.insert(new Node<>("Alex"));
        Node<String> kar = lu.insert(new Node<>("Karla"));
        Node<String> mig = lu.insert(new Node<>("Miguel"));

        Node<String> alber = ma.insert(new Node<>("Alberto"));
        Node<String> mario = ma.insert(new Node<>("Mario"));

        Node<String> jul = ka.insert(new Node<>("Julia"));
        Node<String> roc = ka.insert(new Node<>("Rocio"));
        Node<String> est = ka.insert(new Node<>("Esther"));
        Node<String> yaz = ka.insert(new Node<>("Yazmin"));
        Node<String> car = ka.insert(new Node<>("Carlos"));

        Node<String> lui = mo.insert(new Node<>("Luis"));
        Node<String> seb = mo.insert(new Node<>("Sebastian"));
        Node<String> ant = mo.insert(new Node<>("Antonio"));
        Node<String> ben = mo.insert(new Node<>("Benji"));


        Node<String> dan = ju.insert(new Node<>("Daniel"));
        Node<String> iva = ju.insert(new Node<>("Ivan"));
        Node<String> mir = ju.insert(new Node<>("Miriam"));


        // fourth branch
        Node<String> la = lil.insert(new Node<>("Luis Angel"));
        Node<String> lm = lil.insert(new Node<>("Lilian Michelle"));

        Node<String> carlo = kar.insert(new Node<>("Carlo"));
        Node<String> jaime = kar.insert(new Node<>("Jaime"));

        Node<String> dante = jul.insert(new Node<>("Dante"));

        Node<String> per = lui.insert(new Node<>("Perla"));

        Tree<String> tree = new Tree<>(dinosaur);

        tree.traversal(dinosaur);

        tree.traversal(ja);
    }

    @Test
    public void searchDFS() {
        Node<String> dinosaur = new Node<>("Dinosaur");

        // first branch
        Node<String> antonio = dinosaur.insert(new Node<>("Antonio"));
        Node<String> lucia = dinosaur.insert(new Node<>("Lucia"));

        // second branch
        Node<String> ja = lucia.insert(new Node<>("Jose Antonio"));
        Node<String> lu = lucia.insert(new Node<>("Lucy"));
        Node<String> ma = lucia.insert(new Node<>("Mario"));
        Node<String> ka = lucia.insert(new Node<>("Kary"));
        Node<String> mo = lucia.insert(new Node<>("Mony"));
        Node<String> ju = lucia.insert(new Node<>("Juan"));

        Tree<String> tree = new Tree<>(dinosaur);

        assertTrue(tree.search( dinosaur, "Kary", Tree.SearchTree.DEPTH__FIRST));
        //assertFalse(tree.search( dinosaur, "Paco", Tree.SearchTree.DEPTH__FIRST));
        //assertTrue(tree.search( dinosaur, "Juan", Tree.SearchTree.DEPTH__FIRST));

    }

    @Test
    public void searchBFS() {
        Node<String> dinosaur = new Node<>("Dinosaur");

        // first branch
        Node<String> antonio = dinosaur.insert(new Node<>("Antonio"));
        Node<String> lucia = dinosaur.insert(new Node<>("Lucia"));

        // second branch
        Node<String> ja = lucia.insert(new Node<>("Jose Antonio"));
        Node<String> lu = lucia.insert(new Node<>("Lucy"));
        Node<String> ma = lucia.insert(new Node<>("Mario"));
        Node<String> ka = lucia.insert(new Node<>("Kary"));
        Node<String> mo = lucia.insert(new Node<>("Mony"));
        Node<String> ju = lucia.insert(new Node<>("Juan"));

        Tree<String> tree = new Tree<>(dinosaur);

        //assertTrue(tree.search( dinosaur, "Kary", Tree.SearchTree.BREADTH_FIRST));
        assertFalse(tree.search( dinosaur, "Paco" ));
        //assertTrue(tree.search("Juan"));
    }
}