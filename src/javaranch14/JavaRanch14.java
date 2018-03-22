/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Piet
 */
public class JavaRanch14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Piet, List<Piet>> map = new TreeMap<>();
        Piet p0 = new Piet(0);
        Piet p1 = new Piet(1);
        Piet p2 = new Piet(2);
        Piet p3 = new Piet(3);
        map.put(p0, Arrays.asList(p1, p2, p3));
        map.put(p1, Arrays.asList(p0, p2, p3));
        map.put(p2, Arrays.asList(p0, p1, p3));
        map.put(p3, Arrays.asList(p0, p1, p2));
        
        for (Piet p: map.keySet()) {
            System.out.println("before " + map);
            p.visited = true;
            System.out.println("*********************");
            System.out.println("after " + map);
            System.out.println("*********************");
        }
        
    }
}

class Piet implements Comparable<Piet> {
    int id;
    boolean visited;
    
    Piet(int x) {
        id = x;
        visited = false;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Piet)) return false;
        return id == ((Piet) o).id;
    }
    
    @Override
    public int compareTo(Piet p) {
        return Integer.compare(id, p.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        return hash;
    }
    
    @Override
    public String toString() {
        return String.format("id: %d, visited: %b%n", id, visited);
    }
}
