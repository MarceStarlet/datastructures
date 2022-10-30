package org.marcestarlet.datastructure.tree;

public class BinaryTree<T extends Comparable<T>> {

    public Node<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public void insert( T node, T data, boolean left ){
        root = insertNode(root, node, data, left);
    }

    private Node<T> insertNode( Node<T> root, T node, T data, boolean left){
        if (null == root){
            return new Node(node);
        }

        if(!node.equals(data)) {
            if ( node.equals(root.data)){
                if (left){
                    root.left = new Node(data);
                } else {
                    root.right = new Node(data);
                }
            }


            insertNode(root.left, node, data, left);
            insertNode(root.right, node, data, left);
        }

        return root;
    }

    public void delete( T data ){
        root = deleteNode(root, data);
    }

    private Node<T> deleteNode( Node<T> node, T data ){
        if (null == node) return node;

        node.left = deleteNode(node.left, data);
        node.right = deleteNode(node.right, data);

        if ( data.equals(node.data)){
            if (null == node.left){
                return node.right;
            } else if (null == node.right){
                return node.left;
            } else {
                node.right.left = node.left;
                return node.right;
            }
        }
        return node;
    }

    public void traverse(int type){
        switch (type){
            case 1: traverse_inorder(root);
            case 2: traverse_preorder(root);
            case 3: traverse_postorder(root);
        }
    }

    private void traverse_inorder( Node<T> node ){
        if ( node != null ){
            traverse_inorder(node.left);
            System.out.println( node.data );
            traverse_inorder(node.right);
        }
    }

    private void traverse_preorder( Node<T> node ){
        if ( node != null ){
            System.out.println( node.data );
            traverse_preorder(node.left);
            traverse_preorder(node.right);
        }
    }

    private void traverse_postorder( Node<T> node ){
        if ( node != null ){
            traverse_postorder(node.left);
            traverse_postorder(node.right);
            System.out.println( node.data );
        }
    }

    public boolean isBinarySearchTree_inorder(Node<T> prev){

        return checkInOrderBST(root, prev);
    }

    private boolean checkInOrderBST( Node<T> node, Node<T> prev){
        if (null != node ){
            boolean left = checkInOrderBST(node.left, prev);
            if (node.data.compareTo(prev.data) <= 0){
                return false;
            }
            prev.data = node.data;

            return left && checkInOrderBST(node.right, prev);
        }

        return true;
    }

    public boolean isBinarySearchTree_bounded(T low, T high){
        return checkBoundedBST(root, low, high);
    }

    private boolean checkBoundedBST(Node<T> node, T low, T high){
        if (node == null) {
            return true;
        }

        if (node.data.compareTo(low) <= 0 || node.data.compareTo(high) >= 0){
            return false;
        }

        return checkBoundedBST(node.left, low, node.data) && checkBoundedBST(node.right, node.data, high);
    }

    static class Node<T extends Comparable<T>>{
        T data;
        Node left;
        Node right;

        Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
