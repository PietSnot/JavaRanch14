/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */

public class GarrettMcClure1 {

    public Map<Vertex, Set<Vertex>> adjacencyMap = new TreeMap<>();
    String[] input;
    List<Vertex> vertices, dfsVertices, bfsVertices;

    //-------------------------------------------------------
    public static void main(String[] args) {
        new GarrettMcClure1().go();
    }
    
    //-------------------------------------------------------
    public void go() {
        createAdjacencyMap();
        
        System.out.println();
        System.out.println("Input graph: \n");
        System.out.println(Arrays.toString(input));
        System.out.println("*******************************");
        System.out.println("adjacencymap:");
        System.out.println(adjacencyMap);
        System.out.println("*******************************");
        
        dfsVertices = fs(true);
        bfsVertices = fs(false);
        
        System.out.println("dfs sequence: \n" + dfsVertices);
        System.out.println("*******************************");
        System.out.println("bfs sequence: \n" + bfsVertices);
        
        System.out.println();
        System.out.println();
    }

    //-------------------------------------------------------
    public void createAdjacencyMap() {
        input = new String[] { 
            "0 1 0 0 1 1 0 0",
            "1 0 0 0 0 1 1 0", 
            "0 0 0 1 0 0 1 0",
            "0 0 1 0 0 0 0 1", 
            "1 0 0 0 0 1 0 0",
            "1 1 0 0 1 0 0 0",
            "0 1 1 0 0 0 0 1",
            "0 0 0 1 0 0 1 0"
        };
        
        vertices = IntStream.rangeClosed(1, input.length).mapToObj(Vertex::new).collect(toList());
        
        for (int i = 0; i < input.length; i++) {
            String[] row = input[i].split(" ");
            Set<Vertex> set = IntStream.range(0, row.length)
                .filter(j -> row[j].equals("1"))
                .mapToObj(vertices::get)
                .collect(toCollection(TreeSet::new))
            ;
            adjacencyMap.put(vertices.get(i), set);
        }
    }
    
    //-------------------------------------------------------
    public List<Vertex> fs(boolean dfs) {
        
        resetVertices();
        
        int component = 1;
        LinkedList<Vertex> queue = new LinkedList<>();
        List<Vertex> result = new ArrayList<>();
        
        for (Vertex v: adjacencyMap.keySet()) {
            if (v.visited) continue;
            
            v.visited = true;
            v.component = component;
            queue.add(v);
            
            while (!queue.isEmpty()) {
                Vertex head = queue.removeFirst();
                head.component = component;
                result.add(head);
                List<Vertex> adjacents = getAdjacents(head);
                if (dfs) {
                    Collections.reverse(adjacents);
                    adjacents.stream().forEach(queue::addFirst);
                }
                else queue.addAll(adjacents);
                System.out.println(queue);
                if (queue.isEmpty()) component++;
            }
        }
        return result;
    }
    
    //-------------------------------------------------------
    private void resetVertices() {
        adjacencyMap.keySet().forEach(Vertex::reset);
    }  
    
    //-------------------------------------------------------
    private List<Vertex> getAdjacents(Vertex v) {
        List<Vertex> list = new ArrayList<>();
        adjacencyMap.get(v).stream()
           .filter(x -> !x.visited)
           .forEach(x -> {x.visited = true; list.add(x);})
        ;
        return list;
    }
}  //  end of class ProjectDriver1

//============================================================================
class Vertex implements Comparable<Vertex> {
    
    int id;
    boolean visited;
    int component;

    //-------------------------------------------------------
    Vertex(int id) {
        this.id = id;
        visited = false;
        component = 0;
    }

    //-------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Vertex)) return false;
        Vertex v = (Vertex) o;
        return id == v.id;
    }

    //-------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        return hash;
    }

    //-------------------------------------------------------
    @Override
    public int compareTo(Vertex v) {
        return Integer.compare(id, v.id);
    }

    //-------------------------------------------------------
    @Override
    public String toString() {
        return String.format("id: %d, visited: %b, component: %d%n", id, visited, component);
    }
    
    //-------------------------------------------------------
    public void reset() {
        visited = false;
        component = 0;
    }
}  // end of class Vertex