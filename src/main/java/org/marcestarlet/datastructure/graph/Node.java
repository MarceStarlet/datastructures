package org.marcestarlet.datastructure.graph;

import java.util.Comparator;

public class Node<V,E extends Comparable<E>> implements Comparator<Node>{

    private V vertex; // key name
    private E edge;   // costs to this vertex

    public Node(){}

    public Node(V vertex, E edge){
        this.vertex = vertex;
        this.edge = edge;
    }

    @Override
    public int compare(Node n1, Node n2) {
        return n1.edge.compareTo(n2.vertex);
    }

    @Override
    public boolean equals(Object n) {
        Node<V,E> node = (Node)n;
        return node.edge.equals(this.edge);
    }
}
