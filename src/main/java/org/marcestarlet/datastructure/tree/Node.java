package org.marcestarlet.datastructure.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node<T extends Serializable> {

    private T data;
    private Node<T> parent;
    private boolean visited = false;
    private List<Node<T>> children;

    public Node( T data ){
        this.data = data;
        children = new ArrayList<>();
    }


    public Node<T> insert( Node<T> node ){
        node.setParent(this);
        this.getChildren().add(node);
        return node;
    }

    public T getData() {
        return data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited( boolean visited ) {
        this.visited = visited;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }
}
