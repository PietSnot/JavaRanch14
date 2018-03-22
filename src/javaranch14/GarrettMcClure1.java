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
import static java.util.stream.Collectors.toCollection;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class GarrettMcClure1 {

}

//===========================================================================
class ProjectDriver1 {

    public Map<Vertex, Set<Vertex>> adjacencyMap = new TreeMap<>();
    String[] input;
    List<Vertex> dfsVertices, bfsVertices;

    //-------------------------------------------------------
    public static void main(String[] args) {
        new ProjectDriver1().go();
    }
    
    //-------------------------------------------------------
    public void go() {
        createAdjacencyMap();
        
        System.out.println();
        System.out.println("Input graph: \n");
        System.out.println("*******************************");
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
        Vertex[] temp = IntStream.range(0, input.length).mapToObj(Vertex::new).toArray(Vertex[]::new);
        for (int i = 0; i < input.length; i++) {
            String[] row = input[i].split(" ");
            Set<Vertex> set = IntStream.range(0, row.length)
                .filter(j -> row[j] != "0")
                .mapToObj(a -> temp[a])
                .collect(toCollection(TreeSet::new))
            ;
            adjacencyMap.put(temp[i], set);
        }
        System.out.println("*************************************");
        System.out.println("input matrix:");
        System.out.println(Arrays.toString(input));
        System.out.println("*************************************");
        System.out.println("adjacencyList:");
        System.out.println(adjacencyMap);
        System.out.println("*************************************");
    }
    
    //-------------------------------------------------------
    public static List<Vertex> fs(boolean dfs) {
        adjacencyMap.keySet().forEach(v -> {v.visited = false; v.breakPoint = false;});
        LinkedList<Vertex> queue = new LinkedList<>();
        Vertex v = adjacencyMap.keySet().iterator().next();
        v.visited = true;
        queue.add(v);
        
        List<Vertex> result = new ArrayList<>();
        for (Vertex vertex: adjacencyMap.keySet()) {
            if (queue.isEmpty()) vertex.breakPoint = true;
            while (!queue.isEmpty()) {
                Vertex head = queue.removeFirst();
                result.add(head);
                List<Vertex> adjacents = new ArrayList<>();
                Set<Vertex> set = adjacencyMap.get(head);
                set.stream()
                    .filter(x -> !x.visited)
                    .forEach(x -> {x.visited = true; System.out.println(x);  adjacents.add(x);})
                ;
                if (dfs) {
                    Collections.reverse(adjacents);
                    adjacents.stream().forEach(queue::addFirst);
                }
                else queue.addAll(adjacents);
            }
        }
        return result;
    }
    
    //-------------------------------------------------------    
}  //  end of class ProjectDriver1

//============================================================================
class Vertex implements Comparable<Vertex> {
    int id;
    boolean visited;
    boolean breakPoint;

    //-------------------------------------------------------
    Vertex(int id) {
        this.id = id;
        visited = false;
        breakPoint = false;
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
        return String.format("id: %d, visited: %b, breakPoint: %b%n", id, visited, breakPoint);
    }
}  // end of class Vertex