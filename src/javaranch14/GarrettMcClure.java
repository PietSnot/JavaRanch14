/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class GarrettMcClure {

}

class ProjectDriver {

    public static int count;
    public static int deadCount;
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
        int dfsComponents = 0;
        int bfsComponents = 0;
        Queue<Integer> queue = new LinkedList<>();

        String[] strArray = input;
        int dimensions = strArray.length;

        int n = dimensions;
        edges = new int[n][n];
        boolean[] visited = new boolean[n];
        count = 0;
        deadCount = 0;

        for (int i = 0; i <= n - 1; i++) {
            String[] splitted = strArray[i].split(" ");
            for (int j = 0; j <= n - 1; j++) {
                edges[i][j] = Integer.parseInt(splitted[j]);
            }
         }

        int[] dfsVertices = new int[edges.length];
        int[] bfsVertices = new int[edges.length];
        int[] dfsDeadEnd = new int[edges.length];

        for (int i = 0; i < n - 1; i++) {
            visited[i] = false;
        }

        int[][] BFStreeEdgeGraph = new int[n][n];
        int[][] DFStreeEdgeGraph = new int[n][n];
        int ind = 0;

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                DFStreeEdgeGraph[i][j] = 0;
                BFStreeEdgeGraph[i][j] = 0;
            }
        }

        for (int i = 0; i <= n - 1; i++) {
            if (visited[i] == false) {
                dfs(edges, i, visited, dfsVertices, dfsDeadEnd, DFStreeEdgeGraph);

                dfsDeadEnd[i] = deadCount;
                //               dfsDeadEnd.add(i);
                dfsComponents++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            visited[i] = false;
        }

        count = 0;

        for (int i = 0; i <= n - 1; i++) {
            if (visited[i] == false) {
                bfs(edges, i, visited, bfsVertices, BFStreeEdgeGraph, queue);
                bfsComponents++;
            }
        }
        System.out.println();
        System.out.println("Input graph:");
        displayGraph(edges, n);
        System.out.println();
        System.out.println();

        System.out.println("DFS: Number of Connected Components: " + dfsComponents);
        System.out.print("DFS: Order of First Encountered: ");
        for (int i : dfsVertices) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        System.out.print("DFS: Order of First Dead-Ends: ");
        for (int i : dfsDeadEnd) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Tree edges:");
        displayGraph(DFStreeEdgeGraph, n);

        System.out.println();
        System.out.println();
        System.out.println("BFS: Number of Connected Components: " + bfsComponents);
        System.out.print("BFS: Order of First encountered: ");
        for (int i : bfsVertices) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        System.out.println();

    }

    public static void dfs(int[][] edges, int vertex, boolean[] visited, int[] dfsVertices, int[] dfsDeadEnd, int[][] DFStreeEdgeGraph) {

        dfsVertices[vertex] = count;
        count = count + 1;
        visited[vertex] = true;

        for (int w = 0; w <= edges.length - 1; w++) {
            if (edges[vertex][w] == 1 && !visited[w]) {
                DFStreeEdgeGraph[vertex][w] = 1;
                dfs(edges, w, visited, dfsVertices, dfsDeadEnd, DFStreeEdgeGraph);
                deadCount++;
                dfsDeadEnd[vertex] = deadCount;
                //               dfsDeadEnd.add(w);
            }
        }
    }

    public static void bfs(int[][] edges, int vertex, boolean[] visited, int[] bfsVertices, int[][] BFStreeEdgeGraph, Queue<Integer> queue) {

        bfsVertices[vertex] = count;
        count = count + 1;
        while (!queue.isEmpty()) {
            for (int w = 0; w < edges.length; w++) {
                if (edges[vertex][w] != 0 && !visited[w]) {
                    visited[vertex] = true;
                    bfsVertices[vertex] = count;
                    count = count + 1;
                    queue.add(w);
                }
            }
            queue.remove();
        }
    }

    public static void displayGraph(int[][] graph, int n) {

        for (int i = 0; i <= n - 1; ++i) {
            System.out.print("    ");
            for (int j = 0; j <= n - 1; ++j) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void createAdjacencyMap() {
        for (int i = 0; i < edges.length; i++) {
            int[] row = edges[i];
            Set<Vertex> set = IntStream.range(0, row.length)
                .filter(j -> row[j] != 0)
                .mapToObj(Vertex::new)
                .collect(Collectors.toCollection(TreeSet::new))
            ;
            adjacencyMap.put(new Vertex(i), set);
        }
    }
    
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
    
    public List<Vertex> fs(boolean dfs) {
        adjacencyMap.keySet().forEach(v -> v.visited = false);
        LinkedList<Vertex> queue = new LinkedList<>();
        Vertex v = adjacencyMap.keySet().iterator().next();
        v.visited = true;
        queue.add(v);
        
        List<Vertex> result = new ArrayList<>();
        
        for (Vertex vertex: adjacencyMap.keySet()) {
            if (vertex.visited) continue;
            result.add(vertex);
            while (!queue.isEmpty()) {
                List<Vertex> adjacents = new ArrayList<>();
                adjacencyMap.get(queue.removeFirst()).stream()
                    .filter(x -> !x.visited)
                    .forEach(x -> {x.visited = true; adjacents.add(x);})
                ;
                if (dfs) adjacents.stream().forEach(queue::addFirst);
                else queue.addAll(adjacents);
            }
        }
        return result;
    }
}
