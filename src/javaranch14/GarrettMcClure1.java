/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class GarrettMcClure1 {

}

//===========================================================================
class ProjectDriver1 {

    public static Map<Vertex, Set<Vertex>> adjacencyMap = new TreeMap<>();
    public static int[][] edges;

    public static void main(String[] args) throws FileNotFoundException {
      
        String[] input = { 
            "0 1 0 0 1 1 0 0",
            "1 0 0 0 0 1 1 0", 
            "0 0 0 1 0 0 1 0",
            "0 0 1 0 0 0 0 1", 
            "1 0 0 0 0 1 0 0",
            "1 1 0 0 1 0 0 0",
            "0 1 1 0 0 0 0 1",
            "0 0 0 1 0 0 1 0"
        };

        String[] strArray = input;
        int dimensions = strArray.length;

        int n = dimensions;
        edges = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String[] splitted = strArray[i].split(" ");
            for (int j = 0; j < n; j++) {
                edges[i][j] = Integer.parseInt(splitted[j]);
            }
         }
        
        createAdjacencyMap();

        List<Vertex> dfsVertices, bfsVertices;
        
        System.out.println();
        System.out.println("Input graph:");
        displayGraph(edges);
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

    //=======================================================
    public static void displayGraph(int[][] graph) {
        Arrays.stream(graph).map(Arrays::toString).forEach(System.out::println);
    }
    
    //=======================================================
    public static void createAdjacencyMap() {
        for (int i = 0; i < edges.length; i++) {
            int[] row = edges[i];
            Set<Vertex> set = IntStream.range(0, row.length)
                .filter(j -> row[j] != 0)
                .mapToObj(Vertex::new)
                .collect(Collectors.toCollection(TreeSet::new))
            ;
            adjacencyMap.put(new Vertex(i), set);
        }
        displayGraph(edges);
        System.out.println(adjacencyMap);
    }
    
    //=======================================================
    static class Vertex implements Comparable<Vertex> {
        int id;
        boolean visited;
        Vertex(int id) {
            this.id = id;
            visited = false;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Vertex)) return false;
            Vertex v = (Vertex) o;
            return id == v.id;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 13 * hash + this.id;
            return hash;
        }
        
        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(id, v.id);
        }
        
        @Override
        public String toString() {
            return String.format("id: %d, visited: %b%n", id, visited);
        }
    }
    
    //=======================================================
    public static List<Vertex> fs(boolean dfs) {
        adjacencyMap.keySet().forEach(v -> v.visited = false);
        LinkedList<Vertex> queue = new LinkedList<>();
        Vertex v = adjacencyMap.keySet().iterator().next();
        queue.add(v);
        
        List<Vertex> result = new ArrayList<>();
        
        for (Vertex vertex: adjacencyMap.keySet()) {
            if (vertex.visited) continue;
            while (!queue.isEmpty()) {
                Vertex head = queue.removeFirst();
                result.add(head);
                head.visited = true;
                List<Vertex> adjacents = new ArrayList<>();
                Set<Vertex> set = adjacencyMap.get(head);
                set.stream()
                    .filter(x -> !x.visited)
                    .forEach(x -> {x.visited = true; adjacents.add(x);})
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
    
    //=======================================================
}
