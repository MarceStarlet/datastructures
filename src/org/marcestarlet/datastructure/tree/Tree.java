package org.marcestarlet.datastructure.tree;

import org.marcestarlet.datastructure.container.Queue;

import java.io.Serializable;

public class Tree<T extends Serializable> {

    private Node<T> root;
    private boolean found = false;
    private Queue<Node<T>> queue = new Queue<>();

    public Tree( Node<T> root ) {
        this.root = root;
    }

    public boolean search( T data ){
        found = false;
        return this.search( this.root, data );
    }

    public boolean search( Node<T> root, T data ){
        found = false;
        return this.search_BREADTH_FIRST( root, data );
    }

    public boolean search( Node<T> root, T data, SearchTree searchType ){
        found = false;
        if (SearchTree.DEPTH__FIRST.equals(searchType)){
            return search_DEPTH_FIRST( root, data );
        }else if (SearchTree.BREADTH_FIRST.equals(searchType)){
            return search_BREADTH_FIRST( root, data );
        }
        return false;
    }

    private boolean search_DEPTH_FIRST( Node<T> root, T data ){
        if (data.equals(root.getData())){
            found = true;
        }

        root.setVisited(true);

        if( !found ) {
            for (Node<T> node : root.getChildren()) {
                if (!node.isVisited()) {
                    search_DEPTH_FIRST(node, data);
                }
            }
        }

        return found;
    }

    public boolean search_BREADTH_FIRST( Node<T> root, T data ){
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node<T> node = queue.dequeue();
            if (!node.isVisited()){
                if ( data.equals(node.getData())){
                    return true;
                } else {
                    node.setVisited(true);
                    node.getChildren().forEach(queue::enqueue);
                }
            }
        }
        return false;
    }

    public void traversal( Node<T> root ){
        this.traversal( root, " ");
    }


    private void traversal( Node<T> root, String prefix ){
        System.out.println(prefix + root.getData());
        root.getChildren().forEach(node -> traversal( node, prefix + prefix ));
    }

    public Node<T> getRoot() {
        return root;
    }

    enum SearchTree{
        DEPTH__FIRST,
        BREADTH_FIRST
    }

}
