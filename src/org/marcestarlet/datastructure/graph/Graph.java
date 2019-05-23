package org.marcestarlet.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Graph<K,V,E extends Comparable<E>> {

    private final Graph<K,V,E> instance = new Graph<>();
    private Map<K,List<Node>> graph = new HashMap<>();

    private Graph(){}

    public Graph<K,V,E> getInstance(){
        if ( instance != null ){
            return instance;
        }

        return new Graph<K,V,E>();
    }

    public void add(K key, V vertex, E edge ){
        Node<V,E> node = null;
        List<Node> nodes = null;
        if (graph.containsKey(key)){
            nodes = graph.get(key);
            if ( null != nodes ){
                nodes.add(new Node(vertex,edge));
            }else{
                nodes = new ArrayList<>();
                nodes.add(new Node(vertex,edge));
            }
        } else {
            nodes = new ArrayList<>();
            nodes.add(new Node(vertex,edge));
            graph.put(key, nodes);
        }
    }
}
