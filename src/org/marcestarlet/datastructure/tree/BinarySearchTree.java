package org.marcestarlet.datastructure.tree;

public class BinarySearchTree<T extends Comparable> {

    private Node<T> root;

    public BinarySearchTree(){}

    public void insert( T data ){
        root = insertNode( root, data );
    }

    private Node insertNode( Node<T> node, T data ){
        if ( null == node ){
            return new Node<>( data );
        }

        if ( data.compareTo(node.getData()) < 0 ){
            node.left = insertNode( node.left, data);
        } else if ( data.compareTo(node.getData()) > 0 ){
            node.right = insertNode(node.right, data);
        }

        return node;
    }

    public Node search( T data ) {
        return searchNode( root, data );
    }

    private Node searchNode( Node<T> node, T data ){
        if ( null == node || data.equals(node.getData())){
            return node;
        }

        if ( data.compareTo(node.getData()) < 0 ){
            return searchNode(node.left, data);
        }

        return searchNode(node.right, data);
    }

    public void traversal(){
        this.traversal_PRE_ORDER(root);
    }

    public void traversal( TraversalTree traversalType ){
        if (TraversalTree.IN_ORDER.equals(traversalType)){
            this.traversal_IN_ORDER( root );
        }else if (TraversalTree.PRE_ORDER.equals(traversalType)){
            this.traversal_PRE_ORDER( root );
        }else if (TraversalTree.POST_ORDER.equals(traversalType)){
            this.traversal_POST_ORDER( root );
        }
    }

    private void traversal_IN_ORDER( Node<T> node ){
        if ( null != node ){
            traversal_IN_ORDER(node.left);
            System.out.print("," + node.data);
            traversal_IN_ORDER(node.right);
        }
    }

    private void traversal_PRE_ORDER( Node<T> node ){
        if ( null != node ){
            System.out.print("," + node.data);
            traversal_PRE_ORDER(node.left);
            traversal_PRE_ORDER(node.right);
        }
    }

    private void traversal_POST_ORDER( Node<T> node ){
        if ( null != node ){
            traversal_POST_ORDER(node.left);
            traversal_POST_ORDER(node.right);
            System.out.print("," + node.data);
        }
    }

    static class Node<T>{
        private T data;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        public Node(){}

        public Node( T data ){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    enum TraversalTree{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }
}
